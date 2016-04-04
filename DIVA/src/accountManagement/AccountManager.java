package accountManagement;

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
	
	//------------Methods that can be called by an unauthenticated HTTPS user

	/**
	 * Creates a new CustomerAccount record in the database
	 * Fulfills RAD use-case: Register
	 * @param firstName The first name of the customer
	 * @param lastName The last name of the customer
	 * @param phoneNumber	The customers phone number
	 * @param emailAddress	The customers email address
	 * @param userName		The customers userName
	 * @param password		An encrypted version of The customers password
	 * @return true if the account was successfully created
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	public boolean addCustomerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String status) {
		Account a = new Customer(firstName, lastName, phoneNumber, emailAddress, userName);
		return dbConnection.createAccountEntry(a);
	}
	
	public boolean addEmployeeAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, int works_at, String type) {
		Account a = new Employee(firstName, lastName, phoneNumber, emailAddress, userName, works_at, type);
		return dbConnection.createAccountEntry(a);
	}
	
	public boolean modifyAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String status) {
		return dbConnection.modifyAccountEntry(firstName, lastName, phoneNumber, emailAddress, userName, status);
	}
	
	/**
	 * Changes the customer from a regular customer to a Super Club Member
	 * @param customer The customer who wants to join super club
	 * @pre CustomerHasACreditCard()
	 * @pos getAccount(customer.UserName) instanceof SuperCustomer
	 * @return true if the customer successfully joined Super Club
	 */
	public static void joinSuperClub(String userName) 
	{
		dbConnection.changeAccountStatus(userName, "SRCustomer");
		dbConnection.addSRPoints(userName, 500);
	}
	
	public static void accumulatePoints(int i, int points)
	{
		dbConnection.addSRPoints(i,points);
	}
	
	public static void leaveSuperCLub(String userName)
	{
		dbConnection.changeAccountStatus(userName, "RegisteredCustomer");
	}
	/**
	 * Moves the customers account from the activated state into the deactivated state
	 * @param customer The customer account to be deactivated
	 * @param password The customers password
	 * @return true if the account was successfully activated
	 * @pre customer.state == activated
	 * @pos customer.state == deactivated
	 */
	public boolean deleteAccount(String userName) {
		return dbConnection.removeAccountEntry(userName);
	}
	
	/**
	 * Returns a list of customers that have the same first name as the parameter
	 * @param firstName The first name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Account[] searchAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String status) {
		return dbConnection.searchAccountEntries(firstName,lastName,phoneNumber,emailAddress,userName,status);
	}
	
	/**
	 * Returns the password of a user, given their user name
	 * @param userName The user name of the account needing authentication
	 * @return an encrypted version of the password associated with the UserName
	 */
	public String getPassword(String userName) {
		return dbConnection.retrievePassword(userName);
	}
	
	public boolean changePassword(String userName, String newPassword)
	{
		return dbConnection.modifyPassword(userName,newPassword);
	}
}
