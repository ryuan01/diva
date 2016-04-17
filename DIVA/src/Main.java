import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.Receipt;
import rentalManagement.RentalFacade;
import rentalManagement.Reservation;

public class Main {
	public static void main(String[] args){

		DatabaseManager dbm = DatabaseManager.getInstance();
		PaymentManager pm = new PaymentManager();
		
		RentalFacade resFac = new RentalFacade();
		
		try {
			Reservation[] res = resFac.searchReservationForAccount("bc");
			//System.out.println(res[0].getVehicleID());
			pm.totalPreTax(res[0]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
