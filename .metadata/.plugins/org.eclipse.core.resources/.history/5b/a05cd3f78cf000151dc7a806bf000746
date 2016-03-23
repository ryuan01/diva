package accountManager;

/**
 * An account manager provides account related services
 * @version 1
 * @since March 19, 2016
 * @author AlexDaniels
 */
public class AccountManager {
	
	/**
	 * Constructs an AccountManager object
	 */
	public AccountManager() {
		
	}
	
	//------------Methods that can be called by an unauthenticated HTTPS user

	/**
	 * Creates a new CustomerAccount record in the database
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
	public boolean addCustomerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	//--------Methods that can be called by an Registered Customer
	
	/**
	 * Modifies the password of a customer
	 * @param oldPassword	The customers old password
	 * @param newPassword	The customers new password
	 * @pre oldUserName != newUserName
	 * @return true if the password was changed successfully
	 */
	public boolean changeUserName(String oldUserName, String newUserName) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	//joinsuperclub();
	//deactivateaccount();
	//reactivateaccount();
	
	//--------Methods that can be called by an Super Customer
	
	//--------Methods that can be called by an Registered Customer
	
	/**
	 * Modifies the account information of the given customer
	 * @param firstName	The new first name of the customer
	 * @param lastName  The new last name of the customer
	 * @param phoneNumber the new phone number of the customer
	 * @param emailAddress the new email address of the customer
	 * @return true if the account info was modified
	 */
	public boolean changeaccontinfo(String firstName, String lastName, String phoneNumber, String emailAddress) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Modifies the password of a customer
	 * @param oldPassword	The customers old password
	 * @param newPassword	The customers new password
	 * @pre getPassword(userName) == oldPassword
	 * @return true if the password was changed successfully
	 */
	public boolean changePassword(String userName, String oldPassword, String newPassword) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Modifies the password of a customer
	 * @param customer 		The customer who wants to change their UserName
	 * @param oldPassword	The customers old password
	 * @param newPassword	The customers new password
	 * @pre getPassword(customer) == oldPassword
	 * @pre oldUserName != newUserName
	 * @return true if the password was changed successfully
	 */
	public boolean changeUserName(Customer customer, String oldUserName, String newUserName) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Changes the customer from a regular customer to a Super Club Member
	 * @param customer The customer who wants to join super club
	 * @pre CustomerHasACreditCard()
	 * @pos getAccount(customer.UserName) instanceof SuperCustomer
	 * @return true if the customer successfully joined Super Club
	 */
	public boolean joinSuperClub(Customer customer) {
		return true;
	}
	
	/**
	 * Moves the customers account from the activated state into the deactivated state
	 * @param customer The customer account to be deactivated
	 * @param password The customers password
	 * @return true if the account was successfully activated
	 * @pre customer.state == activated
	 * @pos customer.state == deactivated
	 */
	public boolean deactivateAccount(Customer customer, String password) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Moves the customers account from the deactivated state to the activated state
	 * @param customer The customer account to be deactivated
	 * @param password The customers password
	 * @return true if the account was successfully activated
	 * @pre customer.state == deactivated
	 * @pre password == getPassword(customer)
	 * @pos customer.state == activated
	 */
	public boolean reactivateaccount(Customer customer, String password) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	//--------Methods that can be called by an Super Customer
	
	/**
	 * Changes the super club member into a regular customer
	 * @param customer The customer who wants to stop being a Super Club Member
	 * @return true if the SuperCustomer is successfully changed to a regular customer
	 * @pos getAccount(customer) instanceof RegisteredCustomer
	 */
	public boolean quitsuperclub(SuperCustomer customer) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	//--------Methods that can be called by an Super Customer
	
	//SearchForCustomersByFirstName
	
	/**
	 * Returns a list of customers that have the same first name as the parameter
	 * @param firstName The first name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Customer[] searchForCustomersByFirstName(String firstName) {
		return new Customer[0]; //NOT IMPLEMENTED
	}
	
	/**
	 * Returns a list of customers that have the same last name as the parameter
	 * @param lastName The last name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Customer[] searchForCustomersByLastName(String lastName) {
		return new Customer[0];
	}
	
	/**
	 * Returns a list of customers that have the same first and last name as the parameters
	 * @param firstName The first name of the customer being searched
	 * @param lastName The last name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Customer[] searchForCustomersByFirstAndLastName(String lastName) {
		return new Customer[0];
	}
	
	/**
	 * Returns a list of customers that have the same email as the parameter
	 * @param firstName The first name of the customer being searched
	 * @param lastName The last name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Customer[] searchForCustomersByEmail(String emailAddress) {
		return new Customer[0];
	}
	
	/**
	 * Returns a list of customers that have the same email as the parameter
	 * @param firstName The first name of the customer being searched
	 * @param lastName The last name of the customer being searched
	 * @return a list of customers that match the search criteria
	 */
	public Customer[] searchForCustomersByUserName(String userName) {
		return new Customer[0];
	}
	
	//--------Methods that can be called by a Manager 
	
	//addClerkAccount()
	
	/**
	 * Creates a new RegisteredCustomerAccount record in the database
	 * @param firstName The first name of the employee
	 * @param lastName The last name of the employee
	 * @param phoneNumber	The employee's phone number
	 * @param emailAddress	The employee's email address
	 * @param userName		The employee's userName
	 * @param password		An encrypted version of The employee's password
	 * @return true if the account was successfully created
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	public boolean addClerkAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	//--------Methods that can be called by a System Administrator
	
	/**
	 * Creates a new ManagerAccount record in the database
	 * @param firstName The first name of the employee
	 * @param lastName The last name of the employee
	 * @param phoneNumber	The employee's phone number
	 * @param emailAddress	The employee's email address
	 * @param userName		The employee's userName
	 * @param password		An encrypted version of The employee's password
	 * @return true if the account was successfully created
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	public boolean addManagerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		return false; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Returns the password of a user, given their user name
	 * @param userName The user name of the account needing authentication
	 * @return an encrypted version of the password associated with the UserName
	 */
	private String getPassword(String userName) {
		return new String(); //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Returns an account object for the given user name
	 * @param userName The user name of the account to return
	 * @return An account object that matches the given userName
	 */
	private Account getAccount(String userName) {
		return new Account(); //METHOD NOT IMPLEMENTED
	}
}
