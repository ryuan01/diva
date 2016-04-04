package accountManagement;

public class Customer extends Account{
	private String standing;
	private long cc_num;
	private String name_on_card;
	private String street_name;
	private String city;
	private String province;
	private String zip;
	
	//need to implement
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String objectClass) {
		super(firstname, lastname, phoneNumber, email, loginId, objectClass);
		// TODO Auto-generated constructor stub
	}
}
