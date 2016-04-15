package rentalManagement;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;



class ReturnManager {

	private DatabaseManager dbConnection;
	private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private PaymentManager paymentManager;
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	ReturnManager()
	{
		dbConnection = DatabaseManager.getInstance();
		paymentManager = new PaymentManager();
	}
	
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	ReturnManager(DatabaseManager db)
	{
		dbConnection = db;
	}

	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	boolean checkIfOverdue(int reservID) throws ParseException, SQLException
	{
		// if reservation end date is before current date.
		String current_date = sdf.format(new java.util.Date());
		String due_date = dbConnection.getReservationEndDate(reservID);
		if(sdf.parse(due_date).before(sdf.parse(current_date)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	BigDecimal addOverdueExtraCharge(int rental_id, String current_date) throws SQLException {
		// [x] dbm --> rentalDB.getReturnDate 
		// [] balance = paymentManager.getOverduePrice(start_date, current_date)
		// [x] dbm --> rentalDB.addToBalance(rental_id, balance)
		// [x] dbm --> rentalDB.setIsPaidExtraCharge(false);
		// [x] return balance
		String endDate;
		BigDecimal newBalance = new BigDecimal("0");
		BigDecimal currentBalance;
		
		
		endDate = dbConnection.getReservationEndDate(rental_id);
		
		// How do you calculate over due? (Sammy)
		newBalance = paymentManager.calculateOverduePrice(current_date, endDate);
		currentBalance = dbConnection.getBalance(rental_id).add(newBalance);
		
		dbConnection.addToBalance(rental_id, currentBalance);
		dbConnection.setIs_paid_extra_charge(rental_id, false);
		
		return currentBalance;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Check if the branch returned to is not the branch that the customer wishes to return to at time of booking
	 * @param rental_id
	 * @param current_branch_id
	 * @return true if it is, false if they are different
	 * @throws SQLException
	 */
	boolean checkReturnBranch(int rental_id) throws SQLException {
		// TODO Auto-generated method stub
		return dbConnection.checkReturnBranch(rental_id);
	}

	/**
	 * Add extra charges for a customer who returned to the wrong branch
	 * @param rental_id
	 * @return
	 */
	BigDecimal addWrongReturnBranchExtraCharge(int rental_id) throws SQLException {
		// TODO Auto-generated method stub
		return dbConnection.addWrongReturnBranchExtraCharge(rental_id) ;
	}

	void createAccidentReport(int clerkID, String accident_date, String description, int rentalID,
			String address, String city, String province, String zipcode, String driver, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

	void payForExtraCharge(int rental_id, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

	public boolean readyToReturn(int rental_id) {
		// TODO Auto-generated method stub
		return false;
	}
}
