package vehicleManagement;


import systemManagement.Branch;

/**
 * 
 * A Vehicle Manager which manages the properties and operations of a vehicle. 
 *
 */

public class VehicleManager {
	
	public VehicleManager() {
	
	}
	
	public void set_vehicle_rental_rate(){
	}
	
	public void change_branch(Vehicle vehicle, Branch branch){
	}
	
	
	public String get_Vehicle_type(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_manufacturer(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_year(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_color(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_features(Vehicle vehicle){
		return null;
	}

	public String get_Vehicle_location(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_capacity(Vehicle vehicle){
		return null;
	}
	
	public String get_Vehicle_status(Vehicle vehicle){
		return null;
	}
	
	public void set_Vehicle_type(Vehicle vehicle){
	}
	
	public void set_Vehicle_manufacturer(Vehicle vehicle){
	}
	
	public void set_Vehicle_year(Vehicle vehicle){
	}
	
	public void set_Vehicle_color(Vehicle vehicle){
	}
	
	public void set_Vehicle_features(Vehicle vehicle){
	}
	
	public void set_Vehicle_location(Vehicle vehicle){
	}
	
	public void set_Vehicle_capacity(Vehicle vehicle){
	}
	
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
	public Vehicle[] searchForVehicle (String pickupDate, String dropoffDate, String type, int capacity, String features){
		return null;
		
	}
	
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param type
	 * @param capacity
	 * @return list of vehicles
	 */
	public Vehicle[] search (String pickupDate, String dropoffDate, String type, int capacity){
		return null;
		
	}
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param capacity
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate, int capacity){
		return null;
		
	}
	
	/**
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @param type
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate, String type){
		return null;
		
		
	}
	/** 
	 * An overloaded method which a Customer can search for a vehicle with the given parameters.
	 * @param pickupDate
	 * @param dropoffDate
	 * @return list of vehicles
	 */
	
	public Vehicle[] search (String pickupDate, String dropoffDate){
		return null;
	}
		
}