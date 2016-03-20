package vehicleManager;

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
	private int location;
	private int capacity;
	private int dailyRate;
	private int weeklyRate;
	private int hourlyRate;
	private int perKMRate;
	private int dailyInsuranceRate;
	private int weeklyInsuranceRate;
	private int hourlyInsuranceRate;
	
	/**
	 * Creates a new Vehicle object initialized with the given arguments
	 * @param location		The branch id of the branch that owns the vehicle
	 * @param capacity		The number of seats in the vehicle
	 * @param dailyRate		The flat rate for rentals longer than a day but shorter than a week
	 * @param weeklyRate	The flat rate for rentals longer than a week
	 * @param hourlyRate	The flat rate for rentals shorter than one day
	 * @param perKMRate		The rate changed for each kilometer driven
	 * @param dailyInsuranceRate	Daily Insurance price 
	 * @param hourlyInsuranceRate	Hourly Insurance price
	 * @param weeklyInsuranceRate	Weekly Insurance price
	 * @param type	Either Car or Truck
	 * @param manufactuer	The name of the company who manufactures the vehicle
	 * @param year	The year the vehicle was manufactured
	 * @param color	The color of the car
	 * @param status	The status of the car is either SOLD, FORSALE, or FORRENT
	 * @param features	A description of the car
	 */
	public Vehicle(int location, int capacity, int dailyRate, int weeklyRate, int hourlyRate, int perKMRate, int dailyInsuranceRate, int hourlyInsuranceRate, int weeklyInsuranceRate, String type, String manufacturer, String year, String color, String status, String features) {
		this.setType(type);
		this.manufacturer = manufacturer;
		this.year = year;
		this.color = color;
		this.status = status;
		this.features = features;
		this.location = location;
		this.capacity = capacity;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
		this.hourlyRate = hourlyRate;
		this.perKMRate = perKMRate;
		this.dailyInsuranceRate = dailyInsuranceRate;
		this.weeklyInsuranceRate = weeklyInsuranceRate;
		this.hourlyInsuranceRate = hourlyInsuranceRate;
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
	public int getLocation() {
		return location;
	}

	/**
	 * Sets this vehicles location to to the location argument
	 * @pre The location provided must be a valid branchID
	 * @param location The new branchID of the vehicle
	 */
	public void setLocation(int location) {
		this.location = location;
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

	/**
	 * Returns the Vehicles Daily rental rate
	 * @return the Vehicles Daily rental rate
	 */
	public int getDailyRate() {
		return dailyRate;
	}

	/**
	 * Sets the dailyRate
	 * @param dailyRate
	 */
	public void setDailyRate(int dailyRate) {
		this.dailyRate = dailyRate;
	}

	/**
	 * Returns the Vehicles weekly rental Rate
	 * @return the Vehicles weekly rental Rate
	 */
	public int getWeeklyRate() {
		return weeklyRate;
	}

	/**
	 * Sets the weekly rental rate for this vehicle
	 * @param weeklyRate The weekly rental rate for this vehicle
	 */
	public void setWeeklyRate(int weeklyRate) {
		this.weeklyRate = weeklyRate;
	}

	/**
	 * Returns the Vehicles hourly rental Rate
	 * @return the Vehicles hourly rental Rate
	 */
	public int getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * Set hourly rental rate for this vehicle
	 * @param hourlyRate the hourly rental rate for this vehicle
	 */
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * Returns the Vehicles per KM rental Rate
	 * @return the Vehicles per KM rental Rate
	 */
	public int getPerKMRate() {
		return perKMRate;
	}

	/**
	 * Set per KM rental rate
	 * @param perKMRate the per Kilometer rental rate
	 */
	public void setPerKMRate(int perKMRate) {
		this.perKMRate = perKMRate;
	}

	/**
	 * Returns the Vehicles daily insurance Rate
	 * @return the Vehicles daily insurance Rate
	 */
	public int getDailyInsuranceRate() {
		return dailyInsuranceRate;
	}

	/**
	 * Sets the daily insurance rate for this vehicle
	 * @param dailyInsuranceRate The daily insurance rate for this vehicle
	 */
	public void setDailyInsuranceRate(int dailyInsuranceRate) {
		this.dailyInsuranceRate = dailyInsuranceRate;
	}

	/**
	 * Returns the Vehicles weekly insurance Rate
	 * @return the Vehicles weekly insurance Rate
	 */
	public int getWeeklyInsuranceRate() {
		return weeklyInsuranceRate;
	}

	/**
	 * Sets the weekly insurance rate for this vehicle
	 * @param weeklyInsuranceRate the new weekly insurance rate
	 */
	public void setWeeklyInsuranceRate(int weeklyInsuranceRate) {
		this.weeklyInsuranceRate = weeklyInsuranceRate;
	}

	/**
	 * Returns the Vehicles hourly insurance Rate
	 * @return the Vehicles hourly insurance Rate
	 */
	public int getHourlyInsuranceRate() {
		return hourlyInsuranceRate;
	}

	/**
	 * Sets the hourly insurance rate for this vehicle
	 * @param hourlyInsuranceRate the new hourly insurance rate for this
	 */
	public void setHourlyInsuranceRate(int hourlyInsuranceRate) {
		this.hourlyInsuranceRate = hourlyInsuranceRate;
	}
}

	