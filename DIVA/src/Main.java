import java.sql.SQLException;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import rentalManagement.RentalFacade;

public class Main {
	public static void main(String[] args){

		
		RentalFacade rf = new RentalFacade();
		
		try {
			//acm.joinSuperClub("mjane01");
			//acm.changePassword("jjohn00", null); 
			
			rf.checkReturningBranch(19);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
			 
	}
}
