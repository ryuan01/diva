package paymentManagement;

public class PriceListTruck {


	private double price_TwentyFourFoot;
	private double price_FifteenFoot;
	private double price_TwelveFoot;
	private double price_BoxTruck;

	/**
	 * A Price List of Trucks
	 */
	public PriceListTruck(){
		
	}
	/**
	 * Gets the Price of a 24 Foot truck given a rate
	 * @param rate
	 * @return price_TwentyFourFoot
	 */
	
	public double getPrice_TwentyFourFoot(String rate) {
		return price_TwentyFourFoot;
	}
	
	/**
	 * Sets the Price of a 24 Foot truck  given a rate
	 * @param rate
	 * @param price_TwentyFourFoot
	 */
	public void setPrice_TwentyFourFoot(double price_TwentyFourFoot, String rate) {
		this.price_TwentyFourFoot = price_TwentyFourFoot;
	}
	/**
	 * Gets the Price of a 15 Foot truck given a rate
	 * @param rate
	 * @return price_FifteenFoot
	 */
	public double getPrice_FifteenFoot(String rate) {
		return price_FifteenFoot;
	}
	
	/**
	 * Sets the Price of a 15 Foot truck given a rate
	 * @param rate
	 * @param price_FifteenFoot
	 */
	public void setPrice_FifteenFoot(double price_FifteenFoot, String rate) {
		this.price_FifteenFoot = price_FifteenFoot;
	}
	/**
	 * Gets the Price of a 12 Foot truck given a rate
	 * @param rate
	 * @return price_TwelveFoot
	 */
	public double getPrice_TwelveFoot(String rate) {
		return price_TwelveFoot;
	}
	
	/**
	 * Sets Price of a 12 Foot truck given a rate
	 * @param rate
	 * @param price_TwelveFoot
	 */
	public void setPrice_TwelveFoot(double price_TwelveFoot, String rate) {
		this.price_TwelveFoot = price_TwelveFoot;
	}
	/**
	 * Gets the Price of a Box truck given a rate
	 * @param rate
	 * @return price_BoxTruck
	 */
	public double getPrice_BoxTruck(String rate) {
		return price_BoxTruck;
	}
	/**
	 * Price of a Box truck given a rate
	 * @param rate
	 * @param price_BoxTruck
	 */
	public void setPrice_BoxTruck(double price_BoxTruck, String rate) {
		this.price_BoxTruck = price_BoxTruck;
	}
	
}
