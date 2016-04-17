package rentalFacadeTest;

import java.math.BigDecimal;
import java.sql.SQLException;

import paymentManagement.PaymentManager;
import rentalManagement.RentalFacade;
import rentalManagement.Reservation;

public class RentalFacadeTest {
	
	private static 	RentalFacade rf = new RentalFacade();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_reservation();
	}

	private static void test_reservation() {
		// TODO Auto-generated method stub
		//Reservation r = new Reservation("2016-4-9", "2016-4-10", 1 , eq , 2, 3, 1, -1, new BigDecimal("100.00"));
		int [] eq = new int[]{1,2};
		int [] eq1 = new int[]{0};
		
		try {
//			rf.createReservation("2016-08-05 14:00:00", "2016-09-05 15:00:00", 2 , eq1 , 2, 3, "asdf", false);
//			for (int i = 0 ; i < eq.length; i++){
//				System.out.println(eq[i]+" ");
//			}	
			rf.createReservation("2016-05-06 14:00:00", "2016-07-05 15:00:00", 2 , eq , 2, 3, "asdf", true);			
//			Reservation r = rf.findReservations(26);
//			System.out.println(r.toString());
//			
//			PaymentManager pm = new PaymentManager();
//			BigDecimal total = pm.totalPreTax(r);
//			System.out.println(total);
//			
//			System.out.println(r.toString());
//			
//			Reservation[] rs = rf.searchReservationForAccount("something");
//			for (int i=0; i< rs.length; i++){
//				System.out.println(rs[i].toString());
//			}
			
			//rf.cancelSelfReservation(1, 17);
			
//			rf.cancelAnyReservation(32);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("null pointer");
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
