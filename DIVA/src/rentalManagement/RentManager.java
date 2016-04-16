package rentalManagement;

import java.sql.SQLException;
import databaseManagement.DatabaseManager;

class RentManager {
	
	
		private DatabaseManager dbConnection;
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		RentManager()
		{
			dbConnection = DatabaseManager.getInstance();
		}

		/**
		 * Create rental 
		 * @param reserveID
		 * @param clerkID
		 * @param is_paid_rental
		 * @param is_paid_extra_charge
		 * @throws SQLException
		 */
		void createRental(int reserveID, int clerkID, boolean is_paid_rental) throws SQLException {
			// TODO Auto-generated method stub
			dbConnection.createRental(reserveID,clerkID, is_paid_rental);
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
			Report r = new Report (clerk_id, date, description, rentalID, milage, gasLevel, -1, status);
			dbConnection.addReport(r);
		}
		
		void changeRentalStatusIsPaid(int rentalID, boolean status) throws SQLException{
			dbConnection.changeRentalStatus(rentalID,"is_paid_rental", status);
		}
		
		Rental getRental(int rentID) throws SQLException{
			return dbConnection.getRental(rentID);
		}

}