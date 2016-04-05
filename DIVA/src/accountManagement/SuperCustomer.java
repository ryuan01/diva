package accountManagement;

public class SuperCustomer extends Customer{

	private int points;
	//need to implement
	
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId, int id,
			int points) {
		super(firstname, lastname, phoneNumber, email, loginId, id);
		this.points = points;
		super.objectClass = getClass().getName();
	}
	
	/**
	 * No points assigned.
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param id
	 * @param cc
	 * @param name_on_card
	 * @param street
	 * @param city
	 * @param province
	 * @param zip
	 */
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId, int id,
			long cc, String name_on_card, String street, String city, String province, String zip) {
			super(firstname,  lastname, phoneNumber, email, loginId, id,
					cc, name_on_card, street, city,province, zip);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
