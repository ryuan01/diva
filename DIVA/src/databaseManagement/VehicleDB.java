package databaseManagement;

import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/* Robin */
/**
 * VehicleDB creates, deletes, and modifies data related to Vehicle. 
 * @author Robin
 *
 */
class VehicleDB {

	/**
	 * Creates a VehicleDBManager
	 * @param db
	 * @param pass
	 */
	public VehicleDB(String db, String pass) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * updateVehicleLocation updates the branch that the vehicle belongs to
	 * @param v vehicle
	 * @param b branch
	 * @pre isValidVehicle(v)
	 * @pre isValidBranch(b)
	 * @post v.branch = b
	 */
	public void updateVehicleLocation(String v_key_value, String b_key_value){
		
	}
	

	/**
	 * updateVehicleStatus updates the status of an vehicle
	 * @param v vehicle
	 * @param status status {reserved, rented, damaged, available, sold}
	 * @pre isValidVehicle(v)
	 * @pre status is one of {reserved, rented, damaged, available, sold}
	 * @post v.status = status
	 */
	public void updateVehicleStatus(String v_key_value, int status){
		
	}
	
	//create
	/**
	 * addVehicle creates an new entry in TABLE VEHICLE
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post a new entry in TABLE VEHICLE
	 */
	public void addVehicle(Vehicle v) {
	}
	//need to confirm with whoever is doing rental to see the list
	/**
	 * searchCars searches a list of cars matching criterias for rental
	 * @param list list has format {startDate,endDate,pickUpBranch,returnBranch,...}
	 * @pre list[i] is valid for all i=0..list.length-1
	 * @post list of cars matching 
	 */
	public Car[] searchCars(String[] list) {
		return null;
	}
	
	/**
	 * searchTruckss searches a list of cars matching criterias for rental 
	 * @param list list has format {startDate,endDate,pickUpBranch,returnBranch,...}
	 * @pre list[i] is valid for all i=0..list.length-1
	 * @post list of trucks matching 
	 */
	public Truck[] searchTrucks(String[] list) {
		return null;
	}
	
	/**
	 * searchCars searches a list of cars in a specific branch for-sale
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of cars matching for sale
	 */	
	public Car[] searchForsaleCars(String branch) {
		return null;
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch for-sale
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of trucks matching for sale 
	 */	
	public Truck[] searchForsaleTrucks(String branch) {
		return null;
	}

	/**
	 * searchCars searches a list of cars in a specific branch overdue
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of cars matching overdue 
	 */	
	public Car[] searchOverdueCars(String branch) {
		return null;
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch overdue
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of trucks matching overdue
	 */	
	public Truck[] searchOverdueTrucks(String branch) {
		return null;
	}	

	//Alex can you propagate this change?
	//Actually I think this whole method should be inside Vehicle class
	//because it is a getter.
	//so getting vehicles by searching them will load a Vehicle object
	//and calling v.status will return status? 
	/**
	 * getVehicleStatus gets the status of a vehicle
	 * status can be {reserved, rented, sold, damanged, available}
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post vehicle status is returned
	 */
	public String getvehiclestatus(String v_key_value) {
		return null;
	}

}
