package VehicleManagerTester;

import java.sql.SQLException;
import java.text.ParseException;

import vehicleManagement.Vehicle;
import vehicleManagement.VehicleManager;

public class VehicleManagerTester {

	private static VehicleManager vmg = new VehicleManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated met
		//test_search();
		
		test_add();
		
	}

	private static void test_add() {
		// TODO Auto-generated method stub
			try {
				boolean is_added = 
						//vmg.addCar(-1, "Chevrolet", "2011-01-01", "Spark", "White", "for rent", "photos/economy.jpg","economy", 2, "3/5", true, true, 5);
						vmg.addTruck(-1, "U-Haul", "2011-01-01", "", "White", "aaa", "photos/15-foot", "15-foot", "7.08", "8.00", "15.00", 1150);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
	}

	private static void test_search() {
		// TODO Auto-generated method stub
		Vehicle[] vArray =null;
		
		try {
				vArray = 
						vmg.searchForVehicle(2, "2016-4-6 12:00:00", "2016-4-7 14:00:00", "car");
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7","car");
					//vmg.searchForVehicle(2,"2016-4-5", "2016-4-6","car");
					//vmg.searchForVehicle(2,"2016-4-7", "2016-4-8","car");
			
			
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7", "truck");
					//vmg.searchForVehicle(2,"2016-4-7","2016-4-8", "truck");
					//vmg.searchForVehicle(2,"2016-4-8","2016-4-9" "truck");
					
					//error scenarios
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-4", "truck");
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7", "airplane");
					//vmg.searchForSale(2, "car");
					//vmg.searchForOverdue(2, "car");
			
			for (int i = 0; i<vArray.length; i++){
				System.out.println(vArray[i].toString());
				//System.out.println(vArray[i].getID());
			}	
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
