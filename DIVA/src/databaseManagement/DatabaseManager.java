package databaseManagement;

import java.sql.Connection;
import java.sql.DriveManager;
import java.sql.SQLException;

/*Robin */
/*edit by Sammy*/
/**
 * DatabaseManager deals with connection to database
 * @invariant dbname database name 
 * @invariant pw password for connection 
 */
public class DatabaseManager {
	
	//Database URL
        //THIS IS SET TO A TEST DATABASE: CHANGE TO 'diva_main' WHEN DEPLOYED!!
        private static final String CONN_STRING = "jdbc:mysql://localhost/diva_test";
        
        // Database User Name and Password
        private static final String USERNAME = "diva";
        private static final String PASSWORD = "DiVA$E2016&";
        
        private Connectionn conn;
	
	/** 
	 * Constructs a DatabaseManager
	 * @param db a db name 
	 * @param pass an encrypted password
	 * @pre db and pass are valid
	 * @post a DatabasManager object is created
	 * Note1: The database username and pwd are static final variables and do not need to be passed into these methods
	 * Note2: Consider making them protected
	 */
	protected DatabaseManager() {
		conn = null;
	}
	
	/**
	 * Connect to database
	 * @pre !isConnect()
	 * @post isConnected() 
	 */
	protected void connect() {
		if ()
		try{
			conn = DriveManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		} catch(SQLException e){
			System.err.println(e);
		} finally{
			disconnect();
		}
	}
	
	/**
	 * Disconnect to database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	private void disconnect() {
		try{
			conn.close();
		} catch(SQLException e){
			System.err.println(e);
		}
	}
	
	/**
	 * Checks if there is a connection
	 * @pre none
	 * @post returns true if there is a connection, otherwise false 
	 */
	public boolean isConnected() {
		return false;
	}

}
