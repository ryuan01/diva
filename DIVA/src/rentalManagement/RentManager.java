package rentalManagement;

import java.sql.SQLException;

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
		 * @throws SQLException 
		 */
		void startRental(int clerkID, int reservID,String description) throws SQLException
		{
			String current_date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			int milage = 0;
			int gasLevel = 100;
			//fill out report
			//Ben you need to separate this.
			Report report = new Report(clerkID, current_date, description, reservID,milage, gasLevel, -1);
			
			dbConnection.addReport(report, "before_rental");
			
			//check if it is paid for before payForRental.
			payForRental(dbConnection.getReservationAccount(reservID),reservID);
			
			//dbConnection.changeReservationStatus(reservID, "Rented");
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