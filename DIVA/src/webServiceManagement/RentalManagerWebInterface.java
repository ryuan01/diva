package webServiceManagement;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import rentalManagement.RentalFacade;
import rentalManagement.Reservation;

@WebService
public class RentalManagerWebInterface {
	
	@Resource
	WebServiceContext context;
	
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
	 */
	@WebMethod
	public String createReservation(String startD,String endD, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID) {

		//Set responseString to hold the value returned to the customer
		String responseString;
	
		try {
			//create a RentalManager and create a reservation based on the given parameters
			RentalFacade rm = new RentalFacade();
			rm.createReservation(startD, endD, vehicleID, equipIDs, startBranchID, endBranchID, customerID);
				
			//Set the responseString to success
			responseString = "success";
		} 
		catch (SQLException e) {
			//if an exception is thrown, set the responseString to the appropriate error message	
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
	public String cancelAnyReservation(int reservID){
		
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
	
	/*
	/**
	 * Removes a Reservation that belongs to anyone.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed. 
	 */
	/*
	public String customerCancelsOwnReservation(int reservID){
		
		THIS METHOD IS UNIMPLEMENTED UNTIL THE RENTAL FACADE CHANGES IT's METHOD TO TAKE A USERNAME INSTEAD OF A USERID
		
		//Set responseString to hold the value returned to the caller
		String responseString;
	
		try {
			//Get the customers userName
			String userName = context.getUserPrincipal().getName();
			
			//create a RentalFacade and use it to cancel the reservation with the given ID
			RentalFacade rf = new RentalFacade();
			rf.cancelSelfReservation(reservID, userName);
				
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

	*/
	
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
	 * Searches for the a reservations, on unique ID
	 * @param customerID unique reservation id
	 * @return A list of reservations assosiated with the given customer
	 */
	@WebMethod
	public String[] getReservationByAccountID(int customerID){
		
		//Set responseList to hold a list of values returned to the caller
		String[] responseList;
			
		try {
			//Set reservationList to hold a list of reservation objects
			Reservation[] reservationList;
			
			//create a RentalFacade and use it to search for all reservation for the given accountID
			RentalFacade rf = new RentalFacade();
			reservationList = rf.searchReservationForAccount(customerID);
				
			//Stringify the reservations and store the strings in responseList
			responseList = WebToolkit.toArrayOfStrings(reservationList);
		} 
					
		//if the RentalFacade throws an exception, set responseString to the appropriate error messgae
		catch (NullPointerException e) {
			responseList = new String[] { "Exception = " + e.getMessage() };
		} 
		catch (SQLException e) {
			responseList = new String[] { "Exception = " + e.getMessage() };
		}
						
		//Return responseString
		return responseList;
	}
}
