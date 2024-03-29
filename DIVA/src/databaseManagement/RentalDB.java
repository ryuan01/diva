package databaseManagement;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import paymentManagement.Receipt;
import rentalManagement.AccidentReport;
import rentalManagement.Rental;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Vehicle;

/**
 * RentalDB deals with creation, deletion, and modification related to reservations
 * @author Robin
 */
class RentalDB {
	
	private ConnectDB dbm;
	private VehicleDB veDB;
	
	RentalDB() {
		dbm = new ConnectDB();
		veDB = new VehicleDB();
	}

	//modify 
	/**
	 * reservationQuery returns a reservation related to reservation number
	 * @param rNum reservation number
	 * @pre isValidReservation(rNum)
	 * @post Reservation object
	 * @return Reservation object 
	 * @throws SQLException 
	 */
	Reservation reservationQuery(int rNum) throws SQLException {
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `reservation_id`, `customer`, `start_date`, `end_date`, `start_branch`, `end_branch`, `vehicle_id`, `balance`, `withInsurance` FROM `reservation`"
				+" WHERE `reservation_id` = "+rNum +";";
        ResultSet rs = stmt.executeQuery(query);
        Reservation r = null;
        //parse result, assume only 1 result comes back since rNum is unique
        if (rs.next()){
        	int id = rs.getInt("reservation_id");
        	int customer = rs.getInt("customer");
        	String start_date = rs.getString("start_date");
        	String end_date = rs.getString("end_date");
        	int start_branch = rs.getInt("start_branch");
        	int end_branch = rs.getInt("end_branch");
        	int vehicle_id = rs.getInt("vehicle_id");
        	BigDecimal balance = rs.getBigDecimal("balance");
        	boolean withInsurance = rs.getBoolean("withInsurance");
        	ArrayList<Integer> equipments = executeQueryEquipments(rNum);
        	
        	//conversion
        	int[] eqlist = new int[equipments.size()];
        	for (int i=0; i< equipments.size();i++){
        		eqlist[i] = equipments.get(i).intValue();
        	}
        	//create a resevation 
        	r = new Reservation(start_date, end_date, vehicle_id, eqlist, start_branch,end_branch,customer,id, balance,withInsurance);
        }
    	return r;
	}
	
	/**
	 * 
	 * @param rNum
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Integer> executeQueryEquipments(int rNum) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
 		ArrayList<Integer> equipments = new ArrayList<Integer>();
 		
		String query = "SELECT `equipment_id` FROM `rented_equipment` WHERE `reservation_id` = "+rNum+";";
        ResultSet rs = stmt.executeQuery(query);
        //parse result, as many additional equipments as possible
        while (rs.next()){
        	equipments.add(rs.getInt(1));
        }
        //clean up
        rs.close();
        stmt.close();
        
        //return Integer Array
        return equipments;
	}

	/**
	 * isValidReservation checks if reservation number maps to a persistant reservation
	 * @param rNum reservation number
	 * @throws SQLException 
	 * @pre none
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
	
	private boolean isValidRent(int rentID) throws SQLException{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		conn = dbm.getConnection();
		stmt = conn.createStatement();
		query = "SELECT `reservation_id` "
				+ "FROM `rental` "
				+ "WHERE reservation_id = " + rentID + ";";
		
		rs = stmt.executeQuery(query);
		if (rs.next()){
			if (rentID == rs.getInt("reservation_id")){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * reservationHistory gets a list of reservations related to an account
	 * @param acc account
	 * @pre isValidAccount(acc)
	 * @post list of reservations
	 * @return list of reservations
	 * @throws SQLException 
	 */
	Reservation[] reservationHistory(int acc_key_value) throws SQLException {
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `reservation_id`, `customer` FROM `reservation`"
				+" WHERE `customer` = \'"+acc_key_value+"\';";
        ResultSet rs = stmt.executeQuery(query);
        Reservation r = null;
        //parse result, for list of reservations/reservations related to this customer
    	ArrayList<Reservation> reservations  = new ArrayList<Reservation>();
        while (rs.next()){
        	int id = rs.getInt("reservation_id");
        	reservations.add(reservationQuery(id));
        }

        //change back to array
        Reservation[] rArray = new Reservation[reservations.size()];
        rArray = reservations.toArray(rArray);
        return rArray;
	}
	
