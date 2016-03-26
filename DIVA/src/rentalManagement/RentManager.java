package rentalManagement;

public class RentManager {
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 */
		public RentManager()
		{
	
		}
	
		/**
		 * Begins the Rental.
		 * @param reservID Reservation ID of a Rental to be started, calls Database to record rental.
		 */
		public void startRental(String reservID)
		{
			// order of execution:
			//payForRental(r, TypeOfPayment);
			//recordRental(r);
			//requestReceipt(r);
		}
		
		/**
		 * Cancels a Rental pre-emptively.
		 * @param reservID Reservation ID of a Rental to be cancelled, calls Database to record rental.
		 * @post recordRental().
		 */
		public void cancelRental(String reservID)
		{
			
		}
		
		/**
		 * Calls Accounting system to pay for the Rental.
		 * @param reservID Reservation ID of Rental to be paid.
		 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
		 * @pre typeOfPayment == "debit" && typeOfPayment == "credit" && typeOfPayment == "cash" && typeOfPayment == "SRP"
		 */
		public void payForRental(String reservID, String typeOfPayment)
		{
			
		}
		
		/**
		 * Calls Accounting system to create a receipt for Reservation.
		 * @param reservID Reservation ID of Rental to create Receipt for.
		 * @pre payForRental().
		 * @post new Receipt().
		 */
		public void requestRentalReceipt(String reservID)
		{
			
		}
		
		/**
		 * Calls Database system to record the Rental details.
		 * @param reservID Reservation ID of Rental to record details for.
		 * @pre payForRental().
		 */
		public void recordRental(String reservID)
		{
			
		}
}