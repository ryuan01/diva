package rentalManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;

class RentManager {
	
	
		private DatabaseManager dbConnection;
		private PaymentManager pm; 
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		RentManager()
		{
			dbConnection = DatabaseManager.getInstance();
			pm = new PaymentManager();
		}

		/**
		 * Create rental 
		 * @param reserveID
		 * @param clerkID
		 * @param is_paid_rental
		 * @param is_paid_extra_charge
		 * @throws SQLException
		 */
		void createRental(int reserveID, int clerkID, boolean is_paid_rental, boolean is_paid_extra_charge) throws SQLException {
			// TODO Auto-generated method stub
			dbConnection.createRental(reserveID,clerkID, is_paid_rental, is_paid_extra_charge);
		}

		/**
		 * Create an rental report
		 * @param clerk_id
		 * @param date
		 * @param description
		 * @param rentalID
		 * @param milage
		 * @param gasLevel
		 * @param status ENUM('before_rental','after_rental')
		 * @throws SQLException
		 */
		void createReport(int clerk_id, String date, String description, int rentalID, int milage, int gasLevel,
				String status) throws SQLException {
			// TODO Auto-generated method stub
			Report r = new Report (clerk_id, date, description, rentalID, milage, gasLevel, -1);
			dbConnection.addReport(r, status);
		}

		/**
		 * Get account related to this rental_id
		 * @param rental_id
		 * @return
		 * @throws SQLException 
		 */
		Account getAccountForRental(int rental_id) throws SQLException {
			// TODO Auto-generated method stub
			Account account_id = dbConnection.getReservationAccount(rental_id);
			return account_id;
		}
		
		/**
		 * Pay for rental, add record, produce receipt, decrease amount owning in rental
		 * @param account_id
		 * @param rental_id
		 * @param amount
		 */
		void payForRental(Account account_id, int rental_id, BigDecimal amount) {
			// TODO Auto-generated method stub
			pm.makePayment(account_id, pm.calculateRentprice(rental_id), amount);
		}

		/**
		 * 
		 * @param rental_id
		 * @return 
		 */
		boolean readyToLeave(int rental_id) {
			return false;
			// TODO Auto-generated method stub
			
		}
}