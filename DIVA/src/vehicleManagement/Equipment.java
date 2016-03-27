package vehicleManagement;

import java.util.Currency;
//import Branch

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
	
	public int getSN(){
		return serialNum;
	}
}

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
	
	//-------------------------------------------
	//BEN's work
	//need to talk to BEN
	
	private int id;
	// true if available, false if already reserved.
	private boolean status;
	
	public Equipment()
	{
		type = "";
		id = 0;
		status = false;
	}
	
	public Equipment(String t, int i, boolean s)
	{
		type = t;
		id = i;
		status = s;
	}
	
	public void changeType(String newType)
	{
		type = newType;
	}
	
	public void changeID(int newID)
	{
		id = newID;
	}
	
	public void changeStatus(boolean newStatus)
	{
		status = newStatus;
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean getStatus()
	{
		return status;
	}
}
