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
			acm.addEmployeeAccount("Sammy", "Alma", "7781231234", "sam.@live.ca", "samahri"
					, "password", 1, "SystemAdmin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
