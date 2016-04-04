package databaseManagement;

import java.sql.*;

import paymentManagement.Receipt;
import rentalManagement.Report;
import rentalManagement.Reservation;
import systemManagement.Branch;

/*Robin */
/**
 * RentalDB deals with creation, deletion, and modification related to rentals
 * @author Robin
 */
class RentalDB {
	
	private ConnectDB conDB;
	
	public RentalDB() {
		conDB = new ConnectDB();
	}

	//modify 
	/**
	 * reservationQuery returns a reservation related to reservation number
	 * @param rNum reservation number
	 * @pre isValidReservation(rNum)
	 * @post Reservation object
	 * @return Reservation object 
	 */
	public Reservation reservationQuery(int rNum) {
		return null;
	}
	
	/**
	 * isValidReservation checks if reservation number maps to a persistant reservation
	 * @param rNum reservation number
	 * @pre none
	 * @post returns true if it exists, otherwise false
	 */
	public boolean isValidReservation(int rNum) {
		return false;
	}
	
	/**
	 * reservationHistory gets a list of reservations related to an account
	 * @param acc account
	 * @pre isValidAccount(acc)
	 * @post list of reservations
	 * @return list of reservations
	 */
	public Reservation[] reservationHistory(String acc_key_value) {
		return null;
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
	 */
	public void createReservation(Reservation r){
		
		/*//what happens if it is only half of the insertion?
        try{
            //insert into Reservation table
        	insertReservation(r);
            
            //insert into equipment_reservation table
        	insertEqRes(r);
            
            c.close();
            
        }
        catch(SQLException e){
            System.err.println(e);
        }*/
	}
	

	/**
	 * Helps to add relations between reservation and equipments
	 * @param r
	 * @throws SQLException
	 */
	private void insertEqRes(Reservation r) throws SQLException{
	/*	// TODO Auto-generated method stub
    	String sql = "INSERT INTO `equipment_reservation`(`start_date`, `end_date`,`res_id`, `equip_id`) VALUES (?,?,?,?)";
    	
        for (int i =0; i<r.getEquipments().length; i++){
        	PreparedStatement st = c.prepareStatement(sql);

            st.setDate(1,new java.sql.Date(r.getStartingDate().getTime()));
            st.setDate(2,new java.sql.Date(r.getEndDate().getTime()));
            st.setInt(3, r.getID());
            st.setInt(4,Integer.parseUnsignedInt(r.getEquipments()[i]));
            
            st.executeUpdate();
         
        }*/
	}

	/**
	 * helps to insert into reservation
	 * @param r
	 * @throws SQLException
	 */
	private void insertReservation(Connection c, Reservation r) throws SQLException{
		// TODO Auto-generated method stub
    /*   	String sql = "INSERT INTO `reservation`( `start_date`, `end_date`, `vehicle_id`, `start_branch_id`, `end_branch_id`, `cus_id`, `status`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	
        stmt.setDate(1,new java.sql.Date(r.getStartingDate().getTime()));
        stmt.setDate(2,new java.sql.Date(r.getEndDate().getTime()));
        stmt.setInt(3,Integer.parseInt(r.getVehicleID()));
        stmt.setInt(4,Integer.parseInt(r.getStartBranchID()));
        stmt.setInt(5,Integer.parseInt(r.getEndBranchID()));
        stmt.setInt(6,Integer.parseInt(r.getCustomerAccountID()));
        stmt.setString(7,r.getStatus());

        stmt.executeUpdate();
        
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs!= null && rs.next()){
        	//set the ID of reservation to be the auto generated key
            	r.changeID(rs.getInt(1));
        }
        rs.close();*/
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
