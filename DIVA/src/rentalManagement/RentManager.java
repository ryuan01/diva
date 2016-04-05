package rentalManagement;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;

class RentManager {
	
	
		DatabaseManager dbConnection;
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		RentManager()
		{
			dbConnection = null;
		}
		
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		RentManager(DatabaseManager db)
		{
			dbConnection = db;
		}
	
		/**
		 * Begins the Rental.
		 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
		 */
		void startRental(int reservID,String description)
		{
			String current_date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			Report report = new Report(current_date, description, reservID,"inspection");
			
			dbConnection.addReport(report);
			
			payForRental(dbConnection.getReservationAccount(reservID),reservID);
			
			dbConnection.changeReservationStatus(reservID, "Rented");
		}

		
		/**
		 * Calls Accounting system to pay for the Rental.
		 * @param reservID Reservation ID of Rental to be paid.
		 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
		 * @pre typeOfPayment == "debit" && typeOfPayment == "credit" && typeOfPayment == "cash" && typeOfPayment == "SRP"
		 */
		void payForRental(Account a, int reservID)
		{
			PaymentManager.makePayment(a, PaymentManager.calculateRentprice(reservID));
		}
}