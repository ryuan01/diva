package paymentManagement;

import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

public class paymentManager {

	private double tax = 0.05;
	private int numReceipts = 0;
	private int maxReceipts = 10000;
	private double final_price = 0;
	private Receipt[] list;
	private Receipt currentReceipt;
	
/**
 * A payment Manager that creates and holds a list of receipts. 
 * The payment Manager is responsible for the money flow of the system. 	
 */
	public paymentManager(){
		list = new Receipt[maxReceipts];
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 */
	public Receipt create_new_Receipt(double price, String vehicle_rented, String duration, String dropoff_location){
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
 * Gets all of the Receipts from the Array of Receipts
 * @return list
 */
	public Receipt[] getList() {
		return list;
	}

/**
 * Adds a receipts to the list of receipts
 * @param list
 */
	public void setList(Receipt[] list) {
		this.list = list;
	}

/**
 * Gets the Current Receipt Chosen by a User
 * @return currentReceipt
 */
	public Receipt getCurrentReceipt() {
		return currentReceipt;
	}

/**
 * Sets the Current Receipt Chosen by a User
 * @param currentReceipt
 */
	public void setCurrentReceipt(Receipt currentReceipt) {
		this.currentReceipt = currentReceipt;
	}
	
	/**
	 * Calculates the final price of the transaction
	 * @param vehicleType
	 * @param insurance
	 * @return final_price
	 */
	public double calculate_price(Vehicle vehicleType, Insurance insurance){
		return final_price;
	}
	/**
	 * Calculates the price of a transaction given an Equipment
	 * @param vehicleType
	 * @param insurance
	 * @param equipment
	 * @return final_price
	 */
	public double calculate_price(Vehicle vehicleType, Insurance insurance, Equipment equipment){
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

	
}