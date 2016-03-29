/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Robin */
/*edited by Sammy*/
/**
 * DatabaseManager deals with connection to database
 * @author Robin, Sammy
 * @invariant dbname database name 
 * @invariant pw password for connection 
 */

public class DatabaseManager {
	
	//Database URL
    //THIS IS SET TO A TEST DATABASE: CHANGE TO 'diva_main' WHEN DEPLOYED!!
    private static final String CONN_STRING = "jdbc:mysql://localhost/test";
    
    // Database User Name and Password
    private static final String USERNAME = "diva";
    private static final String PASSWORD = "DiVA$E2016&";
    
    // A session with the database
    private Connection connection;
    
    //singieton design pattern
    private static DatabaseManager instance = null;
    
	/** 
	* Constructs a DatabaseManager
	* @post an only DatabasManager object is created
	*/
    private DatabaseManager(){
    }
    
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
	 * Connect to database
	 * @pre !isConnect()
	 * @post isConnected() 
	 */
	public void connect() {
		if (!isConnected()){
			try{
				System.out.println("Connecting...");
				connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				System.out.println("Connected");
			} catch(SQLException e){
				System.err.println(e);
			}
		}
	}
	
	/**
	 * @pre none
	 * @post none
	 * @return a Connection object
	 */
	public Connection getConnection(){
		return connection;
	}
	
	/**
	 * Disconnect to database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	public void disconnect() {
		if(isConnected()){
			try{
				connection.close();
				System.out.println("Disconnected");
			} catch(SQLException e){
				System.err.println(e);
			}finally{
				connection = null;
			}
		}
	}
	
	/**
	 * Checks if there is a connection
	 * @pre none
	 * @post returns true if there is a connection, otherwise false 
	 */
	private boolean isConnected() {
		//maybe use instance ? 
		if(connection != null){
			return true;
		} else{
			return false;
		}
	}
    
    // AccountDB calls:
   
}
