package webServiceManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import paymentManagement.*;

public class PaymentManagerWebInterface {
	
	//Get Rental Price based on all reservation params
	
	//------------------CALLED ONLY BY EMPLOYEES------------------------
	
	//Get full rental price
	
	//payForReservationWithCard(reservationID);
	/**
	 * 
	 * @param reserve_id
	 * @param customer_id
	 * @param balance
	 * @param amount
	 * @return
	 */
	/*
	public String makePaymentByCard(int reserve_id, int customer_id, BigDecimal balance, String amount) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
				
		try {
			//Create an PaymentManager and pay the given amount toward the given reservation
			PaymentManager pm = new PaymentManager();
			Receipt receipt = pm.makePaymentByCardOnFile(reserve_id, customer_id, balance, amount);
					
			//Turn the receipt into a JSON string and store it in responseStringn
			responseString = receipt.toString();
		} 
				
		//If the AccountManager throws an error, set responseString to the appropriate return value
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
				
		//return responseString
		return responseString;
	}
	*/
	
	//payForReservationOutsideSystem(reservationID);
	
	 //makePaymentCash(int reserve_id, int customer_id, BigDecimal balance, String amount)
	
	//payForReservationWithPoints(reservationID);
	
	//makePaymentBySRP(int reserve_id, int customer_id, String vehicle_type, BigDecimal balance,  int points)
	
	//getInsurancePrice(lengthOfRental, type);

}