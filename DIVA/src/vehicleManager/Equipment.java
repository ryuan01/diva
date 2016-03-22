package vehicleManager;
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
	
	/**
	 * price of the equipment, by day
	 */
	private int price; 
	
	//constructors
	/**
	 * Constructs a new equipment, need to talk to db
	 * @param t type
	 * @param n name
	 * @param p price
	 * @pre !isEquipment(t,n)
	 * @post isEquipment(t,n)
	 */
	public Equipment(String t, String n, String p);
	
	//checkers
	/**
	 * Checks if this is an equipment
	 * @param t type
	 * @param n name
	 * @pre t must be one of the proposed one
	 * @post true if it is, false if it is not
	 */
	private boolean isEquipment(String t, String n);
	//setters and getters
	
	/**
	 * Get type of equipment
	 * @pre none
	 * @post type is returned
	 */
	public String getType();

	/**
	 * Get name of the equipment
	 * @pre none
	 * @post name is returned 
	 */
	public String getName();
	
	/**
	 * Get price of the equipment
	 * @pre none
	 * @post price is returned
	 */
	public String getPrice();
	
	/**
	 * Set type of equipment
	 * @param t a type of equipment
	 * @pre t must be a possible type
	 * @post type is set 
	 */
	public void setType(String t);
	
	/**
	 * Set name of equipment
	 * @param n a name 
	 * @pre n must be formatted
	 * @post name is set 
	 */
	public void setName(String n);
	
	/**
	 * Set price of equipment
	 * @param p price
	 * @pre p > 0
	 * @post price is set
	 */
	public void setPrice(Currency p);

}
