package paymentManagement;

//so Kevin: distance, daily, hourly, weekly, are just the arrays (or other kind of data structure)
//no need to create extra classes
//same as Car, and Truck: these are just types. so more like a 3D array in my mind.
//if you do this, then I think 1 getter, and 1 setter shoud be enough
public class PriceListCar {

	private double price_Economy;
	private double price_Compact;
	private double price_MidSized;
	private double price_Standard;
	private double price_FullSized;
	private double price_Premium;
	private double price_Luxury;
	private double price_SUV;
	private double price_Van;
	
	/**
	 * A Price List of Cars
	 */
	public PriceListCar(){
		
	}
	
	/**
	 * Gets the price of an Economy Type Car given a rate
	 * @return price_Economy
	 */
	public double getPrice_Economy(String rate) {
		return price_Economy;
	}
	/**
	 * Sets the price of an Economy Type Car given a rate
	 * @param rate
	 * @param price_Economy
	 */
	public void setPrice_Economy(double price_Economy,  String rate) {
		this.price_Economy = price_Economy;
	}
	/**
	 * Gets the price of an Compact Type Car given a rate
	 * @param rate
	 * @return price_Compact
	 */
	public double getPrice_Compact( String rate) {
		return price_Compact;
	}
	/**
	 * Sets the price of an Compact Type Car given a rate
	 * @param rate
	 * @param price_Compact
	 */
	public void setPrice_Compact(double price_Compact,  String rate) {
		this.price_Compact = price_Compact;
	}
	/**
	 * Gets the price of an MidSized Type Car given a rate
	 * @param rate
	 * @return price_MidSized
	 */
	public double getPrice_MidSized( String rate) {
		return price_MidSized;
	}
	/**
	 * Set the price of a MidSized Type Car given a rate
	 * @param rate
	 * @param price_MidSized
	 */
	public void setPrice_MidSized(double price_MidSized,  String rate) {
		this.price_MidSized = price_MidSized;
	}
	/**
	 * Gets the price of an Standard Type Car given a rate
	 * @param rate
	 * @return price_Standard
	 */
	public double getPrice_Standard( String rate) {
		return price_Standard;
	}
/**
 * Sets the price of an Standard Type Car given a rate
 * @param rate
 * @param price_Standard
 */
	public void setPrice_Standard(double price_Standard,  String rate) {
		this.price_Standard = price_Standard;
	}
/**
 * Gets the price of an FullSized Type Car given a rate
 * @param rate
 * @return price_FullSized
 */
	public double getPrice_FullSized( String rate) {
		return price_FullSized;
	}
/**
 * Sets the price of an FullSized Type Car given a rate
 * @param rate
 * @param price_FullSized
 */
	public void setPrice_FullSized(double price_FullSized,  String rate) {
		this.price_FullSized = price_FullSized;
	}
/**
 * Gets the price of an Premium Type Car given a rate
 * @param rate
 * @return price_Premium
 */
	public double getPrice_Premium( String rate) {
		return price_Premium;
	}
/**
 * Sets the price of an Economy Type Car given a rate
 * @param rate
 * @param price_Premium
 */
	public void setPrice_Premium(double price_Premium,  String rate) {
		this.price_Premium = price_Premium;
	}
	/**
	 * Gets the price of an Luxury Type Car given a rate
	 * @param rate
	 * @return price_Luxury
	 */
	public double getPrice_Luxury( String rate) {
		return price_Luxury;
	}
	/**
	 * Sets the price of an Luxury Type Car given a rate
	 * @param rate
	 * @param price_Luxury
	 */
	public void setPrice_Luxury(double price_Luxury,  String rate) {
		this.price_Luxury = price_Luxury;
	}
	/**
	 * Gets the price of an SUV Type Car given a rate
	 * @param rate
	 * @return price_SUV
	 */
	public double getPrice_SUV( String rate) {
		return price_SUV;
	}
/**
 * Sets the price of an SUV Type Car given a rate
 * @param rate
 * @param price_SUV
 */
	public void setPrice_SUV(double price_SUV,  String rate) {
		this.price_SUV = price_SUV;
	}
/**
 * Gets the price of an Van Type Car given a rate
 * @param rate
 * @return price_Van
 */
	public double getPrice_Van( String rate) {
		return price_Van;
	}
	/**
	 * Sets the price of an Van Type Car given a rate
	 * @param rate
	 * @param price_Van
	 */
	public void setPrice_Van(double price_Van,  String rate) {
		this.price_Van = price_Van;
	}
	
}
