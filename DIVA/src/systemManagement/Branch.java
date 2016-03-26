package systemManagement;

import vehicleManagement.Vehicle;

public class Branch {
	
	private String id;
	private String address;
	private String[] vehicleIDs;
	
	/**
	 * A Branch containing a Branch ID, address, and list of Vehicle IDs.
	 */
	public Branch()
	{
		
	}
	
	/**
	 * A Branch containing a Branch ID, address, and list of Vehicle IDs.
	 * @param branchID Branch ID.
	 * @param branchAddress Address of the Branch.
	 * @param branchVehicles List of Vehicle IDs
	 */
	public Branch(String branchID, String branchAddress, String[] branchVehicles)
	{
		id = branchID;
		address = branchAddress;
		vehicleIDs = branchVehicles;
	}
	
	/**
	 * Modifies Branch ID.
	 * @param newBranchID New Branch ID.
	 */
	public void changeBranchID(String newBranchID)
	{
		
	}
	
	/**
	 * Modifies Branch Address.
	 * @param newBranchAddress New Branch Address.
	 */
	public void changeBranchAddress(String newBranchAddress)
	{
		
	}
	
	/**
	 * Add a Vehicle ID to list of Vehicle IDs.
	 * @param newVehicleID Vehicle ID to add to the list.
	 */
	public void addBranchVehicleID(String newVehicleID)
	{
		
	}
	
	/**
	 * Remove a Vehicle ID to list of Vehicle IDs.
	 * @param newVehicleID Vehicle ID to be removed from the list.
	 */
	public void removeBranchVehicleID(String removedVehicleID)
	{
		
	}
	
	/**
	 * Returns the Branch ID.
	 * @return Branch ID to be returned.
	 */
	public String getBranchID()
	{
		return "";
	}
	
	/**
	 * Returns the Branch Address.
	 * @return Branch address to be returned.
	 */
	public String getBranchAddress()
	{
		return "";
	}
	
	/**
	 * Returns the list of Vehicle IDs.
	 * @return List of Vehicle IDs.s
	 */
	public String[] getBranchVehicles()
	{
		return null;
	}
}
