package databaseManagement;

import java.sql.*;
import java.util.ArrayList;

import systemManagement.Branch;
import systemManagement.Location;
import vehicleManagement.Car;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

/**
 * BranchDB creates, deletes, and modifies data related to Branch
 * @Author: Saud (Sammy) Almahri
 *
 */
class BranchDB{
	
	ConnectDB dbm;
	
  	BranchDB() {
  		dbm = new ConnectDB();
  	}
  	
  	/**
  	 * addBranch creates an new entry in TABLE BRANCH
  	 * @param b branch
  	 * @throws SQLException 
  	 * @pre isValidBranch(b)
  	 * @post a new entry in TABLE BRANCH
  	 */
  	void addBranch(Branch b) throws SQLException{
  		
  		Location address = b.getLocation();
  		String streetName = address.getAddress();
  		String city = address.getCity();
  		String province = address.getProvince();
  	 	String zipcode = address.getZipcode();
  
  		dbm.connect();
  		
  		Statement stmt = dbm.getConnection().createStatement();
        String query = "INSERT INTO branch (`br_num`, `street_name`, `city`, `province`, `zip_code`) "
          + "VALUES (NULL, \'" + streetName + "\' ,\'" + city + "\', \'" + province + "\',\'" + zipcode +"\');";
        System.out.println(query);
        stmt.executeUpdate(query);
         
        stmt.close();
        dbm.disconnect();
	}
  	
  	/**
  	 * 
  	 * @param id_num
  	 * @throws SQLException
  	 */
  	void removebranch(int id_num) throws SQLException{
  	  
  	  dbm.connect();
  
      Statement stmt = dbm.getConnection().createStatement();
      
      String query = "DELETE FROM branch WHERE br_num=\'" + id_num +"\';";
      
      stmt.executeUpdate(query);
      dbm.disconnect();
  	}

  	/**
  	 * Need to implement
  	 * @param id
  	 * @return
  	 */
	Branch getBranch(int id) throws SQLException{
	  	
		Branch b = null;
		
		dbm.connect();
	  
		Statement stmt = dbm.getConnection().createStatement();
      
		String query = "SELECT * FROM `branch` WHERE br_num = " + id;
		
		//System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		
		
		
		if(rs.next()){
			
			b = new Branch (rs.getInt("br_num"), rs.getString("street_name"),rs.getString("city"),rs.getString("province"),rs.getString("zip_code"));
		}
		dbm.disconnect();
		
		return b;
		
	}

	/**
	 * Get all available branches for interface display purpose
	 * @return all available branches
	 * @throws SQLException 
	 */
	Branch[] getAllBranch() throws SQLException {
		// TODO Auto-generated method stub
		Branch b = null;
		ArrayList<Branch> blist = new ArrayList<Branch>();
		
		dbm.connect();
	  
		Statement stmt = dbm.getConnection().createStatement();
      
		String query = "SELECT * FROM `branch`";
		
		//System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		
		
		
		while(rs.next()){
			
			b = new Branch (rs.getInt("br_num"), rs.getString("street_name"),rs.getString("city"),rs.getString("province"),rs.getString("zip_code"));
			blist.add(b);
		}
		dbm.disconnect();
		
	      //change back to array
        Branch[] bArray = new Branch[blist.size()];
        bArray = blist.toArray(bArray);
        return bArray;
	}
}
