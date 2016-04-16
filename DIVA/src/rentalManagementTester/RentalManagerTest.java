package rentalManagementTester;

import java.sql.SQLException;
import java.text.ParseException;

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
		//test_ready_to_leave();
		
		//test_check_overdue();
		test_ready_to_return();
	}

	private static void test_ready_to_return() {
		// TODO Auto-generated method stub
		try {
			//rf.createInsectionReportAfterRental("managernotreally", "2016-4-15", "all are good", 26, 2000, 80);
			//rf.checkReturningBranch(26, 3);
			Receipt r = 
					//rf.payForRentalByCard("jolene", 26, "200.00");
					//rf.payForRentalByPoints("jolene", 26, 1000);
					rf.payForRentalByCash("jolene", 26, "600.00");
			System.out.println(r.toString());
			rf.readyToReturn(26);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_check_overdue() {
		// TODO Auto-generated method stub
		try {
			rf.checkOverDue(26);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			rf.createRental("jolene", 26);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_cash() {
		// TODO Auto-generated method stub
		try {
			Receipt r = rf.payForRentalByCash("jolene", 20, "80.00");
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_points() {
		// TODO Auto-generated method stub
		try {
			Receipt r = 
					//rf.payForRentalByPoints(26, 1500); //throw exception economy car
					rf.payForRentalByPoints("jolene", 26, 1000);
			System.out.println(r.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_card() {
		// TODO Auto-generated method stub
		try {
			Receipt r = rf.payForRentalByCard("jolene", 26, "20.00");
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_rental() {
		// TODO Auto-generated method stub
		//rf.createInsectionReportBeforeRental(clerk_id, date, description, rentalID, milage, gasLevel);
		try {
			rf.createInsectionReportBeforeRental("jolene", "2016-4-13", "Test?", 19, 100, 100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}