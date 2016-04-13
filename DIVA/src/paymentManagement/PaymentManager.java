package paymentManagement;

import java.math.BigDecimal;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.SuperCustomer;
import databaseManagement.DatabaseManager;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

public class PaymentManager {

	private static BigDecimal tax;
	private static PriceList priceList;
	private static DatabaseManager db;
	
/**
 * A payment Manager that creates and holds a list of receipts. 
 * The payment Manager is responsible for the money flow of the system. 	
 */
	public PaymentManager(){
		tax = new BigDecimal("0.07");
		db = DatabaseManager.getInstance();
		//priceList = new PriceList(db);
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 */
	public Receipt create_new_Receipt(BigDecimal price, String vehicle_rented, String dropoff_location){
		//Receipt receipt = new Receipt(numReceipts, price, dropoff_location, dropoff_location, dropoff_location);
		//return receipt;
		return null;
	}
/**
 * Gets the Number of Receipts in the Array.
 * @return
 */
/*	public int getNumReceipts() {
		return numReceipts;
	}*/

/**
 * Sets the number of Receipts in the Array
 * @param numReceipts
 */
/*	public void setNumReceipts(int numReceipts) {
		this.numReceipts = numReceipts;
	}*/
	
	/**
	 * Calculates the final price of the transaction
	 * @param vehicleType
	 * @param insurance
	 * @return final_price
	 */
	// format of date "yyyy-mm-dd hh:mm:ss"
/*	public static BigDecimal calculateCarPrice(String carClass, String start_date, String end_date) {
		/*switch(carClass){
		case "economy":
			if()break;
		case "compact":
			break;
		case "midSize":
			break;
		case "standard":
			break;
		case "fullSize":
			break;
		case "premium":
			break;
		case "luxury":
			break;
		case "SUV":
			break;
		case "Van":
			break;
		}*/
	

	public static BigDecimal calculateTruckPrice(String truckClass, String start_date, String end_date) {
		return null;
		// TODO Auto-generated method stub
	}
	
	public static BigDecimal calculateLateprice(int reservID){
		return null;
	}
	
	public static int moneyToPoints(BigDecimal money)
	{
		return 0;
	}

	/**
	 * I don't think this should be static 
	 * @param reservID
	 */
	
	//don't want static! 
public void makePayment(Account a, BigDecimal price) {
	// TODO Auto-generated method stub
	// should create a receipt for the payment and pass it to interface to show user.
	// should prompt interface to try again if payment fails.
	if(a instanceof SuperCustomer)
	{
		AccountManager.accumulatePoints(a.getLoginId(), PaymentManager.moneyToPoints(price));
	}
}

	public BigDecimal calculateRentprice(int reservID) {
		// TODO Auto-generated method stub
		return null;
	}


	
}