package rentalManager;

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
	 * @param r Reservation of Rental the Vehilce belongs to.
	 * @pre Rental for the Reservation has started.
	 * @post Receipt is created, Return is recorded in dataabase, Extra payments are handled.
	 */
	public void startReturn(Reservation r)
	{
		// order of execution:
		checkIfOverdue(r);
		if(checkIfOverdue(r))
		{
			payForExtra(r,TypeOfPayment,ReasonForPayment);
		}
		requestReturnReceipt(r);
		recordReturn(r);
	}
	
	/**
	 * Calls Accounting system to handle extra payment.
	 * @param r Reservation of Rental to be paid.
	 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
	 * @param reasonForPayment Reasons for extra payment, such as accidents, returning late, etc.
	 */
	public void payForExtra(Reservation r, String typeOfPayment, String reasonForPayment)
	{
		
	}
	
	/**
	 * Calls Accounting system to create Return Receipt, include extra payments if any.
	 * @param r Reservation of Rental to create Receipt for.
	 * @pre Extra payment has been made if any.
	 * @post A Receipt is created.
	 */
	public void requestReturnReceipt(Reservation r)
	{
		
	}
	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param r Reservation of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 */
	public boolean checkIfOverdue(Reservation r)
	{
		
	}
	
	/**
	 * Calls Database system to record the Return of Vehicle.
	 * @param r Reservation of Return to be recorded.
	 * @pre Extra payment has been made if any.
	 * @post Return is recorded.
	 */
	public void recordReturn(Reservation r)
	{
		
	}
	
	
}
