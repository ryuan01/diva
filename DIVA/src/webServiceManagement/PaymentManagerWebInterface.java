package webServiceManagement;

import java.math.BigDecimal;

public class PaymentManagerWebInterface {
	
	
	public static BigDecimal getCarPrice(String carClass, String start_date, String end_date) {
		return null;
		// TODO Auto-generated method stub
	}
	
	public static BigDecimal getTruckPrice(String truckClass, String start_date, String end_date) {
		return null;
		// TODO Auto-generated method stub
	}
	
	public String calculate_price(String reservationID){
		return "false";
	}
	
	//--------------------CALLED ONLY BY EMPLOYEES------------------------
	
	public void makePayment(String customerID, String reservationID) {
		
	}
}