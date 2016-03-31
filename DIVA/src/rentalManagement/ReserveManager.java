package rentalManagement;

import java.io.IOException;
import java.sql.Date;
import databaseManagement.*;

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
	 * @param reservID Reservation ID.
	 */
	public void addReservation(ReservationDate startDate,ReservationDate endDate, String vehicleID, String equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status, String reservID) 
	{
		
		dbConnection.createReservationEntry(ReservationDate.toString(startDate), ReservationDate.toString(endDate), vehicleID, equipIDs, startBranchID, endBranchID,customerID, employeeID, status);
	}
	
	/**
	 * Removes a Reservation depending on Account type the Account ID belongs to, if belongs to employee, it can remove any Reservation, if it belongs to Customer it can only rmeove
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public void removeReservation(String customerID, String reservID)
	{
		dbConnection.removeReservationEntry(reservID);
		dbConnection.changeStatus(reservID, "terminated");
	}
	
	
	
	/**
	 * Searches for the list of Reservations depending on type of ID passed.
	 * @param id The type of search executed, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * @return List of qualifying Reservations from the search
	 */
	public Reservation[] searchReservations(String id)
	{
		dbConnection.searchReservationEntries(id);
	}
	
	
	/**
	 * Searches Reservations with a start date.
	 * @param d Start date to search with.
	 * @return List of Reservations that a start Date is assigned to.
	 */
	public Reservation[] searchStartDate(ReservationDate d)
	{
		dbConnection.searchReservationEntries(ReservationDate.toString(d));
	}
	

	/**
	 * Searches Reservations with a end date.
	 * @param d End date to search with.
	 * @return List of Reservations that a end Date is assigned to.
	 */
	public Reservation[] searchEndDate(ReservationDate d)
	{
		dbConnection.searchReservationEntries(ReservationDate.toString(d));
	}
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public void changeReservation(String reservID, String id)
	{
		dbConnection.modifyReservationEntries(reservID, id);
	}
	
	/**
	 * Modifies the starting date of Reservation.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param newDate New Date of Reservation.
	 */
	public void changeStartDate(String reservID, ReservationDate newDate)
	{
		dbConnection.modifyReservationStartDateEntries(reservID, ReservationDate.toString(newDate));
	}
	
	/**
	 * Modifies the ending date of Reservation.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param newDate New Date of Reservation.
	 */
	public void changeEndDate(String reservID, ReservationDate newDate)
	{
		dbConnection.modifyReservationEndDateEntries(reservID, ReservationDate.toString(newDate));
	}
	
	
}