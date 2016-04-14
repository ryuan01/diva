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
	
	// assumes gas is already refilled.
	/**
	 * Returns a Vehicle from Rental.
	 * @param reservID Reservation ID of Rental the Vehilce belongs to.
	 * @throws ParseException 
	 */
	void startReturn(int reservID, String description, String dmgDescription,BigDecimal extraPay, String typeOfPayment, String accidentDetail) throws ParseException
	{
		//use-case: return damaged 
		if(accidentDetail != "")
		{
			String current_date = sdf.format(new java.util.Date());
			int milage = 0;
			int gasLevel = 100;
			//fill out report 
			Report r = new Report(current_date, description, reservID,milage, gasLevel, gasLevel, -1);
			
			dbConnection.addReport(r, "after_rental");
			
			PaymentManager.makePayment(dbConnection.getReservationAccount(reservID), extraPay);
		}
		
		//use-case: return over due 
		if(checkIfOverdue(reservID))
		{
			PaymentManager.makePayment(dbConnection.getReservationAccount(reservID),PaymentManager.calculateLateprice(reservID));
		}
		
	
		//use-case: return normally, or after paid extra. 
		//dbConnection.changeReservationStatus(reservID, "complete");
		
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
		BigDecimal newBalance = new BigDecimal("250");
		BigDecimal currentBalance;
		
		
		endDate = dbConnection.getReservationEndDate(rental_id);
		
		// How do you calculate over due?
		//newBalance = paymentManager.getOverduePrice(current_date, endDate);
		currentBalance = dbConnection.getBalance(rental_id).add(newBalance);
		
		dbConnection.addToBalance(rental_id, currentBalance);
		dbConnection.setIs_paid_extra_charge(rental_id, false);
		
		return currentBalance;
		// TODO Auto-generated method stub
		
	}

	boolean checkReturnBranch(int rental_id) {
		// TODO Auto-generated method stub
		return false;
	}

	BigDecimal addWrongReturnBranchExtraCharge(int rental_id) {
		// TODO Auto-generated method stub
		return null;
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
