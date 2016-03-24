package employee;

import vehicleManagement.VehicleManager;

public class Manager extends Employee{

	/**
	 * Creates a Manager Account object initialized with the given arguments. A Manager inherits the operations and fields of an employee.
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 */
	public Manager(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(firstname, lastname, phoneNumber, email, loginId, password);
		// TODO Auto-generated constructor stub
	}
	
	public void manageVehicle(VehicleManager manager){
		
	}

}
