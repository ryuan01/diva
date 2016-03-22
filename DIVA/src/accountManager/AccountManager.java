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
	
	//quitsuperclub();
	
	//--------Methods that can be called by an Super Customer
	
	//SearchForCustomerByFirstName
	//SearchForCustomerByLastName
	//SearchForCustomerByEmailAddress
	//SearchForCustomerByUserName
	
	//--------Methods that can be called by a Manager
	
	//addClerkAccount()
	
	//--------Methods that can be called by a System Administrator
	
	//addManagerAccount()
	
	//--------Methods that can be called by other Subsystems
	
	//getpassword();
	//searchForAccountByUserName();
}
