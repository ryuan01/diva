import java.sql.SQLException;

import accountManagement.Account;
import accountManagement.AccountManager;

public class Main {
	public static void main(String[] args){

//		addCustomerAccount(String firstName, String lastName, String phoneNumber, 
//				String emailAddress, String userName, String password, 
//				long ccNum, String name_on_cc, String address,
//				String city, String province, String zip)
		
		AccountManager acm = new AccountManager();
		
		try {
			//acm.joinSuperClub("mjane01");
			//acm.changePassword("jjohn00", null); 
			Account[] accs = acm.searchAccountByLastName("Johnson");
			for(Account acc : accs){
				System.out.println(acc.getFirstname());
			}
//			acm.addCustomerAccount("sammy", "Al", "775555666", "Sammy@live", "sam", "123123124",
//					12341412345l, "SAMMY", "1243 new york St", "Vanoucver", "BC", "1w23e4");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
			 
	}
}
