package rentalManagementTester;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import paymentManagement.PaymentManager;
import paymentManagement.Receipt;
import rentalManagement.AccidentReport;
import rentalManagement.RentalFacade;
import rentalManagement.Report;

public class RentalManagerTest {
	
	private static RentalFacade rf = new RentalFacade();
	private static PaymentManager pm = new PaymentManager();
	
	public static void main(String[] args){
		//test_rental();
		//test_pay_for_rental_card();
		//test_pay_for_rental_points();
		//test_pay_for_rental_cash();
		//test_make_rental();
		//test_ready_to_leave();
		
		//test_check_overdue();
		//test_ready_to_return();
		//test_search_inspection();
		//test_search_accident_report();
		//test_add_accident_report();
		test_add_inspection();
	}

	private static void test_add_inspection() {
		// TODO Auto-generated method stub
		try {
			//rf.createInsectionReportBeforeRental("jolene", "2016-4-15", "everything looked good", 26, 1000, 100);
			BigDecimal extra = rf.createInsectionReportAfterRental("jolene", "2016-4-15", "need to pay extra for gas and milage", 26, 2200, 80);
			System.out.println(extra);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_add_accident_report() {
		// TODO Auto-generated method stub
		//rf.createAccidentReport(clerk_username, accident_date, description, rentalID, address, city, province, zipcode, driver, amount);
		try {
			rf.createAccidentReport("jolene", "2016-4-15", "Kevin smashed another vehicle", 20, "langara", "vancouver", "BC", "V3R4R3", "Kevin", "2000.00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_search_accident_report() {
		// TODO Auto-generated method stub
		try {
			AccidentReport r = rf.getAccidentReportForRental(19);
			System.out.println(r.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_search_inspection() {
		// TODO Auto-generated method stub
		try {
			Report[] r = rf.getInspectionReportForRental(19);
			for (int i =0; i< r.length; i++)
				System.out.println(r[i].toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_ready_to_return() {
		// TODO Auto-generated method stub
		try {
			//rf.createInsectionReportAfterRental("managernotreally", "2016-4-15", "all are good", 26, 2000, 80);
			BigDecimal owning  = rf.checkReturningBranch(26, 3);
			System.out.println("amoung owning is: "+owning);
//			Receipt r = 
//					//rf.payForRentalByCard("jolene", 26, "200.00");
//					//rf.payForRentalByPoints("jolene", 26, 1000);
//					rf.payForRentalByCash("jolene", 26, "600.00");
//			System.out.println(r.toString());
			rf.readyToReturn(26);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_check_overdue() {
		// TODO Auto-generated method stub
		try {
			BigDecimal owning  = rf.checkOverDue(26);
			System.out.println("amoung owning is: "+owning);
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
			Receipt r = pm.makePaymentCash("jolene", 20, "80.00");
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
					pm.makePaymentBySRP("jolene", 26, 1000);
			System.out.println(r.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_pay_for_rental_card() {
		// TODO Auto-generated method stub
		try {
			Receipt r = pm.makePaymentByCard("jolene", 26, "20.00");
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