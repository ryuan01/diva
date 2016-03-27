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
	 * price of the equipment, by day
	 */
	private Currency price; 
	
	public Equipment(int sn, String type){
		serialNum = sn;
		this.type = type;
	}
	
	// constructors
	public Equipment(Equipment eq){
		this.serialNum = eq.getSerialNum();
		this.type = eq.getType();
		this.price = eq.getPrice();
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
	
	/**
	 * Get price of the equipment
	 * @pre none
	 * @post none
	 * @return Equipment rental price
	 */
	public Currency getPrice() {
		return price;
	}
	
	//checkers
	/**
	 * Checks if this is an equipment
	 * @param t type
	 * @param n name
	 * @pre t must be one of the proposed one
	 * @post true if it is, false if it is not
	 */
	private boolean isEquipment(String t, String n) {
		return false;
		// I don't know what this method is for??!!
	}
}

