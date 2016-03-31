package databaseManagement;

import java.sql.*;
import java.util.ArrayList;
import systemManagement.Branch;

/**
 * BranchDB creates, deletes, and modifies data related to Branch
 * @author Robin
 *
 */
class BranchDB {
	
	private ConnectDB conDB;

  	BranchDB() {
  		  // TODO Auto-generated constructor stub
  		conDB = new ConnectDB();
  	}
  	
  	/**
  	 * addBranch creates an new entry in TABLE BRANCH
  	 * @param b branch
  	 * @pre isValidBranch(b)
  	 * @post a new entry in TABLE BRANCH
  	 */
 /* 	boolean addBranch(Branch b){
  	  String streetName = b.getStreetName();
  		String city = b.getCity();
  		String province = b.getProvince();
  	 	String zipcode = b.getZipCode();
		return false;
  
  		super.connect();
  		
  		if (super.getConnection() == null)
      {
          return false;
      } else
      {
        try{
          Statement stmt = super.getConnection().createStatement();
          String query = "INSERT INTO `branches`(`street_name`, `city`, `province`, `zip_code`) "
          + "VALUES ('" + streetName + "','" + city + "'d,'" + province + "','" + zipcode +"');";
          
          int result = stmt.executeUpdate(query);
          super.disconnect();
          return true;
          
          
        }catch(SQLException e){
          System.err.println(e);
          return false;
        }
		}
  		
  	}
*/
  	
  	//delete
  
  	/**
  	 * removeBranch removes an entry in TABLE BRANCH
  	 * @param b branch
  	 * @return 
  	 * @pre for all v:Vehicle, v.branch != b
  	 * @pre for all e:Employee, e.branch != b
  	 * @post an entry in TABLE BRANCH is removed
  	 */
  	boolean removebranch(String b_key_value) throws SQLException{
		return false;
  	  
  	  // get branch id Number:
  	  // int id_num = b.getID();
  	  
  	  /*super.connect();
  	  
  		if (super.getConnection() == null)
      {
          return false;
      } else{
        try{
          Statement stmt = super.getConnection().createStatement();
          String query = "DELETE FROM branches WHERE id_num=" + Integer.toString(id_num) +";";
          
          int result = stmt.executeUpdate(query);
          super.disconnect();
          return true;
          
          
        }catch(SQLException e){
          System.err.println(e);
          return false;
        }
      }*/
  	}
  	
  	
  	/**
  	 * 
  	 * @param b
  	 */
  	void changeBranch(String b_key_value){
  		
  	}
  	
  	Branch[] getBranch(){
  		ArrayList<Branch> blist = new ArrayList<Branch>();
        try{
        	conDB.connect();
            Statement stmt = conDB.getConnection().createStatement();
            String query = "SELECT br_num, street_name, city, province, zip_code FROM `branches`";
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
            	int num = rs.getInt("br_num");
            	String street_name = rs.getString("street_name");
            	String city = rs.getString("city");
            	String province = rs.getString("province");
            	String zip_code = rs.getString("zip_code");
            	Branch b = new Branch(num,street_name,city,province,zip_code);
            	blist.add(b);
            	//display
            }
            
            rs.close();
            stmt.close();
            conDB.getConnection().close();
        	conDB.disconnect();
            
          }catch(SQLException e){
            System.err.println(e);
          }
        //change back to array
        Branch[] bArray = new Branch[blist.size()];
        bArray = blist.toArray(bArray);
        return bArray;
  	}
}
