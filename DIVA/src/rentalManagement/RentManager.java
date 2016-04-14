package rentalManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.Receipt;

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
		 * Pay for rental, add record, produce receipt, decrease amount owning in rental
		 * @param rental_id
		 * @param amount
		 * @throws SQLException 
		 */
		Receipt payForRentalByCard(int reserve_id, BigDecimal amount) throws SQLException {
			// TODO Auto-generated method stub
			Reservation r = dbConnection.searchReservationEntry(reserve_id);
			Receipt receipt = pm.makePaymentByCard(r, amount);
			return receipt;
		}

		/**
		 * Pay for rental by points
		 * @param id
		 * @param points
		 */
		void payForRentalByPoints(int id, int points) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * Pay for rental by other methods
		 * @param id
		 * @param amount
		 */
		void payForRentalByOther(int id, BigDecimal amount) {
			// TODO Auto-generated method stub
			
		}
		
		void changeRentalStatus(int rentalID, boolean status) throws SQLException{
			dbConnection.changeRentalStatus(rentalID, status);
		}
		
		Rental getRental(int rentID) throws SQLException{
			return dbConnection.getRental(rentID);
		}

}