package webServiceManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import rentalManagement.*;

@WebService
public class RentalManagerWebInterface {
	
	@Resource
	WebServiceContext context;
	
	/**
	 * Creates a Reservation for the calling customer
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
	 * @return a String describing the success of the invocation
	 */
	@WebMethod
	public String customerSelfReservation(String startD,String endD, int vehicleID, 
			int[] equipIDs, int startBranchID, int endBranchID, boolean insurance) throws Exception {

		//Set responseString to hold the value returned to the customer
		String responseString;
	
		try {
			//Get calling customer username
			String customerUserName = context.getUserPrincipal().getName();
			
			//create a RentalManager and create a reservation based on the given parameters
			RentalFacade rm = new RentalFacade();
			rm.createReservation(startD,endD, vehicleID, equipIDs, startBranchID, endBranchID, 
					customerUserName, insurance);
				
			//Set the responseString to success
			responseString = "success";
		} 
		
		//if an exception is thrown, set the responseString to the appropriate error message	
		catch (Exception e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//return responseString
		return responseString;	
	}
	
	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed. 
	 * @throws Exception 
	 */
	public String customerCancelsOwnReservation(int reservID) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
	
		try {
			
			//Get the customers userName
			String userName = context.getUserPrincipal().getName();
			
			//create a RentalFacade and use it to cancel the reservation with the given ID
			RentalFacade rf = new RentalFacade();
			rf.cancelSelfReservation(userName,reservID);
				
			//set responseString to success
			responseString = "success";
		} 
			
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
				
		//Return responseString
		return responseString;
	}
	
	/**
	 * Searches for the a list of reservations associated with the calling customer
	 * @param customerID unique reservation id
	 * @return A list of reservations associated with the given customer
	 */
	@WebMethod
	public String[] getSelfReservations() throws Exception{
		
		//Set responseList to hold a list of values returned to the caller
		String[] responseList;
			
		try {
			//Get the calling customers userName
			String userName = context.getUserPrincipal().getName();
			
			//Set reservationList to hold a list of reservation objects
			Reservation[] reservationList;
			
			//create a RentalFacade and use it to search for all reservation for the calling customer
			RentalFacade rf = new RentalFacade();
			reservationList = rf.searchReservationForAccount(userName);
				
			//Stringify the reservations and store the strings in responseList
			WebToolkit wtk = new WebToolkit();
			responseList = wtk.toArrayOfStrings(reservationList);
		} 
					
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (Exception e) {
			responseList = new String[] { "Exception = " + e.getMessage() };
		} 
						
		//Return responseString
		return responseList;
	}
	
