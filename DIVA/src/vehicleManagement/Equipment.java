/**
 * Notes:
 * 	1- This class is not Tested
 * 	2- Update the javadocs when this class is confirmed
 * 
 */ 
package vehicleManagement;
import java.math.BigDecimal;

/**
 * Equipment class models additional equipments for rentals
 * @author Robin
 * @version April 3 2016
 */
public class Equipment{
	
	
	private String objectClass;
	private int serialNum;
	private String type;
	private int location;
	private BigDecimal rentalPrice; //used to hold calculated rental price for a vehicle.
	
	public Equipment(int sn, String type, int location){
		this.serialNum = sn;
		this.type = type;
		this.location = location;
		this.objectClass = getClass().getName();
		rentalPrice = null;
	}
	
	//setters and getters
	
	/**
	 * Get type of equipment
	 * @pre none
	 * @post none
	 * @return Equipment type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Get id of an equipment
	 * @return id
	 */
	public int getSerialNum(){
		return serialNum;
	}
	
	/**
	 * Get branch of equipment
	 * @return branch ID
	 */
	public int getEquipmentBranch(){
		return location;
	}
	
	/**
	 * Change type of equipment
	 * @param newType
	 */
	public void changeType(String newType)
	{
		type = newType;
	}
	
	/**
	 * Set location of equipment
	 * @param l branch id 
	 */
	public void setLocation(int l){
		this.location = l;
	}
}

