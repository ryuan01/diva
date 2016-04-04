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
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId) {
		super(firstname, lastname, phoneNumber, email, loginId);
		// TODO Auto-generated constructor stub
		super.objectClass = getClass().getName();
	}
	
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			long cc, String name_on_card, String street, String city, String province, String zip) {
		super(firstname, lastname, phoneNumber, email, loginId);
		// TODO Auto-generated constructor stub
		super.objectClass = getClass().getName();
	}
}
