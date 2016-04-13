package security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * For connecting from server to database bypassing logic, and for authentication purpose
 * @author Robin, Sammy
 *
 */
public class AuthenticateDB {
	
    private static final String CONN_STRING = "jdbc:mysql://159.203.34.123:3306/test3";
    
    // Database User Name and Password
    private static final String USERNAMEDATABASE = "diva";
    private static final String PASSWORD = "DiVA$E2016&";
    
	// for checking which type 
	private static final String USER = "`users`";
	private static final String CUSTOMER = "`customer`";
	private static final String SUPER_CUSTOMER = "`super_customer`";
	private static final String EMPLOYEE = "`employee`";
	private static final String USERNAME = "Account_uName";
	private static final String ID_NUM = "users.id_number";
    
    // A session with the database
    private Connection connection;
    
    /**
  	 * Connect to database
  	 * @pre !isConnect()
  	 * @post isConnected() 
  	 */
    private void connect() {
        if (!isConnected()){
            try{
              connection = DriverManager.getConnection(CONN_STRING, USERNAMEDATABASE, PASSWORD);
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
	private void disconnect() {
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
	public AuthenticateDB(){
		
	}
	/**
	 * getEncryptedpassword get the password from database that matches the username
	 * @param username a username
	 * @pre isValidUsername(username)
	 * @post encrypted password for that username
	 * @return encrypted password for that username
	 * @throws SQLException 
	 */
	public String retrievePassword(String username) throws SQLException {
		if (doesItExist(username, USER, USERNAME)){
			connect();
			String query = "SELECT account_password FROM users WHERE account_uName = '" + username +"';";
						
				Statement stmt = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				String password = rs.getString("account_password");
				disconnect();
				return password;		
		}else{
			return null;
		}
	}
	
	/**
	 * Get the type of account as a string
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	public String getAccountType(String username) throws SQLException, IllegalArgumentException {
		Statement stmt;
		ResultSet rs;
		String query, type = null;
		int id;
		connect();
		stmt = connection.createStatement();	
		query = "SELECT id_number FROM users WHERE "+ USERNAME+"= \'" +username+"\'";
		System.out.println(query);
		rs = stmt.executeQuery(query);
		
		//there is not a matching ID
		if (rs.next()) {
			id = rs.getInt("id_number");
		}
		else{
			return null;
		}
		//now we made sure that the username exists
		if (doesItExist(""+id, EMPLOYEE, ID_NUM)){
			type = getEmployeeType(id);
		} else if (doesItExist(""+id, SUPER_CUSTOMER, ID_NUM)){
			type = "super_customer";
		} else if (doesItExist(""+id, CUSTOMER, ID_NUM)){
			type = "customer";
		}
		
		rs.close();
		stmt.close();
		disconnect();
		return type;
	}
	
	/**
	 * Helper for getting type of employee (Clerk, Manager, SystemAdmin)
	 * @param id id for this employee
	 * @return type
	 * @throws SQLException
	 */
	private String getEmployeeType(int id) throws SQLException {
		Statement stmt;
		ResultSet rs;
		String query, type = null;
		connect();
		stmt = connection.createStatement();
		// TODO Auto-generated method stub
		query = "SELECT e_type FROM employee WHERE id_number = "+id;
		rs = stmt.executeQuery(query);
		if (rs.next()){
			type = rs.getString("e_type");
		}
		rs.close();
		stmt.close();
		disconnect();
		return type;
	}

	/**
	 * doesUsernameExist checks if the provided username is in the database
	 * @param username the proposed username
	 * @pre database is not empty
	 * @post true if username exists, false if it does not
	 * @return true if the username exists
	 */
	private boolean doesItExist(String id, String table, String param) throws SQLException {
		// database ojbects:
		Statement stmt;
		ResultSet rs;
		
		//
		String query = "";

		connect();
		stmt = connection.createStatement();
		
		// choose the query
		if (table.equals(CUSTOMER)){
			query = "SELECT " + param + " FROM users,customer WHERE users.id_number = customer.id_number;";
		} else if (table.equals(SUPER_CUSTOMER)){
			query = "SELECT " + param + " FROM users,customer, super_customer WHERE "
					+ "users.id_number = customer.id_number AND "
					+ "customer.id_number = super_customer.id_number;";
		} else if(table.equals(EMPLOYEE)){
			query = "SELECT " + param + " FROM users, employee WHERE "
					+ "users.id_number = employee.id_number";
			
		}	else if (table.equals(USER)){
			query = "SELECT " + param + " FROM users;";
		} else{
			// throw an error
		}
		
		// execute the query:
		rs = stmt.executeQuery(query);
		
		// check for any matching usernames
		while (rs.next()){
			if (id.equals(rs.getString(param))){
				disconnect();
				return true;
			}
		}
		
		disconnect();
		return false;
	}

}
