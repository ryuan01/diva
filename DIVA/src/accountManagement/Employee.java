package accountManagement;

import webServiceManagement.ArrayOfStringsable;

/**
 * Employee is an user, but with working branch and employee type 
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
	 * Creates an employee without password
	 * @param firstname					The first name of the User of the Account
	 * @param lastname					The last name of the User of the Account
	 * @param phoneNumber				The phone number of the User of the Account
	 * @param email						The email of the User of the Account
	 * @param loginId					The log in id of the User of the Account
	 * @param works_at					The branch ID of where the employee works at
	 * @param emp_type					'Clerk', 'Manager', 'SystemAdmin'
	 * @param id						The unique ID that identifies an employee
	 */
	public Employee(String firstname, String lastname, String phoneNumber, String email, String loginId, int works_at, String emp_type, int id) {
		super(firstname, lastname, phoneNumber, email, loginId, id);
		this.works_at = works_at;
		this.emp_type = emp_type;
		// TODO Auto-generated constructor stub
		super.objectClass = getClass().getName();
	}
	
	/**
	 * Creates an employee with password 
	 * @param firstname					The first name of the User of the Account
	 * @param lastname					The last name of the User of the Account
	 * @param phoneNumber				The phone number of the User of the Account
	 * @param email						The email of the User of the Account
	 * @param loginId					The log in id of the User of the Account
	 * @param password					The password of the User of the Account
	 * @param works_at					The branch ID of where the employee works at
	 * @param emp_type					'Clerk', 'Manager', 'SystemAdmin'
	 * @param id						The unique ID that identifies an employee
	 */
	public Employee(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, String password, int works_at, String emp_type, int id){
		
		super(firstname, lastname, phoneNumber, email, loginId, password);
		this.works_at = works_at;
		this.emp_type = emp_type;
		super.objectClass = getClass().getName();
	}
	
	/**
	 * Gets the branch ID of where the employee works at 
	 * @return employee work branch number
	 */
	public int getWorks_at() {
		return works_at;
	}
	
	/**
	 * Sets the branch ID of where the employee works at
	 * @param works_at employee work branch number
	 */
	public void setWorks_at(int works_at) {
		this.works_at = works_at;
	}

	/**
	 * Gets the type of employee 
	 * @return employee type (clerk, manager, sys admin)
	 */
	public String getEmp_type() {
		return emp_type;
	}

	/**
	 * Sets the type of employee 
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
