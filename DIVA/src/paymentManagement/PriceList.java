package paymentManagement;

import java.math.BigDecimal;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;

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

	
	//use BigDeicmal type instead
	
	//really just 3 tables
	// 7 types of rates, 9 types of cars 
	private DatabaseManager db;
	private BigDecimal[][] price_car;
	private BigDecimal[][] price_truck;
	private BigDecimal[][] price_equipment;
	private BigDecimal[][] price_car_insurance;
	private BigDecimal[][] price_truck_insurance;
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
	 * @throws SQLException 
	 */
	public PriceList(DatabaseManager db) throws SQLException{
		this.db = db;
		price_car = db.getCarPriceList();
		//ENUM('24-foot', '15-foot', '12-foot', 'box-truck')
		price_truck = db.getTruckPriceList();
		//ENUM('ski rack', 'child safety seat', 'lift gate', 'car-towing eq')
		price_equipment = db.getEquipmentPriceList();
		price_car_insurance = db.getCarInsurancePriceList();
		price_truck_insurance = db.getTruckInsurancePriceList();
	}
	
	public BigDecimal getPriceCar(int i, int j){
		return price_car[i][j];
	}
	
	public BigDecimal getPriceTruck(int i, int j){
		return price_truck[i][j];
	}
	
	public BigDecimal getPriceEquipment(int i, int j){
		return price_equipment[i][j];
	}
	
	public BigDecimal getPriceCarInsurance(int i, int j){
		return price_car_insurance[i][j];
	}
	
	public BigDecimal getPriceTruckInsurance(int i, int j){
		return price_truck_insurance[i][j];
	}
	
	
	// Changes price lists
	
	
	public void setPriceCar(int i, int j, BigDecimal p){
		price_car[i][j] = p;
	}
	
	public void setPriceTruck(int i, int j, BigDecimal p){
		price_truck[i][j] = p;
	}
	
	public void setPriceEquipment(int i, int j, BigDecimal p){
		price_equipment[i][j] = p;
	}
	
	public void setPriceCarInsurance(int i, int j, BigDecimal p){
		price_car_insurance[i][j] = p;
	}
	
	public void setPriceTruckInsurance(int i, int j, BigDecimal p){
		price_truck_insurance[i][j] = p;
	}
	
	
	// Updates with database
	
	public void updatePriceCar(){
		db.setCarPriceList(price_car);
	}
	
	public void updatePriceTruck(){
		db.setTruckPriceList(price_truck);
	}
	
	public void updatePriceEquipment(){
		db.setEquipmentPriceList(price_equipment);
	}
	
	public void updatePriceCarInsurance(){
		db.setCarInsurancePriceList(price_car_insurance);
	}
	
	public void updatePriceTruckInsurance(){
		db.setTruckInsurancePriceList(price_truck_insurance);
	}
}
