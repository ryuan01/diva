package paymentManagement;

public class Insurance {
	
	private double price_insurance;
	/**
	 * The price list for insurance
	 */
	
	
	public Insurance(){
		
	}
	/**
	 * Gets the price of insurance for given rate of insurance.
	 * @param rate
	 * @return price_insurance
	 */
	
	public double getPrice_insurance(String rate) {
		return price_insurance;
	}
	
	/**
	 * Sets the Price of the insurance for given rate of insurance.
	 * @param rate
	 * @param price_insurance
	 */
	public void setPrice_insurance(double price_insurance, String rate) {
		this.price_insurance = price_insurance;
	}
	
}
