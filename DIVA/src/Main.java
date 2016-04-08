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
			acm.addCustomerAccount("Sammy", "Alma", "7781231234", "sam.@live.ca", "samahri"
					, "password", 1234123451, "SAMMY ALMA", "1234 WALL STREET", "New York",
					"BC", "V5E1X2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
