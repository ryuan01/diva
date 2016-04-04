/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

import accountManagement.Account;
import rentalManagement.AccidentReport;
import rentalManagement.Report;
import rentalManagement.Reservation;
//import accountManagement.Account;
import systemManagement.Branch;
import vehicleManagement.Vehicle;

/*Robin */
/*edited by Sammy*/
/**
 * DatabaseManager deals with connection to database
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
    
    // AccountDB
	/*public Account getAccount(String uname) {
		return accDB.getAccount(uname);
	}
	
	public Account getAccount(String fname, String lname, String phonenum) {
		return accDB.getAccount(fname, lname, phonenum);
	}
	
	public boolean loginPasswordUpdate(String username, String enOldPw, String enNewPw){
		return accDB.loginPasswordUpdate(username, enOldPw, enNewPw);
	}
	
	public void accountUpdate(String acc_key_value, String field, String newInfo) {
		accDB.accountUpdate(acc_key_value, field, newInfo);
	}
	
	public void accountUpdateStatus(Account acc, String status) {
		accDB.accountUpdateStatus(acc, status);
	}
	
	public void updateAccountPoints(String acc_key_value, int pt) {
		accDB.updateAccountPoints(acc_key_value, pt);
	}
	
	public void updateAccountBalance(String acc_key_value,Currency amount) {
		accDB.updateAccountBalance(acc_key_value, amount);
	}
	
	public boolean createAccount(String[] info) {
		return accDB.createAccount(info);
	}
	
	public void archiveAccount(String acc_key_value) {
		accDB.archiveAccount(acc_key_value);
	}*/
	// BranchDB
	public  void addBranch(Branch b) throws SQLException{
		branDB.addBranch(b);
	}
	
	/*public  boolean removebranch(String b_key_value) throws SQLException{
		return branDB.removebranch(b_key_value);
	}
	
	public  void changeBranch(String b_key_value){
		branDB.changeBranch(b_key_value);
	}*/
	

	// EquipmentDB


   
	// RentalDB
	
	/**
	 * Create an reservation entry in database
	 * @param r reservation
	 * @pre r.id is null
	 * @pre r is not in database
	 * @post r.id is updated 
	 */
	public boolean createReservationEntry(Reservation r) {
		// Look at the note in getBranch method
		conDB.connect();
		//System.out.println("Connected, trying to insert next");
		reDB.createReservation(conDB.getConnection(), r);
		conDB.disconnect();
		return true;
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
	public Reservation[] searchReservationEntries(int reservID, Date startDate,Date endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status) {
		return null;
		// TODO Auto-generated method stub
		
	}

	// updated signature
	public boolean modifyReservationEntries(int reservID, Date startDate,Date endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status) {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean addReport(Report r)
	{
		return true;
	}
	
	public Date getReservationEndDate(int reservID)
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
	 * @param start_date
	 * @param list
	 * @return
	 * @throws SQLException 
	 */
	public Vehicle[] search(int branch_id, String type, Date start_date) throws SQLException{
		//System.out.println("Connected, trying to insert next");
		Vehicle[] vlist = veDB.search(branch_id,type,start_date);
		return vlist;
	}
	
	public Vehicle[] search(int branch_id, String type) {
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
	
	public Vehicle[] searchForSale(int branch_id, String type) {
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
	
	public boolean addSRPoints(int i, int points)
	{
		return true;
	}
	
	public boolean modifyPassword(String userName, String newPassword)
	{
		return true;
	}
	
	
	
	//Branch Related
	public boolean createBranchEntry(Branch b)
	{
		return true;
	}
	
	public boolean modifyBranchEntry(int id,String address, String city, String province, String zipcode)
	{
		return true;
	}
	
	public boolean removeBranchEntry(int id)
	{
		return true;
	}
	
	public Branch getBranchEntry(int id)
	{
		return null;
	}
}
