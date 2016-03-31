package rentalManagement;

import java.sql.Date;

import databaseManagement.DatabaseManager;



public class ReturnManager {

	
	
	DatabaseManager dbConnection;
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	public ReturnManager()
	{
		
	}
	
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	public ReturnManager(DatabaseManager db)
	{
		dbConnection = db;
	}
	
	// assumes gas is already refilled.
	/**
	 * Returns a Vehicle from Rental.
	 * @param reservID Reservation ID of Rental the Vehilce belongs to.
	 */
	public void startReturn(String reservID, String typeOfPayment, String accidentDetail)
	{
		if(accidentDetail != "")
		{
			payForExtra(reservID,typeOfPayment);
			makeAccidentReport(reservID, accidentDetail);
		}
		
		if(checkIfOverdue(reservID))
		{
			payForExtra(reservID,typeOfPayment);
		}
		
		recordReturn(reservID);
		
	}
	
	/**
	 * Calls Accounting system to handle extra payment.
	 * @param reservID Reservation ID of Rental to be paid.
	 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
	 * @param reasonForPayment Reasons for extra payment, such as accidents, returning late, etc.
	 */
	public void payForExtra(String reservID, String typeOfPayment)
	{
		dbConnection.makePayment(reservID, typeOfPayment);
	}
	
	public void makeAccidentReport(String reservID, String accidentDetail)
	{
		//AccidentReport(Date d, String description, String reservID,String dmgDes, double extraPay);
	}
	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 */
	public boolean checkIfOverdue(String reservID)
	{
		// checks if reservation date is before current date.
		return false;
	}
	
	/**
	 * Calls Database system to record the Return of Vehicle.
	 * @param reservID Reservation ID of Return to be recorded.
	 */
	public void recordReturn(String reservID)
	{
		dbConnection.createReturn(reservID);
		dbConnection.changeStatus(reservID, "Returned");
	}
	
	
}
