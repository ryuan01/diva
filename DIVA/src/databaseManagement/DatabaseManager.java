package databaseManagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import accountManagement.Account;
import accountManagement.Customer;
import accountManagement.Employee;
import paymentManagement.Receipt;
import rentalManagement.AccidentReport;
import rentalManagement.Rental;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Equipment;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/**
 * DatabaseManager deals with all functions that interacts with database
 * @author Robin, Sammy
 */
public class DatabaseManager {
	
	// I am modeling as Has-A relationship
	private AccountDB accDB;
	private BranchDB branDB;
	private EquipmentDB eqDB;
	private RentalDB reDB;
	private VehicleDB veDB;
	private PriceDB prDB;
	
	private static String CAR = "car";
	private static String TRUCK = "truck";
    
    //singieton design pattern
    private static DatabaseManager instance = null;
 
    /**
     * Get the only databaseManager
     * @return an instance of databasemanager
     * @post databaseManager.instance != null
     */
    public static DatabaseManager getInstance(){
    	if (instance == null){
    		instance = new DatabaseManager();
    	}
    	return instance;
    }
    
    //called by shutDown method in system manager
    /**
     * Destroys instance
     * @pre instance = new DatabaseManager()
     * @post instance = null
     */
    public static void destroyDatabase()
    {
    	instance = null;
    }
    
	/** 
	* Constructs a DatabaseManager
	* @post an only DatabasManager object is created
	*/
    private DatabaseManager(){
		accDB = new AccountDB();
		branDB = new BranchDB();
		eqDB = new EquipmentDB();
		reDB = new RentalDB();
		veDB = new VehicleDB();
		prDB = new PriceDB();
    }
	

//--------------------------------------------Branch Related--------------------------------------
	/**
	 * 
	 * @param b Branch
	 * @throws SQLException
	 */
	public void createBranchEntry(Branch b) throws SQLException
	{
		branDB.addBranch(b);
	}
	
	/*
	 * not relevant
	public boolean modifyBranchEntry(int id,String address, String city, String province, String zipcode)
	{
		return true;
	}*/
	
	/*
	 * not relevant
	public boolean modifyBranchEntry(int id,String address, String city, String province, String zipcode)
	{
		return true;
	}*/
	
	/**
	 * Removes a branch 
	 * @param id branch ID 
	 * @throws SQLException
	 */
	public void removeBranchEntry(int id) throws SQLException
	{
		branDB.removebranch(id);
	}
	
	/**
	 * Gets an branch
	 * @param id branch ID
	 * @return Branch object of that ID
	 * @throws SQLException
	 */
	public Branch getBranchEntry(int id) throws SQLException
	{
		return branDB.getBranch(id);
	}
	
	/**
	 * Gets all possible branch entries on file
	 * @return list of branches
	 * @throws SQLException
	 */
	public Branch[] getAllBranchEntries() throws SQLException
	{
		return branDB.getAllBranch();
	}
	
	/**
	 * Checks if the returning branch is the same as indicated by rental agreement
	 * @param rental_id ID of rental 
	 * @param current_return_branch current branch ID
	 * @return true if they are same, false otherwise
	 * @throws SQLException
	 */
	public boolean checkReturnBranch(int rental_id, int current_return_branch) throws SQLException{
		
		return branDB.checkReturnBranch(rental_id, current_return_branch);
	}
	
	/**
	 * Add extra charge for returning to wrong branch
	 * @param rental_id ID of rental
	 * @return the amount charged, 0 means no charge 
	 * @throws SQLException
	 */
	public BigDecimal addWrongReturnBranchExtraCharge(int rental_id) throws SQLException {
		return branDB.addWrongReturnBranchExtraCharge(rental_id);
	}

	// 
/*----------------------------------------EquipmentDB--------------------------------------------*/

	/**
	 * Search for additional equipments available
	 * @param type ENUM('ski rack','child safety seat','lift gate','car-towing eq')
	 * @param branch_num branch that this equipment belongs to
	 * @param end_date 
	 * @param start_date 
	 * @return list of equipments of a type that is available at a branch
	 * @throws SQLException
	 */
	public Equipment[] searchAdditionalEquipments(String type, int branch_num, String start_date, String end_date) throws SQLException{
		return eqDB.searchAdditionalEquipments(type, branch_num, start_date, end_date);
	}

