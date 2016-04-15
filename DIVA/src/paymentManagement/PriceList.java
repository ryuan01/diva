package paymentManagement;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

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
	private boolean[] is_set;
	private final static int IS_SET_SIZE = 5; //car, truck equipment, car_insurance, truck_insurance
	private final static String[] CAR_TYPE = new String[]{"economy","compact","midsized","standard","fullsized","premium","SUV","van","luxury"};
	private final static String[] TRUCK_TYPE = new String[]{"24-foot","15-foot","12-foot","box-truck"};	
	private final static String[] EQUIPMENT_TYPE = new String[]{"ski rack","child safety seat","lift gate","car-towing eq"};
	private final static String[] SET_TYPE = new String[]{"car","truck","equipment","car_insurance","truck_insurance"};
	private final static String[] RATE_TYPE_1 = new String[]{"perHour","perDay","perWeek","perMonth","perKM"}; //for vehicle rental
	private final static String[] RATE_TYPE_2 = new String[]{"perHour","perDay","perWeek"}; //for insurance and equipment rental
	/**
	 * Loads value from db to create PriceList
	 * @throws SQLException 
	 */
	public PriceList(){
		price_car = new BigDecimal[CAR_TYPE.length][RATE_TYPE_1.length];
		price_truck = new BigDecimal[TRUCK_TYPE.length][RATE_TYPE_1.length];
		price_equipment = new BigDecimal[EQUIPMENT_TYPE.length][RATE_TYPE_2.length];
		price_car_insurance = new BigDecimal[CAR_TYPE.length][RATE_TYPE_2.length]; 
		price_truck_insurance = new BigDecimal[TRUCK_TYPE.length][RATE_TYPE_2.length];
		is_set = new boolean[IS_SET_SIZE];
	}
	
	public void setCarPrice(BigDecimal[][] prices){
		price_car= prices;
	}
	
	public BigDecimal[] getCarPrice(String type){
		int i = Arrays.asList(CAR_TYPE).indexOf(type);
		return price_car[i];
	}
	
	public void setTruckPrice(BigDecimal[][] prices){
		price_truck= prices;
	}
	
	public BigDecimal[] getTruckPrice(String type){
		int i = Arrays.asList(TRUCK_TYPE).indexOf(type);
		return price_truck[i];
	}
	
	public void setEquipmentPrice(BigDecimal[][] prices){
		price_equipment= prices;
	}
	
	public BigDecimal[] getEquipmentPrice(String type){
		int i = Arrays.asList(EQUIPMENT_TYPE).indexOf(type);
		return price_equipment[i];
	}
	
	public BigDecimal[] getCarInsurancePrice(String type){
		int i = Arrays.asList(CAR_TYPE).indexOf(type);
		return price_car_insurance[i];
	}
	
	public BigDecimal[] getTruckInsurancePrice(String type){
		int i = Arrays.asList(TRUCK_TYPE).indexOf(type);
		return price_truck_insurance[i];
	}
	
	public void setIsSet(String type){
		int i = Arrays.asList(SET_TYPE).indexOf(type);
		is_set[i] = true;
	}
	
	public boolean getIsSet(String type){
		int i = Arrays.asList(SET_TYPE).indexOf(type);
		return is_set[i];
	}
	
	public void print(){
		for (int i = 0; i < price_car.length; i++){
			for (int j = 0; j < price_car[i].length; j++){
				System.out.print(price_car[i][j]+" ");
				
			}
			System.out.println();
		}
	}

	public BigDecimal getExtraChargePrice(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get the type of daily price for a vehicle type
	 * @param vehicle_type
	 * @return
	 */
	public boolean isLowerEndVehicle(String type) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		int i = Arrays.asList(CAR_TYPE).indexOf(type);
		int j = Arrays.asList(TRUCK_TYPE).indexOf(type);
		
		if (i == -1 && j == -1){
			throw new IllegalArgumentException(type+" is not of category car or truck");
		}
		else if (i >=0 && i <= 5){
			return true; //lower end, until premium
		}
		else {
			return false; //higher end
		}
	}

	/**
	 * Get daily price of a vehicle of car or of truck
	 * @param vehicle_type
	 * @return
	 */
	public BigDecimal getDailyPrice(String type) {
		int i = Arrays.asList(CAR_TYPE).indexOf(type);
		int j = Arrays.asList(TRUCK_TYPE).indexOf(type);
		
		if (i == -1 && j == -1){
			throw new IllegalArgumentException(type+" is not of category car or truck");
		}
		else if (i >=0 && j == -1){
			return price_car[i][1];
		}
		else {
			return price_truck[j][1];
		}
	}
}
