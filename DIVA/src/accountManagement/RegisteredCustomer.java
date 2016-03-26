package accountManagement;

/**
 * 
 * The Registered Customer user account of the rental company. The registered customer
 * inherits a customer account and is able to store their credit card information on 
 * this registered account.
 *
 */

public class RegisteredCustomer extends Customer{


	private String creditCard;
	
/**
 * Creates a Registered Customer with the inherited fields from Customer Account. 
 * @param firstname
 * @param lastname
 * @param phoneNumber
 * @param email
 * @param loginId
 * @param password
 */
	public RegisteredCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(firstname, lastname, phoneNumber, email, loginId, password);
		// TODO Auto-generated constructor stub
	}
/**
 * Gets a Credit Card from the User.
 * @return creditCard
 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * Sets a creditCard for the user. 
	 * @param creditCard
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

}
