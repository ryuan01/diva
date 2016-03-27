package databaseManagement;

import java.sql.SQLException;
import java.sql.Statement;

import systemManagement.Branch;

/**
 * BranchDB creates, deletes, and modifies data related to Branch
 * @author Robin
 *
 */
class BranchDB {

  	public BranchDB() {
  		  // TODO Auto-generated constructor stub
  	}
  	
  	/**
  	 * addBranch creates an new entry in TABLE BRANCH
  	 * @param b branch
  	 * @pre isValidBranch(b)
  	 * @post a new entry in TABLE BRANCH
  	 */
  	public boolean addBranch(Branch b){
  	  String streetName = b.getStreetName();
  		String city = b.getCity();
  		String province = b.getProvince();
  	 	String zipcode = b.getZipCode();
  
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
  	
  	//delete
  
  	/**
  	 * removeBranch removes an entry in TABLE BRANCH
  	 * @param b branch
  	 * @return 
  	 * @pre for all v:Vehicle, v.branch != b
  	 * @pre for all e:Employee, e.branch != b
  	 * @post an entry in TABLE BRANCH is removed
  	 */
  	public boolean removebranch(String b_key_value) throws SQLException{
  	  
  	  // get branch id Number:
  	  // int id_num = b.getID();
  	  
  	  super.connect();
  	  
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
      }
  	}
  	
  	
  	/**
  	 * 
  	 * @param b
  	 */
  	public void changeBranch(String b_key_value){
  		
  	}
}