	//should be inside Reservation class  
	/**
	 * removeReservation to a reservation, or to be cancelled
	 * @param r reservation 
	 * @param info related information to be updated 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	// not allowing people to udpate reservation as of now, must cancel and then re-book
	/*
	public void updateReservation(String r_key_value, String[] info) {
	}*/
	
	//remove
	/**
	 * removeReservation to a reservation, or to be cancelled
	 * @param r reservation 
	 * @throws SQLException 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	void removeReservation(int r_key_value) throws SQLException,NullPointerException {
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();		
		dbm.getConnection().setAutoCommit(false);
		//set save point 
		Savepoint savepoint1 = dbm.getConnection().setSavepoint("Savepoint1");
		try {
		      
			Reservation r = reservationQuery(r_key_value);
//			System.out.println("in rentalDB: " +r.getEquipments()[0]);
			removeEquipments(r.getEquipments(), r_key_value, stmt);
			
			String query = "DELETE FROM reservation WHERE reservation_id=" + r_key_value +";";
			
			stmt.executeUpdate(query);
	    	//try to execute
	    	dbm.getConnection().commit();
	    	
		} catch (NullPointerException e) {
			throw new NullPointerException ("Reservation with ID "+r_key_value+" does not exist.");
		}
		catch (SQLException e) {
			//this is for unsuccessfully adding any of these entries into database
			dbm.getConnection().rollback(savepoint1);
			e.printStackTrace();
			System.out.println("roll back happened");
		} finally{
	        //clean up
	        stmt.close();
	        dbm.disconnect();
		}
	}
	
	/**
	 * Removes equipments from Reservation
	 * @param equipments
	 * @param r_key_value
	 * @param stmt 
	 * @throws SQLException 
	 */
	private void removeEquipments(int[] equipments, int r_key_value, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String sql;
		for (int i = 0; i< equipments.length; i++){
	       	sql= "DELETE FROM `rented_equipment`" 
        			+" WHERE reservation_id = "+r_key_value
        			+" AND equipment_id = "+equipments[i];
            stmt.executeUpdate(sql);
		}
	}

	//create 
	
	/**
	 * Create an reservation entry in the database
	 * @param c 
	 * @pre r does not exist in database
	 * @pre r parameters conforms to database requirements
	 * @post r is created
	 * @param r an reservation
	 * @throws SQLException 
	 */
	void createReservation(Reservation r) throws SQLException{
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();		
		dbm.getConnection().setAutoCommit(false);
		//set save point 
		Savepoint savepoint1 = dbm.getConnection().setSavepoint("Savepoint1");
		try {
			//do another search before trying to add Reservation
			//throw error if it is not available
			boolean is_reserved = veDB.search(r.getVehicleID(), r.getStartingDate(), r.getEndDate());
			if (!is_reserved){	
				//insert into Reservation table
		    	insertReservation(r, stmt);
		        
		        //insert into equipment_reservation table
		    	if (r.getEquipments() != null){
		    		insertEqRes(r, stmt);
		    	}
		    	
		    	//try to execute
		    	dbm.getConnection().commit();
			}
			else 
				throw new SQLException("Cannot reserve the current vehicle");
		} catch (SQLException e) {
			//this is for unsuccessfully adding any of these entries into database
			dbm.getConnection().rollback(savepoint1);
			//System.out.println("im here");
			throw e;
			//e.printStackTrace();
			//System.out.println("roll back happened");
		} finally{
	        //clean up
	        stmt.close();
	        dbm.disconnect();
		}
	}
	

	/**
	 * Helps to add relations between reservation and equipments
	 * @param r
	 * @param stmt 
	 * @throws SQLException
	 */
	private void insertEqRes(Reservation r, Statement stmt) throws SQLException{
		// TODO Auto-generated method stub
  		
		int[] equipments = r.getEquipments();
    	String sql;
    	
        for (int i =0; i<equipments.length; i++){
        	sql= "INSERT INTO `rented_equipment`(`reservation_id`, `equipment_id`)" 
        			+" VALUES ("+r.getID()+ ", "+equipments[i]+")";
            stmt.executeUpdate(sql);
        }
	}

