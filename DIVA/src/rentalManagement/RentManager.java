package rentalManagement;

import databaseManagement.DatabaseManager;

public class RentManager {
	
	
		DatabaseManager dbConnection;
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		public RentManager()
		{
			
		}
		
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		public RentManager(DatabaseManager db)
		{
			dbConnection = db;
		}
	
		/**
		 * Begins the Rental.
		 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
		 */
		public void startRental(String reservID, String typeOfPayment)
		{
			// order of execution:
			payForRental(reservID, typeOfPayment);
			recordRental(reservID);
			dbConnection.changeStatus(reservID, "Rented");
			requestReceipt(reservID);
		}
		
		/**
		 * Cancels a Rental pre-emptively.
		 * @param reservID Reservation ID of a Rental to be cancelled, calls Database to record rental.
		 * @post recordRental().
		 */
		public void cancelRental(String reservID)
		{
			dbConnection.removeRental(reservID);
			dbConnection.changeStatus(reservID, "Standby");
		}
		
		/**
		 * Calls Accounting system to pay for the Rental.
		 * @param reservID Reservation ID of Rental to be paid.
		 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
		 * @pre typeOfPayment == "debit" && typeOfPayment == "credit" && typeOfPayment == "cash" && typeOfPayment == "SRP"
		 */
		public void payForRental(String reservID, String typeOfPayment)
		{
			paymentManager.makePayment(reservID,typeOfPayment);
		}
		
		/**
		 * Calls Database system to record the Rental details.
		 * @param reservID Reservation ID of Rental to record details for.
		 * @pre payForRental().
		 */
		public void recordRental(String reservID)
		{
			dbConnection.createRental(reservID)
		}
}