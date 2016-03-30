package unitTEst;

import databaseManagement.DatabaseManager;

/**
 * Unit testing for DatabseManager
 * @author Robin
 *
 */
public class DatabaseManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseManager dM = DatabaseManager.getInstance();
		
		//each test will be its own method
		dM.connect();
		dM.disconnect();
	}

}
