package paymentManagement;

import java.math.BigDecimal;

import webServiceManagement.ArrayOfStringsable;

/**
 * 
 * A receipt that is provided to the customer after a rental has been made.
 *
 */
public class Receipt implements ArrayOfStringsable{

	private int receiptId;
	private BigDecimal price;
	private String vehicle_rented;
	private String startDate;
	private String endDate;
	private String pickup_branch;
	private String dropoff_branch;
	
	
	/**
	 * Creates a Receipt Object initialized with the following arguments.
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 */
	public Receipt(int receiptId ,BigDecimal price, String vehicle_rented, String startDate, String endDate, String pickup_branch,String dropoff_branch) {
		this.receiptId = receiptId;
		this.price = price;
		this.vehicle_rented = vehicle_rented;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pickup_branch = pickup_branch;
		this.dropoff_branch = dropoff_branch;
	}

	
	/**
	 *  Gets a Price of the Rental.
	 * @return price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * Sets the Price of the rental.
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * Gets the Price of a rented vehicle.
	 * @return vehicle_rented
	 */
	public String getVehicle_rented() {
		return vehicle_rented;
	}
	/**
	 * Sets the price of a rented Vehicle.
	 * @param vehicle_rented
	 */
	public void setVehicle_rented(String vehicle_rented) {
		this.vehicle_rented = vehicle_rented;
	}

	/**
	 * Gets the Receipt Id of the Receipt.
	 * @return receiptId
	 */
	public int getReceiptId() {
		return receiptId;
	}

	/**
	 * Sets the Receipt Id of the Receipt
	 * @param receiptId
	 */
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	
	public String toString() {
		return "{'receiptId':'"+ this.receiptId +"', 'price':'"+this.price+"',"
			+	"'vehicle_rented':'"+this.vehicle_rented+"',"+"'start_Date':'"+this.startDate+"','end_Date':'"+this.endDate+ "','pickUp_branch':'" + this.pickup_branch
			+"','dropOff_branch':'" + this.dropoff_branch + "'}";
	}	
	
}
