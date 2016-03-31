package rentalManagement;

import java.io.IOException;
import java.util.Date;

import databaseManagement.DatabaseManager;


public class RentalFacade {

	DatabaseManager db;
	ReserveManager reservMan;
	RentManager rentMan;
	ReturnManager returnMan;
	
	public RentalFacade(DatabaseManager db)
	{
		this.db = db;
		reservMan = new ReserveManager(db);
		rentMan = new RentManager(db);
		returnMan = new ReturnManager(db);
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
	public void createReservation(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status) 
	{
		System.out.println("I got to here in RentalFacade");
		reservMan.addReservation(startDate,endDate,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID, employeeID,status);
	}
	
	/**
	 * Removes a Reservation depending on Account type the Account ID belongs to, if belongs to employee, it can remove any Reservation, if it belongs to Customer it can only rmeove
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public void cancelReservation(String customerID, String reservID)
	{
		reservMan.removeReservation(customerID, reservID);
	}
	
	
	
	/**
	 * Searches for the list of Reservations depending on type of ID passed.
	 * @param id The type of search executed, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * @return List of qualifying Reservations from the search
	 */
	public Reservation[] findReservations(String id)
	{
		return reservMan.searchReservations(id);
	}
	
	
	/**
	 * Searches Reservations with a start date.
	 * @param d Start date to search with.
	 * @return List of Reservations that a start Date is assigned to.
	 */
	public Reservation[] findStartDate(ReservationDate d)
	{
		return reservMan.searchStartDate(d);
	}
	

	/**
	 * Searches Reservations with a end date.
	 * @param d End date to search with.
	 * @return List of Reservations that a end Date is assigned to.
	 */
	public Reservation[] findEndDate(ReservationDate d)
	{
		return reservMan.searchEndDate(d);
	}
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public void modReservation(String reservID, String id)
	{
		reservMan.changeReservation(reservID, id);
	}
	
	/**
	 * Modifies the starting date of Reservation.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param newDate New Date of Reservation.
	 */
	public void modStartDate(String reservID, ReservationDate newDate)
	{
		reservMan.changeStartDate(reservID, newDate);
	}
	
	/**
	 * Modifies the ending date of Reservation.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param newDate New Date of Reservation.
	 */
	public void modEndDate(String reservID, ReservationDate newDate)
	{
		reservMan.changeEndDate(reservID, newDate);
	}
	
	/**
	 * Begins the Rental.
	 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
	 */
	public void createRental(String reservID, String typeOfPayment)
	{
		rentMan.startRental(reservID, typeOfPayment);
	}
	
	/**
	 * Cancels a Rental pre-emptively.
	 * @param reservID Reservation ID of a Rental to be cancelled, calls Database to record rental.
	 * @post recordRental().
	 */
	public void destroyRental(String reservID)
	{
		rentMan.cancelRental(reservID);
	}
	
	
	// assumes gas is already refilled.
		/**
		 * Returns a Vehicle from Rental.
		 * @param reservID Reservation ID of Rental the Vehilce belongs to.
		 */
	public void createReturn(String reservID, String typeOfPayment, String accidentDetail)
	{
		returnMan.startReturn(reservID, typeOfPayment, accidentDetail);
	}
}
