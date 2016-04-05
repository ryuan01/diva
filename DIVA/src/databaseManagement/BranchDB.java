package databaseManagement;

import java.sql.*;
import java.util.ArrayList;
import systemManagement.Branch;

import java.sql.*;

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
  		
  		String[] address = b.getFullAddress().split(" ");
  		String streetName = address[0];
  		String city = address[1];
  		String province = address[2];
  	 	String zipcode = address[3];
  
  		dbm.connect();
  		
  		Statement stmt = dbm.getConnection().createStatement();
        String query = "INSERT INTO branch (`street_name`, `city`, `province`, `zip_code`) "
          + "VALUES (\"" + streetName + "\",\"" + city + "\",\"" + province + "\",\"" + zipcode +"\");";
         stmt.executeUpdate(query);
         dbm.disconnect();
	}
  	
  	/**
  	 * 
  	 * @param b
  	 * @throws SQLException
  	 */
  	void removebranch(Branch b) throws SQLException{
  	  
  	  // get branch id Number:
  	  int id_num = b.getId();
  	  
  	  dbm.connect();
  
      Statement stmt = dbm.getConnection().createStatement();
      
      String query = "DELETE FROM branch WHERE br_num=\'" + id_num +"\';";
      
      stmt.executeUpdate(query);
      dbm.disconnect();
  	}
}