	/**
	 * Adding a new equipment 
	 * @param equipment_id
	 * @param equipment_type ENUM('ski rack','child safety seat', 'lift gate','car-towing eq')
	 * @throws SQLException 
	 */
	public void insertEquipment(int branch_id, String equipment_type) throws SQLException{
		eqDB.addEquipment(branch_id, equipment_type);
	}
	
	/**
	 * Get the type of equipment according to its vehicle ID
	 * @param equipment_id
	 * @return
	 * @throws SQLException
	 */
	public String getTypeOfEquipment(int equipment_id) throws SQLException
	{
		return eqDB.getEquipmentType(equipment_id);
	}
   
/*----------------------------------------RentalDB--------------------------------------------*/
	/**
	 * Create an reservation entry in database
	 * @param r reservation
	 * @throws SQLException 
	 * @pre r.id is null
	 * @pre r is not in database
	 * @post r.id is updated 
	 */
	public void createReservationEntry(Reservation r) throws SQLException {
		// Look at the note in getBranch method
		reDB.createReservation(r);
	}
	

	/**
	 * Return reservation history for a customer
	 * @param acc_key_value customer account key value
	 * @return list of reservations associated with a customer
	 * @throws SQLException 
	 */
	public Reservation[] reservationHistory(int acc_key_value) throws SQLException{
		return reDB.reservationHistory(acc_key_value);
	}
	
	/**
	 * removes a Reservation from the database completely, not archived
	 * @param reservID
	 * @throws SQLException
	 */
	public void removeReservationEntry(int reservID) throws SQLException, NullPointerException {
		reDB.removeReservation(reservID);
	}
	
	/**
	 * Search database for a reservation
	 * @param reservID uniquely identifies reservation
	 * @return reservation object
	 * @throws SQLException query has problems
	 */
	public Reservation searchReservationEntry(int reservID) throws SQLException {
		return reDB.reservationQuery(reservID);
	}

	/**
	 * Add an inspection report for Database
	 * @param r inspection report 
	 * @param state: ENUM('before_rental','after_rental')
	 * @throws SQLException
	 */
	public void addReport(Report r) throws SQLException
	{
		reDB.createInspectionReport(r);
	}
	
	/**
	 * Add an accident report for database
	 * @param r accident report
	 * @throws SQLException
	 */
	public void addAccidentReport(AccidentReport r) throws SQLException{
		reDB.createAccidentReport(r);
		//also change vehicle state
		Rental rental = reDB.getRental(r.getRentalID());
		veDB.updateVehicleStatus(rental.getRentalReservation().getVehicleID(), "damaged");
	}
	
	/**
	 * Searches for inspection reports related to an rental ID, can have 0 - 2 reports
	 * @param rental_id ID of rental
	 * @return list of inspection reports from size 0 to 2
	 * @throws SQLException
	 */
	public Report[] searchInspectionReport(int rental_id) throws SQLException {
		// 
		ArrayList<Report> reports = new ArrayList<Report>();
		Report one = reDB.searchInspectionReport(rental_id, "before_rental");
		Report two = reDB.searchInspectionReport(rental_id, "after_rental");
		if (one != null)
			reports.add(one);
		if (two != null)
			reports.add(two);
        //change back to array
        Report[] rArray = new Report[reports.size()];
        rArray = reports.toArray(rArray);
        return rArray;
	}

	/**
	 * Gets an accident report related to an rental
	 * @param rental_id ID of rental
	 * @return accident report if found, otherwise null
	 * @throws SQLException
	 */
	public AccidentReport searchAccidentReport(int rental_id) throws SQLException {
		// 
		return reDB.searchAccidentReport(rental_id);
	}
	
	/**
	 * Get the reservation end date
	 * @param reservID ID that identifies a reservation
	 * @return end date as a string
	 * @throws SQLException
	 */
	public String getReservationEndDate(int reservID) throws SQLException
	{
		Reservation r = reDB.reservationQuery(reservID);
		return r.getEndDate();
	}
	
	/**
	 * Get the account related to reservation 
	 * @param reservID reservation ID
	 * @return Account object 
	 * @throws SQLException 
	 */
	public Account getReservationAccount(int reservID) throws SQLException
	{
		Reservation r = reDB.reservationQuery(reservID);
		return getAccountFromID(r.getCustomerAccountID());
	}

