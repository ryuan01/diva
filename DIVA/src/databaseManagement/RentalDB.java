package databaseManagement;

import accountManagement.Account;
import rentalManagement.Reservation;
import vehicleManagement.Car;
import vehicleManagement.Equipment;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/*Robin */
/**
 * RentalDB deals with creation, deletion, and modification related to rentals
 */
public class RentalDB extends DatabaseManager{
	
	
	public RentalDB(String db, String pass) {
		super(db, pass);
		// TODO Auto-generated constructor stub
	}

	//modify 
	/**
	 * reservationQuery returns a reservation related to reservation number
	 * @param rNum reservation number
	 * @pre isValidReservation(rNum)
	 * @post Reservation object
	 * @return Reservation object 
	 */
	public Reservation reservationQuery(int rNum) {
		return null;
	}
	
	/**
	 * isValidReservation checks if reservation number maps to a reservation
	 * @param rNum reservation number
	 * @pre none
	 * @post returns true if it exists, otherwise false
	 */
	public boolean isValidReservation(int rNum) {
		return false;
	}
	
	/**
	 * reservationHistory gets a list of reservations related to an account
	 * @param acc account
	 * @pre isValidAccount(acc)
	 * @post list of reservations
	 * @return list of reservations
	 */
	public Reservation[] reservationHistory(Account acc) {
		return null;
	}
	
	//need to confirm with whoever is doing rental to see the list
	//Do we have a car class yet?
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
	
	/**
	 * searchAdditionalEquipments searches for a list of available equipments for a type
	 * @param t type of equipments
	 * @param branch a branch
	 * @pre a rental is underway
	 * @pre branch is valid
	 * @pre t is valid 
	 * @post list of equipments
	 */
	public Equipment[] searchAdditionalEquipments(String t, String branch) {
		return null;
	}

	//Alex can you propagate this change?
	//Actually I think this whole method should be inside Vehicle class
	/**
	 * getVehicleStatus gets the status of a vehicle
	 * status can be {reserved, rented, sold, damanged, available}
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post vehicle status is returned
	 */
	public String getvehiclestatus(Vehicle v) {
		return null;
	}
	
	//should be inside Reservation class  
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @param info related information to be updated 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void updateReservation(Reservation r, String[] info) {
	}
	
	//remove
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void removeReservation(Reservation r) {
	}
	
	//create 
	//createInspectionReport();
	
	//createReservation();
	
	//createAccidentReport();
	
	//createTransaction();
	
	

}