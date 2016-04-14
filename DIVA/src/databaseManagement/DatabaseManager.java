/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
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
	// Not sure if I need to change this? 
	private AccountDB accDB;
	private BranchDB branDB;
	private EquipmentDB eqDB;
	private RentalDB reDB;
	private VehicleDB veDB;
	private PriceDB prDB;
    
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
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void removeBranchEntry(int id) throws SQLException
	{
		branDB.removebranch(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Branch getBranchEntry(int id) throws SQLException
	{
		return branDB.getBranch(id);
	}
	
	public Branch[] getAllBranchEntries() throws SQLException
	{
		return branDB.getAllBranch();
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
		Equipment e = eqDB.search(equipment_id);
		return e.getType();
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
		// TODO Auto-generated method stub
		reDB.removeReservation(reservID);
	}

	/**
	 * 
	 */
	public boolean checkReservationBalance(int reservation_id){
		return reDB.checkReservationBalance(reservation_id);
	}
	
	
	/**
	 * Search database for a reservation
	 * @param reservID uniquely identifies reservation
	 * @return reservation object
	 * @throws SQLException query has problems
	 */
	public Reservation searchReservationEntry(int reservID) throws SQLException {
		// TODO Auto-generated method stub
		return reDB.reservationQuery(reservID);
	}

	/**
	 * Add an inspection report for Database
	 * @param r inspection report 
	 * @param state: ENUM('before_rental','after_rental')
	 * @throws SQLException
	 */
	public void addReport(Report r, String state) throws SQLException
	{
		reDB.createInspectionReport(r, state);
	}
	
	/**
	 * Add an accident report for database
	 * @param r accident report
	 * @throws SQLException
	 */
	public void addAccidentReport(AccidentReport r) throws SQLException{
		reDB.createAccidentReport(r);
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
	 * 
	 * @param reservID
	 * @return
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
	public void createRental(int reserveID, int clerkID, boolean is_paid_rental, boolean is_paid_extra_charge) throws SQLException {
		reDB.createRental(reserveID, clerkID, is_paid_rental, is_paid_extra_charge);
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
	 * Get the account for the rental, for calculating price purpose
	 * @param rental_id
	 * @return
	 */
	public int getAccountForRental(int rental_id) {
		// TODO Auto-generated method stub
		return reDB.getAccountForRental(rental_id);
	}
	
	/**
	 * Get a vehicle inside reservation, for calculating price purpose
	 * @param reservID
	 * @return Vehicle
	 * @throws SQLException 
	 */
	public Vehicle getReservationVehicle(int reservID) throws SQLException {
		// TODO Auto-generated method stub
		Reservation r = reDB.reservationQuery(reservID);
		int vehicle_id = r.getVehicleID();
		Vehicle v = veDB.search(vehicle_id);
		return v;
	}
	
	/**
	 * Returns a string made from 
	 * @param id
	 * @return
	 */
	public String getReservationInReceiptForm(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*-----------------------------------------VehicleDB----------------------------------------------*/
	/**
	 * Generic search of vehicle available at certain date, certain branch 
	 * @param c
	 * @param branch_id
	 * @param type
	 * @param time
	 * @param end_date 
	 * @param list
	 * @return
	 * @throws SQLException 
	 */
	public Vehicle[] search(int branch_id, String type, String start_date, String end_date) throws SQLException{
		//System.out.println("Connected, trying to insert next");
		Vehicle[] vlist = veDB.search(branch_id,type,start_date, end_date);
		return vlist;
	}
	
	/**
	 * Searching for overdue trucks or cars (today)
	 * @param branch_id
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public Vehicle[] search(int branch_id, String type) throws SQLException {
		// TODO Auto-generated method stub
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
	 * 
	 * @param branch_id
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public Vehicle[] searchForSale(int branch_id, String type) throws SQLException {
		// TODO Auto-generated method stub
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
	
/*---------------------------------------Account related----------------------------------------------*/
	
	public void createAccountEntry(Account account) throws SQLException{
		if (account instanceof Customer){
			accDB.createCustomer((Customer)account);
		} else if (account instanceof Employee){
			accDB.createEmployee((Employee)account);
		} // create one for superCustomer account
	}
	
	public void removeAccountEntry(String userName) throws SQLException
	{
		accDB.removeAccountEntry(userName);
	}
	
	/**
	 * 
	 * @param parameter can be either username, lastname, or phonenumber
	 * @return
	 * @throws SQLException 
	 */
	public Account[] searchAccountEntries(String parameter) throws SQLException{
		// Needs to be done
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
		// TODO Auto-generated method stub
		String username = accDB.getUserNameFromId(customerAccountID);
		System.out.println();
		return accDB.getAccounts(username)[0];
	}
	
	// find account by loginID, loginID should be immutable
//	public void modifyAccountEntry(String firstname, String lastname, String phoneNumber, String email)
//	{
//	}
	
	public void changeAccountStatus(String userName, String status) throws SQLException{
		
		// upgrade to SuperCustomer
		if (status.equals("SRCustomer")){
			accDB.upgradeCustomer(userName);
			
		} else if (status.equals("RegisteredCustomer")){
			accDB.downgradeSCustomer(userName);
		}
	}
	
	public void changeRentalStatus(int rentalID, boolean status) throws SQLException{
		reDB.changeRentalStatus(rentalID, status);
	}
	
	public void addSRPoints(String userName, int points) throws SQLException
	{
		accDB.addSRPoints(userName, points);
	}
		
	public void modifyPassword(String userName, String newPassword) throws SQLException{
		accDB.modifyPassword(userName, newPassword);
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		veDB.updateVehicleStatus(v, status);
	}

	/**
	 * Add a vehicle to database
	 * @param v {car, truck}
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public void addVehicle(Vehicle v) throws IllegalArgumentException, SQLException{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	
/* --------------------------------------PriceDB--------------------------------------*/
	
	/**
	 * Returns a row of price according to row name and table name 
	 * @param type row name in specific table
	 * @param table_name table name in database
	 * @return row of prices (perHour, perDay, perWeek)
	 * @throws SQLException 
	 */
	public BigDecimal[] getPriceRow(String type, String table_name) throws SQLException {
		// TODO Auto-generated method stub
		return prDB.getPriceRow(type,table_name);
	}
	
	public BigDecimal[][] getAllCarPrice() throws SQLException{
		return prDB.getCarPriceList();
	}
	
	public BigDecimal[][] getAllTruckPrice() throws SQLException{
		return prDB.getTruckPriceList();
	}
	
	public BigDecimal[][] getAllEquipmentPrice() throws SQLException{
		return prDB.getEquipmentPriceList();
	}

	public void addReceipt(Receipt receipt) {
		// TODO Auto-generated method stub
		
	}
}
