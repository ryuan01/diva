package accountManagement;

import webServiceManagement.ArrayOfStringsable;

/**
 * 
 * @author Robin
 *
 */
public class Employee extends Account implements ArrayOfStringsable{
	
	/**
	 * employee work branch number
	 */
	private int works_at;
	
	/**
	 * employee type (clerk, manager, sys admin)
	 */
	private String emp_type;
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param works_at
	 * @param emp_type
	 * @param id
	 */
	public Employee(String firstname, String lastname, String phoneNumber, String email, String loginId, int works_at, String emp_type, int id) {
		super(firstname, lastname, phoneNumber, email, loginId, id);
		this.works_at = works_at;
		this.emp_type = emp_type;
		// TODO Auto-generated constructor stub
		super.objectClass = getClass().getName();
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 * @param works_at
	 * @param emp_type
	 * @param id
	 */
	public Employee(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, String password, int works_at, String emp_type, int id){
		
		super(firstname, lastname, phoneNumber, email, loginId, password);
		this.works_at = works_at;
		this.emp_type = emp_type;
		super.objectClass = getClass().getName();
	}
	
	/**
	 * 
	 * @return employee work branch number
	 */
	public int getWorks_at() {
		return works_at;
	}
	
	/**
	 * 
	 * @param works_at employee work branch number
	 */
	public void setWorks_at(int works_at) {
		this.works_at = works_at;
	}

	/**
	 * 
	 * @return employee type (clerk, manager, sys admin)
	 */
	public String getEmp_type() {
		return emp_type;
	}

	/**
	 * 
	 * @param emp_type employee type (clerk, manager, sys admin)
	 */
	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}
	
	
	/**
	 * @override super.toString()
	 */
	@Override
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'fisrtName':'"+this.getFirstname()
				+"','lastname':'"+this.getLastname()+"',"+"'phoneNumber;':'"+this.getPhoneNumber()
				+"','email':'"+this.getEmail()+"','status':'"+this.getLoginId()
				+"','objectClass':'"+this.getObjectClass()+"', 'works_at':'"+this.works_at
				+"','emp_type':'"+this.emp_type+"'}";
	}

}
