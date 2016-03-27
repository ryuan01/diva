package databaseManagement;

import vehicleManagement.Equipment;

/**
 * EquipmentDB creates, deletes, and modifies data related to Equipment
 * @author Robin
 *
 */
public class EquipmentDB extends DatabaseManager{
	
	public EquipmentDB() {
		super(dbname, dbname);
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
	public void updateEquipmentStatus(String e_key_value, int status){
		
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
	/**
	 * Checks if this is an equipment
	 * @param t type
	 * @param n name
	 * @pre t must be one of the proposed one
	 * @post true if it is, false if it is not
	 */
	private boolean isEquipment(String t, String n) {
		return false;
	}
	
	/**
	 * 
	 * @param e_key_value
	 * @return
	 */
	public String getEquipment(String e_key_value){
		return e_key_value;
		
	}
	
	/**
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public String getEquipment(String type, String name){
		return name;
		
	}

}