	/**
	 * helps to insert into reservation
	 * @param r
	 * @param stmt 
	 * @throws SQLException
	 * @pre r.id = -1 because we want to add NEW entry, not duplicate entry
	 * @post r.id = auto assigned int 
	 */
	private void insertReservation(Reservation r, Statement stmt) throws SQLException{
		// TODO Auto-generated method stub
       	String query = "INSERT INTO `reservation` (`reservation_id`, `customer`, `start_date`, `end_date`, `start_branch`, `end_branch`, `vehicle_id`, `balance`) "
       			+" VALUES (NULL, "
       			+r.getCustomerAccountID()
       			+", \'"+r.getStartingDate()+"\', \'"+ r.getEndDate()+"\', "
       			+r.getStartBranchID()+", "
       			+r.getEndBranchID()+", "
       			+r.getVehicleID()+", "
       			+r.getBalance()
       			+");";
        System.out.println(query);
	    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        
        //the following is used when there is auto generated key
        ResultSet rs=stmt.getGeneratedKeys();
        if (rs.next()) {
        	r.changeID(rs.getInt(1));
        }
	}
	/**
	 * Create inspection Report 
	 * @param r
	 * @param state 
	 * @throws SQLException 
	 */
	void createInspectionReport(Report r) throws SQLException{
		//Report(String d, String description, int reservID, int milage, int gasLevel)
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
    	String sql= "INSERT INTO `report`(`report_num`, `reporting_clerk`, `rental_id`, `milage`, `gasLevel`, `comments`, `report_date`, `state`) "
    				+" VALUES (NULL, "+ r.getReportClerk()+","
    				+r.getReportReservationID()+", "
    				+r.getMilage()+", "
    				+r.getGasLevel()+", \'"
    				+r.getReportDescription()+"\', \'"
    				+r.getReportDate()+"\', \'"
    				+r.getReportState()
    				+"\')";
    	//System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close();
        dbm.disconnect();
	}
	
	/**
	 * Create an accident report for an rental
	 * @param r
	 * @throws SQLException 
	 */
	void createAccidentReport(AccidentReport r) throws SQLException{
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
		dbm.getConnection().setAutoCommit(false);
		//add to `report_accident`
    	String sql= "INSERT INTO `report_accident`(`report_num`, `rental_id`, `clerk_id`, `accident_date`, "
    				+ "`comments`, `driver`, `balance`, `street_name`, `city`, `province`, `zipcode`) "
    				+" VALUES ( NULL, "
    				+r.getRentalID()+", "
    				+r.getClerkID()+", \'"
    				+r.getDate()+"\', \'"
    				+r.getDescription()+"\', \'"
    				+r.getDriver()+"\', "
    				+r.getAmount()+", \'"
    				+r.getLocation().getAddress()+"\', \'"
    				+r.getLocation().getCity()+"\', \'"
    				+r.getLocation().getProvince()+"\', \'"
    				+r.getLocation().getZipcode()+"\');";
    	//System.out.println(sql);
        stmt.executeUpdate(sql);
        
        //add to `reservation`, change balance
        addToBalanceInternal(r.getRentalID(), r.getAmount(), stmt);
        
    	dbm.getConnection().commit();
        stmt.close();
        dbm.disconnect();		
	}

	/**
	 * Create an rental
	 * @param reserveID
	 * @param clerkID
	 * @param is_paid_rental
	 * @param is_paid_extra_charge
	 * @throws SQLException
	 */
	void createRental(int reserveID, int clerkID, boolean is_paid_rental) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
 		
