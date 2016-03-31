
import databaseManagement.DatabaseManager;
import systemManagement.Branch;
/**
 * Unit testing for DatabseManager
 * @author Robin
 *
 */
public class DatabaseManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseManager db = DatabaseManager.getInstance();
		
		//each test will be its own method
		//test getBranch and prints out the result
		Branch[] bArray = db.getBranch();
		String tmp;
		
		for (int i = 0; i<bArray.length; i++){
			tmp = "Branch: "+bArray[i].getStreetName()+" "+bArray[i].getCity() + " ";
			tmp += bArray[i].getProvince()+" "+bArray[i].getZipCode()+" ";
			System.out.println(tmp);
			tmp = null;
		}
		
		//dM.disconnect();
		//System.out.println("SUCCESS");
	  /*    try{
	        	db.connect();
	            Statement stmt = db.getConnection().createStatement();
	            String query = "SELECT br_num, street_name, city, province, zip_code FROM `branches`";
	            
	            ResultSet rs = stmt.executeQuery(query);
	            
	            while (rs.next()){
	            	int num = rs.getInt("br_num");
	            	String street_name = rs.getString("street_name");
	            	String city = rs.getString("city");
	            	String province = rs.getString("province");
	            	String zip_code = rs.getString("zip_code");
	            	
	            	//display
	            	System.out.print("Result: "+ num);
	            }
	            
	            rs.close();
	            stmt.close();
	            db.getConnection().close();
	            
	          }catch(SQLException e){
	            System.err.println(e);
	          } */	
	}

}
