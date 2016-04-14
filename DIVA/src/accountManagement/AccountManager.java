package accountManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;

/**
 * An account manager provides account related services
 * @version 1
 * @since March 19, 2016
 * @author AlexDaniels
 */
public class AccountManager {
	
	
	static DatabaseManager dbConnection;
	
	
	/**
	 * Constructs an AccountManager object
	 */
	public AccountManager() {
		dbConnection = DatabaseManager.getInstance();
	}
	
	//------------Methods that can be called by an unauthenticated HTTPS user--------//

	/**
	 * Creates a new CustomerAccount record in the database
	 * Fulfills RAD use-case: Register
	 * @param firstName The first name of the customer
	 * @param lastName The last name of the customer
	 * @param phoneNumber	The customers phone number
	 * @param emailAddress	The customers email address
	 * @param userName		The customers userName
	 * @param password		An encrypted version of The customers password
	 * @param 
	 * @throws SQLException 
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	//this need to be updated to contain address info
	public void addCustomerAccount(String firstName, String lastName, String phoneNumber, 
			String emailAddress, String userName, String password, 
			long ccNum, String name_on_cc, String address,
			String city, String province, String zip) throws SQLException 
	{
		
		int id = -1; //let database auto increment id
		// Need to add validation an dchange signature to boolean (or throw exception) -Sammy
		Account acc = new Customer(firstName, lastName, phoneNumber, 
				emailAddress, userName, id,
				password, ccNum, name_on_cc,
				address, city, province, zip);
		dbConnection.createAccountEntry(acc);
	}
	
	public void addEmployeeAccount(String firstName, String lastName, String phoneNumber, 
			String emailAddress, String userName,String password, int works_at, String type) throws SQLException {
		int id = -1; //let database auto increment id 
		Account acc = new Employee(firstName, lastName, phoneNumber, emailAddress, userName, password, works_at, type, id);
		dbConnection.createAccountEntry(acc);
	}
	
//	public void modifyAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName) {
//		dbConnection.modifyAccountEntry(firstName, lastName, phoneNumber, emailAddress, userName);
//	}
	
	/**
	 * Changes the customer from a regular customer to a Super Club Member
	 * @param customer The customer who wants to join super club
	 * @pre CustomerHasACreditCard()
	 * @pos getAccount(customer.UserName) instanceof SuperCustomer
	 * @return true if the customer successfully joined Super Club
	 * @throws SQLException 
	 */
	public void joinSuperClub(String userName) throws SQLException 
	{// Done
		
		dbConnection.changeAccountStatus(userName, "SRCustomer");
		//the database automatically adds 500 points when a customer
		// is upgraded to superCustomer
	}
	
	public void accumulatePoints(String username, int points) throws SQLException
	{// Done
		if (points > 0){
			dbConnection.addSRPoints(username,points);
		} else {
			// throw an error
		}
	}
	
	public void leaveSuperCLub(String userName) throws SQLException
	{// done
		dbConnection.changeAccountStatus(userName, "RegisteredCustomer");
	} 
	/**
	 * Moves the customers account from the activated state into the deactivated state
	 * @param customer The customer account to be deactivated
	 * @param password The customers password
	 * @return true if the account was successfully activated
	 * @throws SQLException 
	 * @pre customer.state == activated
	 * @pos customer.state == deactivated
	 */
	public void deleteAccount(String userName) throws SQLException {
		dbConnection.removeAccountEntry(userName);
	}
	
	/**
	 * Returns a list of customers that have the same last name as the parameter
	 * @param firstName The first name of the customer being searched
	 * @return a list of customers that match the search criteria
	 * @throws SQLException 
	 */
	public Account[] searchAccountByLastName(String lastName) throws SQLException{
		return dbConnection.searchAccountEntries(lastName);
	}
	
	public Account searchAccountByUsername(String username) throws SQLException{
		return dbConnection.searchAccountEntries(username)[0];
	}
	
	public Account[] searchAccountByPhoneNumber(String phoneNum) throws SQLException{
		return dbConnection.searchAccountEntries(phoneNum);
	}
	
	/**
	 * Returns the password of a user, given their user name
	 * @param userName The user name of the account needing authentication
	 * @return an encrypted version of the password associated with the UserName
	 * @throws SQLException 
	 */
	public String getPassword(String userName) throws SQLException {
		// Done
		return dbConnection.retrievePassword(userName);
	}
	
	public void changePassword(String userName, String newPassword) throws SQLException
	{
		dbConnection.modifyPassword(userName,newPassword);
	}
	
	/**
	 * Checks if a customer is of type Super Customer
	 * @param account_id
	 * @return
	 */
	public boolean is_super_rent(int account_id){
		//dbConnection.
		return false;
	}
	
	public void usePoints(int account_id, int points){
		//dbConnection.
	}

	/**
	 * Get a customer's current available points according to its ID
	 * @param customer_id
	 * @return
	 */
	public int getPoints(int customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
