package rentalManagement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import vehicleManagement.Car;


public class RentalFacade {

	private ReserveManager reservMan;
	private RentManager rentMan;
	private ReturnManager returnMan;
	private java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
	
	public RentalFacade()
	{
		reservMan = new ReserveManager();
		rentMan = new RentManager();
		returnMan = new ReturnManager();
	}
	
	//---------------------------reservation related-------------------------------------
	
//	1. search for a vehicle
//	2. returning branch
//	3. search for additional equipments
//	5. calculate price for insurance based on parameters
//	4. calculate price for vehicle + equipments+optional insurance
//	5. create reservation (add boolean insurance)
	
	
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
		//balance need to be re-calculated for security purpose 
		reservMan.addReservation(startD,endD,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID);
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
	
	//---------------------------rental related-------------------------------------	
/*
for when the customer comes in the store to pick up a reservation.
	1. get customer account
	2. get reservation
	3. create inspection report (change in DB to refer to reservation instead) Robin needs to change that
	3. pay for rental 
	4. create rental <-- set is_paid_rental = true
*/
	/**
	 * Begins the Rental.
	 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
	 * @throws SQLException 
	 */
	public void createRental(int clerkID, int reservationID) throws SQLException
	{
		//sammy will implement this properly 
		rentMan.createRental(reservationID, clerkID, true, false);
	}
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
		
	public void payForRental(int rental_id, BigDecimal amount) throws SQLException{
		//not done Robin
		Account account_id = rentMan.getAccountForRental(rental_id);
		rentMan.payForRental(account_id, rental_id, amount);
	}
	
	/**
	 * Checks if the customer is ready to leave to this rented vehicle (if paid in full amount)
	 * @param rental_id
	 * @return
	 */
	public boolean readyToLeaveWithVehicle(int rental_id){
		//not done Sammy
		return rentMan.readyToLeave(rental_id);
	}
	
//---------------------------return related-------------------------------------
/*for when the customer returns a vehicle
0. check for overdue (add to amount owning : property of the rental )
1. check for returning branch (add to amount)
2. create after rental inspection report (milage, gas tank level (liters))
3. create accident report (create an accident report) (add extra amount owning)
3. pay for extra charge () <-- set is_paid_extra_charge = true 
*/
	/**
	 * Checks for overdue, add to owning amount if late
	 * @param rental_id
	 * @return true if there is extra charge, false if there isn't 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public BigDecimal checkOverDue(int rental_id) throws ParseException, SQLException{
		BigDecimal amountOwning = new BigDecimal("0");
		if (returnMan.checkIfOverdue(rental_id)){
			String current_date = df.format(new java.util.Date());
			amountOwning = returnMan.addOverdueExtraCharge(rental_id, current_date);
		}
		return amountOwning;
	}

	/**
	 * Checks for returning branch, add to owning amount if returned to wrong branch
	 * @param rental_id
	 */
	public BigDecimal checkReturningBranch(int rental_id){
		BigDecimal amountOwning = new BigDecimal("0");
		if (returnMan.checkReturnBranch(rental_id)){
			amountOwning = returnMan.addWrongReturnBranchExtraCharge(rental_id);
		}
		return amountOwning;
		
	}
	
	/**
	 * Create inspection report after rental 
	 * @param clerk_id
	 * @param date
	 * @param description
	 * @param rentalID
	 * @param milage
	 * @param gasLevel
	 * @throws SQLException
	 */
	public void createInsectionReportAfterRental (int clerk_id, String date, String description, int rentalID, int milage, int gasLevel) throws SQLException{
		rentMan.createReport(clerk_id, date, description, rentalID, milage, gasLevel, "after_rental");
	}
	
	public void createAccidentReport(int clerkID, String accident_date, String description, int rentalID, String address, 
			String city, String province, String zipcode, String driver, BigDecimal amount){
		returnMan.createAccidentReport(clerkID,accident_date,description,rentalID,address,city,province,zipcode,driver,amount);
	}
	
	public void payForExtraCharge(int rental_id, BigDecimal amount){
		returnMan.payForExtraCharge(rental_id,amount);
	}
	
	/**
	 * Checks if the rental is ready to be archived, customer paid for any possible extra charge
	 * @param rental_id
	 * @return
	 */
	public boolean readyToReturn(int rental_id){
		return returnMan.readyToReturn(rental_id);
	}
}
