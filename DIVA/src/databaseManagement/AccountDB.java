package databaseManagement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Currency;

import accountManagement.Account;
/**
 * AccountDB provides services related to the creation, deletion, and modification of account
 * @author Robin
 * no invariant 
 */

class AccountDB {
	
	
	//checking 
	public AccountDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * isValidUsername checks if the provided username is in the database
	 * @param username the proposed username
	 * @pre database is not empty
	 * @post true if username exists, false if it does not
	 * @return true if the username exists
	 */
	private boolean isValidUsername(String username) {
		//Get DatabaseManager instance and connect to the database
		ConnectDB dbm = new ConnectDB();
		dbm.connect();
		
		// execute the query:
		try{
			Statement stmt = dbm.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			// check for uany matching usernames
			while (rs.next()){
				if (username.equals(rs.getString("account_uName"))){
					return true;
				}
			}
		}catch (SQLException e){
			System.err.println(e);
		}finally{
			dbm.disconnect();
		}
		
		return false;
	}
	
	/**
	 * isValidLogin checks if the username and pw matches
	 * @param username a username
	 * @param pw the encrypted password
	 * @pre isValidUsername(username)
	 * @post true if the there is a match, otherwise false
	 */
	private boolean isValidLogin(String username, String pw) {
		if (isValidUsername(username) == true){
			ConnectDB dbm = new ConnectDB();
			dbm.connect();
		
			try{
				Statement stmt = dbm.getConnection().createStatement();
			
				ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
			
				while(rs.next()){
					if ((username.equals(rs.getString("account_uName")) == true) && (pw.equals(rs.getString("account_password")) == true)){
						return true;
					}
				}
			
			} catch (SQLException e){
				System.err.println(e);
			} finally{
				dbm.disconnect();
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
	 */
	private boolean isValidAccount(Account acc ) {
		ConnectDB dbm = new ConnectDB();
		dbm.connect();
		String username = acc.getLoginId(); // Note: username is cases sensitive 
		
		try{
			Statement stmt = dbm.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
			
			while(rs.next()){
				if (username.equals(rs.getString("account_uName"))){
					return true;
				}
					
			}
			
		} catch (SQLException e){
			System.err.println(e);
		} finally{
			dbm.disconnect();
		}
		return false;
	}
	
	/**
	 * getAccountKeyValue gets an account's key value from database
	 * @param username the username related to a account
	 * @return 
	 * @pre isValidUsername(username)
	 * @post account's key value
	 * @return account's key value
	 */
	public Account getAccount(String username) {
		if(isValidUsername(username)){
			ConnectDB dbm = new ConnectDB();
			dbm.connect();
			
			try{
				Statement stmt = dbm.getConnection().createStatement();
				
				// Problem: how to determine the "type" of account (whether it's a customer, employee, clerk, etc..)
				
			} catch (SQLException e){
				System.err.println(e);
			} finally{
				dbm.disconnect();
			}
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
	 * @post account's key value 
	 * @return account's key value
	 */
	public Account getAccount(String fname, String lname, String phonenum) {
		ConnectDB dbm = new ConnectDB();
		dbm.connect();
		
		try{
			Statement stmt = dbm.getConnection().createStatement();
			
			// Problem: how to determine the "type" of account (whether it's a customer, employee, clerk, etc..)
			
		} catch (SQLException e){
			System.err.println(e);
		} finally{
			dbm.disconnect();
		}
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
	 */
	public boolean loginPasswordUpdate(String username, String enOldPw, String enNewPw) {
		if (isValidLogin(username, enOldPw)){
			ConnectDB dbm = new ConnectDB();
			dbm.connect();
			
			try{
				Statement stmt = dbm.getConnection().createStatement();
				String query = "UPDATE users SET account_password= '" + enNewPw +
						"' WHERE account_uName='" + username + "' AND account_password='" + enOldPw + "';";
						
				stmt.executeUpdate(query);
				dbm.disconnect();
				return true;
				
			}catch (SQLException e){
				System.err.println(e);
				return false;
			} finally{
				dbm.disconnect();
				
			}
		} else{
			return false;
		}
	}
	
	/**
	 * accountUpdate updates one field of the account
	 * @param acc an account 
	 * @param field a field in the account, can be one of the {firstname, lastname, phoneNuber, email}, loginId cannot be updated, password has its own method
	 * @param newInfo the new update for a specific field
	 * @pre format matches
	 * @pre isValidAccount(acc)
	 * @post the specific field information is updated
	 */
	public void accountUpdate(String acc_key_value, String field, String newInfo) {
	}
	
	//not sure what kind of statues are here, please add more 
	/**
	 * accountUpdateStatus updates the status of the account
	 * @param acc an account 
	 * @param status status of the account, can be one of the {good, ownPayment, lateReturn}
	 * @pre isValidAccount(acc)
	 * @post status is updated
	 */
	public void accountUpdateStatus(Account acc, String status) {
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
	public void updateAccountPoints(String acc_key_value, int pt) {
	}
	
	/**
	 * updateAccountBalance updates the balance related to an account
	 * @param acc an account
	 * @param amount the amount to be added, can be negative
	 * @pre isValidAccount(acc)
	 * @post acc.balance += amount
	 */
	public void updateAccountBalance(String acc_key_value,Currency amount) {
	}
	
	//not too sure if types are just subclasses, how do we update them?
	//updateaccountype();
	
	/**
	 * createAccount create an new account
	 * @param info the list of information for a new account, 
	 * following the order of {loginId, password, firstname, lastname, phoneNumber, email}
	 * @pre !isValidAccount(info[2],info[3],info[4]);
	 * @pre !isValidUsername(info[0]);
	 * @post isValidAccount(loginId);
	 */
	public boolean createAccount(String[] info) {
		// Does it need to specify the account type?
		if (!isValidAccount(info[2], info[3], info[4]) && !isValidUsername(info[0]))
		{
			ConnectDB dbm = new ConnectDB();
			dbm.connect();
			try{
				Statement stmt = dbm.getConnection().createStatement();
				
				String query = "INSERT INTO `users` (`first_name`,`last_name`,`phone`,`email`,`account_uName`,`account_password`) "+
						"VALUES ('" + info[2] + "','" + info[3] + "','"+ info[4] + "','"+ info[5] + "','"+ info[0] + "','"
						+ info[1] + "');";
	
				stmt.executeUpdate(query);
				dbm.disconnect();
				return true;
			} catch (SQLException e){
				System.err.println(e);
				return false;
			} finally{
				dbm.disconnect();
				
			}
		} else{
			return false;
		}
		
	}
	
	/**
	 * archiveAccount archives an account
	 * @param acc an account
	 * @pre isValidAccount(acc)
	 * @post !isValidAccount(acc)
	 */
	public void archiveAccount(String acc_key_value) {
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
	 */
	private String getEncryptedPassword(String username) {
		if (isValidUsername(username)){
			ConnectDB dbm = new ConnectDB();
			dbm.connect();
			String query = "SELECT account_password FROM users WHERE account_uName = '" + username +"';";
			
			try{
				Statement stmt = dbm.getConnection().createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				return rs.getString("account_password");
				
			}catch (SQLException e){
				System.err.println(e);
				return null;
			} finally{
				dbm.disconnect();
			}	
		}
		return null;
	}
	
	/**
	 * isValidAccount checks if the provided account exists
	 * @param fname first name
	 * @param lname last name
	 * @param phonenum phone number
	 * @pre database account is not empty
	 * @post true if it exists, false if it does not
	 * @return true if it exists, false if it does not
	 */
	private boolean isValidAccount(String fname, String lname,String phonenum) {
		return false;
	}
}
