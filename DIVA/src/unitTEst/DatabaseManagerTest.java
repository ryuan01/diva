package unitTEst;
import java.util.*;
import java.sql.SQLException;
import java.text.*;
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

	static DatabaseManager db = DatabaseManager.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//each test will be its own method
		//test_get_branch();
		
		//test searching cars, returns all, returns 2, returns all
		/*test_search("car","2006-5-5","2006-5-7");
		test_search("car","2016-4-5", "2016-4-6");
		test_search("car","2016-4-7", "2016-4-8");
		*/
		
		//test searching trucks, returns all, returns 2, returns all
		/*test_search("truck","2006-5-5","2006-5-7");
		test_search("truck","2016-4-7","2016-4-8");
		test_search("truck","2016-4-8","2016-4-9");
		*/
		
		//test trying to search for strange things
		test_search("car","2006-5-5","2006-5-5");
		//test_add_branch(); //works!
		
		//test simple query
		
		//add threadpool to test how it goes?
		
		//test a list of account
		
		//
	}

	/**
	 * test adding branch
	 */
	private static void test_add_branch() {
		// TODO Auto-generated method stub
		/*Branch b = new Branch(-1, "100 Manitoba Street", "Vancouver", "BC", "V5Y2Z6");
		try {
			db.addBranch(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Test db.search();
	 */
	private static void test_search(String type, String start_date, String end_date) {
	      
		Vehicle[] vArray =null;
		try {
			vArray = db.search(2,type,start_date, end_date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i<vArray.length; i++){
			//System.out.println(vArray[i].toString());
			System.out.println(vArray[i].getID());
		}	
	}

	/**
	 * Test db.getBranch();
	 */
/*	private static void test_get_branch() {
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
		
	}*/

}
