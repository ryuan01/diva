//package unitTEst;

import java.util.Date;

import databaseManagement.DatabaseManager;
import systemManagement.Branch;
import vehicleManagement.Vehicle;
/**
 * Unit testing for DatabseManager
 * @author Robin
 *
 */
public class DatabaseManagerTest {

	private static DatabaseManager db = DatabaseManager.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//each test will be its own method
		//test_get_branch();
		
		test_search();
	}

	/**
	 * Test db.search();
	 */
	private static void test_search() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Vehicle[] vArray = db.search("1","car",new Date(),null);
		String tmp;
		
		for (int i = 0; i<vArray.length; i++){
			System.out.println(vArray[i].toString());
		}	
	}

	/**
	 * Test db.getBranch();
	 */
	private static void test_get_branch() {
		// TODO Auto-generated method stub
		//test getBranch and prints out the result
		Branch[] bArray = db.getBranch();
		String tmp;
		
		for (int i = 0; i<bArray.length; i++){
			tmp = "Branch: "+bArray[i].getStreetName()+" "+bArray[i].getCity() + " ";
			tmp += bArray[i].getProvince()+" "+bArray[i].getZipCode()+" ";
			System.out.println(tmp);
			tmp = null;
		}
		
	}

}
