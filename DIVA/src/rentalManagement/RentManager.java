package rentalManagement;

import java.util.Date;

import systemManagement.Branch;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;
import accountManagement.Account;
import accountManagement.Customer;

// assumes param objects are already constructed, such as Vehicle, list of Equipments, Location, and Date.
public class RentManager {
	
	/**
	 * A Manager that handles all Reserve, Rental, and Return actions.
	 */
	public RentManager()
	{
		
	}
	
	/**
	 * Calls ReserveManager to create a Reservation object with date, vehicle, equipments, startBranch, endBranch, and account.
	 * @param date Date of the Reservation.
	 * @param v Vehicle of the Reservation.
	 * @param equips Equipments of the Reservation.
	 * @param startBranch Branch Vehicle is Rented.
	 * @param endBranch Branch Vehicle is Returned.
	 * @param c Customer of the Reservation.
	 */
	public void createReservation(Date date, Vehicle v, Equipment[] equips, Branch startBranch, Branch endBranch, Customer c)
	{
		
	}
	
	/**
	 * Calls ReserveManager to cancel a Reservation based on Account type.
	 * @param r Reservation to be cancelled.
	 * @param a Account type
	 * @pre Account type is valid and Reservation is valid.
	 * @post Cancellation is recoreded by Database.
	 */
	public void cancelReservation(Account a, Reservation r)
	{
		
	}
	
	// does not deal with illegal params
	/**
	 * Calls ReserveManager to search for Reservations based on parameter passed.
	 * @param o The type of attribute to search for in Reservations.
	 * @return List of matching Reservations
	 * @pre Only valid object types are passed.
	 */
	public Reservation[] searchReservation(Object o)
	{
		return null;
		
	}
	
	/**
	 * Calls ReserveManager to change Reservation details based on parameter passed.
	 * @param o The type of attribute to modify in Reservation.
	 * @param r The Reservation to be modified.
	 * @pre Reservation is valid.
	 */
	public void changeReservationDetail(Object o, Reservation r)
	{
	
	}
	
	/**
	 * Calls ReserveManager to add an Equipment to a Reservation.
	 * @param r Reservation to be modified.
	 * @param e Equipment to be added to a Reservation.
	 * @pre Reservation is valid and Equipment is available.
	 */
	public void addReservationEquipment(Reservation r, Equipment e)
	{
	
	}
	
	/**
	 * Calls ReserveManager to removes an Equipment to a Reservation.
	 * @param r Reservation to be modified.
	 * @param e Equipment to be removed from a Reservation.
	 * @pre Reservation is valid.
	 */
	public void removeReservationEquipment(Reservation r, Equipment e)
	{
	
	}
	
	/**
	 * Calls RentManager to start a Rental.
	 * @param r Reservation to start a Rental from.
	 * @pre Reservation is valid, Customer does not have outstanding fees.
	 * @post A Receipt is created, Rental is recorded in database, Payment has been made.
	 */
	public void createRental(Reservation r) {
	}
	
	/**
	 * Calls ReturnManager to start a Return.
	 * @param r Reservation to start a Return from.
	 * @pre Rental of Reservation has been started.
	 * @post A Receipt is created, Return is recorded in database, Extra payment has been made if any.
	 */
	public void createReturn(Reservation r) {
	}
	
}
