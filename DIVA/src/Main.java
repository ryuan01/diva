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
			BigDecimal[][] price = dbm.getAllTruckInsurancePrice();
			
			for(int i = 0; i < 4; i++){
				
				for(int j = 0; j < 3; j++){
					System.out.print(price[i][j] + " ");
				}
				
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
