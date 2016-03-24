package employee;

/**
 * 
 * A System Administrator of a Rental Car Company.
 *
 */
public class SystemAdministrator extends Employee{

	/**
	 * Creates a System Administrator Object initialized with the given fields
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 */
	public SystemAdministrator(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(firstname, lastname, phoneNumber, email, loginId, password);
		// TODO Auto-generated constructor stub
	}
	
	public void manageBranch (Branch branch){
		
	}

}
