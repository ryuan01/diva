package paymentManagement;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.Customer;
import accountManagement.SuperCustomer;
import databaseManagement.DatabaseManager;
import rentalManagement.Reservation;

/**
 * Calculates prices for rentals, insurances, and sale
 * @author Robin
 *
 */
public class PaymentManager {

	private static MathContext mc = new MathContext(2);
	private BigDecimal tax;
	private PriceList priceList;
	private DatabaseManager db;
	//private AccountManager am;
	private CreditCardEncryptor encryptor;
	private DateFormat dateFormat;
	private DateFormat dateonlyFormat;
	private static final int PRICE_ROW_SIZE = 3;
	private static final int MONTH_DAYS = 28;
	private static final int WEEK_DAYS = 7;
	private static final BigDecimal CONVERSION_RATE= new BigDecimal("5"); //5 DOLLARS FOR 1 POINTS
	private static final int PER_KM_INDEX=4; //for extra charge perKM
	
	/**
	 * A payment Manager that creates and holds a list of receipts. 
	 * The payment Manager is responsible for the money flow of the system. 	
	 * @throws SQLException 
	 */
	public PaymentManager(){
		tax = new BigDecimal("0.07");
		db = DatabaseManager.getInstance();
		priceList = new PriceList();
		//am = new AccountManager();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateonlyFormat = new SimpleDateFormat("yyyy-MM-dd");
		encryptor = new CreditCardEncryptor();
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 * @throws Error 
	 * @throws SQLException 
	 */
	public Receipt create_new_Receipt(int clerkID, int customerID, String basicInfo, String paymentInfo) throws SQLException, Error{
		Receipt receipt = new Receipt(-1,customerID,clerkID, basicInfo,paymentInfo);
		db.addReceipt(receipt);
		return receipt;
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

	/**
	 * Calculate price for rental searches only 
	 * @param type class of vehicle or equipments
	 * @param rate_type index of rate 
	 * @return calculated price 
	 * @throws ParseException
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	public BigDecimal calculatePrice(String type, int rate_type) throws ParseException, SQLException, IllegalArgumentException{
		
		BigDecimal[] priceRow;
		//check if the argument is of type car
		if (isLegalCarClass(type)){
			priceRow = getPriceCar(type);			
		}
		//or of type truck
		else if (isLegalTruckClass(type)){
			priceRow = getPriceTruck(type);					
		}
		else if (isLegalEquipmentClass(type)){
			priceRow = getPriceEquipment(type);
		}
		else {
			throw new IllegalArgumentException("The type "+type+" is not valid.");
		}
		return priceRow[rate_type];
		
	}
	
	/**
	 * Calculate insurance price during reservation
	 * @param type
	 * @param rate_type
	 * @return
	 * @throws ParseException
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	public BigDecimal calculateInsurancePrice(String type, int rate_type) throws ParseException, SQLException, IllegalArgumentException
	{
		//will need to use start_date and end_date
		BigDecimal[] priceRow;
		if(isLegalCarClass(type))
		{
			priceRow = getPriceCarInsurance(type);
//			System.out.println(type);
//			for (int i =0; i<priceRow.length; i++){
//				System.out.print(priceRow[i]+" ");
//			}
		}
		else if(isLegalTruckClass(type))
		{
			priceRow = getPriceTruckInsurance(type);
		}
		else
		{
			throw new IllegalArgumentException("The type "+type+"is not valid.");
		}
		return priceRow[rate_type];
	}
	
	// Calculate total of reservation pre tax, with and without insurances.
	public BigDecimal totalPreTax(Reservation reserv) throws ParseException, SQLException
	{
		String start_date = reserv.getStartingDate();
		String end_date = reserv.getEndDate();
		
		// For Vehicle
		// calculate rate_type
		int vehicle_rate_type;
		vehicle_rate_type = compareDates(start_date,end_date,"vehicle");
		
		
		// calculate vehicle_price
		BigDecimal vehicle_price;
		String vehicle_type = db.getTypeOfVehicle(reserv.getVehicleID());
//System.out.println(vehicle_rate_type+" "+vehicle_type);
		vehicle_price = calculatePrice(vehicle_type,vehicle_rate_type);
//System.out.println(vehicle_price);		
		// calculate vehicle_insurance_price
		BigDecimal vehicle_insurance_price;
		
		int insurance_rate_type;
		insurance_rate_type = compareDates(start_date,end_date,"insurance");
//System.out.println(insurance_rate_type);

		vehicle_insurance_price = calculateInsurancePrice(vehicle_type,insurance_rate_type);
		
		// For Equipment
		// calculate rate_type
		int equipment_rate_type;
		equipment_rate_type = compareDates(start_date,end_date,"equipment");
		
		// calculate total equip_price
		BigDecimal equip_price = BigDecimal.ZERO;
		int[] equip_ids = reserv.getEquipments();
		for(int i = 0; i < equip_ids.length; i++)
		{
			String equip_type = db.getTypeOfEquipment(equip_ids[i]);
			equip_price = new BigDecimal ("10.00");
			//todo
			//equip_price = equip_price.add(calculatePrice(equip_type, equipment_rate_type),mc);
		}
		
		// Adds Vehicle price, Vehicle insurance price, Total equipments price
		BigDecimal total;
		if(reserv.getInsuranceStatus() == true){
			total = vehicle_price.add(vehicle_insurance_price.add(equip_price, mc), mc).setScale(2, RoundingMode.CEILING);
		}
		else
		{
			total = vehicle_price.add(equip_price,mc).setScale(2, RoundingMode.CEILING);
		}
		System.out.println(total);
		return total;
		//return new BigDecimal("100.00");
	}
	
	public BigDecimal applyTax(BigDecimal price)
	{
		return price.add(price.multiply(tax, mc),mc);
	}
	
	/**
	 * Checks for the type of equipment
	 * @param type
	 * @return
	 */
	private boolean isLegalEquipmentClass(String type) {
		// TODO Auto-generated method stub
		if (type.equals("ski rack") || 
			type.equals("child safety seat") ||
			type.equals("lift gate") ||
			type.equals("car-towning eq"))
			return true;
		return false;
	}

	/**
	 * Checks for the type of truck
	 * @param type
	 * @return
	 */
	private boolean isLegalTruckClass(String type) {
		// TODO Auto-generated method stub
		if (type.equals("24-foot") || 
			type.equals("15-foot") ||
			type.equals("12-foot") ||
			type.equals("box-truck"))
			return true;
		return false;
	}

	/**
	 * Checks for the type of car
	 * @param type
	 * @return
	 */
	private boolean isLegalCarClass(String type) {
		// TODO Auto-generated method stub
		if (type.equals("economy") || 
			type.equals("compact") ||
			type.equals("midsized") ||
			type.equals("standard") ||
			type.equals("fullsized") ||
			type.equals("premium") ||
			type.equals("SUV") ||
			type.equals("van") ||
			type.equals("luxury"))
			return true;
		return false;
	}
	
	/**
	 * Get a row of rental price for car
	 * @param type a type of car
	 * @return the row of price for this type of car
	 * @throws SQLException
	 */
	public BigDecimal[] getPriceCar(String type) throws SQLException{
		if (!priceList.getIsSet("car")){
			priceList.setCarPrice(db.getAllCarPrice());
			priceList.setIsSet("car");
		}
		return priceList.getCarPrice(type);
	}
	
	/**
	 * Get a row of rental price for truck
	 * @param type a type of truck
	 * @return the row of price for this type of truck
	 * @throws SQLException
	 */
	public BigDecimal[] getPriceTruck(String type) throws SQLException{
		if (!priceList.getIsSet("truck")){
			priceList.setTruckPrice(db.getAllTruckPrice());
			priceList.setIsSet("truck");
		}
		return priceList.getTruckPrice(type);
	}
	
	/**
	 * Get a row of rental price for equipment
	 * @param type a type of equipment
	 * @return the row of price for this type of equipment
	 * @throws SQLException
	 */
	public BigDecimal[] getPriceEquipment(String type) throws SQLException{
		if (!priceList.getIsSet("equipment")){
			priceList.setTruckPrice(db.getAllEquipmentPrice());
			priceList.setIsSet("equipment");
		}
		return priceList.getEquipmentPrice(type);
	}

	/**
	 * Compares the dates and returns rate type
	 * >1 month => month; >1 week => week; >1 day => day; >1 hour => hour;
	 * @param start_date
	 * @param end_date
	 * @param type : vehicle or equipment or insurance
	 * @return
	 * @throws ParseException 
	 */
	public int compareDates(String start_date, String end_date, String type) throws ParseException {
		// TODO Auto-generated method stub
		int rate_type;
		Date startDate = dateFormat.parse(start_date);		
		Date endDate = dateFormat.parse(end_date);
		
		long daysDuration = getDateDiff(startDate,endDate,TimeUnit.DAYS);
		
		if (daysDuration > MONTH_DAYS && type.equals("vehicle")){
			rate_type = 3; //perMonth
		}
		else if (daysDuration > WEEK_DAYS){
			rate_type = 2; //perWeek
		}
		else if (daysDuration > 1){
			rate_type = 1; //perDay
		}
		else{
			rate_type = 0; //perHour
		}
		return rate_type;
	}
	
	/**
	 * 
	 * @param reserve_id
	 * @param customer_id
	 * @param balance
	 * @return
	 * @throws Exception 
	 */
	public Receipt makePaymentByCardOnFile(String clerk_username, int reservation_id, String username) throws Exception{
		//get the balance, the customer has to pay for that many
		Reservation r = db.searchReservationEntry(reservation_id);
		Receipt receipt = null;
		int clerk_id = -1; //no clerk 
		//get customer name and credit card info, load the object
		//first check if the customer is the person who holds the reservation
		String customer_username = db.getUsernameFromId(r.getCustomerAccountID());
		if (! customer_username.equals(username)){ //not the holder, cannot pay
			throw new IllegalArgumentException("Customer does not have the right to access someone else's credit information.");
		}
		Customer a = (Customer) db.getAccountFromID(r.getCustomerAccountID());
		String encrypted_ccnum = a.getCc_num();
		if (encrypted_ccnum == null){
			throw new IllegalArgumentException("Customer does not have a credit on file");
		}
		String cc = encryptor.decrypt(encrypted_ccnum);
		String expireDate = a.getExpireDate();
		if (isValidCreditCard(expireDate)){
			//pay with it
			//produce receipt
			if (!(clerk_username == null)){
				clerk_id = db.getIdFromUsername(clerk_username);
			}
			BigDecimal balance = r.getBalance();
			int customer_id = r.getCustomerAccountID();		
			//check if the balance is negative 
			if (balance.compareTo(new BigDecimal("0")) == -1){
				throw new IllegalArgumentException("amount paid cannot be negative");
			}
			//customer has to pay exactly how much they own. cannot pay partly.
			receipt = generalPayment(clerk_id, reservation_id, customer_id,balance,""+balance,"credit");
		}
		else {
			throw new IllegalArgumentException("Credit card is expired");
		}
		return receipt;
	}

	/**
	 * Check if the credit card is valid, right now only checks for expire date
	 * @param expireDate
	 * @return
	 * @throws ParseException 
	 */
	private boolean isValidCreditCard(String expireDate) throws ParseException {
		Date currentDate = new Date();		
		Date endDate = dateonlyFormat.parse(expireDate);
		if (endDate.after(currentDate)){
			return true;
		}
		else {
			return false;
		}
	}

	//if we have time we will go ahead and implement check for credit card validity
	/**
	 * A customer pays for an order through his card externally
	 * @pre card on file is valid
	 * @param reserve_id
	 * @param customer_id
	 * @param balance amount owning
	 * @param amount amount to be paid
	 * @return receipt about this transaction
	 * @throws Exception 
	 */
	public Receipt makePaymentByCard(String clerk_username, int reserve_id,String amount) throws Exception {
		int clerk_id = db.getIdFromUsername(clerk_username);
		Reservation r = db.searchReservationEntry(reserve_id);
		BigDecimal balance = r.getBalance();
		int customer_id = r.getCustomerAccountID();
		//amount_paid cannot be more than amount_owning when paying by card
		BigDecimal amount_paid = new BigDecimal(amount);
		
		//check if the amount_paid is more than balance
		if (amount_paid.compareTo(balance) == 1){
			throw new IllegalArgumentException("amount paid cannot exceeds amount owning when paying by card");
		}
		else if (amount_paid.compareTo(new BigDecimal("0")) == -1){
			throw new IllegalArgumentException("amount paid cannot be negative");
		}
		return generalPayment(clerk_id, reserve_id, customer_id,balance,amount,"credit");
	}
	
	/**
	 * A customer pays for reservation by using points
	 * @param reserve_id
	 * @param customer_id
	 * @param vehicle_type 
	 * @param balance
	 * @param points
	 * @return
	 * @throws Exception 
	 */
	public Receipt makePaymentBySRP(String clerk_username, int reserve_id, int points) throws Exception
	{
		int clerk_id = db.getIdFromUsername(clerk_username);
		Reservation r = db.searchReservationEntry(reserve_id);
		BigDecimal balance = r.getBalance();
		int customer_id = r.getCustomerAccountID();
		int vehicle_id = r.getVehicleID();
		String vehicle_type = db.getTypeOfVehicle(vehicle_id);
		//calculate the equivalent price of this amount of points
		//check if the amount_paid is more than balance
		BigDecimal amount_paid;
		BigDecimal change;
		try{
			amount_paid = pointsToAmount(points,vehicle_type);
		}
		catch (IllegalArgumentException e){
			throw e;
		}
		if (!is_super_rent(customer_id)){
			throw new IllegalArgumentException("customer must be a super club member to access his/her points");
		}
		else if (amount_paid.compareTo(balance) == 1){
			throw new IllegalArgumentException("amount paid cannot exceeds amount owning when paying by card");
		}
		else if (amount_paid.compareTo(new BigDecimal("0")) == -1){
			throw new IllegalArgumentException("amount paid cannot be negative");
		}

		synchronized(this){
			db.deductSRPoints(customer_id, points);
			change = balance.subtract(amount_paid).setScale(2, RoundingMode.CEILING);
			db.addToBalance(reserve_id, change);
//			System.out.println(balance+" "+amount_paid+" "+change);
//			System.exit(0);
		}
		
		String payment_info = "Payment by SuperRent Points: " +points+"\n";
		payment_info += "Amount owning after payment: "+change+"\n";
		String basic_info = db.getReservationInReceiptForm(reserve_id);
		
		Receipt receipt = new Receipt(-1, customer_id, clerk_id, basic_info, payment_info);
		db.addReceipt(receipt);
		return receipt;
	}
	
	/**
	 * Customer pays for reservation by cash, it is possible to give change
	 * @param reserve_id
	 * @param customer_id
	 * @param customer_id2 
	 * @param balance
	 * @param amount
	 * @return
	 * @throws Exception 
	 */
	public Receipt makePaymentCash(String clerk_username, int reserve_id,String amount) throws Exception {
		int clerk_id = db.getIdFromUsername(clerk_username);
		Reservation r = db.searchReservationEntry(reserve_id);
		BigDecimal balance = r.getBalance();
		int customer_id = r.getCustomerAccountID();		
		BigDecimal amount_paid = new BigDecimal(amount);
		//check if the amount_paid is negative, it can exceeds balance
		if (amount_paid.compareTo(new BigDecimal("0")) == -1){
			throw new IllegalArgumentException("amount paid cannot be negative");
		}
		return generalPayment(clerk_id, reserve_id, customer_id,balance,amount,"cash");
	}

	/**
	 * Helper for makePaymentCash and makePaymentCard, because they are very similar except
	 * the latter does not allow change to be given back
	 * @param reserve_id
	 * @param customer_id
	 * @param balance
	 * @param amount
	 * @param type "cash" or "credit"
	 * @return
	 * @throws SQLException
	 */
	private Receipt generalPayment(int clerk_id, int reserve_id, int customer_id, BigDecimal balance,
			String amount, String type) throws SQLException{
		String payment_info = "";
		String basic_info = "";
		BigDecimal amount_paid = new BigDecimal(amount);
		//if we have a super rent customer, then he/she will earn points in this transaction
		synchronized(this){
			if (is_super_rent(customer_id)){
				int points = amountToPoints(amount_paid);
				db.addSRPoints(customer_id, points);
				payment_info += "Earning points: "+points+"\n";
			}
			//we have got a normal customer
			//this method connects to outside
			if (pay_with_machine(amount)){
				BigDecimal change = balance.subtract(amount_paid).setScale(2, RoundingMode.CEILING);
				//set this balance to database
				db.addToBalance(reserve_id, change);
				//add this to the receipt
				payment_info += "Payment by "+type+": "+amount_paid+"\n";
				payment_info += "Amount owning after payment: "+change+"\n";
			}
		}
		//System.exit(0);
		
		//set up basic information too
		basic_info += db.getReservationInReceiptForm(reserve_id);
		
		//now set up a new receipt object and returns it
		Receipt receipt = new Receipt(-1, customer_id, clerk_id, basic_info, payment_info);
		//store that into database
		db.addReceipt(receipt);
		return receipt;
	}
	
	/**
	 * This method connects to outside machine, could be a cash, or could be some kind of credit/debit machine
	 * @param amount
	 * @return
	 */
	private boolean pay_with_machine(String amount) {
		
		//this is a stub right now, need to figure out how to connect to outside machine
		return true;
	}

	/**
	 * Checks for type of rental and get the equivalent amount 
	 * @param points
	 * @param vehicle_type 
	 * @pre must be multiple of 1000 or 1500
	 * @return
	 * @throws SQLException 
	 */
	private BigDecimal pointsToAmount(int points, String vehicle_type) throws IllegalArgumentException, SQLException{
		// TODO Auto-generated method stub
		//remember to set the price if not already set
		if (!priceList.getIsSet("car")){
			priceList.setCarPrice(db.getAllCarPrice());
			priceList.setIsSet("car");
		}
		if (!priceList.getIsSet("truck")){
			priceList.setTruckPrice(db.getAllTruckPrice());
			priceList.setIsSet("truck");
		}
		// check type of reserved_vehicle
		int points_per_day;
		if (priceList.isLowerEndVehicle(vehicle_type)){
			points_per_day = 1000;
		}
		else{
			points_per_day = 1500;
		}
		int days = points / points_per_day;
//		System.out.println(vehicle_type+" "+days+" "+ points % points_per_day);
//		System.exit(0);
		if (points % points_per_day != 0){
//			System.out.println("I am here");
//			System.exit(0);
			throw new IllegalArgumentException("Points spend has to be multiple of 1000 or 1500 depending on vehicle type");
		}
		BigDecimal dailyprice = priceList.getDailyPrice(vehicle_type);
		
		return dailyprice.multiply(new BigDecimal(days)).setScale(2, RoundingMode.CEILING);
//		System.out.println(vehicle_type);
//		System.exit(0);
	}

	/**
	 * Convert 
	 * @param amount_paid
	 * @return
	 */
	private int amountToPoints(BigDecimal amount_paid) {
		// TODO Auto-generated method stub
		return Integer.valueOf(amount_paid.divide(CONVERSION_RATE,RoundingMode.FLOOR).intValue());
	}
	
	public BigDecimal[] getPriceCarInsurance(String type) throws SQLException{
//		System.out.println(type);
//		if(!priceList.getIsSet("car_insurance")){
			priceList.setInsuranceCarPrice(db.getAllCarInsurancePrice());		
//			priceList.setIsSet("car_insurance");
//		}
		return priceList.getCarInsurancePrice(type);
	}
	
	/**
	 * Get price list for truck insurance 
	 * @param type type of truck, points to a row 
	 * @return
	 * @throws SQLException
	 */
	public BigDecimal[] getPriceTruckInsurance(String type)throws SQLException{
		if(!priceList.getIsSet("truck_insurance")){
			priceList.setInsuranceTruckPrice(db.getAllTruckInsurancePrice());
			priceList.setIsSet("truck_insurance");
		}
		return priceList.getTruckInsurancePrice(type);
	}

	/**
	 * Access DB to get overdue price for daily, then use that to calculate
	 * @param current_date
	 * @param endDate
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public BigDecimal calculateOverduePrice(String current_date, String endDate, String type) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		/*
		 * calculate the differences from current_date and end_date
		 * multiply by price loaded from database
		 * return that
		 */
		Date startDate = dateFormat.parse(current_date);		
		Date end_date = dateFormat.parse(endDate);
		
		long daysDuration = Math.abs(getDateDiff(startDate,end_date,TimeUnit.DAYS));
		//System.out.println("days" + daysDuration);
		BigDecimal extra_charge_price = getExtraChargePrice("overdue_daily");
		//System.out.println(extra_charge_price);
		//System.exit(0);
		return extra_charge_price.multiply(new BigDecimal(daysDuration)).setScale(2, RoundingMode.CEILING);
	}

	/**
	 * 
	 * Load extra charge price into PriceList if it isn't present, and get the row associated with that
	 * @param type
	 * @return
	 * @throws SQLException 
	 */
	private BigDecimal getExtraChargePrice(String type) throws SQLException {
		// TODO Auto-generated method stub
		if(!priceList.getIsSet("extra_charge_price")){
			priceList.setExtraCharge(db.getAllExtraChargePrice());
			priceList.setIsSet("extra_charge_price");
		}
		return priceList.getExtraChargePrice(type);
	}
	
	/**
	 * Checks if a customer is of type Super Customer
	 * @param account_id
	 * @return
	 * @throws SQLException 
	 */
	private boolean is_super_rent(int account_id) throws SQLException{
		//System.out.println("customer account is: " +account_id);
		Account a = db.getAccountFromID(account_id);
		if (a instanceof SuperCustomer){
			return true;
		}
		return false;
	}

	/**
	 * place holder right now
	 * @return
	 * @throws SQLException 
	 */
	public BigDecimal calculateWrongReturnBranchPrice() throws SQLException {
		// TODO Auto-generated method stub
		return getExtraChargePrice("wrong_branch");
	}
	
	public Receipt[] getReceiptForCustomer(String customer_username) throws Exception{
		int customer_id = db.getIdFromUsername(customer_username);
		return db.searchReceipt(customer_id);
	}

	public BigDecimal calculateGasLevelPrice(int gaslevel_before, int gaslevel_after) throws SQLException {
		// TODO Auto-generated method stub
		int difference = Math.abs(gaslevel_before - gaslevel_after);
		return getExtraChargePrice("gas_tank").multiply(new BigDecimal(difference)).setScale(2, RoundingMode.CEILING);
	}

	public BigDecimal calculateExtraKMPrice(int extra_milage, String v_type) throws Exception {
		//get the price perKM for v_type
		BigDecimal perKM_price;
		if (isLegalCarClass(v_type)){
			perKM_price = getPriceCar(v_type)[PER_KM_INDEX];
		}
		else if (isLegalTruckClass(v_type)){
			perKM_price = getPriceTruck(v_type)[PER_KM_INDEX];
		}
		else {
			throw new Exception("vehicle type does not exist");
		}
		BigDecimal balance = perKM_price.multiply(new BigDecimal(extra_milage)).setScale(2, RoundingMode.CEILING);
//		System.out.println(balance+" "+v_type + " "+perKM_price + " "+extra_milage);
		return balance;
	}
	
	/**
	 * Encrypt a credit card and returns the encrypted version
	 * @param cardnum clear credit card number
	 * @return encrypted credit card number
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String encrypt (String cardnum) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		return encryptor.encrypt(cardnum);
	}
}
