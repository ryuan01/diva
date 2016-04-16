/**
 * ConnectDB handles all database connections
 * Author: Saud (Sammy) Almahri
 * @version March 28'th 2016
 */
package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectDB{
	/**
	 * Database IP address
	 */
    private static final String CONN_STRING = "jdbc:mysql://159.203.34.123:3306/test3";
    
    /**
     * database username & password
     */
    private static final String USERNAME = "diva";
    private static final String PASSWORD = "DiVA$E2016&";
    

    private Connection connection;
    
    /**
     * default constructor
     */
    public ConnectDB(){
      connection = null;
    }
 
 /* ------------------------------------------ public interface ------------------------------- */
    /**
     * 
     * @return a connection ojbect
     */
    public Connection getConnection(){
    	return connection;
    }
    
    /**
  	 * Connect to database
  	 * @pre !isConnect()
  	 * @post isConnected() 
  	 */
    public void connect() {
        if (!isConnected()){
            try{
              connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch(SQLException e){
              System.err.println(e);
            }
        }
    }
    
    /**
	 * Disconnect from database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	public void disconnect() {
		if(isConnected()){
			try{
				connection.close();
				//System.out.println("Disconnected");
			} catch(SQLException e){
				System.err.println(e);
			}finally{
				connection = null;
			}
		}
	}

/* ------------------------------------------ private methods ------------------------------- */
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
	
	
}
