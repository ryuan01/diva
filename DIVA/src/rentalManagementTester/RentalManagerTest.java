package rentalManagementTester;

import java.sql.SQLException;

import rentalManagement.RentalFacade;

public class RentalManagerTest {
	
	private static RentalFacade rf = new RentalFacade();
	
	public static void main(String[] args){
		//test_rental();
		test_pay_for_rental_card();
	}

	private static void test_pay_for_rental_card() {
		// TODO Auto-generated method stub
		try {
			rf.payForRentalByCard(26, "50.00");
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