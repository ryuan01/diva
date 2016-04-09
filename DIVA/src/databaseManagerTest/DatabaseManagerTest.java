package databaseManagerTest;

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
		test_reservation_query(1);
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
