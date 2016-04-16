import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import databaseManagement.DatabaseManager;
import paymentManagement.Receipt;
import rentalManagement.RentalFacade;

public class Main {
	public static void main(String[] args){

		DatabaseManager dbm = DatabaseManager.getInstance();
		
		try {
			BigDecimal[][] price = dbm.getAllCarInsurancePrice();
			
			System.out.println(price[0][1]);
			System.out.println(price[1][2]);
			System.out.println(price[2]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
