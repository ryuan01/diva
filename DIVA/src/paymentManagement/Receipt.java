package paymentManagement;

import java.math.BigDecimal;

/**
 * 
 * A receipt that is provided to the customer after a rental has been made.
 *
 */
public class Receipt {

	private int receiptId;
	private BigDecimal price;
	private String vehicle_rented;
	private String duration;
	private String dropoff_location;
	
	
	/**
	 * Creates a Receipt Object initialized with the following arguments.
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 */
	public Receipt(int receiptId ,BigDecimal price, String vehicle_rented, String duration, String dropoff_location) {
		this.setReceiptId(receiptId);
		this.price = price;
		this.vehicle_rented = vehicle_rented;
		this.duration = duration;
		this.dropoff_location = dropoff_location;
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
	 * Gets the duration of the Rental.
	 * @return duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * Sets the duration of the rental.
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * Get the Drop off Location After Rental has been completed.
	 * @return dropoff_location
	 */
	public String getDropoff_location() {
		return dropoff_location;
	}
	/**
	 * Set the Location to be Dropped off when Rental is completed.
	 * @param dropoff_location
	 */
	public void setDropoff_location(String dropoff_location) {
		this.dropoff_location = dropoff_location;
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
			+	"'vehicle_rented':'"+this.vehicle_rented+"',"+"'duration':'"+this.duration+"','dropoff_location':'"+this.dropoff_location+"'}";
	}	
	
}
