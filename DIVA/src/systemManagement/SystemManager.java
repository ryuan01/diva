package systemManagement;

import java.sql.SQLException;

import databaseManagement.DatabaseManager;

/**
 * The system manager is used by System Administrators to initialize and safely
 * shutdown the system. It is also used for adding and removing data
 * @version 1
 * @since March 19, 2016
 */
public class SystemManager {
	
	
	DatabaseManager dbConnection;
	
	public SystemManager() {
		dbConnection = DatabaseManager.getInstance();
	}
	
	/**
	 * Adds a new branch record to the database
	 * @pre Provided branch number must be unique among all branches
	 * @return True if the branch was successfully added
	 * @param addressBuildingNumber  The numerical portion of the branch's address
	 * @param addressStreetName  The name of the street the branch is located
	 * @param phoneNumber  The phone number of the new branch
	 * @throws SQLException 
	 */
	public void addBranch(String address, String city, String province, String zipcode) throws SQLException {
		
		dbConnection.createBranchEntry(new Branch(-1, address,city,province,zipcode));
	}
	
	/*
	 * not relevant, maybe 2.0
	public boolean changeBranch(int id,String address, String city, String province, String zipcode)
	{
		return dbConnection.modifyBranchEntry(id,address,city,province,zipcode);
	}*/
	
	/**
	 * Created from Ben's method destroyBranch
	 * @param branchNumber
	 * @return
	 * @throws SQLException 
	 */
	public void removeBranch(int id) throws SQLException {
		dbConnection.removeBranchEntry(id);
	}
	
	public Branch getBranch(int id) throws SQLException
	{
		return dbConnection.getBranchEntry(id);
	}
	
	/**
	 * This is the first method called when the system starts up
	 * @pre The system is not already started and running
	 * @pos The system is in the ready state
	 */
	public void startUp(String branchNumber) {
		DatabaseManager.getInstance(); 
	}
	
	/**
	 * This method will prepare the system for a safe exit and then it will 
	 * terminate the system.
	 * @pre The system is in the ready state
	 * @pos The system is terminated
	 */
	public void shutDown(String branchNumber) {
		DatabaseManager.destroyDatabase(); 
	}

	/**
	 * Create from Ben's method enterMaintenance()
	 */
	public void maintenance() {
		// TODO Auto-generated method stub
		
	}
}