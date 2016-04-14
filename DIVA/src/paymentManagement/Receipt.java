package paymentManagement;

import java.math.BigDecimal;

import webServiceManagement.ArrayOfStringsable;

/**
 * 
 * A receipt that is provided to the customer after a rental has been made.
 * @author Robin
 */
public class Receipt implements ArrayOfStringsable{

	private int receiptId;
	private int customer_id;
	//basic_info contains all the fields with reservation information
	private String basic_info;
	//payment_info contains all the fields with type of payment, how much paid, and change
	private String payment_info;
	
	

	/**
	 *  Creates a Receipt Object initialized with the following arguments.
	 * @param receiptId
	 * @param price_owning
	 * @param amount_paid
	 * @param change
	 * @param paymentmethod {cash, card, or 
	 * @param points
	 * @param point_balance
	 * @param vehicle_rented
	 * @param startDate
	 * @param endDate
	 * @param pickup_branch
	 * @param dropoff_branch
	 */
	public Receipt(int receiptId , int customer_id, String basic_info, String payment_info) {
		this.receiptId = receiptId;
		this.customer_id = customer_id;
		this.basic_info = basic_info;
		this.payment_info = payment_info;
	}
	
	/**
	 * Gets the receipt customer ID
	 * @return customer ID
	 */
	public int getReceiptCustomer(){
		return customer_id;
	}
	
	public void setReceiptCustomer(int customer_id){
		this.customer_id = customer_id;
	}
	
	public String getBasicInfo(){
		return basic_info;
	}
	
	public void setBasicInfo(String basic_info){
		this.basic_info = basic_info;
	}
	
	public String getPaymentInfo(){
		return this.payment_info;
	}
	
	public void setPyamentInfo(String payment_info){
		this.payment_info = payment_info;
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
		return "{'receiptId':'"+ this.receiptId +"', 'customer_id':'"+this.customer_id+"',"
			+	"'basic_info':'"+this.basic_info+"',"+"'payment_info':'"+this.payment_info+"'}";
	}	
	
}
