package databaseManagerTest;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import accountManagement.AccountManager;
import accountManagement.Customer;
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
		//test_rental();
		test_add_customer();
	}

	private static void test_add_customer(){
		// TODO Auto-generated method stub
		/*public Customer(String firstname, String lastname, String phoneNumber, 
				String email, String loginId, int id,
				String cc, String expire_date, String name_on_card, String address, 
				String city, String province, String zip, String standing) */
		Customer kevin = new Customer("kevin","ho","7780030000","kevinho@example.ca",
				"kevinho01",-1,"kevinpass", "1234567890123456","2016-5-1","kevin ho","langara street",
				"vancouver", "BC","V3T5A2","Good");
		System.out.println(kevin.toString());
		AccountManager am = new AccountManager();
		try {
			/*public void addCustomerAccount(String firstName, String lastName, String phoneNumber, 
			String emailAddress, String userName, String password, 
			String ccNum, String name_on_cc, String expire_date, String address,
			String city, String province, String zip)*/ 
			am.addCustomerAccount(kevin.getFirstname(), kevin.getLastname(), kevin.getPhoneNumber(), 
					kevin.getEmail(), kevin.getLoginId(),kevin.getPassword(), kevin.getCc_num(),
					kevin.getName_on_card(), kevin.getExpireDate(), kevin.getLocation().getAddress(), kevin.getLocation().getCity(),
					kevin.getLocation().getProvince(), kevin.getLocation().getZipcode());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_rental() {
		// TODO Auto-generated method stub
		//dbm.createRental(reserveID, clerkID, is_paid_rental, is_paid_extra_charge);
		try {
			dbm.createRental(19, 5, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Report r = new Report(4,"2016-4-9", "everything looks good", 19,2000, 100, -1, null);
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
			Reservation r = new Reservation("2016-4-9", "2016-4-10", 1 , eq , 2, 3, 1, -1, new BigDecimal("100.00"), false);
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
