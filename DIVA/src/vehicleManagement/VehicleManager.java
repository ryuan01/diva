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
	 * @param type
	 * @param manufacturer
	 * @param year
	 * @param color
	 * @param status
	 * @param features
	 * @return list
	 */
	public Vehicle[] add_Vehicle(int location, int capacity, String type, String manufacturer, String year, String color, String status, String features){
		return list;
	
	}
	
	public void set_vehicle_rental_rate(){
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