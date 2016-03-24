<<<<<<< HEAD:DIVA/src/accountManager/Account.java
package accountManager;


/**
 * 
 *	An Account that holds the data of a User that signs up with the Rental Company
 */
=======
package accountManagement;
//Kevin , continue to extend

>>>>>>> b5a7ecfeed5c781af882e7fc4e592ff6eb67a823:DIVA/src/accountManagement/Account.java

public class Account {

	
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String email;
	private String loginId;
	private String password;
	
	/**
	 * Creates a new Account object initialized with the given arguments
	 * @param firstname					The first name of the User of the Account
	 * @param lastname					The last name of the User of the Account
	 * @param phoneNumber				The phone number of the User of the Account
	 * @param email						The email of the User of the Account
	 * @param loginId					The log in id of the User of the Account
	 * @param password					The password of the User of the Account
	 */
	public Account (String firstname, String lastname, String phoneNumber, String email, String loginId, String password){
		this.firstname = firstname;
		this.lastname =  lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.loginId= loginId;
		this.password = password;
	
	}

	/**
	 * Gets the firstname of a user account.
	 * 
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the first name of a user account.
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	/**
	 * Gets the last name of a user account.
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the last name of a user account.
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the phone number of a user account.
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of a user account.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email of a user account.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email of a user account.
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password of a user account.
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of a user account.
	 * @param password
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the login id of a user account.
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login Id of a user account.
	 * @param loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
}
