package rentalManagement;


import java.util.Date;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import paymentManagement.paymentManager;

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
		public void startRental(int reservID,String description)
		{
			// order of execution:
			Report report = new Report(new Date(System.currentTimeMillis()), description, reservID);
			
			dbConnection.addReport(report);
			
			payForRental(dbConnection.getReservationAccount(reservID),reservID, typeOfPayment);
			
			dbConnection.changeReservationStatus(reservID, "Rented");
		}

		
		/**
		 * Calls Accounting system to pay for the Rental.
		 * @param reservID Reservation ID of Rental to be paid.
		 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
		 * @pre typeOfPayment == "debit" && typeOfPayment == "credit" && typeOfPayment == "cash" && typeOfPayment == "SRP"
		 */
		public void payForRental(Account a, int reservID, String typeOfPayment)
		{
			paymentManager.makePayment(a, paymentManager.calculateRentprice(reservID),typeOfPayment);
		}
}