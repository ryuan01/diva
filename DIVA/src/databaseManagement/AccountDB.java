package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import accountManagement.Account;
/**
 * AccountDB provides services related to the creation, deletion, and modification of account
 * @author Robin
 * no invariant 
 */
class AccountDB{
	
	private ConnectDB dbm;
	//checking 
	public AccountDB() {
		dbm = new ConnectDB();
	}

	/**
	 * isValidUsername checks if the provided username is in the database
	 * @param username the proposed username
	 * @pre database is not empty
	 * @post true if username exists, false if it does not
	 * @return true if the username exists
	 */
	private boolean isValidUsername(String username) throws SQLException {
		//Get DatabaseManager instance and connect to the database
		dbm.connect();
		
		// execute the query:
		Statement stmt = dbm.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		
		// check for uany matching usernames
		while (rs.next()){
			if (username.equals(rs.getString("account_uName"))){
				dbm.disconnect();
				return true;
			}
		}
		dbm.disconnect();
		return false;
	}
	
	/**
	 * isValidLogin checks if the username and pw matches
	 * @param username a username
	 * @param pw the encrypted password
	 * @throws SQLException 
	 * @pre isValidUsername(username)
	 * @post true if the there is a match, otherwise false
	 */
	private boolean isValidLogin(String username, String pw) throws SQLException {
		if (isValidUsername(username) == true){
			dbm.connect();
		
			Statement stmt = dbm.getConnection().createStatement();
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
		
			while(rs.next()){
				if ((username.equals(rs.getString("account_uName")) == true) && (pw.equals(rs.getString("account_password")) == true)){
					dbm.disconnect();
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * isValidAccount checks if the provided account exists
	 * @param acc_key_value a key value that represents account object
	 * @pre database account is not empty
	 * @post true if it exists, false if it does not
	 * @return true if it exists, false if it does not
	 * @throws SQLException 
	 */
	private boolean isValidAccount(Account acc) throws SQLException {
		dbm.connect();
		String username = acc.getLoginId(); // Note: username is cases sensitive 
		
		
		Statement stmt = dbm.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
		
		while(rs.next()){
			if (username.equals(rs.getString("account_uName"))){
				dbm.disconnect();
				return true;
			}
				
		}
		dbm.disconnect();
		return false;
	}
	
	/**
	 * getAccountKeyValue gets an account's key value from database
	 * @param username the username related to a account
	 * @return 
	 * @pre isValidUsername(username)
	 * @post Account object
	 * @return Account object
	 * @throws SQLException 
	 */
	public Account getAccount(String username) throws SQLException {
		if(isValidUsername(username)){
			dbm.connect();
			
			Statement stmt = dbm.getConnection().createStatement();
				
			// Problem: how to determine the "type" of account (whether it's a customer, employee, clerk, etc..)
				
			dbm.disconnect();
			
		}
		return null;
	
	}
	
	/**
	 * getAccount gets an account from database
	 * @param fname first name
	 * @param lname last name
	 * @param phonenum phone number
	 * @pre fname, lname, and phonenum are formatted properly
	 * @pre isValidAccount(fname,lname,phonenum)
	 * @post Account object 
	 * @return Account object
	 * @throws SQLException 
	 */
	public Account getAccount(String fname, String lname, String phonenum) throws SQLException {
		dbm.connect();
		

		Statement stmt = dbm.getConnection().createStatement();
			
		// problem: how to determine the "type" of account (whether it's a customer, employee, clerk, etc..)
	
		dbm.disconnect();
		return null;
	}
	
	//not needed because searchCustomer is just part of getAccount 
	//searchCustomer();
	
	//isValidUsername, the same thing 
	//unless we want to get the whole list of usernames? 
	//getusername();
	
	
	//modifier 
	
	//loginupdate as in, updating the password?
	/**
	 * loginPasswordUpdate updates an username with a new password
	 * @param usernmae a username
	 * @param oldPw the old encrypted password
	 * @param enNewPw the new encrypted password
	 * @pre isValidLogin(username, oldPw)
	 * @post isValidLogin(username, enNewPw)
	 * @return boolean value if the update is succesfull, return true; otherwise, resturn false
	 * @throws SQLException 
	 */
	public boolean loginPasswordUpdate(String username, String enOldPw, String enNewPw) throws SQLException {
		if (isValidLogin(username, enOldPw)){
			dbm.connect();
			
			
			Statement stmt = dbm.getConnection().createStatement();
			String query = "UPDATE users SET account_password= '" + enNewPw +
					"' WHERE account_uName='" + username + "' AND account_password='" + enOldPw + "';";
					
			stmt.executeUpdate(query);
			dbm.disconnect();
			return true;
	
			
		} else{
			
			return false;
		}
	}
	
	//need to check Kevin's work for naming conventions 
	/**
	 * updateAccountPoint updates the points related to an account
	 * @param acc an account 
	 * @param pt the pt to be added, can be negative
	 * @pre isValidAccount(acc)
	 * @pre pt+acc.points >= 0
	 * @pre typeof(acc) == SuperRent
	 * @post acc.points =  pt + acc.points
	 */
	public void updateAccountPoints(Account acc, int pt) {
	}
		
	//not too sure if types are just subclasses, how do we update them?
	//updateaccountype();
	
	/**
	 * createAccount create an new account
	 * @param info the list of information for a new account, 
	 * following the order of {loginId, password, firstname, lastname, phoneNumber, email}
	 * @throws SQLException 
	 * @pre !isValidAccount(info[2],info[3],info[4]);
	 * @pre !isValidUsername(info[0]);
	 * @post isValidAccount(loginId);
	 */
	public boolean createAccount(String[] info) throws SQLException {
		// Does it need to specify the account type?
		
		if (!isValidAccount(info[2], info[3], info[4]) && !isValidUsername(info[0])){
			dbm.connect();
			
			Statement stmt = dbm.getConnection().createStatement();
			
			String query = "INSERT INTO `users` (`first_name`,`last_name`,`phone`,`email`,`account_uName`,`account_password`) "+
					"VALUES ('" + info[2] + "','" + info[3] + "','"+ info[4] + "','"+ info[5] + "','"+ info[0] + "','"
					+ info[1] + "');";
			System.out.println();
			stmt.executeUpdate(query);
			dbm.disconnect();
			return true;
			
		} else{
			return false;
		}
		
	}
	//same as loginPasswordUpdate
	//updatePassword();

	//not sure if we really want this, but OK.
	//I think for security purpose, we might want to move the validation inside to this class
	/**
	 * getEncryptedpassword get the password from database that matches the username
	 * @param username a username
	 * @pre isValidUsername(username)
	 * @post encrypted password for that username
	 * @return encrypted password for that username
	 * @throws SQLException 
	 */
	private String getEncryptedPassword(String username) throws SQLException {
		if (isValidUsername(username)){
			dbm.connect();
			String query = "SELECT account_password FROM users WHERE account_uName = '" + username +"';";
						
				Statement stmt = dbm.getConnection().createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				String password = rs.getString("account_password");
				dbm.disconnect();
				return password;		
		}else{
			return null;
		}
	}
	/**
	 * isValidAccount checks if the provided account exists
	 * @param fname first name
	 * @param lname last name
	 * @param phonenum phone number
	 * @pre database account is not empty
	 * @post true if it exists, false if it does not
	 * @return true if it exists, false if it does not
	 * @throws SQLException 
	 */
	private boolean isValidAccount(String fname, String lname,String phonenum) throws SQLException{
		dbm.connect();
		
		String query = "SELECT first_name, last_name, phone FROM users "
				+ "WHERE first_name ='" + fname + "' AND last_name ='" + lname
				+ "' AND phone ='" + phonenum +"';";
		Statement stmt = dbm.getConnection().createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()){
			
			if (fname.equals(rs.getString("first_name")) &&
					lname.equals(rs.getString("last_name")) &&
					phonenum.equals(rs.getString("phone"))){
				dbm.disconnect();
				return true;
			}
		}
		dbm.disconnect();
		return false;
	}
}
