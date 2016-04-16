package rentalManagement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import databaseManagement.DatabaseManager;
import paymentManagement.Receipt;


public class RentalFacade {

	private ReserveManager reservMan;
	private RentManager rentMan;
	private ReturnManager returnMan;
	private DatabaseManager dbm;
	private java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
	
	public RentalFacade()
	{
		reservMan = new ReserveManager();
		rentMan = new RentManager();
		returnMan = new ReturnManager();
		dbm = DatabaseManager.getInstance();
	}
	
	//---------------------------reservation related-------------------------------------
	
//	1. search for a vehicle
//	2. returning branch
//	3. search for additional equipments
//	5. done: calculate price for insurance based on parameters
//	4. done: calculate price for vehicle + equipments+optional insurance
//	5. done: create reservation (add boolean insurance) 
	
	
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
	 * @throws Exception 
	 */
	public void createReservation(String startD,String endD, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			String customer_username, boolean insurance) throws Exception 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		
		if (sdf.parse(startD).after(sdf.parse(endD))){
			throw new IllegalArgumentException("Start Date cannot be before end date");
		}
		//balance need to be re-calculated for security purpose 
		int customerID = dbm.getIdFromUsername(customer_username);
		reservMan.addReservation(startD,endD,vehicleID,equipIDs,startBranchID, endBranchID, 
				customerID, insurance);
	}
	
	/**
	 * Removes a Reservation that belongs to a customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Customer ID.
	 * @param reservID The Reservation ID to be removed.
	 * @throws Exception 
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	public void cancelSelfReservation(String username, int reservID) throws Exception
	{
		//the case with customer full name and phone number will return a list of available reservations
		//then the customer picks one, and it leads to this function in the end.
		int customer_id = dbm.getIdFromUsername(username);
		reservMan.removeReservation(customer_id, reservID);
	}
	
	/**
	 * Searches for reservations for an account
	 * @param customerID account id
	 * @return reservations under this account
	 * @throws Exception 
	 */
	public Reservation[] searchReservationForAccount(String customer_username) throws Exception{
		int customerID = dbm.getIdFromUsername(customer_username);		
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
	 * @throws Exception 
	 */
	public void createRental(String clerk_username, int reservationID) throws Exception
	{
		/*
		 * 1. check if the rental is paid (balance = 0)
		 * 		1.2 DatabaseManager.checkReservationBalance(reservationID)
		 *  	1.2 if true, rentMan.createRental(reservationID, clerkID, true, false);
		 *  	1.4 if false, rentMan.createRental(reservationID, clerkID, false, false);
		 *  		---> two more methods to
		 *  				DatabaseManager.searchFoRental(rentalID)
		 *  				DatabaseManager.changeRentalStatus(rentalID, boolean isPaid)
		 */
		int clerkID = dbm.getIdFromUsername(clerk_username);
		BigDecimal balance;
		
		System.out.println("I am in RentalFacade");
		balance = dbm.getBalance(reservationID);
		
		if (balance.compareTo(new BigDecimal(0)) == 0){
			// are equal
			rentMan.createRental(reservationID, clerkID, true);
		} else{
			// not equal
			rentMan.createRental(reservationID, clerkID, false);
		}
		

		//it is assumed that the start_date and end_date are the same as reservation.
		
	}
	/**
	 * Create an inspection report before Rental
	 * @param clerk_id clerk who processed this request
	 * @param date date that the inspection happened
	 * @param description description of certain conditions
	 * @param rentalID which rental is this report connected to
	 * @param milage how far the vehicle has been driving
	 * @param gasLevel gas level between 0 - 100
	 * @throws Exception 
	 */
	public void createInsectionReportBeforeRental(String clerk_username, String date, String description, int reserveID, int milage, int gasLevel) throws Exception{
		int clerk_id = dbm.getIdFromUsername(clerk_username);	
		rentMan.createReport(clerk_id, date, description, reserveID, milage, gasLevel, "before_rental");
	}
	
	public void changeRentalStatusIsPaid(int rentalID, boolean status) throws SQLException{
		rentMan.changeRentalStatusIsPaid(rentalID, status);
	}
	
	public Rental searchForRental(int rentID) throws SQLException{
		// call RentManager.searchForRental --> DatabaseManager --> RentalDB
		return rentMan.getRental(rentID);
	}
	
	/**
	 * Checks if the balance is 0
	 * @param rentID
	 * @throws Exception when customer tries to leave without car
	 */
	public void readyToLeave(int rentID) throws Exception{
		//todo
		//if the balance is 0, then set is_paid_rental to true and let someone leave, return true
		//else return false		
		BigDecimal balance = dbm.getBalance(rentID);
		boolean is_paid = balance.compareTo(new BigDecimal(0)) == 0;
		boolean has_before_rental_inspection_report = dbm.hasInspectionReport(rentID, "before_rental");
		if (!is_paid){
			throw new Exception("Please pay first before leaving with a vehicle");
		}
		if (!has_before_rental_inspection_report){
			throw new Exception("Please file an inspection report before leaving with a vehicle");
		}
		//now we have both set
		rentMan.changeRentalStatusIsPaid(rentID, true);
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
			// everything works, except this method
			amountOwning = returnMan.addOverdueExtraCharge(rental_id, current_date);
		}
		return amountOwning;
	}

	/**
	 * Checks for returning branch, add to owning amount if returned to wrong branch
	 * @param rental_id
	 * @throws SQLException 
	 */
	public BigDecimal checkReturningBranch(int rental_id, int current_branch_id) throws SQLException{
		BigDecimal amountOwning = new BigDecimal("0");
		
		if (returnMan.checkReturnBranch(rental_id, current_branch_id)){
			System.out.println("wrong branch in facade" );
			amountOwning = returnMan.addWrongReturnBranchExtraCharge(rental_id,current_branch_id);
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
	 * @throws Exception 
	 */
	public void createInsectionReportAfterRental (String clerk_username, String date, String description, int rentalID, int milage, int gasLevel) throws Exception{
		int clerk_id = dbm.getIdFromUsername(clerk_username);	
		rentMan.createReport(clerk_id, date, description, rentalID, milage, gasLevel, "after_rental");
	}
	
	public void createAccidentReport(String clerk_username, String accident_date, String description, int rentalID, String address, 
			String city, String province, String zipcode, String driver, BigDecimal amount) throws Exception{
		//todo
		int clerk_id = dbm.getIdFromUsername(clerk_username);	
		returnMan.createAccidentReport(clerk_id,accident_date,description,rentalID,address,city,province,zipcode,driver,amount);
	}
	
	/**
	 * Checks if the rental is ready to be archived, customer paid for any possible extra charge
	 * @param rental_id
	 * @return
	 * @throws Exception 
	 */
	public void readyToReturn(int rental_id) throws Exception{
		//CHECK for all kinds of extra charges situations
		//if the balance is 0, then set is_paid_rental to true and let someone leave, return true
		//else return false		
		BigDecimal balance = dbm.getBalance(rental_id);
		boolean is_paid = (balance.compareTo(new BigDecimal(0)) == 0);
		boolean has_after_rental_inspection_report = dbm.hasInspectionReport(rental_id, "after_rental");
		Rental rental = dbm.getRental(rental_id);
		if (!has_after_rental_inspection_report){
			throw new Exception("Please file an after inspection report before returning a vehicle");
		}
		if (!rental.getIsCheckOverdue()){
			throw new Exception("Please check if the vehicle is overdue before returning a vehicle");
		}
		if (!rental.getIsCheckReturnBranch()){
			throw new Exception("Please check if the customer returned to the correct branch before returning a vehicle");
		}
		if (!is_paid){
			throw new Exception("Please pay the extra charges first before returning a vehicle");
		}
		//now we have extra charge set and paid
		//accident report is optional
		returnMan.changeRentalStatusExtraCharge(rental_id, true);
	}
}
