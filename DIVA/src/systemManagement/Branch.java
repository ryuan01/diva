package systemManagement;

//import vehicleManagement.Vehicle;
import java.util.ArrayList;

public class Branch {
	
	private int id;
	private String address;
	// ArrayList<Vehicle> fleet;
	
	public Branch(String address){
		this.address = address;
	}
	
	public Branch(Branch br){
		br.getBranchID() = id
		br.getAddress() = address;
	}
	
	// Getters and Setters
	public int getBranchID(){
		return id;
	}
	
	public String getAddress(){
		return streetName;
	}
	
	
	// public interface
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
}