	/**
	 * Get reservation vehicle ID
	 * @param reservID
	 * @return vehicle ID
	 * @throws SQLException
	 */
	public int getReservationVehicleID(int reservID) throws SQLException
	{
		Vehicle v = this.getReservationVehicle(reservID);
		return v.getID();
	}
	
	/**
	 * Create an rental
	 * @param reserveID
	 * @param clerkID
	 * @param is_paid_rental
	 * @param is_paid_extra_charge
	 * @throws SQLException
	 */
	public void createRental(int reserveID, int clerkID, boolean is_paid_rental) throws SQLException {
		reDB.createRental(reserveID, clerkID, is_paid_rental);
	}
	
	/**
	 * Get a rental object based on rental_id
	 * @throws SQLException 
	 * 
	 */
	public Rental getRental(int rentID) throws SQLException{
		return reDB.getRental(rentID);
	}
	
	/**
	 * Get an rental from reservation
	 * @param reservID reservation ID
	 * @return Rental object 
	 * @throws SQLException
	 */
	public Rental getRentalFromReservation(int reservID) throws SQLException{
		return reDB.getRental(reservID);
	}
	
	/**
	 * Get the account for the rental, for calculating price purpose
	 * @param rental_id
	 * @return
	 */
	public int getAccountForRental(int rental_id) {
		// 
		return reDB.getAccountForRental(rental_id);
	}
	
	/**
	 * Get a vehicle inside reservation, for calculating price purpose
	 * @param reservID
	 * @return Vehicle
	 * @throws SQLException 
	 */
	public Vehicle getReservationVehicle(int reservID) throws SQLException {
		// 
		Reservation r = reDB.reservationQuery(reservID);
		int vehicle_id = r.getVehicleID();
		Vehicle v = veDB.search(vehicle_id);
		return v;
	}
	
	/**
	 * Adding to balance 
	 * @param rental_id
	 * @param balance
	 * @throws SQLException
	 */
	public void addToBalance(int rental_id, BigDecimal balance) throws SQLException{
		reDB.addToBalance(rental_id, balance);
	}
	
	/**
	 * Modifies rental status depending on column names 
	 * @param rental_id rental ID
	 * @param is_paid_extra_charge is a column in rental, sets to false when the other one is set to true
	 * @param state true or false, state of columnName
	 * @param columnName columnName can be is_check_overdue or is_check_return_branch
	 * @throws SQLException
	 */
	public void modifyRentalStatus(int rental_id, boolean is_paid_extra_charge, boolean state,String columnName) throws SQLException{
		reDB.modifyRentalStatus(rental_id, is_paid_extra_charge, state, columnName);
	}
	
	/**
	 * Get balance of an rental 
	 * @param rentID ID of rental 
	 * @return balance, cannot be negative 
	 * @throws SQLException
	 */
	public BigDecimal getBalance(int rentID) throws SQLException{
		//System.out.println("im in dbmanager");
		return reDB.getBalance(rentID);
	}
	
	/**
	 * Get a string that represents all information regarding this reservation with descriptive information
	 * So for example branch 1 will actually say Location: xxxx street, city, province, zipcode
	 * @param reserve_id
	 * @return
	 * @throws SQLException 
	 */
	public String getReservationInReceiptForm(int reserve_id) throws SQLException {
		// 
		//get reservation
		Reservation r = reDB.reservationQuery(reserve_id);
		//get customer 
		String username = accDB.getUserNameFromId(r.getCustomerAccountID());
		Account customer = accDB.getAccounts(username)[0];
		//get branches
		Branch start_branch = branDB.getBranch(r.getStartBranchID());
		Branch end_branch = branDB.getBranch(r.getEndBranchID());
		//get vehicle
		Vehicle reserved_vehicle = veDB.search(r.getVehicleID());
		
		String basic_info = "\nStart date: "+ r.getStartingDate()+"\n"
							+"End date: "+r.getEndDate()+"\n"
							+"Customer name: "+customer.getFirstname()+" "+customer.getLastname()+"\n"
							+"Start branch: "+start_branch.getFullAddress()+"\n"
							+"End branch: "+end_branch.getFullAddress()+"\n"
							+"Vehicle: "+reserved_vehicle.getVehicleClass()+" "+reserved_vehicle.getManufacturer()+" "+reserved_vehicle.getModel()+"\n";
		//get equipments
		int[] equipment_id = r.getEquipments();
		for (int i=0; i<equipment_id.length;i++){
			basic_info += "Equipment: "+eqDB.getEquipmentType(equipment_id[i])+"\n";
		}
		return basic_info;
	}
	
/*---------------------------------------Account related----------------------------------------------*/
	
