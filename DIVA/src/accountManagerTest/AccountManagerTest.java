package accountManagerTest;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.Customer;
import databaseManagement.AuthenticateDB;

public class AccountManagerTest {

	static AccountManager am = new AccountManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test_account();
		//test_authenticate();
		test_add_account();
	}

	private static void test_add_account() {
		// TODO Auto-generated method stub
		//am.addCustomerAccount(firstName, lastName, phoneNumber, emailAddress, userName, password, ccNum, name_on_cc, expire_date, address, city, province, zip);
		try {
			am.addCustomerAccount("Sammy", "Samahri", "7789990001", "sammy@example.ca", "sammy01", "sammyisthebest", null, null, null, "langara street", "vancouver", "BC", "VS22VS");
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
