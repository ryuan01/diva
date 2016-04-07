package rentalManagement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

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
	 * @param startD Starting Date of the Reservation.
	 * @param endD Ending Date of the Reservation.
	 * @param vehicleID Vehicle ID of the Reservation.
	 * @param equipIDs Equipment IDs of the Reservation.
	 * @param startBranchID The Branch ID Vehicle is Rented.
	 * @param endBranchID The Branch ID Vehicle is Returned.
	 * @param customerID Customer login ID of the Reservation.
	 * @param employeeID Employee login ID of the Reservation.
	 * @param status Status of the Reservation.
	 * @param reservID Reservation ID.
	 * @throws SQLException 
	 */
	public void createReservation(String startD,String endD, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, String status) throws SQLException 
	{
		reservMan.addReservation(startD,endD,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID,status);
	}
	
	/**
	 * Removes a Reservation that belongs to a customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Customer ID.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public boolean cancelSelfReservation(int customerID, int reservID)
	{
		//the case with customer full name and phone number will return a list of available reservations
		//then the customer picks one, and it leads to this function in the end.
		return reservMan.removeReservation(customerID, reservID);
	}

	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	/*
	 * Robin: why are we letting people do this?
	public boolean cancelAnyReservation(int reservID)
	{
		return reservMan.removeReservation(reservID);
	}
	*/
	
	
	
	/**
	 * Searches for the a reservations, on unique ID
	 * @param id unique reservation id
	 * @return a match
	 * @throws SQLException 
	 */
	public Reservation findReservations(int reservID) throws SQLException
	{
		return reservMan.searchReservations(reservID);
	}
	
	
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	/* Robin: not currently a use-case, maybe added later
	public boolean modReservation(int reservID, String startDate,String endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status)
	{
		return reservMan.changeReservation(reservID, startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
				customerID, employeeID, status);
	}
	*/
	
	/**
	 * Begins the Rental.
	 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
	 */
	public void createRental(int reservID, String descriptionOfInspection)
	{
		//report has a rental field. 
		//type of payment is irrelevant I think
		
		rentMan.startRental(reservID, descriptionOfInspection);
	}
		
	// assumes gas is already refilled.
		/**
		 * Returns a Vehicle from Rental.
		 * @param reservID Reservation ID of Rental the Vehilce belongs to.
		 * @throws ParseException 
		 */
	public void createReturn(int reservID, String description, String dmgDescription,BigDecimal extraPay, String typeOfPayment, String accidentDetail) throws ParseException
	{
		//check for another inspection report/ possibly accident report
		
		returnMan.startReturn(reservID, description, dmgDescription,extraPay, typeOfPayment, accidentDetail);
	}
}
