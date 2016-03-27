package databaseManagement;

import paymentManager.Receipt;
import accountManagement.Account;
import rentalManagement.Report;
import rentalManagement.Reservation;

/*Robin */
/**
 * RentalDB deals with creation, deletion, and modification related to rentals
 * @author Robin
 */
public class RentalDB extends DatabaseManager{
	
	
	public RentalDB(String db, String pass) {
		super(db, pass);
		// TODO Auto-generated constructor stub
	}

	//modify 
	/**
	 * reservationQuery returns a reservation related to reservation number
	 * @param rNum reservation number
	 * @pre isValidReservation(rNum)
	 * @post Reservation object
	 * @return Reservation object 
	 */
	public Reservation reservationQuery(int rNum) {
		return null;
	}
	
	/**
	 * isValidReservation checks if reservation number maps to a persistant reservation
	 * @param rNum reservation number
	 * @pre none
	 * @post returns true if it exists, otherwise false
	 */
	public boolean isValidReservation(int rNum) {
		return false;
	}
	
	/**
	 * reservationHistory gets a list of reservations related to an account
	 * @param acc account
	 * @pre isValidAccount(acc)
	 * @post list of reservations
	 * @return list of reservations
	 */
	public Reservation[] reservationHistory(String acc_key_value) {
		return null;
	}
	
	//should be inside Reservation class  
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @param info related information to be updated 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void updateReservation(String r_key_value, String[] info) {
	}
	
	//remove
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void removeReservation(String r_key_value) {
	}
	
	//create 
	/**
	 * 
	 * @param r
	 */
	public void createInspectionReport(Report r){
		
	}
	
	/**
	 * 
	 * @param r
	 */
	public void createReservation(Reservation r){
		
	}
	
	/**
	 * 
	 * @param r
	 */
	public void createAccidentReport(Report r){
		
	}
	
	/**
	 * 
	 * @param r
	 */
	public void createTransaction(Receipt r){
		
	}
	
	

}