	/**
	 * Creates an account in database with automatically assigned ID
	 * @param account account object
	 * @throws SQLException
	 */
	public void createAccountEntry(Account account) throws SQLException{
		if (account instanceof Customer){
			accDB.createCustomer((Customer)account);
		} else if (account instanceof Employee){
			accDB.createEmployee((Employee)account);
		} // create one for superCustomer account
	}
	
	/**
	 * Searches for account entries based on parameter
	 * @param parameter can be either username, lastname, or phonenumber
	 * @return
	 * @throws SQLException 
	 */
	public Account[] searchAccountEntries(String parameter) throws SQLException{
		//done
		return accDB.getAccounts(parameter);
	}
	
	public String retrievePassword(String userName) throws SQLException
	{// Done
		return accDB.retrievePassword(userName);
	}
	
	/**
	 * Get an account object based on its account ID
	 * @param customerAccountID
	 * @return account object
	 * @throws SQLException 
	 */
	public Account getAccountFromID(int customerAccountID) throws SQLException {
		// C
		String username = accDB.getUserNameFromId(customerAccountID);
//		System.out.println(username);
//		System.exit(0);
		return accDB.getAccounts(username)[0];
	}
	
	// find account by loginID, loginID should be immutable
//	public void modifyAccountEntry(String firstname, String lastname, String phoneNumber, String email)
//	{
//	}
	
	/**
	 * Change customer account status from super customer to customr, or vise versa
	 * @param userName username that identifies account
	 * @param status can be 'SRCustomer' or 'RegisteredCustomer'
	 * @throws SQLException
	 */
	public void changeAccountStatus(String userName, String status) throws SQLException{
		
		// upgrade to SuperCustomer
		if (status.equals("SRCustomer")){
			accDB.upgradeCustomer(userName);
			
		} else if (status.equals("RegisteredCustomer")){
			accDB.downgradeSCustomer(userName);
		}
	}
	
	/**
	 * Change rental status changes a column in rental 
	 * @param rentalID rental ID 
	 * @param columnName can be any column in rental is_paid_rental, is_paid_extra_charge, is_check_overdue or is_check_return_branch
	 * @param status true or false
	 * @throws SQLException
	 */
	public void changeRentalStatus(int rentalID,String columnName, boolean status) throws SQLException{
		reDB.changeRentalStatus(rentalID, columnName, status);
	}
	
	/**
	 * Adding points to a customer's account according to its username
	 * @param userName
	 * @param points
	 * @throws SQLException
	 */
	public void addSRPoints(String userName, int points) throws SQLException
	{
		accDB.addSRPoints(userName, points);
	}

	/**
	 * Adding points to a super customer's account according to its ID
	 * @param customer_id
	 * @param points
	 * @throws SQLException 
	 */
	public void addSRPoints(int customer_id, int points) throws SQLException {
		// 
		String username = accDB.getUserNameFromId(customer_id);
		accDB.addSRPoints(username, points);
	}
	
	/**
	 * Deduct points to a super customer's account according to its ID
	 * @param customerAccountID
	 * @param points
	 * @throws SQLException
	 */
	public void deductSRPoints(int customer_id, int points) throws SQLException
	{
		String username = accDB.getUserNameFromId(customer_id);
		accDB.addSRPoints(username, -points);
	}
	
	/**
	 * Modifies password for an user
	 * @param userName username of an user
	 * @param newPassword new hashed password 
	 * @throws SQLException
	 */
	public void modifyPassword(String userName, String newPassword) throws SQLException{
		accDB.modifyPassword(userName, newPassword);
	}
	
	/**
	 * Gets username from ID
	 * @param id ID of an user
	 * @return username of an user 
	 * @throws SQLException
	 */
	public String getUsernameFromId(int id) throws SQLException{
		return accDB.getUserNameFromId(id);
	}
	
	/**
	 * Gets all active customer accounts including super rent customers 
	 * @return list of all active customer accounts 
	 * @throws SQLException
	 */
	public Customer[] getCustomerAccounts() throws SQLException{
		return accDB.getCustomerAccounts();
	}
	
	/**
	 * Activate account based on username
	 * @param username username of account
	 * @throws SQLException
	 */
	public void activateAccount(String username) throws SQLException{
		accDB.accountActivation(username, true);
	}
	
