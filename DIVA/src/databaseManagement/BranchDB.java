package databaseManagement;

import java.sql.*;
import systemManagement.Branch;
import systemManagement.Location;

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
		return null;
		// TODO Auto-generated method stub
		
	}
}
