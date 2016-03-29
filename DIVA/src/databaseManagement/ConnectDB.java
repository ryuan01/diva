/**
 * ConnectDB handles all database connections
 * Author: Saud (Sammy) Almahri
 * Date: March 28'th 2016
 */
package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectDB{
  	//Database URL
    //THIS IS SET TO A TEST DATABASE: CHANGE TO 'diva_main' WHEN DEPLOYED!!
    private static final String CONN_STRING = "jdbc:mysql://localhost/test";
    
    // Database User Name and Password
    private static final String USERNAME = "diva";
    private static final String PASSWORD = "DiVA$E2016&";
    
    // A session with the database
    private Connection connection;
    
    public ConnectDB(){
      connection = null;
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
}