 		if (isValidReservation(reserveID) && !isValidRent(reserveID)){
	  		Statement stmt = dbm.getConnection().createStatement();
	    	String sql= "INSERT INTO `rental` VALUES ("
	    				+reserveID+", "
	    				+is_paid_rental+", "
	    				+false+", "
	    				+clerkID+", "
	    				+false+", "
	    				+false+")";
	    	System.out.println(sql);
	        stmt.executeUpdate(sql);
	        stmt.close();
	        dbm.disconnect();	
 		} else{
 			dbm.disconnect();
 			throw new Error("reservation deson't exist OR rent already exists!");
 		}
	}

	int getAccountForRental(int rental_id) {
		return 0;
		// TODO Auto-generated method stub
	}
		
	void changeRentalStatus(int rentalID, String columnName, boolean status) throws SQLException{
		Connection conn;
		Statement stmt;
		String query;
		
		dbm.connect();
		
		if (isValidReservation(rentalID)){
			query = "UPDATE `rental` "
					+ "SET `"+columnName+"` = " + status + " "
					+ "WHERE `reservation_id` = " + rentalID + ";";
			
			
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
			stmt.close();
		
		} else{
			throw new Error("No reservation found");
		}
		
		dbm.disconnect();
		
	}
	
	Rental getRental(int rentID) throws SQLException{
		Connection conn;
		Statement stmt;
		String query;
		ResultSet rs;
		
		// local variables
		Reservation reservation;
		Rental rent;
		
		// Reservaton object variables:
		String startDate;
		String endDate;
		int vehicleID;
		ArrayList<Integer> equipmentsArrayList = new ArrayList<Integer>();
		int[] equipmentArray;
		int startBranchID;
		int endBranchID;
		int customerID;
		BigDecimal balance;
		boolean isInsurance;
		
		// rental object variables
		boolean is_paid_rental;
		boolean is_paid_extra_charge;
		boolean is_check_overdue;
		boolean is_check_return_branch;
		
		
		dbm.connect();
		
		if(isValidRent(rentID))
		{
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			// 1- get int[] of equipments
			query = "SELECT `equipment_id` AS id FROM `rented_equipment` "
					+ "WHERE reservation_id = " + rentID;
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				equipmentsArrayList.add(rs.getInt("id"));
			}
			equipmentArray = new int[equipmentsArrayList.size()];
			for (int i=0; i < equipmentsArrayList.size(); i++){
				equipmentArray[i] = equipmentsArrayList.get(i);
			}
			
			rs.close();
			
			// 2- get reservation
			query = "SELECT * FROM `reservation` "
					+ "WHERE reservation_id = " + rentID + ";";
			rs = stmt.executeQuery(query);
			rs.next();
			
			startDate = rs.getString("start_date");
			endDate = rs.getString("end_date");
			vehicleID = rs.getInt("vehicle_id");
			startBranchID = rs.getInt("start_branch");
			endBranchID = rs.getInt("end_branch");
			customerID = rs.getInt("customer");
			balance = new BigDecimal(rs.getDouble("balance"));
			isInsurance = rs.getBoolean("withInsurance");
			
			
			// String startD, String endD, int vehID, int[] e, int startBranch, int endBranch, int cusID, 
			 //int id, BigDecimal amount)
			reservation = new Reservation(startDate, endDate, vehicleID, equipmentArray,
			startBranchID, endBranchID, customerID, rentID, balance,isInsurance);
			
			// 3- get rental
			query = "SELECT * FROM `rental` "
					+ "WHERE reservation_id = " + rentID + ";";
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			is_paid_rental = rs.getBoolean("is_paid_rental");
			is_paid_extra_charge = rs.getBoolean("is_paid_extra_charge");
			is_check_overdue = rs.getBoolean("is_check_overdue");
			is_check_return_branch = rs.getBoolean("is_check_return_branch");

			rent = new Rental(reservation, is_paid_rental, is_paid_extra_charge,is_check_overdue,is_check_return_branch);
			return rent;
			
		} else{
			return null;
		}
	}
	
	/**
	 * Replace the balance of reservation to the new one
	 * @param rental_id reservation_id
	 * @param balance new balance
	 * @throws SQLException
	 */
	void addToBalance(int rental_id, BigDecimal balance) throws SQLException{
		Connection conn;
		Statement stmt;
		
		dbm.connect();

		conn = dbm.getConnection();
		stmt = conn.createStatement();
		
		addToBalanceInternal(rental_id, balance, stmt);
			
		stmt.close();
		dbm.disconnect();
	}
	
	private void addToBalanceInternal (int rental_id, BigDecimal balance, Statement stmt) throws SQLException{
		//never add balance to be negative
		//it only becomes negative when customer pays by cash, which is returned to clerk on the spot
		if (balance.compareTo(new BigDecimal("0")) == -1){
			balance = new BigDecimal("0");
		}
		String query;
		query = "UPDATE `reservation` SET balance = " + balance + " "
				+ "WHERE reservation_id = " + rental_id + ";";
//		System.out.println(query);
//		System.exit(0);
		stmt.executeUpdate(query);
	}
	
	BigDecimal getBalance(int rentID) throws SQLException{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		BigDecimal balance;
		
		query = "SELECT balance FROM `reservation` WHERE reservation_id = " + rentID + ";";
		
		dbm.connect();
		
		if(isValidReservation(rentID)){
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			balance = new BigDecimal(rs.getInt("balance"));
			
			rs.close();
			stmt.close();
			dbm.disconnect();
			
			//System.out.println("balance is inside RentalDB: " +balance);
			return balance;
		}else{
			dbm.disconnect();
			throw new Error("reservation id is not available");
		}
		
	}
	
	/**
	 * Get an inspection report entry depending on the rental ID
	 * @param rentID
	 * @return
	 * @throws SQLException 
	 */
	Report searchInspectionReport(int rentID, String status) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `report_num`, `reporting_clerk`, `rental_id`, `milage`, `gasLevel`, `comments`, `state`, `report_date`"
					+"FROM `report` WHERE `rental_id` = "+rentID+ " AND `state` = \'"+status+"\'";
		//System.out.println(query);
        ResultSet rs = stmt.executeQuery(query);
        Report r = null;
        //parse result, assume only 1 result comes back since rNum is unique
        if (rs.next()){
        	int report_num = rs.getInt("report_num");
        	int reporting_clerk = rs.getInt("reporting_clerk");
        	int rental_id = rs.getInt("rental_id");
        	int milage = rs.getInt("milage");
        	int gasLevel = rs.getInt("gasLevel");
        	String comments = rs.getString("comments");
        	String state = rs.getString("state");
        	String date = rs.getString("report_date");
        	
        	//Report(int clerk_id, String date, String description, int rentalID, int milage, int gasLevel, int report_num, String state)
        	r = new Report(reporting_clerk, date, comments, rental_id, milage, gasLevel, report_num, state);
        }
        
        //clean up
        rs.close();
        stmt.close();
        dbm.disconnect();
    	return r;
	}

	void modifyRentalStatus(int rental_id, boolean is_paid_extra_charge, boolean is_check_overdue, String columnName) throws SQLException, Error {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt;
		String query;
		
		query = "UPDATE `rental` SET `is_paid_extra_charge` = " + is_paid_extra_charge + ", "
				+"`"+columnName+"` = "+is_check_overdue
				+ " WHERE reservation_id = " + rental_id + ";";
		//System.out.println(query);
		dbm.connect();
		
		if(isValidRent(rental_id)){
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);
			
			stmt.close();
			dbm.disconnect();
		}else{
			dbm.disconnect();
			throw new Error("Rent id is not available");
		}
	}

	/**
	 * Search for accident report and returns it 
	 * @param rental_id
	 * @return
	 * @throws SQLException 
	 */
	AccidentReport searchAccidentReport(int rental_id) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `report_num`, `rental_id`, `clerk_id`, `accident_date`, `comments`, `driver`, "
					+"`balance`, `street_name`, `city`, `province`, `zipcode` FROM `report_accident` WHERE "
					+"`rental_id` = "+rental_id;
		//System.out.println(query);
        ResultSet rs = stmt.executeQuery(query);
        AccidentReport r = null;
        //parse result, assume only 1 result comes back since rNum is unique
        if (rs.next()){
        	int report_num = rs.getInt("report_num");
        	int clerk_id = rs.getInt("clerk_id");
        	String accident_date = rs.getString("accident_date");
        	String comments = rs.getString("comments");
        	String driver = rs.getString("driver");
        	BigDecimal balance = rs.getBigDecimal("balance");
        	String street_name = rs.getString("street_name");
        	String city = rs.getString("city");
        	String province = rs.getString("province");
        	String zipcode = rs.getString("zipcode");
        	
        	// AccidentReport(int clerkID, String accident_date, String description, int rentalID, String address, 
			// String city, String province, String zipcode, String driver, BigDecimal amount, int r_num) {
        	r = new AccidentReport(clerk_id, accident_date, comments, rental_id, street_name,
        			city,province,zipcode,driver,balance,report_num);
        }
        
        //clean up
        rs.close();
        stmt.close();
        dbm.disconnect();
    	return r;
	}

}


