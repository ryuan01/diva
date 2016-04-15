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

	BigDecimal addOverdueExtraCharge(int rental_id, String current_date) {
		// dbm --> rentalDB.getReturnDate
		// balance = paymentManager.getOverduePrice(start_date, current_date)
		// dbm --> rentalDB.addToBalance(rental_id, balance)
		// dbm --> rentalDB.setIsPaidExtraCharge(false);
		// return balance
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Check if the branch returned to is not the branch that the customer wishes to return to at time of booking
	 * @param rental_id
	 * @param current_branch_id
	 * @return true if it is, false if they are different
	 * @throws SQLException
	 */
	boolean checkReturnBranch(int rental_id, int current_branch_id) throws SQLException {
		// TODO Auto-generated method stub
		Reservation reservation = dbConnection.searchReservationEntry(rental_id);
		if (reservation.getEndBranchID() == current_branch_id){
			return true;
		}
		return false;
	}

	/**
	 * Add extra charges for a customer who returned to the wrong branch
	 * @param rental_id
	 * @return
	 */
	BigDecimal addWrongReturnBranchExtraCharge(int rental_id) {
		// TODO Auto-generated method stub
		//need to create a table in database to represent extra charges
		//in term of adding insurance
		//in term of wrong branch
		//in term of accident
		//in term of not filled up gas tank
		//in term of extra milage
		//the above should be two array in pricelist as well
		paymentManager.addExtraCharge(rental_id, "wrong_return_branch");
		return paymentManager.getExtraCharge(rental_id, "wrong_return_branch");
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