	/**
	 * Creates a Reservation for the customer passed as an argument
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
	 * @return a String describing the success of the invocation
	 */
	@WebMethod
	public String clerkCreatesReservationForCustomer(String startD,String endD, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			String customerUserName, boolean insurance) {

		//Set responseString to hold the value returned to the customer
		String responseString;
	
		try {
			//create a RentalManager and create a reservation based on the given parameters
			RentalFacade rm = new RentalFacade();
			rm.createReservation(startD,endD, vehicleID, equipIDs, startBranchID, endBranchID, 
					customerUserName, insurance);
				
			//Set the responseString to success
			responseString = "success";
		} 
		
		//if an exception is thrown, set the responseString to the appropriate error message	
		catch (Exception e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//return responseString
		return responseString;	
	}

	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed. 
	 */
	@WebMethod
	public String ClerkCancelAnyReservation(int reservID){
		
		//Set responseString to hold the value returned to the caller
		String responseString;
	
		try {
			//create a RentalFacade and use it to cancel the reservation with the given ID
			RentalFacade rf = new RentalFacade();
			rf.cancelAnyReservation(reservID);
				
			//set responseString to success
			responseString = "success";
		} 
			
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (NullPointerException e) {
			responseString = "Exception = " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception = " + e.getMessage();
		}
				
		//Return responseString
		return responseString;
	}
	
	
	/**
	 * Searches for the a reservations, on unique ID
	 * @param id unique reservation id
	 * @return The reservation matching the given ID
	 */
	@WebMethod
	public String getReservationByReservationID(int reservID){
		
		//Set responseString to hold the value returned to the caller
		String responseString;
			
		try {
			//Set reservation to hold a reservation object
			Reservation reservation;
			
			//create a RentalFacade and use it to search for the reservation with the given ID
			RentalFacade rf = new RentalFacade();
			reservation = rf.findReservations(reservID);
				
			//Stringify the reservation and store it in responseString
			responseString = reservation.toString();
		} 
					
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (NullPointerException e) {
			responseString = "Exception = " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception = " + e.getMessage();
		}
						
		//Return responseString
		return responseString;
	}
	
	/**
	 * Searches for the a reservations for the given userName
	 * @param userName - The username of the customer you are trying to get reservations for
	 * @return A list of reservations associated with the given customer
	 */
	@WebMethod
	public String[] getReservationByUserName(String userName){
		
		//Set responseList to hold a list of values returned to the caller
		String[] responseList;
			
		try {
			//Set reservationList to hold a list of reservation objects
			Reservation[] reservationList;
			
			//create a RentalFacade and use it to search for all reservation for the given accountID
			RentalFacade rf = new RentalFacade();
			reservationList = rf.searchReservationForAccount(userName);
				
			//Stringify the reservations and store the strings in responseList
			WebToolkit wtk = new WebToolkit();
			responseList = wtk.toArrayOfStrings(reservationList);
		} 
					
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (Exception e) {
			responseList = new String[] { "Exception = " + e.getMessage() };
		} 
						
		//Return responseString
		return responseList;
	}
	
	/**
	 * Begins a rental based on a reservation
	 * @param reservationID The unique ID for the reservation that is to be started
	 * @return A string describing the success or failure of the invocation 
	 */
	public String createRental(int reservationID) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
					
		try {
		
			//Get the calling employees ID
			String clerkID = context.getUserPrincipal().getName();
					
			//create a RentalFacade and use it to start a rental
			RentalFacade rf = new RentalFacade();
			rf.createRental(clerkID, reservationID);
						
			//Set responseString to success
			responseString = "success";
			
		} 
		
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Create A Pre-Rental Inspection Report" Service
	 * @param date The day the form was created
	 * @param description The value of the report used by the front end to display the report
	 * @param reserveID The ID of the reservation that is associated with this report
	 * @param milage The mileage the vehicle has before the customer leaves the store
	 * @param gasLevel the amount of gas in the vehicle before the customer leaves the store
	 * @return A string describing the success or failure of the invocation
	 */
	public String createInsectionReportBeforeRental(String date, String description, int reserveID, int milage, int gasLevel) {
		//Set responseString to hold the value returned to the caller
		String responseString;
							
		try {
				
			//Get the calling employees ID
			String clerkID = context.getUserPrincipal().getName();
							
			//create a RentalFacade and use it create an inspection report
			RentalFacade rf = new RentalFacade();
			rf.createInsectionReportBeforeRental(clerkID, date, description, reserveID, milage, gasLevel);
								
			//Set responseString to success
			responseString = "success";
					
		}
		
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
				responseString = "Exception = " + e.getMessage();
		}
		
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Create A Post-Rental Inspection Report" Service
	 * @param date The day the form was created
	 * @param description The value of the report used by the front end to display the report
	 * @param reserveID The ID of the reservation that is assosiated with this report
	 * @param milage The mileage the vehicle has before the customer leaves the store
	 * @param gasLevel the amount of gas in the vehicle before the customer leaves the store
	 * @return A string describing the success or failure of the invocation
	 */
	public String createInsectionReportAfterRental(String date, String description, int reserveID, int milage, int gasLevel) {
		//Set responseString to hold the value returned to the caller
		String responseString;
							
		try {
				
			//Get the calling employees ID
			String clerkID = context.getUserPrincipal().getName();
							
			//create a RentalFacade and use it create an inspection report
			RentalFacade rf = new RentalFacade();
			rf.createInsectionReportAfterRental(clerkID, date, description, reserveID, milage, gasLevel);
								
			//Set responseString to success
			responseString = "success";
					
		}
				
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
				responseString = "Exception = " + e.getMessage();
		}
		
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Create An Accident Report" Service
	 * @param clerk_username The username of the clerk who conducted the AccidentReport
	 * @param accident_date	The day the accidentHappend
	 * @param description A value used by the interface to display a visual representation of the damage
	 * @param rentalID The ID of the rental where the accident occurred
	 * @param address Address where the accident happened
	 * @param city The city where the accident happened
	 * @param province the province where the accident happend
	 * @param zipcode the zipcode of the accident location
	 * @param driver The name of the person driving the car
	 * @param amount The amount to be added to the return price
	 * @return
	 */
	public String createAccidentReport(String accident_date, String description, int rentalID, String address, 
			String city, String province, String zipcode, String driver, BigDecimal amount) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
							
		try {
				
			//Get the calling employees ID
			String clerkID = context.getUserPrincipal().getName();
							
			//create a RentalFacade and use it create an AccidentReport
			RentalFacade rf = new RentalFacade();
			rf.createAccidentReport(clerkID, accident_date, description, rentalID, address, city, province, zipcode, driver, amount);
								
			//Set responseString to success
			responseString = "success";
					
		}
				
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
				responseString = "Exception = " + e.getMessage();
		}
		
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Search for a Rental" Service
	 * @return A rental object with the given rentalID
	 */
	public String searchForRental(int rentalID) {
		//Set responseString to hold the value returned to the caller
		String responseString;
									
		try {
			//Create a rentalFacade and search for the rental with the given rentalID
			RentalFacade rf = new RentalFacade();
			Rental rental = rf.searchForRental(rentalID);
			
			//Turn the rental into a JSON stringified Object
			responseString = rental.toString();		
		}
		
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
		
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Check if Customers rental is Overdue" Service
	 * @return The amount that has been added to the return price for the overdue vehicle
	 */
	public String checkOverDue(int rentalID) {
		//Set responseString to hold the value returned to the caller
		String responseString;
									
		try {
			//Create a rentalFacade, check if the given rental is overdue
			//and add the overdue charge to the rental
			RentalFacade rf = new RentalFacade();
			BigDecimal charge = rf.checkOverDue(rentalID);
			
			//Turn the additional charge into a string and store it in responseString
			responseString = charge.setScale(2).toString();	
		}
		
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
		
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web interface for the "Checking If The Customer Returned To The Correct Branch" Service 
	 * @param rentalID The unique ID of the rental object being checked
	 * @param current_branch_id The branch that the vehicle is physically returned to
	 * @return The amount of money that has been added to the return price
	 */
	public String checkReturningBranch(int rentalID, int current_branch_id) {
		//Set responseString to hold the value returned to the caller
		String responseString;
											
		try {
			//Create a rentalFacade, check if the given customer returned the vehicle to the wrong branch 
			RentalFacade rf = new RentalFacade();
			BigDecimal charge = rf.checkReturningBranch(rentalID,current_branch_id);
					
			//Turn the additional charge into a string and store it in responseString
			responseString = charge.setScale(2).toString();
		}
				
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
				
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web interface for the "Checking If the Customer is Ready to Leave" Service
	 * @param rentalID The ID of the rental to be checked and committed to leaving
	*/
	public String readyToLeave(int rentalID) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
											
		try {
			//Create a rentalFacade and check if the given rental is ready for the customre to leave with the vehicle
			RentalFacade rf = new RentalFacade();
			rf.readyToLeave(rentalID);
			
			//Set the responseString to success
			responseString = "success";
			
		}
				
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
				
		//Return responseString
		return responseString;
	}
	
	/**
	 * Web interface for the "Checking If the Customer is Ready to Leave" Service
	 * @param rentalID The ID of the rental to be checked and committed to a return
	*/
	public String readyToReturn(int rentalID) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
											
		try {
			//Create a rentalFacade and check if the given rental is ready to be finalized
			RentalFacade rf = new RentalFacade();
			rf.readyToReturn(rentalID);
			
			//Set the responseString to success
			responseString = "success";
			
		}
				
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch(Exception e) {
			responseString = "Exception = " + e.getMessage();
		}
				
		//Return responseString
		return responseString;
	}
}