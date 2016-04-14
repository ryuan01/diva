package systemManagerTest;

import java.sql.SQLException;

import systemManagement.Branch;
import systemManagement.SystemManager;

public class SystemManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemManager s = new SystemManager();
		try {
			Branch b = s.getBranch(1);
			System.out.println(b.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
