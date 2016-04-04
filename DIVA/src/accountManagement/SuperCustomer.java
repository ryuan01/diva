package accountManagement;

public class SuperCustomer extends Customer{

	private int points;
	//need to implement
	
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			int points) {
		super(firstname, lastname, phoneNumber, email, loginId);
		this.points = points;
		super.objectClass = getClass().getName();
	}

}
