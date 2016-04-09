package databaseManagerTest;

import java.math.BigDecimal;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;
import rentalManagement.Reservation;

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
		test_create_reservation();
	}

	private static void test_create_reservation() {
		// TODO Auto-generated method stub
		int [] eq = new int[2];
		eq[0] = 1;
		eq[1] = 2;
		//(String startD, String endD, int vehID, int[] e, int startBranch, int endBranch, int cusID, 
		// int id, BigDecimal amount)
		Reservation r = new Reservation("2016-4-9", "2016-4-10", 1 , eq , 2, 3, 1, -1, new BigDecimal("100.00"));
		try {
			dbm.createReservationEntry(r);
			Reservation[] rs = dbm.reservationHistory(1);
			for (int i=0; i< rs.length; i++){
				System.out.println(rs[i].toString());;
			}
			//dbm.removeReservationEntry(r.getID());
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
