/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

import java.sql.Connection;
import java.sql.SQLException;
import accountManagement.Account;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/**
 * DatabaseManager deals with all functions that interacts with database
 * @author Robin, Sammy
 */
public class DatabaseManager {
	
	// I am modeling as Has-A relationship
	// Not sure if I need to change this? 
	private ConnectDB conDB; // you don't need to create a ConnectDB object here
	//private AccountDB accDB;
	private BranchDB branDB;
	//private EquipmentDB eqDB;
	private RentalDB reDB;
	private VehicleDB veDB;
    
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
		conDB = new ConnectDB();
		//accDB = new AccountDB();
		branDB = new BranchDB();
		//eqDB = new EquipmentDB();
		reDB = new RentalDB();
		veDB = new VehicleDB();
    }
       
	
    // ConnectDB
	/**
	 * Connect to database
	 * @pre !isConnect()
	 * @post isConnected() 
	 */
	public void connect() {
		// you don't need to create a ConnectDB object here
		conDB.connect();
	}
	
	/**
	 * Get the connection
	 * @pre none
	 * @post none
	 * @return a Connection object
	 */
	public Connection getConnection(){
		return conDB.getConnection();
	}
	
	/**
	 * Disconnect to database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	public void disconnect() {
		conDB.disconnect();
	}
 
	//Branch Related
	/**
	 * 
	 * @param b
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
	

	// EquipmentDB

	// probably should be able to add/delete equipments, modify them

   
	// RentalDB
	
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
	
	// can be implemented, removes a Reservation from the database completely, not archived.
	public boolean removeReservationEntry(int reservID) {
		// TODO Auto-generated method stub
		return true;
	}

	// can be implemented, changes status of reservation only.
	public void changeReservationStatus(int reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	// updated signature
	public boolean modifyReservationEntries(int reservID, String startDate,String endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Reservation searchReservationEntry(int reservID) throws SQLException {
		// TODO Auto-generated method stub
		return reDB.reservationQuery(reservID);
	}


	public boolean addReport(Report r)
	{
		return true;
	}
	
	public String getReservationEndDate(int reservID)
	{
		return null;
	}
	
	
	public Account getReservationAccount(int reservID)
	{
		return null;
	}
	
	//VehicleDB
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
	 * 
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
	
	
	// Account related
	
	public boolean createAccountEntry(Account a)
	{
		return true;
	}
	
	public boolean removeAccountEntry(String userName)
	{
		return true;
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
	public boolean modifyAccountEntry(String firstname, String lastname, String phoneNumber, String email, String loginId, String status)
	{
		return true;
	}
	
	public boolean changeAccountStatus(String userName, String status)
	{
		return true;
	}
	
	public boolean addSRPoints(String userName, int points)
	{
		return true;
	}
	public void addSRPoints(int i, int points) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean modifyPassword(String userName, String newPassword)
	{
		return true;
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
}
