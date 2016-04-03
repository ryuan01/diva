/**
 * Notes:
 * 	1- This class is not Tested
 * 	2- Update the javadocs when this class is confirmed
 * 
 */ 
package vehicleManagement;

import java.util.Currency;
import systemManagement.Branch;

/* Robin */
/**
 * Equipment class models additional equipments for rentals
 */
public class Equipment{
	
	private int serialNum;
	
	/**
	 * type can be 'ski rack', 'child safety seat', 'lift gate', or 'car-towing eq'
	 */
	private String type;
	
	/**
	 * location refers to id of branch
	 */
	private int location;
	
	/**
	 * price of the equipment, by day
	 */
	
	public Equipment(int sn, String type, int location){
		this.type = type;
		this.location = location;
	}
	
	//setters and getters
	
	/**
	 * Get type of equipment
	 * @pre none
	 * @post none
	 * @return Equipment type
	 */
	public String getType() {
		return null;
	}
	
	public int getSerialNum(){
		return serialNum;
	}
	
	public int getEquipmentBranch(){
		return location;
	}
	
	public void changeType(String newType)
	{
		type = newType;
	}
	
	public void setLocation(int l){
		this.location = l;
	}
}

