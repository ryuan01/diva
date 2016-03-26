package rentalManagement;

public class ReturnManager {

	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	public ReturnManager()
	{
		
	}
	
	// assumes gas is already refilled.
	/**
	 * Returns a Vehicle from Rental.
	 * @param reservID Reservation ID of Rental the Vehilce belongs to.
	 */
	public void startReturn(String reservID)
	{
		// order of execution:
	}
	
	/**
	 * Calls Accounting system to handle extra payment.
	 * @param reservID Reservation ID of Rental to be paid.
	 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
	 * @param reasonForPayment Reasons for extra payment, such as accidents, returning late, etc.
	 */
	public void payForExtra(String reservID, String typeOfPayment, String reasonForPayment)
	{
		
	}
	
	/**
	 * Calls Accounting system to create Return Receipt, include extra payments if any.
	 * @param reservID Reservation ID of Rental to create Receipt for.
	 */
	public void requestReturnReceipt(String reservID)
	{
		
	}
	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 */
	public boolean checkIfOverdue(String reservID)
	{
		return true;
	}
	
	/**
	 * Calls Database system to record the Return of Vehicle.
	 * @param reservID Reservation ID of Return to be recorded.
	 */
	public void recordReturn(String reservID)
	{
		
	}
	
	
}
