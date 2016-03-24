package employee;

import vehicleManagement.VehicleManager;

public class Manager extends Employee{

	/**
	 * Creates a Manager Account object initailized with the given arguements.
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
