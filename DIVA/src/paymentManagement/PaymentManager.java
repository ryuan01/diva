package paymentManagement;

import java.math.BigDecimal;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.SuperCustomer;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

public class PaymentManager {

	private double tax = 0.05;
	private int numReceipts = 0;
	private int maxReceipts = 10000; // don't need this
	private double final_price = 0;
	
/**
 * A payment Manager that creates and holds a list of receipts. 
 * The payment Manager is responsible for the money flow of the system. 	
 */
	public PaymentManager(){
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 */
	public Receipt create_new_Receipt(BigDecimal price, String vehicle_rented, String duration, String dropoff_location){
		Receipt receipt = new Receipt(numReceipts, price, dropoff_location, dropoff_location, dropoff_location);
		return receipt;
	}
/**
 * Gets the Number of Receipts in the Array.
 * @return
 */
	public int getNumReceipts() {
		return numReceipts;
	}

/**
 * Sets the number of Receipts in the Array
 * @param numReceipts
 */
	public void setNumReceipts(int numReceipts) {
		this.numReceipts = numReceipts;
	}
	
	/**
	 * Calculates the final price of the transaction
	 * @param vehicleType
	 * @param insurance
	 * @return final_price
	 */
	public static BigDecimal calculateCarPrice(String carClass, String start_date, String end_date) {
		return null;
		// TODO Auto-generated method stub
	}
	

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
	 * Calculates the price of a transaction given an Equipment
	 * @param vehicleType
	 * @param insurance
	 * @param equipment
	 * @return final_price
	 */
	public double calculate_price(Vehicle vehicleType, Equipment equipment){
		return final_price;
	}
/**
 * Gets the tax.
 * @return tax
 */
	public double getTax() {
		return tax;
	}
/**
 * Sets the Tax.
 * @param tax
 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * I don't think this should be static 
	 * @param reservID
	 */
public static void makePayment(Account a, BigDecimal price) {
	// TODO Auto-generated method stub
	// should create a receipt for the payment and pass it to interface to show user.
	// should prompt interface to try again if payment fails.
	if(a instanceof SuperCustomer)
	{
		AccountManager.accumulatePoints(a.getID(), PaymentManager.moneyToPoints(price));
	}
}

	public static BigDecimal calculateRentprice(int reservID) {
		// TODO Auto-generated method stub
		return null;
	}


	
}