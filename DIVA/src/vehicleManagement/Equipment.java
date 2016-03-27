package vehicleManagement;
import java.util.Currency;

/* Robin */
/**
 * Equipment class models additional equipments for rentals
 */
public class Equipment {
	
	/**
	 * type can be {forCar, forTruck}
	 */
	private String type;
	
	/**
	 * name of the equipment
	 */
	private String name;
	 
	
	private String equipmentID;
	
	// true if available, false if already reserved.
	private boolean status;
	
	//constructors
	/**
	 * Constructs a new equipment, need to talk to db
	 * @param t type
	 * @param n name
	 * @param p price
	 * @pre !isEquipment(t,n)
	 * @post isEquipment(t,n)
	 */
	public Equipment(String t, String n, String p) {
	}
	
	//setters and getters
	
	/**
	 * Get type of equipment
	 * @pre none
	 * @post type is returned
	 */
	public String getType() {
		return null;
	}

	/**
	 * Get name of the equipment
	 * @pre none
	 * @post name is returned 
	 */
	public String getName() {
		return null;
	}
	
	/**
	 * Get price of the equipment
	 * @pre none
	 * @post price is returned
	 */
	public String getPrice() {
		return null;
	}
	
	/**
	 * Set type of equipment
	 * @param t a type of equipment
	 * @pre t must be a possible type
	 * @post type is set 
	 */
	public void setType(String t) {
	}
	
	/**
	 * Set name of equipment
	 * @param n a name 
	 * @pre n must be formatted
	 * @post name is set 
	 */
	public void setName(String n) {
	}
	
	/**
	 * Set price of equipment
	 * @param p price
	 * @pre p > 0
	 * @post price is set
	 */
	public void setPrice(Currency p) {
	}
	
	public void changeType(String newType)
	{
		type = newType;
	}
	
	public void changeID(String newID)
	{
		equipmentID = newID;
	}
	
	public void changeStatus(boolean newStatus)
	{
		status = newStatus;
	}
	
	public String getID()
	{
		return equipmentID;
	}
	
	public boolean getStatus()
	{
		return status;
	}
}
