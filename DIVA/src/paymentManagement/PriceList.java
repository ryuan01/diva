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
	private BigDecimal[][] price_car;
	private BigDecimal[][] price_truck;
	private BigDecimal[][] price_equipment;
	private BigDecimal[][] price_car_insurance;
	private BigDecimal[][] price_truck_insurance;
	
	/**
	 * Loads value from db to create PriceList
	 * @throws SQLException 
	 */
	public PriceList(){
		
	}
	
	public BigDecimal getPriceCar(String type){
		return db.getPriceRow(type, "car_price");
	}
	
	public BigDecimal getPriceTruck(String type){
		return db.getPriceRow(type, "truck_price");
	}
	
	public BigDecimal getPriceEquipment(String type){
		return db.getPriceRow(type, "equipment_price");
	}
	
	public BigDecimal getPriceCarInsurance(String type){
		return db.getPriceRow(type, "insurance_car_price");
	}
	
	public BigDecimal getPriceTruckInsurance(String type){
		return db.getPriceRow(type, "insurance_truck_price");
	}
	
	
	// Changes price lists
	
	/*
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
	*/
	
	public void print(){
		for (int i = 0; i < price_car.length; i++){
			for (int j = 0; j < price_car[i].length; j++){
				System.out.print(price_car[i][j]+" ");
				
			}
			System.out.println();
		}
	}
}
