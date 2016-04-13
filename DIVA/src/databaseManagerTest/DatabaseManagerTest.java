package databaseManagerTest;

import java.math.BigDecimal;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;
import rentalManagement.AccidentReport;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Vehicle;

/**
 * Unit test for databasemanager class
 * @author Robin
 *
 */
public class DatabaseManagerTest {

	private static DatabaseManager dbm = DatabaseManager.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test_reservation_query(4);
		//test_create_reservation();
		//test_report();
		//test_branch();
		//test_get_reservation_vehicle();
		//test_get_branch();
		test_rental();
	}

	private static void test_rental() {
		// TODO Auto-generated method stub
		
	}

	private static void test_get_branch() {
		// TODO Auto-generated method stub
		Branch b = null;
		try {
			b = dbm.getBranchEntry(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.toString());
	}

	private static void test_get_reservation_vehicle() {
		// TODO Auto-generated method stub
		try {
			Vehicle v = 
					//dbm.getReservationVehicle(1);
					dbm.getReservationVehicle(20);
			System.out.println(v.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_branch() {
		// TODO Auto-generated method stub
		Branch b = new Branch(-1, " 100 Manitoba Street", "Vancouver", "BC", "V4TZ7T");
		System.out.println(b.toString());
		try {
			dbm.createBranchEntry(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_report() {
		// TODO Auto-generated method stub
		//int clerk_id, String d, String description, int reservID, int milage, int gasLevel
		Report r = new Report(4,"2016-4-9", "everything looks good", 19,2000, 100, -1);
		//(int clerkID, String accident_date, String description, int rentalID, String address, 
		//String city, String province, String zipcode, String driver, BigDecimal amount, int r_num)
		AccidentReport ra = new AccidentReport(4,"2016-4-9","Car crashed", 1, "6507 Main St" , 
				"Vancouver", "BC", "V5X3H1", "Sammy", new BigDecimal("1000.00"), -1);
		try {
			
			//dbm.addReport(r, "before_rental");
			dbm.addAccidentReport(ra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_create_reservation() {
		// TODO Auto-generated method stub
		int [] eq = new int[2];
		eq[0] = 1;
		eq[1] = 2;
		//(String startD, String endD, int vehID, int[] e, int startBranch, int endBranch, int cusID, 
		// int id, BigDecimal amount)
		try {
			Reservation r = new Reservation("2016-4-9", "2016-4-10", 1 , eq , 2, 3, 1, -1, new BigDecimal("100.00"));
			dbm.createReservationEntry(r);
			Reservation[] rs = dbm.reservationHistory(1);
			for (int i=0; i< rs.length; i++){
				System.out.println(rs[i].toString());;
			}
			//dbm.removeReservationEntry(16);
			//dbm.searchReservationEntry(17);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_reservation_query(int reservationID) {
		// TODO Auto-generated method stub
		Reservation r;
		try {
			r = dbm.searchReservationEntry(reservationID);
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
