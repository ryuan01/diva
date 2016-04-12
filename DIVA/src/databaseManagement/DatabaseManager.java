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
import rentalManagement.AccidentReport;
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
       
	//Branch Related
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
	

	// 
/*----------------------------------------EquipmentDB--------------------------------------------*/

	/**
	 * Search for additional equipments available
	 * @param type ENUM('ski rack','child safety seat','lift gate','car-towing eq')
	 * @param branch_num branch that this equipment belongs to
	 * @return list of equipments of a type that is available at a branch
	 * @throws SQLException
	 */
	public Equipment[] searchAdditionalEquipments(String type, int branch_num) throws SQLException{
		return eqDB.searchAdditionalEquipments(type, branch_num);
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

	// can be implemented, changes status of reservation only.
	// doesn't have a status as of now, maybe implemented later
	/*
	public void changeReservationStatus(int reservID, String string) {
		// TODO Auto-generated method stub
		
	}*/

	// updated signature
	// maybe hard to do because of how we track reserved dates
	// for version 2.0 maybe
	/*
	public void modifyReservationEntries(int reservID, String startDate,String endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status) {
		// TODO Auto-generated method stub
	}*/
	
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
		//waiting for sammy's method for getting account from ID		r.getCustomerAccountID();
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
<<<<<<< HEAD
	 * Searching for overdue trucks or cars (today)
=======
	 * 
>>>>>>> benZ
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
	
	
/*---------------------------------------Account related----------------------------------------------*/
	
	public void createAccountEntry(Account account) throws SQLException{
		if (account instanceof Customer){
			accDB.createCustomer((Customer)account);
		} else if (account instanceof Employee){
			accDB.createEmployee((Employee)account);
		}
	}
	
	public void removeAccountEntry(String userName)
	{
	}
	
	public Account[] searchAccountEntries(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String status)
	{
		return null;
	}
	
	public String retrievePassword(String userName)
	{
		return null;
	}
	
	// find account by loginID, loginID should be immutable
	public void modifyAccountEntry(String firstname, String lastname, String phoneNumber, String email, String loginId, String status)
	{
	}
	
	public void changeAccountStatus(String userName, String status) throws SQLException{
		
		// upgrade to SuperCustomer
		if (status.equals("SRCustomer")){
			accDB.upgradeCustomer(userName);
			
		}
	}
	
	public void addSRPoints(String userName, int points)
	{
	}
	
	public void addSRPoints(int i, int points) {
		// TODO Auto-generated method stub
		
	}
	
	public void modifyPassword(String userName, String newPassword)
	{
	}

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
	
/* --------------------------------------USED BY PAYMENT MANAGER--------------------------------------*/
	
	// returns BigDecimal[9][5]
	public BigDecimal[][] getCarPriceList() throws SQLException
	{
		return prDB.getCarPriceList();
	}

	// returns BigDecimal[4][5]
	public BigDecimal[][] getTruckPriceList() throws SQLException
	{
		return prDB.getTruckPriceList();
	}

	// returns BigDecimal[4][3]
	public BigDecimal[][] getEquipmentPriceList() throws SQLException
	{
		return prDB.getEquipmentPriceList();
	}
	
	// returns BigDecimal[9][3]
	public BigDecimal[][] getCarInsurancePriceList() throws SQLException
	{
		return prDB.getCarInsurancePriceList();
	}
	
	// returns BigDecimal[3][9]
	public BigDecimal[][] getTruckInsurancePriceList() throws SQLException
	{
		return prDB.getTruckInsurancePriceList();
	}
	
	// sets BigDecimal[5][9]
	public boolean setCarPriceList(BigDecimal[][] a)
	{
		return true;
	}

	// sets BigDecimal[5][4]
	public boolean setTruckPriceList(BigDecimal[][] a)
	{
		return true;
	}

	// sets BigDecimal[3][4]
	public boolean setEquipmentPriceList(BigDecimal[][] a)
	{
		return true;
	}
	
	// sets BigDecimal[3][9]
	public boolean setCarInsurancePriceList(BigDecimal[][] a)
	{
		return true;
	}
	
	// sets BigDecimal[3][9]
	public boolean setTruckInsurancePriceList(BigDecimal[][] a)
	{
		return true;
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

	/**
	 * Create an rental
	 * @param reserveID
	 * @param clerkID
	 * @param is_paid_rental
	 * @param is_paid_extra_charge
	 * @throws SQLException
	 */
	public void createRental(int reserveID, int clerkID, boolean is_paid_rental, boolean is_paid_extra_charge) throws SQLException {
		// TODO Auto-generated method stub
		reDB.createRental(reserveID, clerkID, is_paid_rental, is_paid_extra_charge);
	}
}
