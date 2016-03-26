package vehicleManagement;


import systemManagement.Branch;

/**
 * 
 * A Vehicle Manager which manages the properties and operations of a vehicle. 
 *
 */

public class VehicleManager {
	
	int numVehicle = 0;
	private Vehicle[] list;
	private Vehicle currentVehicle;		// Holds the Current Vehicle being viewed
	private Vehicle[] matched; // Holds a list of vehicles matching the Search Results
	
	public VehicleManager() {
		list = new Vehicle[numVehicle];
	}
	
	/**
	 * Adds a New Vehicle to the list of Vehicles that the Vehicle Manager holds
	 * @param location
	 * @param capacity
	 * @param dailyRate
	 * @param weeklyRate
	 * @param hourlyRate
	 * @param perKMRate
	 * @param dailyInsuranceRate
	 * @param hourlyInsuranceRate
	 * @param weeklyInsuranceRate
	 * @param type
	 * @param manufacturer
	 * @param year
	 * @param color
	 * @param status
	 * @param features
	 * @return list
	 */
	public Vehicle[] add_Vehicle(int location, int capacity, int dailyRate, int weeklyRate, int hourlyRate, int perKMRate, int dailyInsuranceRate, int hourlyInsuranceRate, int weeklyInsuranceRate, String type, String manufacturer, String year, String color, String status, String features){
		return list;
	}
	
	/**
	 * Set the Number of Vehicles in the array of Vehicles
	 * @param numVehicle
	 * @Pre numVehicle >= 0
	 * @Post numVehicle >= numVehicle + 1
	 * @return numVehicle
	 */
	public int set_Num_Vehicle(int numVehicle){
		return numVehicle;
	}
	
	/**
	 * Sets the rental rate of all Vehicles with the same type
	 * @param rate
	 * @param vehicle
	 * @param type
	 */
	public void set_vehicle_rental_rate(double rate, Vehicle vehicle, String type){
	}
	
	
	/** 
	 * Change the Branch of a Vehicle
	 * @param vehicle
	 * @param branch
	 */
	public void change_branch(Vehicle vehicle, Branch branch){
		
	}
	
	/**
	 * Gets the type of a Vehicle
	 * @param vehicle
	 * @return type
	 */
	public String get_Vehicle_type(Vehicle vehicle){
		return null;
	}
	/**
	 * Gets the Vehicle Manufacturer
	 * @param vehicle
	 * @return manufacturer
	 */
	public String get_Vehicle_manufacturer(Vehicle vehicle){
		return null;
	}
	
	/**
	 * Gets the Year of the Vehicle
	 * @param vehicle
	 * @return
	 */
	public String get_Vehicle_year(Vehicle vehicle){
		return null;
	}
	
	/**
	 * Gets the Color of the Vehicle
	 * @param vehicle
	 * @return color
	 */
	public String get_Vehicle_color(Vehicle vehicle){
		return null;
	}
	
	/**
	 * Gets the Vehicle Features
	 * @param vehicle
	 * @return vehicle
	 */
	public String get_Vehicle_features(Vehicle vehicle){
		return null;
	}
	
	/**
	 * Get the Vehicle Location
	 * @param vehicle
	 * @return location
	 */
	public String get_Vehicle_location(Vehicle vehicle){
		return null;
	}
	/**
	 * Get the Vehicle capacity
	 * @param vehicle
	 * @return capacity
	 */
	public String get_Vehicle_capacity(Vehicle vehicle){
		return null;
	}
	/**
	 * Get the Vehicle Status
	 * @param vehicle
	 * @return status
	 */
	public String get_Vehicle_status(Vehicle vehicle){
		return null;
	}
	/**
	 * Sets the Type of Vehicle
	 * @param vehicle
	 */
	public void set_Vehicle_type(Vehicle vehicle){
	}
	/**
	 * Sets the Type of manufacturer
	 * @param vehicle
	 */
	public void set_Vehicle_manufacturer(Vehicle vehicle){
	}
	/**
	 * Sets the Type of year
	 * @param vehicle
	 */
	public void set_Vehicle_year(Vehicle vehicle){
	}
	/**
	 * Sets the Type of color
	 * @param vehicle
	 */
	public void set_Vehicle_color(Vehicle vehicle){
	}
	/**
	 * Sets the Type of features
	 * @param vehicle
	 */
	public void set_Vehicle_features(Vehicle vehicle){
	}
	/**
	 * Sets the Type of location
	 * @param vehicle
	 */
	public void set_Vehicle_location(Vehicle vehicle){
	}
	/**
	 * Sets the Capacity of the Vehicle
	 * @param vehicle
	 */
	public void set_Vehicle_capacity(Vehicle vehicle){
	}
	
	/**
	 * Sets the Status of the Vehicle
	 * @param vehicle
	 */
	public void set_Vehicle_status(Vehicle vehicle){
		
	}
	
	/**
	 * A Method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param type
	 * @param capacity
	 * @param features
	 * @return A list of vehicles
	 */
	public Vehicle[] searchForVehicle (String pickupDate, String dropoffDate, String type, int capacity, String features, Vehicle[] list){
		return matched;
		
	}
	
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param type
	 * @param capacity
	 * @return list of vehicles
	 */
	public Vehicle[] search (String pickupDate, String dropoffDate, String type, int capacity, Vehicle[] list){
		return matched;
		
	}
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param capacity
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate, int capacity, Vehicle[] list){
		return matched;
		
	}
	
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param type
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate, String type, Vehicle[] list){
		return matched;
		
		
	}
	/** 
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate, Vehicle[] list){
		return matched;
	}
	
	/**
	 * Picks a vehicle from the list of vehicles that matched the search description
	 * @param matched
	 * @return currentVehicle
	 */
	public Vehicle chosen(Vehicle[] matched){
		return currentVehicle;
	}
		
}