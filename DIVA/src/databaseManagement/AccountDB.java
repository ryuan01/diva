package databaseManagement;

import java.util.Currency;
import java.sql.*;

import accountManagement.*;
/**
 * AccountDB provides services related to the creation, deletion, and modification of account
 * no invariant 
 */
class AccountDB{
	
	private ConnectDB dbm;
	//checking 
	public AccountDB() {
		dbm = new ConnectDB();
	}

/* ----------------------------------PUBLIC INTERFACE-------------------------------------------*/
	
	/**
	 * createCustomer adds a new customer account to the database
	 * @param customer object
	 * @throws SQLException 
	 * @pre !isValidUsername(loginID);
	 * @post isValidAccount(loginId);
	 * @throws SQLException
	 */
	public void createCustomer(Customer customer) throws SQLException{
		// Account variables
		String userName = customer.getLoginId();
		String password;
		String fname;
		String lname;
		String phone;
		String email;
		
		//customer variables
		long ccNum;
		String ccName;
		String street;
		String city;
		String province;
		String zipCode;
		System.out.println("before if");
		
		//database variables
		Statement stmt;
		Connection conn;
		String query;
		
		if (isValidUsername(userName)){
			password = customer.getPassword();
			fname = customer.getFirstname();
			lname = customer.getLastname();
			phone = customer.getPhoneNumber();
			email = customer.getEmail();
			ccNum = customer.getCc_num();
			ccName = customer.getName_on_card();
			street = customer.getLocation().getAddress();
			city = customer.getLocation().getCity();
			province = customer.getLocation().getProvince();
			zipCode = customer.getLocation().getZipcode();

			dbm.connect();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			// to enable more than one transaction
			conn.setAutoCommit(false);
					
			// insert into user table
			query = "INSERT INTO `users` (`first_name`, `last_name`, "
					+ "`phone`, `email`, `account_uName`, `account_password`) VALUES ( \""
					+ fname + "\", \"" + lname + "\", \"" + phone + "\", \"" + email 
					+ "\", \"" + userName + "\", \"" + password + "\");\n";
			stmt.executeUpdate(query);
			// insert into customer table
			query= "INSERT INTO `customer` (`id_number`, `cc_Num`, "
					+ "`name_on_cCard`, `street_name`, `city`, "
					+ "`province`, `zipcode`) VALUES (LAST_INSERT_ID(),\"" + ccNum
					+ "\", \"" + ccName + "\", \"" + street + "\", \"" + city + "\", \"" + province
					+ "\", \"" + zipCode + "\") ;";
			
			
			stmt.executeUpdate(query);
			
			conn.commit(); 
			conn.setAutoCommit(true);
			
			dbm.disconnect();
		}
	}
	
	
	/**
	 * getAccount gets an account from database
	 * @param username the username related to a account
	 * @pre isValidUsername(username)
	 * @post Account object
	 * @return Account object
	 * @throws SQLException 
	 */
	public Account getAccount(String username) throws SQLException {
		/*if(isValidUsername(username)){
			dbm.connect();
			
			Statement stmt = dbm.getConnection().createStatement();
			String query = "";
			ResultSet rs = null;
			Account acct = null;
				
			if (isValidAccount(username, "super_customer")){
				query = "SELECT * FROM `users`, `super_customer`, `customer` WHERE "
						+ "users.id_number = customer.id_number AND "
						+ "super_customer.id_number = customer.id_number AND"
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new SuperCustomer(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"),
						rs.getInt("points"));
				
				
			} else if (isValidAccount(username, "customer")){
				query = "SELECT * FROM `users`, `customer` WHERE "
						+ "users.id_number = customer.id_number AND "
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new Customer(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"));			
			} else{ // if the username is present, and it's not a customer or a super customer, then it's an employee
				query = "SELECT * FROM `users`, `employee` WHERE "
						+ "users.id_number = employee.id_number AND"
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new Employee(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"),
						rs.getInt("works_at"),
						rs.getString("e_type"));
			}
			
			
			dbm.disconnect();
			return acct;
		}*/
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
		/*if(isValidAccount(fname,lname,phonenum)){
			dbm.connect();
			// Change the implementation to fit...
			Statement stmt = dbm.getConnection().createStatement();
			String query = "";
			ResultSet rs = null;
			Account acct = null;
				
			if (isValidAccount(username, "super_customer")){
				query = "SELECT * FROM `users`, `super_customer`, `customer` WHERE "
						+ "users.id_number = customer.id_number AND "
						+ "super_customer.id_number = customer.id_number AND"
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new SuperCustomer(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"),
						rs.getInt("points"));
				
				
			} else if (isValidAccount(username, "customer")){
				query = "SELECT * FROM `users`, `customer` WHERE "
						+ "users.id_number = customer.id_number AND "
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new Customer(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"));			
			} else{ // if the username is present, and it's not a customer or a super customer, then it's an employee
				query = "SELECT * FROM `users`, `employee` WHERE "
						+ "users.id_number = employee.id_number AND"
						+ "account_uName = \'" + username +"\';";
				rs = stmt.executeQuery(query);
				rs.next();
				acct = new Employee(rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("account_uName"),
						rs.getInt("works_at"),
						rs.getString("e_type"));
			}
			
			
			dbm.disconnect();
			return acct;
		}*/
		return null;
	
	}
	
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
		

/* ----------------------------------PRIVATE METHODS-------------------------------------------*/
	// PRIVATE METHODS
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
				return false;
			}
		}
		dbm.disconnect();
		return true;
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
	 * @param acc an account object 
	 * @pre database account is not empty
	 * @post true if it exists, false if it does not
	 * @return true if it exists, false if it does not
	 * @throws SQLException 
	 */
	private boolean isValidAccount(String username, String type) throws SQLException {
		dbm.connect();
		
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT * FROM users, " + type + " WHERE users.id_number = " + type + ".id_number";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			if (username.equals(rs.getString("account_uName"))){
				dbm.disconnect();
				return true;
			}
				
		}
		dbm.disconnect();
		return false;
	}
}