	/**
	 * Deactive account based on username
	 * @param username username of account 
	 * @throws SQLException
	 */
	public void deactivateAccount(String username) throws SQLException{
		//need to check if the account holds any rental at the moment
		accDB.accountActivation(username, false);
	
	}

/*---------------------------------------Used By vehicleDB------------------------------*/
	/**
	 * Update vehicle's owning branch
	 * @pre vehicle is always assumed to be at its owning branch
	 * @param v vehicle_id
	 * @param b branch_id
	 * @throws SQLException when the update fails
	 */
	public void updateVehicleLocation(int v, int b) throws SQLException {
		// 
		veDB.updateVehicleLocation(v, b);
	}
	
	/**
	 * Add vehicle's owning branch when it is first added
	 * @param v vehicle id
	 * @param b branch id 
	 * @throws SQLException
	 */
	public void addVehicleLocation(int v, int b) throws SQLException{
		veDB.addVehicleLocation(v, b);
	}

	/**
	 * Update vehicle's status from {for rent, for sale, sold}
	 * @param v vehicle_id
	 * @param status from {for rent, for sale, sold}
	 * @throws SQLException when the update fails
	 */
	public void updateVehicleStatus(int v, String status) throws SQLException {
		// 
		veDB.updateVehicleStatus(v, status);
	}

	/**
	 * Add a vehicle to database
	 * @param v {car, truck}
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public void addVehicle(Vehicle v) throws IllegalArgumentException, SQLException{
		// 
		if (v instanceof Car){
			veDB.addCar((Car) v);
		}
		else if (v instanceof Truck){
			veDB.addTruck((Truck)v);
		}
		else { //none of above
			throw new IllegalArgumentException("addVehicle only takes vehicle of type Car or Truck");
		}
	}

	/**
	 * Remove vehicle from database 
	 * @param vehicle_id id that uniquely identifies vehicle
	 * @param type type of vehicle {'car','truck'}
	 * @throws SQLException 
	 */
	public void removeVehicle(int vehicle_id, String type) throws SQLException {
		// 
		if (type.equals("car")){
			veDB.removeCar(vehicle_id);
		}
		else if (type.equals("truck")){
			veDB.removeTruck(vehicle_id);
		}
		else {
			throw new IllegalArgumentException("Vehicle can only be of 'car' or 'truck");
		}
	}

	/**
	 * Generic search of vehicles
	 * @param branch_id branch ID
	 * @param type type of vehicles (car or truck)
	 * @param start_date yyyy-MM-dd HH:mm:ss format
	 * @param end_date yyyy-MM-dd HH:mm:ss format
	 * @return list of vehicles available at this time at this branch
	 * @throws SQLException
	 */
	public Vehicle[] search(int branch_id, String type, String start_date, String end_date) throws SQLException{
		//System.out.println("Connected, trying to insert next");
		Vehicle[] vlist = veDB.search(branch_id,type,start_date, end_date);
		return vlist;
	}
	
	/**
	 * Searching for overdue trucks or cars (today) in a specific branch 
	 * @param branch_id branch ID
	 * @param type "car" or "truck" 
	 * @return list of overdue vehicles in this branch 
	 * @throws SQLException
	 */
	public Vehicle[] search(int branch_id, String type) throws SQLException {
		// 
		Vehicle[] vlist = null;
		if (type.equals("car")){
			vlist = veDB.searchOverdueCars(branch_id);
		}
		else if (type.equals("truck")){
			vlist = veDB.searchOverdueTrucks(branch_id);
		}
		else{
			throw new IllegalArgumentException("Type must be 'car' or 'truck'");
		}
		return vlist;
	}
	
	/**
	 * Searches for list of for-sale vehicles in a specific branch 
	 * @param branch_id branch Id of a branch
	 * @param type "car" or "truck"
	 * @return list of for sale vehicles in this branch 
	 * @throws SQLException
	 */
	public Vehicle[] searchForSale(int branch_id, String type) throws SQLException {
		// 
		Vehicle[] vlist = null;
		if (type.equals("car")){
			vlist = veDB.searchForsaleCars(branch_id);
		}
		else if (type.equals("truck")){
			vlist = veDB.searchForsaleTrucks(branch_id);
		}
		else{
			throw new IllegalArgumentException("Type must be 'car' or 'truck'");
		}
		return vlist;
	}
	
