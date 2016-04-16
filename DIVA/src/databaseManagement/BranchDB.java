package databaseManagement;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import systemManagement.Branch;
import systemManagement.Location;

/**
 * BranchDB creates, deletes, and modifies data related to Branch
 * @Author: Saud (Sammy) Almahri
 *
 */
class BranchDB{
	
	ConnectDB dbm;
	
	
	/**
	 * default constructor
	 */
  	BranchDB() {
  		dbm = new ConnectDB();
  	}
  
 /* ------------------------------------- Public Interface --------------------------- */
  	/**
  	 * addBranch creates a new branch entry in branch table
  	 * @author saudalmahri
  	 * @param b branch object
  	 * @throws SQLException 
  	 * @post a new entry in TABLE BRANCH
  	 */
  	void addBranch(Branch b) throws SQLException{
  		Connection conn;
  		Statement stmt;
  		String query;
  		
  		Location address = b.getLocation();
  		String streetName = address.getAddress();
  		String city = address.getCity();
  		String province = address.getProvince();
  	 	String zipcode = address.getZipcode();
  
  		dbm.connect();
  		
  		conn = dbm.getConnection();
		stmt = conn.createStatement();
		
		query = "INSERT INTO branch (`br_num`, `street_name`, `city`, `province`, `zip_code`) "
				+ "VALUES (NULL, \'" + streetName + "\' ,\'" + city + "\', \'" + province + "\',\'" + zipcode +"\');";
 
		stmt.executeUpdate(query);
     
		stmt.close();
		dbm.disconnect();
  		
	}
  	
  	/**
  	 * deletes branch entry from the database
  	 * @author saudalmahri
  	 * @param id_num	branch id number
  	 * @throws SQLException
  	 */
  	void removebranch(int id_num) throws SQLException{
  	  
  	  dbm.connect();
  
      Statement stmt = dbm.getConnection().createStatement();
      
      String query = "DELETE FROM branch WHERE br_num=\'" + id_num +"\';";
      
      stmt.executeUpdate(query);
      
      stmt.close();
      dbm.disconnect();
  	}

  	/**
  	 * Returns a branch using a branch id
  	 * @param id	branch id
  	 * @return	branch object
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
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		Branch b = null;
		ArrayList<Branch> blist = new ArrayList<Branch>();
		
		dbm.connect();
	  
		conn = dbm.getConnection();
		stmt = conn.createStatement();
      
		query = "SELECT * FROM `branch`";
		
		rs = stmt.executeQuery(query);

		while(rs.next()){
			
			b = new Branch (rs.getInt("br_num"), rs.getString("street_name"),rs.getString("city"),rs.getString("province"),rs.getString("zip_code"));
			blist.add(b);
		}
		dbm.disconnect();
		
        Branch[] bArray = new Branch[blist.size()];
        bArray = blist.toArray(bArray);
        return bArray;
	}
	
	/**
	 * @author saudalmahri
	 * @param rental_id
	 * @param current_branch_id
	 * @return check if return branch matches that with the one specified in the database
	 * @pre isValidReservation(rental_id)
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	boolean checkReturnBranch(int rental_id, int current_branch_id) throws SQLException{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		int endBranch;
		
		query = "SELECT start_branch, end_branch FROM `reservation` "
				+ "WHERE reservation_id = " + rental_id + ";";
		
		dbm.connect();
		
		if (isValidReservation(rental_id)){
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			endBranch = rs.getInt("end_branch");
			
			rs.close();
			stmt.close();
			dbm.disconnect();
			
			if(current_branch_id == endBranch){
				return true;
			} else{
				return false;
			}
			
		} else{
			dbm.disconnect();
			throw new IllegalArgumentException("reservation does not exist!");
		}
		
	}
	
	/**
	 * Note the extra charge from returning the vehicle to the wrong branch in the database
	 * @author saudalmahri
	 * @param rental_id		the rental number
	 * @return	Extra charge from
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 */
	BigDecimal addWrongReturnBranchExtraCharge(int rental_id) throws SQLException {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		BigDecimal extraCharge = new BigDecimal(0);
		// TODO How much is the extra
		
		BigDecimal currentBalance;
		
		
		dbm.connect();
		
		if(isValidReservation(rental_id)){
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			query = "SELECT balance FROM reservation WHERE reservation_id = " + rental_id +";";
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			currentBalance = new BigDecimal(rs.getDouble("balance"));
			currentBalance.add(extraCharge);
			
			rs.close();
			
			query = "UPDATE reservation SET balance = " + currentBalance + " "
					+ "WHERE reservation_id = " + rental_id + ";";
			stmt.executeUpdate(query);
			
			stmt.close();
			dbm.disconnect();
			
			return extraCharge;
					
		}else{
			dbm.disconnect();
			throw new IllegalArgumentException("no rental id");
		}
	}
	
	/**
	 * isValidReservation checks if reservation number maps to a persistant reservation
	 * @param rNum reservation number
	 * @throws SQLException 
	 * @post returns true if it exists, otherwise false
	 */
	private boolean isValidReservation(int rNum) throws SQLException {
		boolean isValid = false;
 		
  		Statement stmt = dbm.getConnection().createStatement();		
		String query = "SELECT `reservation_id` FROM `reservation` WHERE "
					+ "`reservation_id` = "+ rNum;
        ResultSet rs = stmt.executeQuery(query);
        //parse result, as many additional equipments as possible
        if (rs.next()){
        	isValid = true;
        }
        
        //clean up
        rs.close();
        stmt.close();

        return isValid;
	}
}
