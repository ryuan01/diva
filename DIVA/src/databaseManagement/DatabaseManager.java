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
	private AccountDB accDB;
	private BranchDB branDB;
	//private EquipmentDB eqDB;
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
    // I'm not sure what this method is for (-samahri)
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
		accDB = new AccountDB();
		branDB = new BranchDB();
		//eqDB = new EquipmentDB();
		reDB = new RentalDB();
		veDB = new VehicleDB();
		prDB = new PriceDB();
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
	// We don't need this method in AccountDB (-samahri)
	public Connection getConnection(){
		return conDB.getConnection();
	}
	
	/**
	 * Disconnect to database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	// We don't need this method in AccountDB (-samahri)
	public void disconnect() {
		conDB.disconnect();
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

	// probably should be able to add/delete equipments, modify them

   
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
	
	// can be implemented, removes a Reservation from the database completely, not archived.
	public void removeReservationEntry(int reservID) {
		// TODO Auto-generated method stub
	}

	// can be implemented, changes status of reservation only.
	public void changeReservationStatus(int reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	// updated signature
	public void modifyReservationEntries(int reservID, String startDate,String endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status) {
		// TODO Auto-generated method stub
	}
	
	public Reservation searchReservationEntry(int reservID) throws SQLException {
		// TODO Auto-generated method stub
		return reDB.reservationQuery(reservID);
	}


	public void addReport(Report r)
	{
	}
	
	public String getReservationEndDate(int reservID)
	{
		return null;
	}
	
	
	public Account getReservationAccount(int reservID)
	{
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
}