	/**
	 * Get the type of vehicle according to its vehicle ID
	 * @param vehicle_id
	 * @return
	 * @throws SQLException
	 */
	public String getTypeOfVehicle(int vehicle_id) throws SQLException
	{
		Vehicle v = veDB.search(vehicle_id);
		return v.getVehicleClass();
	}
	
/* -------------------------------------------PriceDB--------------------------------------------*/
	
	/**
	 * Returns a row of price according to row name and table name 
	 * @param type row name in specific table
	 * @param table_name table name in database
	 * @return row of prices (perHour, perDay, perWeek)
	 * @throws SQLException 
	 */
	public BigDecimal[] getPriceRow(String type, String table_name) throws SQLException {
		// 
		return prDB.getPriceRow(type,table_name);
	}
	
	/**
	 * Returns all car prices in database
	 * @return all car prices
	 * @throws SQLException
	 */
	public BigDecimal[][] getAllCarPrice() throws SQLException{
		return prDB.getCarPriceList();
	}
	
	/**
	 * Returns all truck prices in database
	 * @return all truck prices
	 * @throws SQLException
	 */
	public BigDecimal[][] getAllTruckPrice() throws SQLException{
		return prDB.getTruckPriceList();
	}
	
	/**
	 * Returns all equipment prices in database
	 * @return all equipment prices 
	 * @throws SQLException
	 */
	public BigDecimal[][] getAllEquipmentPrice() throws SQLException{
		return prDB.getEquipmentPriceList();
	}

//2.0 features
//	public void setAllCarPrice(){
//		
//	}
//	
//	public void setAllTruckPrice(){
//		
//	}
//	
//	public void setAllEquipmentPrice(){
//		
//	}
	/**
	 * Search for receipts based on customer ID 
	 * @param customer_id ID of customer
	 * @return list of receipts based for this customer 
	 * @throws SQLException
	 * @throws Error
	 */
	public Receipt[] searchReceipt(int customer_id) throws SQLException, Error{
		return prDB.getReceipt(customer_id);
	}
	
	/**
	 * Add receipt to database
	 * @param receipt an receipt object 
	 * @throws SQLException
	 * @throws Error
	 */
	public void addReceipt(Receipt receipt) throws SQLException, Error {
		prDB.addReceipt(receipt);
		
	}
	
	/**
	 * Get all extra charge price from database
	 * @return all extra charge prices 
	 * @throws SQLException
	 */
	public BigDecimal[] getAllExtraChargePrice() throws SQLException {
		return prDB.getAllExtraChargePrice();
	}

	
	/**
	 * Get all car insurance prices
	 * @return all car insurance prices
	 * @throws SQLException
	 */
	public BigDecimal[][] getAllCarInsurancePrice() throws SQLException{
		return prDB.getAllInsurancePrice(CAR);
	}

	/**
	 * Get all truck insurance prices 
	 * @return  all truck insurance prices 
	 * @throws SQLException
	 */
	public BigDecimal[][] getAllTruckInsurancePrice() throws SQLException{
		return prDB.getAllInsurancePrice(TRUCK);
	}



// 2.0 features
//	public void setAllCarInsurnacePrice(BigDecimal[][] bg){
//		
//	}
//	
//	public void setAllTruckInsurnacePrice(){
//		
//	}

	/**
	 * Checks if a rental has an inspection report before rental done
	 * @param rentID ID of rental
	 * @param status "before_rental" or "after_rental"
	 * @return true of there is an inspection report of that status 
	 * @throws SQLException 
	 */
	public boolean hasInspectionReport(int rentID, String status) throws SQLException {
		// 
		Report report = reDB.searchInspectionReport(rentID, status);
		if (report == null){
			return false;
		}
		else  { //there is an after rental report, or a before rental report
			return true;
		}
	}

	/**
	 * Get ID from username for any user
	 * @param clerk_username
	 * @return ID
	 * @throws Exception 
	 */
	public int getIdFromUsername(String username) throws Exception {
		// 
		return accDB.getIdFromUsername(username);
	}

	/**
	 * Checks if a rental has an accident report
	 * @param rental_id
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasAccidentReport(int rental_id) throws SQLException {
		// TODO Auto-generated method stub
		AccidentReport report = reDB.searchAccidentReport(rental_id);
		if (report == null){
			return false;
		}
		else  { //there is an accident report
			return true;
		}
	}
}
