package rentalManagement;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

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
		 * @param amount_paid
		 * @throws SQLException 
		 */
		Receipt payForRentalByCard(int reserve_id, String amount_paid) throws SQLException {
			// TODO Auto-generated method stub
			Reservation r = dbConnection.searchReservationEntry(reserve_id);
			BigDecimal balance = r.getBalance();
			int customer_id = r.getCustomerAccountID();
			Receipt receipt = pm.makePaymentByCard(reserve_id, customer_id, balance, amount_paid);
			return receipt;
		}

		/**
		 * Pay for rental by points
		 * @param id
		 * @param points
		 * @throws Exception 
		 */
		Receipt payForRentalByPoints(int reserve_id, int points) throws Exception{
			Reservation r = dbConnection.searchReservationEntry(reserve_id);
			BigDecimal balance = r.getBalance();
			int customer_id = r.getCustomerAccountID();
			int vehicle_id = r.getVehicleID();
			String vehicle_type = dbConnection.getTypeOfVehicle(vehicle_id);
			return pm.makePaymentBySRP(reserve_id, customer_id, vehicle_type, balance, points);
		}
		/**
		 * Pay for rental by cash
		 * @param id
		 * @param amount
		 * @throws SQLException 
		 */
		Receipt payForRentalByCash(int reserve_id, String amount) throws SQLException {
			Reservation r = dbConnection.searchReservationEntry(reserve_id);
			BigDecimal balance = r.getBalance();
			int customer_id = r.getCustomerAccountID();
			return pm.makePaymentCash(reserve_id, customer_id, balance, amount);
		}
		
		void changeRentalStatus(int rentalID, boolean status) throws SQLException{
			dbConnection.changeRentalStatus(rentalID, status);
		}
		
		Rental getRental(int rentID) throws SQLException{
			return dbConnection.getRental(rentID);
		}

}