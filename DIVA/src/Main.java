import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.PriceList;
import paymentManagement.Receipt;
import rentalManagement.RentalFacade;
import rentalManagement.Reservation;

public class Main {
	public static void main(String[] args){

		DatabaseManager dbm = DatabaseManager.getInstance();
		PaymentManager pm = new PaymentManager();
		PriceList pl = new PriceList();
		
		
		
		try {
			Reservation rez = dbm.searchReservationEntry(19);
			pm.totalPreTax(rez);
			
			//pm.getPriceCarInsurance("economy");
			
			//System.out.println(bd3);
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
