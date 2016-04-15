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
			dbm.addReceipt(new Receipt(-1, 1, "basic Info", "receipt info"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
