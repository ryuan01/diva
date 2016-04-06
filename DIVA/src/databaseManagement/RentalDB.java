package databaseManagement;

import java.sql.*;
import java.util.ArrayList;

import paymentManagement.Receipt;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Vehicle;

/*Robin */
/**
 * RentalDB deals with creation, deletion, and modification related to rentals
 * @author Robin
 */
class RentalDB {
	
	private ConnectDB dbm;
	
	public RentalDB() {
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
	public Reservation reservationQuery(int rNum) throws SQLException {
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `reservation_id`, `customer`, `start_date`, `end_date`, `start_branch`, `end_branch`, `vehicle_id` FROM `rental`"
				+" WHERE `reservation_id = "+rNum
				+" AND `state` = 'reserved';";
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
        	String state= "reserved";
        	int vehicle_id = rs.getInt("vehicle_id");
        	ArrayList<Integer> equipments = executeQueryEquipments(rNum);
        	
        	//conversion
        	int[] eqlist = new int[equipments.size()];
        	for (int i=0; i< equipments.size();i++){
        		eqlist[i] = equipments.get(i).intValue();
        	}
        	//create a resevation 
        	r = new Reservation(start_date, end_date, vehicle_id, eqlist, start_branch,end_branch,customer,state,id);
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
	public boolean isValidReservation(int rNum) throws SQLException {
		boolean isValid = false;
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();		
		String query = "SELECT `reservation_id` FROM `rental` WHERE "
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
	 */
	public Reservation[] rentalHistory(String acc_key_value) {
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		String query = "SELECT `reservation_id`, `customer` FROM `rental`"
				+" WHERE `customer` = \'"+acc_key_value+"\';";
        ResultSet rs = stmt.executeQuery(query);
        Reservation r = null;
        //parse result, for list of reservations/rentals related to this customer
    	ArrayList<Reservation> rentals  = new ArrayList<Reservation>();
        while (rs.next()){
        	int id = rs.getInt("reservation_id");
        	rentals.add(reservationQuery(id));
        }

        //change back to array
        Vehicle[] vArray = new Car[vlist.size()];
        vArray = vlist.toArray(vArray);
        return vArray;
	}
	
	//should be inside Reservation class  
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @param info related information to be updated 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void updateReservation(String r_key_value, String[] info) {
	}
	
	//remove
	/**
	 * removeReservation to a rental, or to be cancelled
	 * @param r reservation 
	 * @pre isValidReservation(r)
	 * @post !isValidReservation(r)
	 */
	public void removeReservation(String r_key_value) {
	}
	
	//create 
	/**
	 * 
	 * @param r
	 */
	public void createInspectionReport(Report r){
		
	}
	
	/**
	 * Create an reservation entry in the database
	 * @param c 
	 * @pre r does not exist in database
	 * @pre r parameters conforms to database requirements
	 * @post r is created
	 * @param r an reservation
	 * @throws SQLException 
	 */
	public void createReservation(Reservation r) throws SQLException{
		
		//what happens if it is only half of the insertion?
		//then reservation is still created
		//customer need to cancel it manually through the function cancel_reservation
		
        //insert into Reservation table
    	insertReservation(r);
        
        //insert into equipment_reservation table
    	insertEqRes(r);
	}
	

	/**
	 * Helps to add relations between reservation and equipments
	 * @param r
	 * @throws SQLException
	 */
	private void insertEqRes(Reservation r) throws SQLException{
		// TODO Auto-generated method stub
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		
		int[] equipments = r.getEquipments();
    	String sql;
    	
        for (int i =0; i<equipments.length; i++){
        	sql= "INSERT INTO `rented_equipment`(`reservation_id`, `equipment_id`)" 
        			+" VALUES ("+r.getID()+ ", "+equipments[i]+")";
            stmt.executeUpdate(sql);
        }
        //clean up
        stmt.close();
        dbm.disconnect();
	}

	/**
	 * helps to insert into reservation
	 * @param r
	 * @throws SQLException
	 * @pre r.id = -1 because we want to add NEW entry, not duplicate entry
	 * @post r.id = auto assigned int 
	 */
	private void insertReservation(Reservation r) throws SQLException{
		// TODO Auto-generated method stub
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
       	String query = "INSERT INTO `rental`(`reservation_id`, `customer`, `start_date`, `end_date`, `start_branch`, `end_branch`, `state`, `vehicle_id`) "
       			+" VALUES (NULL, "+r.getCustomerAccountID()+", \'"
       			+r.getStartingDate()+"\', \'"+ r.getEndDate()+"\', "
       			+r.getStartBranchID()+", "+r.getEndBranchID()+", 'reserved', "+r.getVehicleID()+");";
        System.out.println(query);
	    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        
        //the following is used when there is auto generated key
        ResultSet rs=stmt.getGeneratedKeys();
        if (rs.next()) {
        	r.changeID(rs.getInt(1));
        }
        
        //clean up
        stmt.close();
        dbm.disconnect();
	}

	/**
	 * 
	 * @param r
	 */
	public void createAccidentReport(Report r){
		
	}
	
	/**
	 * 
	 * @param r
	 */
	public void createTransaction(Receipt r){
		
	}
	
	

}
