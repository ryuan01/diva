package accountManagement;
/**
 * 
 * @author Robin
 *
 */
public class Employee extends Account{

	private int works_at;
	private String emp_type;
	
	public Employee(String firstname, String lastname, String phoneNumber, String email, String loginId, int works_at, String emp_type, int id) {
		super(firstname, lastname, phoneNumber, email, loginId, id);
		this.works_at = works_at;
		this.emp_type = emp_type;
		// TODO Auto-generated constructor stub
		super.objectClass = getClass().getName();
	}
	
	public int getWorks_at() {
		return works_at;
	}

	public void setWorks_at(int works_at) {
		this.works_at = works_at;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

}
