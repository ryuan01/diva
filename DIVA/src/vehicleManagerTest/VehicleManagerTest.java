package vehicleManagerTest;

import java.sql.SQLException;
import java.text.ParseException;

import vehicleManagement.Car;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;
import vehicleManagement.VehicleManager;

/**
 * PLEASE DO NOT DELETE TESTER FILES? WHY!
 * @author ROBIN	
 *
 */
public class VehicleManagerTest {

	private static VehicleManager vm = new VehicleManager();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_search_overdue();
		test_search();
	}

	private static void test_search() {
		// TODO Auto-generated method stub
		Vehicle[] a;
		try {
			a = vm.searchForVehicle(2, "2016-4-9", "2016-4-10", "car");
			for (int i=0; i< a.length; i++){
				System.out.println(a[i].toString());
			}
		} catch (IllegalArgumentException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static void test_search_overdue() {
		// TODO Auto-generated method stub
		try {
			//Car[] a = (Car[]) vm.searchForOverdue(2, "car");
			Truck[] a = (Truck[])vm.searchForOverdue(2, "truck");
			for (int i=0; i< a.length; i++){
				System.out.println(a[i].toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
