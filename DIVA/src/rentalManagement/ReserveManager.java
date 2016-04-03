package rentalManagement;

import java.io.IOException;
import java.util.Date;

import databaseManagement.DatabaseManager;


public class ReserveManager {
	
	
	DatabaseManager dbConnection;
	/**
	 * A Manager for adding, removing, and modifying Reservations and its attributes.
	 */
	public ReserveManager()
	{
		dbConnection = null;
	}
	
	/**
	 * A Manager for adding, removing, and modifying Reservations and its attributes.
	 * @param db The database it's connecting.
	 */
	public ReserveManager(DatabaseManager db)
	{
		dbConnection = db;
	}
	
	/**
	 * Creates a Reservation with a date, vehicle, list of equipments, starting branch, ending branch, customer, employee, status, and reservation ID.
	 * @param startDate Starting Date of the Reservation.
	 * @param endDate Ending Date of the Reservation.
	 * @param vehicleID Vehicle ID of the Reservation.
	 * @param equipIDs Equipment IDs of the Reservation.
	 * @param startBranchID The Branch ID Vehicle is Rented.
	 * @param endBranchID The Branch ID Vehicle is Returned.
	 * @param customerID Customer login ID of the Reservation.
	 * @param employeeID Employee login ID of the Reservation.
	 * @param status Status of the Reservation.
	 */
	public boolean addReservation(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status) 
	{
		//the ID = null right now because we don't know yet
		//we will know the value once the entry is created
		System.out.println("I got to here in ReserveManager");
		Reservation r = new Reservation(startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID,customerID, employeeID, status,-1);
		System.out.println("Reservation object created");
		return dbConnection.createReservationEntry(r);
	}
	
	/**
	 * Removes a Reservation that belongs to Customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public boolean removeReservation(String customerID, String reservID)
	{
		return dbConnection.removeReservationEntry(reservID);
	}
	
	/**
	 * Removes a Reservation belonging to anyone.
	 * Reservations belonging to themselves.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public boolean removeReservation(String reservID)
	{
		return dbConnection.removeReservationEntry(reservID);
	}
	
	/**
	 * Searches for the list of Reservations with all attributes passed.
	 * @param id The type of search executed, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * @return List of qualifying Reservations from the search
	 */
	public Reservation[] searchReservations(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status)
	{
		return dbConnection.searchReservationEntries(startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
				customerID, employeeID, status);
	}
	
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public boolean changeReservation(String reservID, Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status)
	{
		return dbConnection.modifyReservationEntries(reservID, startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
				customerID, employeeID, status);
	}
}