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

	//really just 3 tables
	// 7 types of rates, 9 types of cars 
	private double[][] price_car;
	private double[][] price_truck;
	private double[][] price_equipment;
	private double[][] price_car_insurance;
	private double[][] price_truck_insurance;
/*	private double[] price_Economy;
	private double[] price_Compact;
	private double[] price_MidSized;
	private double[] price_Standard;
	private double[] price_FullSized;
	private double[] price_Premium;
	private double[] price_Luxury;
	private double[] price_SUV;
	private double[] price_Van;
	
	private double price_TwentyFourFoot;
	private double price_FifteenFoot;
	private double price_TwelveFoot;
	private double price_BoxTruck;
	
*/	
	//there are 7 kinds of rates: dailyRate, weeklyRate, hourlyRate, perKMRate, dailyInsuranceRate,
	//hourlyInsuranceRate, and weeklyInsuranceRate
	
	/**
	 * Loads value from db to create PriceList
	 */
	public PriceList(){
		price_car = new double[7][9];
		//ENUM('24-foot', '15-foot', '12-foot', 'box-truck')
		price_truck = new double[7][4];
		//ENUM('ski rack', 'child safety seat', 'lift gate', 'car-towing eq')
		price_equipment = new double[3][4];
		price_car_insurance = new double[3][9];
		price_truck_insurance = new double[3][4];
	}
	
	public double getPriceCar(int i, int j){
		return price_car[i][j];
	}
	
	public double getPriceTruck(int i, int j){
		return price_truck[i][j];
	}
	
	public double getPriceEquipment(int i, int j){
		return price_equipment[i][j];
	}
	
	public double getPriceCarInsurance(int i, int j){
		return price_car_insurance[i][j];
	}
	
	public double getPriceTruckInsurance(int i, int j){
		return price_truck_insurance[i][j];
	}
	
	public void setPriceCar(int i, int j, double p){
		price_car[i][j] = p;
	}
	
	public void setPriceTruck(int i, int j, double p){
		price_truck[i][j] = p;
	}
	
	public void setPriceEquipment(int i, int j, double p){
		price_equipment[i][j] = p;
	}
	
	public void setPriceCarInsurance(int i, int j, double p){
		price_car_insurance[i][j] = p;
	}
	
	public void setPriceTruckInsurance(int i, int j, double p){
		price_truck_insurance[i][j] = p;
	}
}
