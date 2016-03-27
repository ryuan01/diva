package vehicleManagement;

/**
 * A vehicle holds data about real Vehicles owned by the rental company
 */
public class Vehicle {
	
	private String type;
	private String manufacturer;
	private String year;
	private String color;
	private String status;
	private String features;
	private String branchID;
	private int capacity;
	
	/**
	 * Creates a new Vehicle object initialized with the given arguments
	 * @param location		The branch id of the branch that owns the vehicle
	 * @param capacity		The number of seats in the vehicle
	 * @param type	Either Car or Truck
	 * @param manufactuer	The name of the company who manufactures the vehicle
	 * @param year	The year the vehicle was manufactured
	 * @param color	The color of the car
	 * @param status	The status of the car is either SOLD, FORSALE, or FORRENT
	 * @param features	A description of the car
	 */
	public Vehicle(String location, int capacity, int dailyRate, int weeklyRate, int hourlyRate, int perKMRate, int dailyInsuranceRate, int hourlyInsuranceRate, int weeklyInsuranceRate, String type, String manufacturer, String year, String color, String status, String features) {
		this.setType(type);
		this.manufacturer = manufacturer;
		this.year = year;
		this.color = color;
		this.status = status;
		this.features = features;
		this.branchID = location;
		this.capacity = capacity;
	}

	/**
	 * Returns the Vehicles Type
	 * @return the type of this vehicle
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the vehicle to the argument type
	 * @pre the type argument must be either Car or Truck
	 * @param type The type of vehicle
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the Vehicles location which is the id of it's owning branch
	 * @return the branchID of the branch who owns this vehicle
	 */
	public String getLocation() {
		return branchID;
	}

	/**
	 * Sets this vehicles location to to the location argument
	 * @pre The location provided must be a valid branchID
	 * @param location The new branchID of the vehicle
	 */
	public void setLocation(String location) {
		this.branchID = location;
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
		return year;
	}

	/**
	 * Sets the year that the car was manufactured
	 * @param year The year the car was manufactured
	 */
	public void setYear(String year) {
		this.year = year;
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
	 * Returns the number of people who can fit in the vehicle
	 * @return the capacity of this vehicle
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity of the vehicle
	 * @param capacity The number of seats the vehicle has
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	 * Returns a string describing the Vehicle
	 * @return the the description of this vehicle
	 */
	public String getFeatures() {
		return features;
	}

	/**
	 * Sets the features of this car
	 * @param features A short description of the vehicle
	 */
	public void setFeatures(String features) {
		this.features = features;
	}
}

	