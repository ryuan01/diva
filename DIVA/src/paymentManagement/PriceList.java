package paymentManagement;

//so Kevin: distance, daily, hourly, weekly, are just the arrays (or other kind of data structure)
//no need to create extra classes
//same as Car, and Truck: these are just types. so more like a 3D array in my mind.
//if you do this, then I think 1 getter, and 1 setter shoud be enough

//let's only have 1 class PriceList...
/**
 * Kevin had the first version, Robin edited this
 * Price of Car, Truck, Equipment
 * @author Kevin,Robin
 *
 */
public class PriceList {

	private static final int PRICE_SIZE = 7;
	private double[] price_Economy;
	private double[] price_Compact;
	private double[] price_MidSized;
	private double[] price_Standard;
	private double[] price_FullSized;
	private double[] price_Premium;
	private double[] price_Luxury;
	private double[] price_SUV;
	private double[] price_Van;
	private double[] equipment_daily;
	
	//there are 7 kinds of rates: dailyRate, weeklyRate, hourlyRate, perKMRate, dailyInsuranceRate,
	//hourlyInsuranceRate, and weeklyInsuranceRate
	
	/**
	 * Loads value from db to create PriceList
	 */
	public PriceList(){
	}
	
	protected double getPrice_Economy(int i) {
		return price_Economy[i];
	}
	protected void setPrice_Economy(double price_Economy, int i) {
		this.price_Economy[i] = price_Economy;
	}
	protected double getPrice_Compact(int i) {
		return price_Compact[i];
	}
	protected void setPrice_Compact(double price_Compact, int i) {
		this.price_Compact[i] = price_Compact;
	}
	protected double getPrice_MidSized(int i) {
		return price_MidSized[i];
	}
	protected void setPrice_MidSized(double price_MidSized, int i) {
		this.price_MidSized[i] = price_MidSized;
	}
	protected double getPrice_Standard(int i) {
		return price_Standard[i];
	}
	protected void setPrice_Standard(double price_Standard, int i) {
		this.price_Standard[i] = price_Standard;
	}
	protected double getPrice_FullSized(int i) {
		return price_FullSized[i];
	}
	protected void setPrice_FullSized(double price_FullSized, int i) {
		this.price_FullSized[i] = price_FullSized;
	}
	protected double getPrice_Premium(int i) {
		return price_Premium[i];
	}
	protected void setPrice_Premium(double price_Premium, int i) {
		this.price_Premium[i] = price_Premium;
	}
	protected double getPrice_Luxury(int i) {
		return price_Luxury[i];
	}
	protected void setPrice_Luxury(double price_Luxury, int i) {
		this.price_Luxury[i] = price_Luxury;
	}
	protected double getPrice_SUV(int i) {
		return price_SUV[i];
	}
	protected void setPrice_SUV(double price_SUV, int i) {
		this.price_SUV[i] = price_SUV;
	}
	protected double getPrice_Van(int i) {
		return price_Van[i];
	}
	protected void setPrice_Van(double price_Van, int i) {
		this.price_Van[i] = price_Van;
	}
	
}
