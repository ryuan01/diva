package vehicleManagerTest;

import java.sql.SQLException;
import java.text.ParseException;

import vehicleManagement.Car;
import vehicleManagement.Equipment;
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
		//test_search_overdue();
		//test_search();
		//test_add_vehicle();
		test_search_equipments();
		//test_add_equipment();
		
	}

	private static void test_add_equipment() {
		// TODO Auto-generated method stub
		try {
			vm.addEquipment(1, "lift gate");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_search_equipments() {
		// TODO Auto-generated method stub
		try {
			Equipment[] e = 
					//vm.searchForEquipments("car", 2, "2016-4-9 14:00:00", "2016-4-10 14:00:00");
					//vm.searchForEquipments("car", 2, "2016-4-14 14:00:00", "2016-4-14 14:00:00");
					vm.searchForEquipments("car",3, "2016-4-19 14:00:00", "2016-4-22 14:00:00");
			for (int i=0; i< e.length; i++){
				System.out.println(e[i].toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_add_vehicle() {
		// TODO Auto-generated method stub
		try {
			//vm.addCar("Chrysler", "2010-01-01", "Sonic", "Blue", "for rent", "photos/economy.jpg", "midsized", 2, "4", true,true,5, 1);
			vm.addTruck("U-haul", "2011", "", "White", "for rent", "photos/24-foot", "24-foot", "8.50", "8.00", "24.00", 3200, 2);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_search() {
		// TODO Auto-generated method stub
		Vehicle[] a;
		try {
//			a = vm.searchForVehicle(1, "2016-4-9 14:00:00", "2016-4-10 14:00:00", "car");
//			for (int i=0; i< a.length; i++){
//				System.out.println(a[i].toString());
//			}
			a = vm.searchForVehicle(3, "2016-4-19 14:00:00", "2016-4-22 14:00:00", "car");
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
			Car[] a = (Car[]) vm.searchForOverdue(2, "car");
			//Truck[] a = (Truck[])vm.searchForOverdue(2, "truck");
			for (int i=0; i< a.length; i++){
				System.out.println(a[i].toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
