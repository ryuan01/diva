package rentalManagement;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import databaseManagement.DatabaseManager;


class ReserveManager {
	
	
	private DatabaseManager dbConnection;
	/**
	 * A Manager for adding, removing, and modifying Reservations and its attributes.
	 */
	ReserveManager()
	{
		dbConnection = null;
	}
	
	/**
	 * A Manager for adding, removing, and modifying Reservations and its attributes.
	 * @param db The database it's connecting.
	 */
	ReserveManager(DatabaseManager db)
	{
		dbConnection = db;
	}
	
	/**
	 * Creates a Reservation with a date, vehicle, list of equipments, starting branch, ending branch, customer, employee, status, and reservation ID.
	 * @param startD Starting Date of the Reservation.
	 * @param endD Ending Date of the Reservation.
	 * @param vehicleID Vehicle ID of the Reservation.
	 * @param equipIDs Equipment IDs of the Reservation.
	 * @param startBranchID The Branch ID Vehicle is Rented.
	 * @param endBranchID The Branch ID Vehicle is Returned.
	 * @param customerID Customer login ID of the Reservation.
	 * @param employeeID 
	 * @param employeeID Employee login ID of the Reservation.
	 * @param balance Status of the Reservation.
	 * @throws SQLException 
	 */
	void addReservation(String startD,String endD, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, BigDecimal balance) throws SQLException 
	{
		//create reservation object and pass that on
		//(String startD, String endD, int vehID, int[] e, int startBranch, int endBranch, int cusID, 
		// int id, BigDecimal amount)
		Reservation r = new Reservation(startD,endD,vehicleID,equipIDs,startBranchID,endBranchID,customerID,-1, balance);
		dbConnection.createReservationEntry(r);
	}
	
	/**
	 * Removes a Reservation that belongs to Customer.
	 * Reservations belonging to themselves.
	 * @param accountID The Account ID of the Reservation.
	 * @param reservID The Reservation ID to be removed.
	 * @throws Exception 
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	void removeReservation(int customerID, int reservID) throws Exception
	{
		Reservation r = dbConnection.searchReservationEntry(reservID);
		if (r.getCustomerAccountID()== customerID){
			dbConnection.removeReservationEntry(reservID);
		}
		else {
			throw new Exception("Calling customer does not have the right to access other's reservations");
		}
	}
	
	/**
	 * Removes a Reservation belonging to anyone.
	 * Reservations belonging to themselves.
	 * @param reservID The Reservation ID to be removed.
	 * @throws SQLException 
	 * @pre If(customerID == Customer), customerID must belong to reservID 
	 */
	void removeReservation(int reservID) throws SQLException
	{
		dbConnection.removeReservationEntry(reservID);
	}
	
	/**
	 * Searches for the list of Reservations with all attributes passed.
	 * @param id The type of search executed, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * @return List of qualifying Reservations from the search
	 * @throws SQLException 
	 */
	Reservation searchReservation(int reservID) throws SQLException
	{
		return dbConnection.searchReservationEntry(reservID);
	}

	/**
	 * Searches reservations for an account
	 * @param customerID reservation ID
	 * @return reservations under a customer
	 * @throws SQLException 
	 */
	Reservation[] searchReservationForAccount(int customerID) throws SQLException {
		// TODO Auto-generated method stub
		return dbConnection.reservationHistory(customerID);
	}
	
	
	/**
	 * Modifies the Reservation based on id passed.
	 * @param reservID Reservation ID of Reservation to be modified.
	 * @param id Type of modification of Reservation, can be vehicleID, branchID, reservationID, customerID, employeeID, equipID, reservStatus.
	 * If existing equipID is passed, then it is removed, if a non-existing equipID is passed, then it is added.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	/* Robin: if we have time
	boolean changeReservation(int reservID, String startDate,String endDate, int vehicleID, int[] equipIDs, int startBranchID, int endBranchID, 
			int customerID, int employeeID, String status)
	{
		return dbConnection.modifyReservationEntries(reservID, startDate,endDate, vehicleID, equipIDs, startBranchID, endBranchID, 
				customerID, employeeID, status);
	}
	*/
}