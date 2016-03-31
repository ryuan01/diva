package systemManagement;

import databaseManagement.DatabaseManager;

public class SystemFacade {
	
	DatabaseManager db;
	SystemManager sysMan;
	
	public SystemFacade()
	{
		
	}
	
	public SystemFacade(DatabaseManager db)
	{
		this.db = db;
	}
	
	/**
	 * Adds a new branch record to the database
	 * @pre Provided branch number must be unique among all branches
	 * @return True if the branch was successfully added
	 * @param addressBuildingNumber  The numerical portion of the branch's address
	 * @param addressStreetName  The name of the street the branch is located
	 * @param phoneNumber  The phone number of the new branch
	 */
	public boolean createBranch(String addressBuildingNumber, String addressStreetName, String phoneNumber)
	{
		 return sysMan.addBranch(addressBuildingNumber, addressStreetName, phoneNumber);
	}
	
	/**
	 * Removes the branch with the given branch number
	 * @pre The branchNumber must exist
	 * @return True if the branch was successfully false
	 */
	public boolean destroyBranch(String branchNumber) 
	{
		return sysMan.removeBranch(branchNumber); 
	}
	
	/**
	 * This is the first method called when the system starts up
	 * @pre The system is not already started and running
	 * @pos The system is in the ready state
	 */
	public void BootUp(String branchNumber)
	{
		sysMan.startUp(branchNumber);
	}
	
	/**
	 * This method will prepare the system for a safe exit and then it will 
	 * terminate the system.
	 * @pre The system is in the ready state
	 * @pos The system is terminated
	 */
	public void shutDown(String branchNumber)
	{
		sysMan.shutDown(branchNumber);
	}
	
	/**
	 * Enters website maintenance.
	 */
	public void enterMaintenance()
	{
		sysMan.maintenance();
	}
}
