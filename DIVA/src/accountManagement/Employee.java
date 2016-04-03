package accountManagement;
/**
 * 
 * @author Robin
 *
 */
public class Employee extends Account{

	private int works_at;
	private String type;
	
	public Employee(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String status) {
		super(firstname, lastname, phoneNumber, email, loginId, status);
		// TODO Auto-generated constructor stub
	}

}
