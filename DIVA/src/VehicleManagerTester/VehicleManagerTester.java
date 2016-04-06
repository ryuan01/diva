package VehicleManagerTester;

import java.sql.SQLException;
import java.text.ParseException;

import vehicleManagement.Vehicle;
import vehicleManagement.VehicleManager;

public class VehicleManagerTester {

	public static void main(String[] args) {
		// TODO Auto-generated met

		VehicleManager vmg = new VehicleManager();
		Vehicle[] vArray =null;
		
		try {
			vArray = 
					//vmg.searchForVehicle(2, "2016-4-6", "2016-4-7", "car");
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7","car");
					//vmg.searchForVehicle(2,"2016-4-5", "2016-4-6","car");
					//vmg.searchForVehicle(2,"2016-4-7", "2016-4-8","car");
			
			
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7", "truck");
					//vmg.searchForVehicle(2,"2016-4-7","2016-4-8", "truck");
					//vmg.searchForVehicle(2,"2016-4-8","2016-4-9" "truck");
					
					//error scenarios
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-4", "truck");
					//vmg.searchForVehicle(2,"2006-5-5","2006-5-7", "airplane");
					vmg.searchForSale(2, "car");
			
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
		}
		
	}

}
