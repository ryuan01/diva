package accountManagement;

/**
 * 
 * A Super Customer account for a rental company. The Super Customer is allowed to pay
 * for the rental with Points.
 * 
 */
public class SuperCustomer extends RegisteredCustomer{
	
	private int points;

	/**
	 * Creates a super customer account with the inherited fields from a registered customer.
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 */
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(password, password, password, password, password, password);
		// TODO Auto-generated constructor stub
	}
/**
 * Gets the current amount of points.
 * @return points
 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the current amount of points. 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

}
