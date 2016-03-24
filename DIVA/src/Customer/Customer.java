package Customer;

import accountManager.Account;
import vehicleManager.Equipment;
import vehicleManager.Vehicle;

/**
 * 
 * A Customer Account of the Rental Company which allows a customer to 
 * search and reserve vehicles.
 *
 */
public class Customer extends Account{

	/**
	 * Creates a Customer object initialized with the given arguments.
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param password
	 */
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId,
			String password) {
		super(firstname, lastname, phoneNumber, email, loginId, password);
		// TODO Auto-generated constructor stub
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
	public Vehicle[] search (String pickupDate, String dropoffDate, String type, int capacity, String features){
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
	/**
	 * Reserve a vehicle for the set dates
	 * @param pickupDate
	 * @param dropoffDate
	 * @param vehicle
	 */
	public void reserve(String pickupDate, String dropoffDate, Vehicle vehicle){
		
	}
	
	/**
	 * Reserve a vehicle for the set dates with Equipment
	 * @param pickupDate
	 * @param dropoffDate
	 * @param vehicle
	 * @param equipment
	 */
	public void reserve(String pickupDate, String dropoffDate, Vehicle vehicle, Equipment equipment){
		
	}

}
