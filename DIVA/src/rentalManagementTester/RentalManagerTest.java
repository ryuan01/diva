package rentalManagementTester;

import java.sql.SQLException;

import paymentManagement.Receipt;
import rentalManagement.RentalFacade;

public class RentalManagerTest {
	
	private static RentalFacade rf = new RentalFacade();
	
	public static void main(String[] args){
		//test_rental();
		//test_pay_for_rental_card();
		//test_pay_for_rental_points();
		//test_pay_for_rental_cash();
		//test_make_rental();
		test_ready_to_leave();
	}

	private static void test_ready_to_leave() {
		// TODO Auto-generated method stub
		try {
			rf.readyToLeave(26);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_make_rental() {
		// TODO Auto-generated method stub
		try {
			rf.createRental(5, 26);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_cash() {
		// TODO Auto-generated method stub
		try {
			Receipt r = rf.payForRentalByCash(4, 20, "80.00");
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_points() {
		// TODO Auto-generated method stub
		try {
			Receipt r = 
					//rf.payForRentalByPoints(26, 1500); //throw exception economy car
					rf.payForRentalByPoints(4, 26, 1000);
			System.out.println(r.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_card() {
		// TODO Auto-generated method stub
		try {
			Receipt r = rf.payForRentalByCard(4, 26, "20.00");
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_rental() {
		// TODO Auto-generated method stub
		//rf.createInsectionReportBeforeRental(clerk_id, date, description, rentalID, milage, gasLevel);
		try {
			rf.createInsectionReportBeforeRental(5, "2016-4-13", "Test?", 19, 100, 100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}