package paymentManagement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import databaseManagement.DatabaseManager;
import rentalManagement.Reservation;

/**
 * Calculates prices for rentals, insurances, and sale
 * @author Robin
 *
 */
public class PaymentManager {

	private BigDecimal tax;
	private PriceList priceList;
	private DatabaseManager db;
	private AccountManager am;
	private DateFormat dateFormat;
	private static final int PRICE_ROW_SIZE = 3;
	private static final int MONTH_DAYS = 28;
	private static final int WEEK_DAYS = 7;
	private static final BigDecimal CONVERSION_RATE= new BigDecimal("5"); //5 DOLLARS FOR 1 POINTS
	
	/**
	 * A payment Manager that creates and holds a list of receipts. 
	 * The payment Manager is responsible for the money flow of the system. 	
	 * @throws SQLException 
	 */
	public PaymentManager(){
		tax = new BigDecimal("0.07");
		db = DatabaseManager.getInstance();
		priceList = new PriceList();
		am = new AccountManager();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 */
	public Receipt create_new_Receipt(BigDecimal price, String vehicle_rented, String dropoff_location){
		//Receipt receipt = new Receipt(numReceipts, price, dropoff_location, dropoff_location, dropoff_location);
		//return receipt;
		return null;
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
	 * Calculate price for rental searches
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

	public Receipt makePaymentByCard(Reservation reservation, BigDecimal amount_paid) throws SQLException, IllegalArgumentException {
		//steps: 1. pay by type (card), front-end made sure it is valid
		//		 2. get points for it if this is a super customer
		//		 3. produce receipts
		
		//amount_paid cannot be more than amount_owning when paying by card
		if (amount_paid.compareTo(new BigDecimal("0")) == -1 || amount_paid.compareTo(reservation.getBalance()) == 1 ){
			throw new IllegalArgumentException("Cannot pay negative amount or pay more than amount owning when using credit card.");
		}
		
		String payment_info = "";
		String basic_info = "";
		int customer_id = reservation.getCustomerAccountID();
		//System.out.println(reservation.getID());
		Account a = db.getReservationAccount(reservation.getID());
		//System.out.println(a.toString());
		String customer_username = a.getLoginId();
		
		//if we have a super rent customer, then he/she will earn points in this transaction
		if (am.is_super_rent(customer_id)){
			int points = AmountToPoints(amount_paid);
			am.accumulatePoints(customer_username, points);
			payment_info += "Earning points: "+points+"\n";
			payment_info += "Current points: "+am.getPoints(customer_id)+"\n";
		}
		//we have got a normal customer
		MathContext mc = new MathContext(2); // 2 precision
		BigDecimal change = reservation.getBalance().subtract(amount_paid, mc);
		//add this to the receipt
		payment_info += "Payment by credit: "+amount_paid+"\n";
		payment_info += "Amount owning after payment: "+change+"\n";
		
		//set up basic information too
		basic_info += db.getReservationInReceiptForm(reservation.getID());
		
		//now set up a new receipt object and returns it
		Receipt receipt = new Receipt(-1, customer_id, basic_info, payment_info);
		//store that into database
		db.addReceipt(receipt);
		return receipt;
	}

	/**
	 * Convert 
	 * @param amount_paid
	 * @return
	 */
	private int AmountToPoints(BigDecimal amount_paid) {
		// TODO Auto-generated method stub
		return Integer.valueOf(amount_paid.divide(CONVERSION_RATE,RoundingMode.FLOOR).intValue());
	}

	public void addExtraCharge(int rental_id, String type) {
		// TODO Auto-generated method stub
		
	}

	public BigDecimal getExtraCharge(int rental_id, String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	public BigDecimal[] getPriceCarInsurance(String type){
		return db.getPriceRow(type, "insurance_car_price");
	}
	
	public BigDecimal[] getPriceTruckInsurance(String type){
		return db.getPriceRow(type, "insurance_truck_price");
	}*/
	
	
}
