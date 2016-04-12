package rentalManagement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import databaseManagement.DatabaseManager;


public class RentalFacade {

	ReserveManager reservMan;
	RentManager rentMan;
	ReturnManager returnMan;
	
	public RentalFacade()
	{
		reservMan = new ReserveManager();
		rentMan = new RentManager();
		returnMan = new ReturnManager();
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
			int customerID) throws SQLException 
	{
		//balance need to be calculated
		reservMan.addReservation(startD,endD,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID, new BigDecimal("100"));
	}
	
	/**
	 * Removes a Reservation that belongs to a customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Customer ID.
	 * @param reservID The Reservation ID to be removed.
	 * @throws Exception 
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public void cancelSelfReservation(int customerID, int reservID) throws Exception
	{
		//the case with customer full name and phone number will return a list of available reservations
		//then the customer picks one, and it leads to this function in the end.
		reservMan.removeReservation(customerID, reservID);
	}
	
	/**
	 * Searches for reservations for an account
	 * @param customerID account id
	 * @return reservations under this account
	 * @throws SQLException 
	 */
	public Reservation[] searchReservationForAccount(int customerID) throws SQLException{
		return reservMan.searchReservationForAccount(customerID);
	}

	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @return 
	 * @throws SQLException 
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public void cancelAnyReservation(int reservID) throws SQLException, NullPointerException
	{
		reservMan.removeReservation(reservID);
	}
	
	
	
	/**
	 * Searches for the a reservations, on unique ID
	 * @param id unique reservation id
	 * @return a match
	 * @throws SQLException 
	 */
	public Reservation findReservations(int reservID) throws SQLException
	{
		return reservMan.searchReservation(reservID);
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
	 * @throws SQLException 
	 */
	public void createRental(int clerkID, int reservationID) throws SQLException
	{
		//it is assumed that the start_date and end_date are the same as reservation.
		rentMan.createRental(reservationID, clerkID, false, false);
	}
	
	payForRental;
	/**
	 * Create an inspection report before Rental
	 * @param clerk_id clerk who processed this request
	 * @param date date that the inspection happened
	 * @param description description of certain conditions
	 * @param rentalID which rental is this report connected to
	 * @param milage how far the vehicle has been driving
	 * @param gasLevel gas level between 0 - 100
	 * @throws SQLException 
	 */
	public void createInsectionReportBeforeRental(int clerk_id, String date, String description, int rentalID, int milage, int gasLevel) throws SQLException{
		rentMan.createReport(clerk_id, date, description, rentalID, milage, gasLevel, "before_rental");
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
