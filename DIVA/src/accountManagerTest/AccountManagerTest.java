package accountManagerTest;

import java.sql.SQLException;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.Customer;
import databaseManagement.AuthenticateDB;

public class AccountManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test_account();
		test_authenticate();
	}

	private static void test_authenticate() {
		// TODO Auto-generated method stub
		AuthenticateDB ab = new AuthenticateDB();
		try {
			System.out.println(ab.retrievePassword("ehunter01"));
			System.out.println(ab.retrievePassword("jjohn00"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_account() {
		// TODO Auto-generated method stub
		AccountManager am = new AccountManager();
		try {
			//am.deleteAccount("clerkc");
			Account a;
			a = am.searchAccountByUsername("asd");
			Customer[] list = am.getAllCustomer();
			for (int i=0 ; i < list.length;i++){
				a = list[i];
				System.out.println(a.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
