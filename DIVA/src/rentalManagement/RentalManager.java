package rentalManagement;

public class RentalManager {
	
		/**
		 * A Rental Manager that creates, and modifies Rentals.
		 * @pre RentalManager is already created.
		 */
		public RentalManager()
		{
	
		}
	
		/**
		 * Begins the Rental.
		 * @param r Reservation of a Rental to be started, calls Database to record rental.
		 * @pre Contract is already signed.Reservation has valid fields.
		 * @post Payment is made. A Receipt is created. Rental is recorded in database.
		 */
		public void startRental(Reservation r)
		{
			// order of execution:
			//payForRental(r, TypeOfPayment);
			//recordRental(r);
			//requestReceipt(r);
		}
		
		/**
		 * Cancels a Rental pre-emptively.
		 * @param r Reservation of a Rental to be cancelled, calls Database to record rental.
		 * @pre Rental is already started and has not been returned yet, should only be used in emergency, use Return 
		 * for normal Rental closure.
		 * @post Rental cancel is recorded in database.
		 */
		public void cancelRental(Reservation r)
		{
			
		}
		
		/**
		 * Calls Accounting system to pay for the Rental.
		 * @param r Reservation of Rental to be paid.
		 * @param typeOfPayment Debit for debit card, Credit for credit card, Cash for cash, SRP for SuperRent points.
		 * @pre Reservation has valid fields, correct typeOfPayment is entered.
		 */
		public void payForRental(Reservation r, String typeOfPayment)
		{
			
		}
		
		/**
		 * Calls Accounting system to create a receipt for Reservation.
		 * @param r Reservation of Rental to create Receipt for.
		 * @pre Reservation has valid fields, and payment has been made.
		 * @post Receipt is created.
		 */
		public void requestRentalReceipt(Reservation r)
		{
			
		}
		
		/**
		 * Calls Database system to record the Rental details.
		 * @param r Reservation of Rental to record details for.
		 * @pre Reservation has valid fields, payment has been made.
		 * @post Rental is recorded in database.
		 */
		public void recordRental(Reservation r)
		{
			
		}
}