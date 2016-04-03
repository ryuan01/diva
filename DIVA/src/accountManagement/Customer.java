package accountManagement;

public class Customer extends Account{
	private String standing;
	private long cc_num;
	private String name_on_card;
	
	//need to implement
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String status) {
		super(firstname, lastname, phoneNumber, email, loginId, status);
		// TODO Auto-generated constructor stub
	}
}
