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
	 * Gets the Price of a 24 Foot truck
	 * @return price_TwentyFourFoot
	 */
	
	public double getPrice_TwentyFourFoot() {
		return price_TwentyFourFoot;
	}
	
	/**
	 * Sets the Price of a 24 Foot truck.
	 * @param price_TwentyFourFoot
	 */
	public void setPrice_TwentyFourFoot(double price_TwentyFourFoot) {
		this.price_TwentyFourFoot = price_TwentyFourFoot;
	}
	/**
	 * Gets the Price of a 15 Foot truck
	 * @return price_FifteenFoot
	 */
	public double getPrice_FifteenFoot() {
		return price_FifteenFoot;
	}
	
	/**
	 * Sets the Price of a 15 Foot truck
	 * @param price_FifteenFoot
	 */
	public void setPrice_FifteenFoot(double price_FifteenFoot) {
		this.price_FifteenFoot = price_FifteenFoot;
	}
	/**
	 * Gets the Price of a 12 Foot truck
	 * @return price_TwelveFoot
	 */
	public double getPrice_TwelveFoot() {
		return price_TwelveFoot;
	}
	
	/**
	 * Sets Price of a 12 Foot truck
	 * @param price_TwelveFoot
	 */
	public void setPrice_TwelveFoot(double price_TwelveFoot) {
		this.price_TwelveFoot = price_TwelveFoot;
	}
	/**
	 * Gets the Price of a Box truck
	 * @return price_BoxTruck
	 */
	public double getPrice_BoxTruck() {
		return price_BoxTruck;
	}
	/**
	 * Price of a Box truck
	 * @param price_BoxTruck
	 */
	public void setPrice_BoxTruck(double price_BoxTruck) {
		this.price_BoxTruck = price_BoxTruck;
	}
	
}
