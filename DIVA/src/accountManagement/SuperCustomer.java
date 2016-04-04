package accountManagement;

public class SuperCustomer extends Customer{

	private int points;
	//need to implement
	
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String objectClass, int points) {
		super(firstname, lastname, phoneNumber, email, loginId, objectClass);
		this.points = points;
		// TODO Auto-generated constructor stub
	}

}
