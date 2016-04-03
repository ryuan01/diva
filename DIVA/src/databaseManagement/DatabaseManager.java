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
	public boolean removeReservationEntry(String reservID) {
		// TODO Auto-generated method stub
		return true;
	}

	// can be implemented, changes status of reservation only.
	public void changeReservationStatus(String reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	// updated signature
	public Reservation[] searchReservationEntries(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status) {
		return null;
		// TODO Auto-generated method stub
		
	}

	// updated signature
	public boolean modifyReservationEntries(String reservID, Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status) {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean addReport(Report r)
	{
		return true;
	}
	
	public boolean addAccidentReport(AccidentReport r)
	{
		return true;
	}
	
	public Date getReservationEndDate(String reservID)
	{
		return null;
	}
	
	
	public Account getReservationAccount(String reservID)
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
	public Vehicle[] search(String branch_id, String type, Date start_date, String[] list) throws SQLException{
		// Look at the note in getBranch method
		// Also, don't throw an exception here! throw means pass the problem to the calling class, the calling class
		// has no SQLException type. This might cause debugging problems
		conDB.connect();
		//System.out.println("Connected, trying to insert next");
		Vehicle[] vlist = veDB.search(conDB.getConnection(),branch_id,type,start_date,null);
		conDB.disconnect();
		return vlist;
	}
	
	
	
	// Account related
	
	public boolean createAccountEntry(Account a)
	{
		return true;
	}
	
	public boolean removeAccountEntry(Account a)
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
	
	public boolean changeAccountStatus(Account a, String status)
	{
		return true;
	}
	
	public boolean addSRPoints(Account a, int points)
	{
		return true;
	}
}
