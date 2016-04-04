package rentalManagement;

import java.math.BigDecimal;
import java.sql.Date;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;



class ReturnManager {

	
	
	DatabaseManager dbConnection;
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
	 */
	void startReturn(int reservID, String description, String dmgDescription,BigDecimal extraPay, String typeOfPayment, String accidentDetail)
	{
		//use-case: return damaged 
		if(accidentDetail != "")
		{
			Report r = new Report(new Date(System.currentTimeMillis()), description, reservID, "accident");
			
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
	 */
	private boolean checkIfOverdue(int reservID)
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
