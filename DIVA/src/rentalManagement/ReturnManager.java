package rentalManagement;

import java.math.BigDecimal;
import java.sql.Date;

import databaseManagement.DatabaseManager;
import paymentManagement.paymentManager;



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
	public void startReturn(int reservID, String description, String dmgDescription,BigDecimal extraPay, String typeOfPayment, String accidentDetail)
	{
		if(accidentDetail != "")
		{
			AccidentReport r = new AccidentReport(new Date(System.currentTimeMillis()), description, reservID, dmgDescription, extraPay);
			
			dbConnection.addAccidentReport(r);
			
			paymentManager.makePayment(dbConnection.getReservationAccount(reservID), extraPay, typeOfPayment);
		}
		
		if(checkIfOverdue(reservID))
		{
			paymentManager.makePayment(dbConnection.getReservationAccount(reservID),paymentManager.calculateLateprice(reservID), typeOfPayment);
		}
		
	
		dbConnection.changeReservationStatus(reservID, "archived");
		
	}

	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 */
	public boolean checkIfOverdue(int reservID)
	{
		// if reservation end date is before current date.
		if(dbConnection.getReservationEndDate(reservID).compareTo(new Date(System.currentTimeMillis())) < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
