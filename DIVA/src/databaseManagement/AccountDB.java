package databaseManagement;

import java.util.ArrayList;
import java.util.Currency;
import java.sql.*;

import accountManagement.*;
/**
 * AccountDB provides services related to the creation, deletion, and modification of account
 * no invariant
 * @author Saud (Sammy) Almahri 
 */
class AccountDB{
	
	private static final String USER = "`users`";
	private static final String CUSTOMER = "`customer`";
	private static final String SUPER_CUSTOMER = "`super_customer`";
	private static final String EMPLOYEE = "`employee`";
	private static final String ID_NUM = "users.id_number";
	private static final String USERNAME = "Account_uName";
	
	private ConnectDB dbm;
	//checking 
	AccountDB() {
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
	void createCustomer(Customer customer) throws SQLException{
		// Account variables
		String userName = customer.getLoginId();
		String password;
		String fname;
		String lname;
		String phone;
		String email;
		
		//customer variables
		String ccNum;
		String expire_date;
		String ccName;
		String street;
		String city;
		String province;
		String zipCode;
		
		//database variables
		Statement stmt;
		Connection conn;
		String query;
		
		// Connect to the database
		dbm.connect();
		
		if (!doesItExist(userName, USER, USERNAME)){
			password = customer.getPassword();
			fname = customer.getFirstname();
			lname = customer.getLastname();
			phone = customer.getPhoneNumber();
			email = customer.getEmail();
			
			ccNum = customer.getCc_num();
			expire_date = customer.getExpireDate();
			ccName = customer.getName_on_card();
			street = customer.getLocation().getAddress();
			city = customer.getLocation().getCity();
			province = customer.getLocation().getProvince();
			zipCode = customer.getLocation().getZipcode();
			
			
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
			query= "INSERT INTO `customer` (`id_number`, `cc_Num`, `expire_date`"
					+ "`name_on_cCard`, `street_name`, `city`, "
					+ "`province`, `zipcode`) VALUES (LAST_INSERT_ID(),\"" + ccNum
					+ "\", \"" +expire_date+"\", \""+ ccName + "\", \"" + street + "\", \"" + city + "\", \"" + province
					+ "\", \"" + zipCode + "\") ;";
			
			// execute the statements
			stmt.executeUpdate(query);
			
			conn.commit(); 
			conn.setAutoCommit(true);
			
		} else{
			dbm.disconnect();
			throw new Error("Account already exist");
		}
		
		dbm.disconnect();
	}

	
	void createEmployee(Employee employee) throws SQLException{
		// Account variables
		String userName = employee.getLoginId();
		String password;
		String fname;
		String lname;
		String phone;
		String email;
		
		// Employee variables
		int works_at;
		String emp_type;
		
		//database variables
		Statement stmt;
		Connection conn;
		String query;
		
		dbm.connect();
		
		if (!doesItExist(userName, USER, USERNAME)){
			password = employee.getPassword();
			fname = employee.getFirstname();
			lname = employee.getLastname();
			phone = employee.getPhoneNumber();
			email = employee.getEmail();
			
			works_at = employee.getWorks_at();
			emp_type = employee.getEmp_type();
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			// insert into user table
			query = "INSERT INTO `users` (`first_name`, `last_name`, "
					+ "`phone`, `email`, `account_uName`, `account_password`) VALUES ( \""
					+ fname + "\", \"" + lname + "\", \"" + phone + "\", \"" + email 
					+ "\", \"" + userName + "\", \"" + password + "\");\n";
			stmt.executeUpdate(query);
			
			// insert into employee table
			query = "INSERT INTO `employee`(`id_number`, `works_at`, `e_type`) VALUES "
					+ "(LAST_INSERT_ID(), \"" + works_at + "\", \"" + emp_type + "\");";
			
			stmt.executeUpdate(query);
			
			conn.commit();
			conn.setAutoCommit(false);
			
		} else{
			dbm.disconnect();
			throw new Error("Account already exist");
		}
		
		dbm.disconnect();
	}
	
	void upgradeCustomer(String username) throws SQLException{
		//database variables
		Statement stmt;
		Connection conn;
		ResultSet rs;
		String query;
		
		// supercustomer variables
		int SRC_id;
		
		dbm.connect();
		
		if(isValidAccount(username, CUSTOMER)){
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			// get the id number associated with the account;
			query = "SELECT users.id_number FROM `customer`, `users` WHERE "
					+ "users.id_number = customer.id_number AND "
					+ "users.Account_uName = \"" + username +"\";"; 
			rs = stmt.executeQuery(query);
			
			// create a SuperCustomer entry
			rs.next(); 
			SRC_id = rs.getInt("id_number");
			query = "INSERT INTO `super_customer`(`id_number`) VALUES (" + SRC_id + ");";
			stmt.executeUpdate(query);
			
		}else{
			dbm.disconnect();
			throw new Error("Username is not a customer; create customer account first");
		}
		
		dbm.disconnect();
	}
	
	
	void addSRPoints(String username, int points) throws SQLException{
		//database variables
		Statement stmt;
		Connection conn;
		ResultSet rs;
		String query;
		
		//local variable
		int currentBalance;
		int newBalance;
		int userID;
		
		dbm.connect();
		
		// check if the user is a superRent customer
		if (doesItExist(username, SUPER_CUSTOMER, USERNAME)){
			
			query = "SELECT points, users.id_number FROM users "
					+ "INNER JOIN customer ON users.id_number = customer.id_number "
					+" INNER JOIN super_customer ON customer.id_number = super_customer.id_number "
					+"WHERE Account_uName = \"" + username + "\";";
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			// Get the current balance for the user
			rs = stmt.executeQuery(query);
			rs.next();
			
			// update the balance
			currentBalance = rs.getInt("points");
			newBalance = currentBalance + points;
			
			userID = rs.getInt("id_number");
			
			// store the new balance in the database
			query = "UPDATE super_customer "
					+ "SET `points` = " + newBalance + " "
					+ "WHERE id_number = " + userID +";";
			stmt.executeUpdate(query);
			
		} else{
			dbm.disconnect();
			throw new Error("user is not a superRent customer");
		}
		
		dbm.disconnect();
	}
	
	
	
	void downgradeSCustomer(String username) throws SQLException{
		//database variables
		Statement stmt;
		Connection conn;
		ResultSet rs;
		String query;
		
		int src_id;

		dbm.connect();
		
		if(doesItExist(username, SUPER_CUSTOMER, USERNAME))
		{
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			// get the id number associated with the account and execute the query;
			query = "SELECT users.id_number FROM `customer`, `users` WHERE "
					+ "users.id_number = customer.id_number AND "
					+ "users.Account_uName = \"" + username +"\";"; 
			rs = stmt.executeQuery(query);
			
			rs.next();
			src_id = rs.getInt("id_number");
			
			// Remove customer from superRent table:
			query = "DELETE FROM super_customer WHERE id_number = " + src_id;
			stmt.executeUpdate(query);
			
		}else{
			dbm.disconnect();
			throw new Error("User is not a superRent customer");
		}
		
		// disconnect from DB;
		dbm.disconnect();
	}
	
	void removeAccountEntry(String username) throws SQLException, IllegalArgumentException{
		//database variables
		Statement stmt;
		Connection conn;

		String query = "";
		
		dbm.connect();
		
		try {
			if(doesItExist(username, EMPLOYEE, USERNAME ))
			{
				query="DELETE users, employee FROM users INNER JOIN employee WHERE "
						+ "users.id_number = employee.id_number AND "
						+ "users.account_uName = \"" + username +"\";";
				
				conn = dbm.getConnection();
				stmt = conn.createStatement();
				
				stmt.executeUpdate(query);
				
				dbm.disconnect();
			}else {
				dbm.disconnect();
				throw new Error("can't delete customer account");
				
			}
		} catch (IllegalArgumentException e){
			throw e;
		}
	}
	
	/**
	 * getAccount gets an account from database
	 * @param parameter can be either username, lastname, or phonenumber
	 * @pre (username)
	 * @return Account[] array
	 * @throws SQLException 
	 */
	Account[] getAccounts(String parameter) throws SQLException {
		// assume its last name
		//database variables
		Statement stmt;
		Connection conn;
		ResultSet rs;
		String query;
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<String> userIDs = new ArrayList<String>();
		
		// Account variables
		// account = {first name, last name, phone number,
		String firstN;
		String lastN;
		String phoneNum;
		String email;
		String userName;
		
		// Custoemer variables:
		String ccNumber;
		String expire_date;
		String nameOnCC;
		String address;
		String city;
		String province;
		String zipcode;
		String standing;
		
		// superCustomer variables
		String points;
		
		// Employee
		int works_at;
		String emp_type;
		
		query = "SELECT id_number FROM `users` "
				+ "WHERE last_name = \"" + parameter + "\" OR "
				+ "Account_uName = \"" + parameter +"\" OR "
				+ "phone = \"" + parameter + "\";";
		
		dbm.connect();
		
		conn = dbm.getConnection();
		stmt = conn.createStatement();
		
		// get all users
		rs = stmt.executeQuery(query);
		
		while(rs.next()){
			userIDs.add(rs.getString("id_number"));
		}
		
		
		for(String users: userIDs)
		{			
			if(doesItExist(users, EMPLOYEE, ID_NUM)){
				query = "SELECT * FROM users "
						+ "INNER JOIN employee ON users.id_number = employee.id_number "
						+ "WHERE users.last_name = \"" + parameter + "\" OR "
						+ "users.Account_uName = \"" + parameter +"\" OR "
						+ "users.phone = \"" + parameter + "\";";
				rs = stmt.executeQuery(query);
				
				while(rs.next()){
					firstN = rs.getString("first_name");
					lastN = rs.getString("last_name");
					phoneNum = rs.getString("phone");
					email = rs.getString("email");
					userName = rs.getString("Account_uName");
					works_at = rs.getInt("works_at");
					emp_type = rs.getString("e_type");
					
					accountList.add(new Employee(firstN, lastN, phoneNum, 
							email,userName, works_at, emp_type, Integer.parseInt(users)));
						
				}
			} else if (doesItExist(users, CUSTOMER, ID_NUM)){
				query = "SELECT * FROM users "
						+ "INNER JOIN customer ON users.id_number = customer.id_number "
						+ "LEFT JOIN super_customer ON customer.id_number = super_customer.id_number "
						+ "WHERE users.last_name = \"" + parameter + "\" OR "
						+ "users.Account_uName = \"" + parameter +"\" OR "
						+ "users.phone = \"" + parameter + "\";";
				rs = stmt.executeQuery(query);
				
				while(rs.next()){
					firstN = rs.getString("first_name");
					lastN = rs.getString("last_name");
					phoneNum = rs.getString("phone");
					email = rs.getString("email");
					userName = rs.getString("Account_uName");
					
					ccNumber = rs.getString("cc_Num");
					expire_date = rs.getString("expire_date");
					nameOnCC = rs.getString("name_on_cCard");
					address = rs.getString("street_name");
					city = rs.getString("city");
					province = rs.getString("province");
					zipcode = rs.getString("zipcode");
					standing = rs.getString("standing");
					
					Customer customer = new Customer(firstN, lastN, phoneNum,
							email, userName, Integer.parseInt(users),
							ccNumber, expire_date, nameOnCC, address, city, province,
							zipcode, standing);
					
					points = rs.getString("points");
					
					if(points != null){
						//superRent customer
						accountList.add(new SuperCustomer(customer, Integer.parseInt(points)));
					} else{
						// just a regular customer
						accountList.add(customer);
					}
				}
			}
		
		}
		
		dbm.disconnect();
		
		return accountList.toArray(new Account[accountList.size()]);
	
	}
		
	//modifier 
	
	
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
	/* obsolete
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
	}*/
		
	/**
	 * createAccount create an new account
	 * @param info the list of information for a new account, 
	 * following the order of {loginId, password, firstname, lastname, phoneNumber, email}
	 * @throws SQLException 
	 * @pre !isValidAccount(info[2],info[3],info[4]);
	 * @pre !isValidUsername(info[0]);
	 * @post isValidAccount(loginId);
	 */
//	public boolean createAccount(String[] info) throws SQLException {
//		// Does it need to specify the account type?
//		
//		if (!isValidAccount(info[2], info[3], info[4]) && !isValidUsername(info[0])){
//			dbm.connect();
//			
//			Statement stmt = dbm.getConnection().createStatement();
//			
//			String query = "INSERT INTO `users` (`first_name`,`last_name`,`phone`,`email`,`account_uName`,`account_password`) "+
//					"VALUES ('" + info[2] + "','" + info[3] + "','"+ info[4] + "','"+ info[5] + "','"+ info[0] + "','"
//					+ info[1] + "');";
//			System.out.println();
//			stmt.executeUpdate(query);
//			dbm.disconnect();
//			return true;
//			
//		} else{
//			return false;
//		}
//		
//	}
		

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
	String retrievePassword(String username) throws SQLException {
		dbm.connect();
		
		if (doesItExist(username, USER, USERNAME)){
			
			String query = "SELECT account_password FROM users WHERE account_uName = '" + username +"';";
						
				Statement stmt = dbm.getConnection().createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				String password = rs.getString("account_password");
				dbm.disconnect();
				return password;		
		}else{
			dbm.disconnect();
			return null;
		}
	}
	
	void modifyPassword(String userName, String newPassword) throws SQLException{
		// Database variables
		Connection conn;
		Statement stmt;
		String query;
		
		dbm.connect();
		
		if(doesItExist(userName, USER, USERNAME))
		{
			query = "UPDATE users SET account_password = \"" + newPassword + "\" "
					+ "WHERE account_uName = \"" + userName + "\";";
			
			
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
			
		} else{
			dbm.disconnect();
			throw new Error("Username does not exist!");
		}
		dbm.disconnect();	
	}
/* ----------------------------------PRIVATE METHODS-------------------------------------------*/
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
	 * doesUsernameExist checks if the provided username is in the database
	 * @param username the proposed username
	 * @pre database is not empty
	 * @post true if username exists, false if it does not
	 * @return true if the username exists
	 */
	private boolean doesItExist(String id, String table, String param) throws SQLException, IllegalArgumentException {
		// database ojbects:
		Connection conn;
		Statement stmt;
		ResultSet rs;
		System.out.println(id+" "+table+" "+param);		
		//
		String query = "";

		conn = dbm.getConnection();
		stmt = conn.createStatement();
		
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
		}
		
		// execute the query:
		rs = stmt.executeQuery(query);
		
		// check for any matching parameters
		while (rs.next()){
			if (id.equals(rs.getString(param))){
				return true;
			}
		}
		throw new IllegalArgumentException("account does not exist");
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
		if (doesItExist(username, USER, USERNAME) == true){
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
				return true;
			}
				
		}
		dbm.disconnect();
		return false;
	}

	/**
	 * Get username from account ID
	 * @param customerAccountID
	 * @return username
	 * @throws SQLException 
	 */
	String getUserNameFromId(int customerAccountID) throws SQLException {
		// TODO Auto-generated method stub
		dbm.connect();
		String username = "";
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT `account_uName` FROM users WHERE users.id_number = "+customerAccountID;
		ResultSet rs = stmt.executeQuery(query);
		
		if (rs.next()){
			username = rs.getString("account_uName");
		}
		dbm.disconnect();
		return username;
	}

	int getIdFromUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		dbm.connect();
		int id = -1;
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT `id_number` FROM users WHERE users.account_uName = \'"+username+"\'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		
		if (rs.next()){
			id = rs.getInt("id_number");
		}
		else{
			throw new Exception("account username does not exist");
		}
		dbm.disconnect();
		return id;
	}
}

	
