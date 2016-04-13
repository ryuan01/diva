package databaseManagement;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import paymentManagement.Receipt;
import rentalManagement.AccidentReport;
import rentalManagement.Rental;
import rentalManagement.Report;
import rentalManagement.Reservation;

/**
 * RentalDB deals with creation, deletion, and modification related to reservations
 * @author Robin
 */
class RentalDB {
	
	private ConnectDB dbm;
	
	RentalDB() {
		dbm = new ConnectDB();
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
  		
		String query = "SELECT `reservation_id`, `customer`, `start_date`, `end_date`, `start_branch`, `end_branch`, `vehicle_id`, `balance` FROM `reservation`"
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
        	ArrayList<Integer> equipments = executeQueryEquipments(rNum);
        	
        	//conversion
        	int[] eqlist = new int[equipments.size()];
        	for (int i=0; i< equipments.size();i++){
        		eqlist[i] = equipments.get(i).intValue();
        	}
        	//create a resevation 
        	r = new Reservation(start_date, end_date, vehicle_id, eqlist, start_branch,end_branch,customer,id, balance);
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
	boolean isValidReservation(int rNum) throws SQLException {
		boolean isValid = false;
 		dbm.connect();
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
			//insert into Reservation table
	    	insertReservation(r, stmt);
	        
	        //insert into equipment_reservation table
	    	insertEqRes(r, stmt);
	    	
	    	//try to execute
	    	dbm.getConnection().commit();
		} catch (SQLException e) {
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
	void createInspectionReport(Report r, String state) throws SQLException{
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
    				+state
    				+"\')";
    	System.out.println(sql);
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
    	System.out.println(sql);
        stmt.executeUpdate(sql);
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
	void createRental(int reserveID, int clerkID, boolean is_paid_rental, boolean is_paid_extra_charge) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
    	String sql= "INSERT INTO `rental`(`reservation_id`, `is_paid_rental`, `is_paid_extra_charge`, `clerk_id`) VALUES ("
    				+reserveID+", "
    				+is_paid_rental+", "
    				+is_paid_extra_charge+", "
    				+clerkID+")";
    	System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close();
        dbm.disconnect();		
	}

	int getAccountForRental(int rental_id) {
		return 0;
		// TODO Auto-generated method stub
	}
	
	/**
	 * 
	 * @param r
	 */
	// not understanding what this is for
	/*
	public void createTransaction(Receipt r){
		
	}*/
	
	

}
