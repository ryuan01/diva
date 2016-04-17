package accountManagement;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;

/**
 * An account manager provides account related services
 * @version 1
 * @since March 19, 2016
 * @author AlexDaniels
 */
public class AccountManager {
	
	/**
	 * dbConnection a DatabaseManager instance object for methods that require
	 * 	direct database connection
	 */
	private static DatabaseManager dbConnection;
	private PaymentManager pm;
	
	
	/**
	 * Constructs an AccountManager object
	 */
	public AccountManager() {
		dbConnection = DatabaseManager.getInstance();
		pm = new PaymentManager();
	}
	
	//------------Methods that can be called by an unauthenticated HTTPS user--------//

	/**
	 * Creates a new CustomerAccount record in the database
	 * Fulfills RAD use-case: Register
	 * @param firstName 	The first name of the customer
	 * @param lastName 		The last name of the customer
	 * @param phoneNumber	The customers phone number
	 * @param emailAddress	The customers email address
	 * @param userName		The customers userName
	 * @param password		An encrypted version of The customers password
	 * @param ccNum 		Customer credit card number
	 * @param name_on_cc	Name written on customer credit card
	 * @param expire_date	Customer credit card expire date
	 * @param address		Customer residence street name
	 * @param city			Customer city of residence
	 * @param province		Customer province of residence; it has to be Canadian
	 * @param zip			Customer residence Zip Code
	 * @throws SQLException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	public void addCustomerAccount(String firstName, String lastName, String phoneNumber, 
			String emailAddress, String userName, String password, 
			String ccNum, String name_on_cc, String expire_date, String address,
			String city, String province, String zip) throws SQLException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException 
	{
		int id = -1; //let database auto increment id
		String encrypted_credit_card = pm.encrypt(ccNum);
		System.out.println(encrypted_credit_card.length());
		/*Customer(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, int id, 
			String password, String cc, String expire_date, String name_on_card, 
			String address, String city, String province, String zip, String standing) */
		Account acc = new Customer(firstName, lastName, phoneNumber, 
				emailAddress, userName, id,
				password, encrypted_credit_card, expire_date, name_on_cc,
				address, city, province, zip,"Good");
		System.out.println(acc.toString());
		dbConnection.createAccountEntry(acc);
	}
	
	/**
	 * Creates a new Employee Account record in the database
	 * Fulfills RAD use-case: Register
	 * @author saud (sammy) almahri
	 * @param firstName 	The first name of the employee
	 * @param lastName 		The last name of the employee
	 * @param phoneNumber	The employee phone number
	 * @param emailAddress	The employee email address
	 * @param userName		The employee userName
	 * @param works_at		Employee's work branch number
	 * @param type			Employee type (manager, clerk, system admin)
	 * @throws SQLException 
	 * @pre userNameIsUnique(userName)
	 * @pre phoneNumberIsUnique(phoneNumber)
	 * @pre emailAddressIsUnique(emailAddress)
	 */
	public void addEmployeeAccount(String firstName, String lastName, String phoneNumber, 
			String emailAddress, String userName,String password, int works_at, String type) throws SQLException {
		int id = -1; //let database auto increment id 
		Account acc = new Employee(firstName, lastName, phoneNumber, emailAddress, userName, password, works_at, type, id);
		dbConnection.createAccountEntry(acc);
	}
		
	/**
	 * Changes the customer from a regular customer to a Super Club Member
	 * @author saud (sammy) almahri
	 * @param customer The customer who wants to join super club
	 * @pre CustomerHasACreditCard()
	 * @pos getAccount(customer.UserName) instanceof SuperCustomer
	 * @return true if the customer successfully joined Super Club
	 * @throws SQLException 
	 */
	public void joinSuperClub(String userName) throws SQLException 
	{
		// Note: the database automatically adds 500 points when a customer
		// is upgraded to superCustomer
		dbConnection.changeAccountStatus(userName, "SRCustomer");
	}
	
	/**
	 * Add points to SuperRent customer account
	 * @author saud (sammy) almahri
	 * @param username 		SuperRent customer username
	 * @param points 		Ammount of points to add to SuperRent customer account
	 * @invariant points > 0
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	public void accumulatePoints(String username, int points) throws SQLException
	{
		if (points > 0){
			dbConnection.addSRPoints(username,points);
		} else {
			throw new IllegalArgumentException("Points is not a Positive Number");
		}
	}
	
	/**
	 * Downgrade SuperRent customer to regual customer
	 * @param userName		SuperRent customer username
	 * @throws SQLException
	 */
	public void leaveSuperCLub(String userName) throws SQLException
	{
		dbConnection.changeAccountStatus(userName, "RegisteredCustomer");
	} 
	
	
	/**
	 * Moves the customers account from the activated state into the deactivated state
	 * @param customer The customer account to be deactivated
	 * @param password The customers password
	 * @return true if the account was successfully activated
	 * @throws SQLException 
	 * @pre customer.getState() == activated
	 * @pos customer.getState() == deactivated
	 */
	public void deleteAccount(String userName) throws SQLException {
		// TODO re-implement a new method
		dbConnection.removeAccountEntry(userName);
	}
	
	/**
	 * Returns a list of customers that have the same last name
	 * @author saud (sammy) almahri
	 * @param lastName The first name of the customer being searched
	 * @return a list of customers that match the search criteria
	 * @throws SQLException 
	 */
	public Account[] searchAccountByLastName(String lastName) throws SQLException{
		return dbConnection.searchAccountEntries(lastName);
	}
	
	/**
	 * Returns a customer object using a username parameter
	 * @author saud (sammy) almahri
	 * @param username customer account username
	 * @return a list of customers that match the search criteria
	 * @throws SQLException 
	 */
	public Account searchAccountByUsername(String username) throws SQLException{
		return dbConnection.searchAccountEntries(username)[0];
	}
	
	/**
	 * @author saud (sammy) almahri 
	 * @param phoneNum 	customer phone number
	 * @return a list of customers that match the search criteria
	 * @throws SQLException
	 */
	public Account[] searchAccountByPhoneNumber(String phoneNum) throws SQLException{
		return dbConnection.searchAccountEntries(phoneNum);
	}
	
	/**
	 * Returns the password of a user, given their user name
	 * @author saud (sammy) almahri 
	 * @param userName The user name of the account needing authentication
	 * @return an encrypted version of the password associated with the UserName
	 * @throws SQLException 
	 */
	public String getPassword(String userName) throws SQLException {
		return dbConnection.retrievePassword(userName);
	}
	
	/**
	 * @author saud (sammy) almahri 
	 * @param userName 		The user name of the account needing password change
	 * @param newPassword 	The user account new password
	 * @throws SQLException
	 */
	public void changePassword(String userName, String newPassword) throws SQLException{
		dbConnection.modifyPassword(userName,newPassword);
	}
}
