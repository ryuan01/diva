/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Date;

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
	private ConnectDB conDB;
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
	/*public  boolean addBranch(Branch b){
		return branDB.addBranch(b);
	}
	
	public  boolean removebranch(String b_key_value) throws SQLException{
		return branDB.removebranch(b_key_value);
	}
	
	public  void changeBranch(String b_key_value){
		branDB.changeBranch(b_key_value);
	}*/
	
	/**
	 * Get a list of branches
	 * @pre conDB is not connected
	 * @post conDB is disconnected
	 * @return
	 */
	public Branch[] getBranch(){
		conDB.connect();
		Branch[] blist = branDB.getBranch(conDB.getConnection());
		conDB.disconnect();
		return blist;
	}
	// EquipmentDB


   
	// RentalDB
	
	/**
	 * Create an reservation entry in database
	 * @param r reservation
	 * @pre r.id is null
	 * @pre r is not in database
	 * @post r.id is updated 
	 */
	public void createReservationEntry(Reservation r) {
		conDB.connect();
		//System.out.println("Connected, trying to insert next");
		reDB.createReservation(conDB.getConnection(), r);
		conDB.disconnect();
	}
	
	public void removeReservationEntry(String reservID) {
		// TODO Auto-generated method stub
		
	}

	public void changeStatus(String reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	public Reservation[] searchReservationEntries(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public void modifyReservationEntries(String reservID, String id) {
		// TODO Auto-generated method stub
		
	}

	public void modifyReservationStartDateEntries(String reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	public void modifyReservationEndDateEntries(String reservID, String string) {
		// TODO Auto-generated method stub
		
	}

	public void makePayment(String reservID, String typeOfPayment) {
		// TODO Auto-generated method stub
		
	}

	public void createReturn(String reservID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Can we cancel a rental? 
	 * @param reservID
	 */
	public void removeRental(String reservID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Is rental different from Reserve? 
	 * @param reservID
	 */
	public void createRental(String reservID) {
		// TODO Auto-generated method stub
		
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
	 */
	public Vehicle[] search(String branch_id, String type, Date start_date, String[] list){
		conDB.connect();
		//System.out.println("Connected, trying to insert next");
		Vehicle[] vlist = veDB.search(conDB.getConnection(),branch_id,type,start_date,null);
		conDB.disconnect();
		return vlist;
	}
	
}
