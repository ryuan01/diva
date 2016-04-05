package rentalManagement;

import java.math.BigDecimal;
import java.text.ParseException;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;



class ReturnManager {

	private DatabaseManager dbConnection;
	private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	ReturnManager()
	{
		dbConnection = null;
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
			Report r = new Report(current_date, description, reservID, "accident");
			
			dbConnection.addReport(r);
			
			PaymentManager.makePayment(dbConnection.getReservationAccount(reservID), extraPay);
		}
		
		//use-case: return over due 
		if(checkIfOverdue(reservID))
		{
			PaymentManager.makePayment(dbConnection.getReservationAccount(reservID),PaymentManager.calculateLateprice(reservID));
		}
		
	
		//use-case: return normally, or after paid extra. 
		dbConnection.changeReservationStatus(reservID, "complete");
		
	}

	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 * @throws ParseException 
	 */
	private boolean checkIfOverdue(int reservID) throws ParseException
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
}
