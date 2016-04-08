import java.sql.SQLException;

import accountManagement.AccountManager;

public class Main {
	public static void main(String[] args){

//		addCustomerAccount(String firstName, String lastName, String phoneNumber, 
//				String emailAddress, String userName, String password, 
//				long ccNum, String name_on_cc, String address,
//				String city, String province, String zip)
		
		AccountManager acm = new AccountManager();
		
		try {
			acm.joinSuperClub("mjane01");
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
	}
}
