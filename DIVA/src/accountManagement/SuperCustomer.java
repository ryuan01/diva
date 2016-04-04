package accountManagement;
/**
 * 
 * @author Robin
 *
 */
public class Employee extends Account{

	private int works_at;
	private String emp_type;
	
	public Employee(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String objectClass, int works_at, String emp_type) {
		super(firstname, lastname, phoneNumber, email, loginId, objectClass);
		this.works_at = works_at;
		this.emp_type = emp_type;
		// TODO Auto-generated constructor stub
	}

}
