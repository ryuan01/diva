package rentalManagement;

import java.io.IOException;
import java.util.Date;

import databaseManagement.DatabaseManager;


public class RentalFacade {

	DatabaseManager db;
	ReserveManager reservMan;
	RentManager rentMan;
	ReturnManager returnMan;
	
	public RentalFacade()
	{
		this.db = DatabaseManager.getInstance();
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
	public boolean createReservation(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status) 
	{
		System.out.println("I got to here in RentalFacade");
		return reservMan.addReservation(startDate,endDate,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID, employeeID,status);
	}
	
	/**
	 * Removes a Reservation that belongs to a customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Customer ID.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public boolean cancelSelfReservation(String customerID, String reservID)
	{
		return reservMan.removeReservation(customerID, reservID);
	}
	
	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public boolean cancelAnyReservation(String reservID)
	{
		return reservMan.removeReservation(reservID);
	}
	
	
	
	/**
	 * Searches for the list of Reservations depending on type of ID passed.
	 * @param id The type of search executed, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * @return List of qualifying Reservations from the search
	 */
	public Reservation[] findReservations(Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status)
	{
		return reservMan.searchReservations(startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
			customerID, employeeID, status);
	}
	
	
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public boolean modReservation(String reservID, Date startDate,Date endDate, String vehicleID, String[] equipIDs, String startBranchID, String endBranchID, 
			String customerID, String employeeID, String status)
	{
		return reservMan.changeReservation(reservID, startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
				customerID, employeeID, status);
	}
	
	/**
	 * Begins the Rental.
	 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
	 */
	public void createRental(String reservID, String descriptionOfInspection, String typeOfPayment)
	{
		rentMan.startRental(reservID, descriptionOfInspection, typeOfPayment);
	}
		
	// assumes gas is already refilled.
		/**
		 * Returns a Vehicle from Rental.
		 * @param reservID Reservation ID of Rental the Vehilce belongs to.
		 */
	public void createReturn(String reservID, String description, String dmgDescription,double extraPay, String typeOfPayment, String accidentDetail)
	{
		returnMan.startReturn(reservID, description, dmgDescription,extraPay, typeOfPayment, accidentDetail);
	}
}
