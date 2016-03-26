package databaseManagement;

import vehicleManagement.Equipment;

/**
 * EquipmentDB creates, deletes, and modifies data related to Equipment
 * @author Robin
 *
 */
public class EquipmentDB extends DatabaseManager{
	
	public EquipmentDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * updateEquipmentStatus updates the status of an equipment
	 * @param e equipment
	 * @param status status {rented, damaged, available}
	 * @pre isValidEquipment(e)
	 * @pre status is one of {rented, damaged, available}
	 * @post e.status = status
	 */
	public void updateEquipmentStatus(Equipment e, int status){
		
	}
	
	
	/**
	 * searchAdditionalEquipments searches for a list of available equipments for a type
	 * @param t type of equipments
	 * @param branch a branch
	 * @pre a rental is underway
	 * @pre branch is valid
	 * @pre t is valid 
	 * @post list of equipments
	 */
	public Equipment[] searchAdditionalEquipments(String t, String branch) {
		return null;
	}

}
