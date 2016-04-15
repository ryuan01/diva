package accountManagerTest;

import java.sql.SQLException;

import accountManagement.AccountManager;

public class AccountManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountManager am = new AccountManager();
		try {
			am.deleteAccount("clerkc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
