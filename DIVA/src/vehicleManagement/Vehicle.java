package vehicleManagement;

/**
 * A vehicle holds data about real Vehicles owned by the rental company
 */
public class Vehicle {
	
	private String objectClass;
	private String status;
	private int id; 
	private String manufacturer;
	private String v_year; // year of purchase
	private String model;
	private String color;
	private String path;
	
	/**
	 * Creates a new vehicle
	 * @param id vehicle id
	 * @param manufacturer company who made this vehicle
	 * @param year year of purchase
	 * @param model model of vehicle
	 * @param color color of vehicle
	 * @param status for rent, for sale, or sold
	 * @param path an relative path to find the picture for this vehicle
	 */
	public Vehicle(int id, String manufacturer, String year, String model, String color, String status, String path) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.v_year = year;
		this.color = color;
		this.status = status;
		this.model = model;
		this.path = path;
	}
	
	/**
	 * @return vehicle id
	 */
	public int getID(){
		return id;
	}

	
	/**
	 * Returns the Manufacture of this vehicle
	 * @return
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufacturer of this vehicle
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Returns the year the Vehicle was manufactured
	 * @return the year this Vehicle was manufactured
	 */
	public String getYear() {
		return v_year;
	}

	/**
	 * Sets the year that the car was manufactured
	 * @param year The year the car was manufactured
	 */
	public void setYear(String year) {
		this.v_year = year;
	}
	
	/**
	 * get model of vehicle
	 * @return vehicle model
	 */
	public String getModel(){
		return model;
	}
	
	/**
	 * set model of vehicle
	 * @param model model of vehicle
	 */
	public void setModel(String model){
		this.model = model;
	}

	/**
	 * Returns the color of the Vehicle
	 * @return the color of this vehicle
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color of the vehicle
	 * @param color The color of the vehicle
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the status of the vehicle
	 * @return the status of this vehicle
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the Vehicle
	 * @pre	Provided status must be SOLD, FORSALE or FORRENT
	 * @param status Describes is the vehicle is sold, for sale or for rent
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * get relative path for image of this vehicle
	 * @return path
	 */
	public String getPath(){
		return path;
	}
	
	/**
	 * set relative path for image of this vehicle
	 * @param path relative path in linux
	 */
	public void setPath(String path){
		this.path = path;
	}

	/**
	 * Returns a string describing the Vehicle
	 * @return the the description of this vehicle
	 */
	public String toString(){
		String tmp = getClass().getName()+" "
				+" ID: " +id
				+" manufacturer: "+ manufacturer
				+" year: " + v_year
				+" model: " + model
				+" color: " + color
				+" status: " + status
				+" path: " + path;
		return tmp;
	}
}

	
