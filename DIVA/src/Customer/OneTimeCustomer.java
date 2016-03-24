package Customer;

/**
 * 
 * A One Time Customer Account which has all the functionality of a customer
 *
 */
public class OneTimeCustomer extends Customer{

	/**
	 * The One Time Customer Inherits the fields from the customer.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 */
	public OneTimeCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(firstname, lastname, phoneNumber, email, loginId, password);
		// TODO Auto-generated constructor stub
	}

}
