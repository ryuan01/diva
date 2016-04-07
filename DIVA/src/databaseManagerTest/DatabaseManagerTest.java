package databaseManagerTest;
import java.util.*;
import java.sql.SQLException;
import java.text.*;

import databaseManagement.DatabaseManager;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;
/**
 * Unit testing for DatabseManager
 * @author Robin
 *
 */
public class DatabaseManagerTest {

	static DatabaseManager db = DatabaseManager.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//each test will be its own method
		//test_get_branch();
		
		//test searching cars, returns all, returns 2, returns all
		/*test_search("car","2006-5-5","2006-5-7");
		test_search("car","2016-4-5", "2016-4-6");
		test_search("car","2016-4-7", "2016-4-8");
		*/
		
		//test searching trucks, returns all, returns 2, returns all
		//test_search("truck","2006-5-5","2006-5-7");
		/*test_search("truck","2016-4-7","2016-4-8");
		test_search("truck","2016-4-8","2016-4-9");
		*/
		
		//test trying to search for strange things
		//test_search("car","2006-5-5","2006-5-5");
		
		//test assignvehiclebranch
		//test_assign_vehicle_branch();
		
		//test updateVehicleStatus(int v_key_value, String status)
		//test_update_vehicle_status();
		
		//test addCar(Car c) and addTruck(Truck t)
		test_add_vehicle();
		
		//test_get_price_list();
	}

	private static void test_get_price_list() {
		// TODO Auto-generated method stub
		try {
			//db.getCarPriceList();
			//db.getTruckPriceList();
			//db.getCarInsurancePriceList();
			db.getEquipmentPriceList();
			//db.getTruckInsurancePriceList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * test addCar(Car c)
	 */
	private static void test_add_vehicle() {
		// TODO Auto-generated method stub

		//test cars
		//Vehicle v = new Car(-1, "Chevrolet", "2011-1-1", "Spark", "Blue", "for rent", "photos/economy.jpg", "economy", 2, "3/5", true,true, 5);
		
		//test trucks
		Vehicle v = new Truck(-1, "U-Haul", "2010-1-1", "", "White", "aa", "photos/24-foot.jpg", "24-foot", "8.50", "8.00", "24.00",3200);
		
		//error conditions
		//trying to add duplicate entry
		//Vehicle v = new Car(-1, "Chevrolet", "2011-1-1", "Spark", "Blue", "for rent", "photos/economy.jpg", "economy", 2, "3/5", true,true, 5);
		try {
			db.addVehicle(v);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	/**
	 * test updateVehicleStatus(int v_key_value, String status)
	 */
	private static void test_update_vehicle_status() {
		// TODO Auto-generated method stub
		try {
			db.updateVehicleStatus(3, "for sale");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * test updateVehicleLocation(int v_key_value, int b_key_value)
	 */
	private static void test_assign_vehicle_branch() {
		// TODO Auto-generated method stub
		try {
			db.updateVehicleLocation(3, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * test adding branch
	 */
	private static void test_add_branch() {
		// TODO Auto-generated method stub
		/*Branch b = new Branch(-1, "100 Manitoba Street", "Vancouver", "BC", "V5Y2Z6");
		try {
			db.addBranch(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Test db.search();
	 */
	private static void test_search(String type, String start_date, String end_date) {
	      
		Vehicle[] vArray =null;
		try {
			vArray = db.search(2,type,start_date, end_date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i<vArray.length; i++){
			//System.out.println(vArray[i].toString());
			System.out.println(vArray[i].getID());
		}	
	}

	/**
	 * Test db.getBranch();
	 */
/*	private static void test_get_branch() {
		// TODO Auto-generated method stub
		//test getBranch and prints out the result
		Branch[] bArray = db.getBranch();
		String tmp;
		
		for (int i = 0; i<bArray.length; i++){
			tmp = "Branch: "+bArray[i].getStreetName()+" "+bArray[i].getCity() + " ";
			tmp += bArray[i].getProvince()+" "+bArray[i].getZipCode()+" ";
			System.out.println(tmp);
			tmp = null;
		}
		
	}*/

}
