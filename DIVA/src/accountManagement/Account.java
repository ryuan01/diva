/**
 * 
 *	An Account that holds the data of a User that signs up with the Rental Company
 */

package accountManagement;
//Kevin , continue to extend



public abstract class Account {

	private int id;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String email;
	private String loginId;
	private String objectClass;
	
	/** cx 
	 * Creates a new Account object initialized with the given arguments
	 * @param firstname					The first name of the User of the Account
	 * @param lastname					The last name of the User of the Account
	 * @param phoneNumber				The phone number of the User of the Account
	 * @param email						The email of the User of the Account
	 * @param loginId					The log in id of the User of the Account
	 * @param password					The password of the User of the Account
	 */
	public Account (String firstname, String lastname, String phoneNumber, String email, String loginId){
		this.firstname = firstname;
		this.lastname =  lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.loginId= loginId;
		this.objectClass= getClass().getName();
	}

	/**
	 * Gets the first name of a user account.
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
	 * Gets the login id of a user account.
	 * @return loginId
	 */
	public String getLoginId() {
		// TODO Auto-generated method stub
		return loginId;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
}
