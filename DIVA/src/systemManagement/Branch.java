/**
 * Note: 
 * 	1- Please notice the "issues" which are commented throughout the file
 * 	2- The javadoc can be updated when this class is approved
 * 
 * This class has NOT BEEN TESTED
 * 
 * Changes:
 * 	1- the removeVehicle() method: what if the vehicle is not there? it should return a boolean determining the success of the operation; 
 */
package systemManagement;

import vehicleManagement.Vehicle;
import vehicleManagement.Equipment;

import java.util.ArrayList;

public class Branch {
	
	private int id;
	private String address;
	private ArrayList<Vehicle> fleet;
	private ArrayLIst<Equipment> inventory;
	
	public Branch(String address){
		this.address = address;
	}
	
	public Branch(Branch br){
		br.getBranchID() = id
		br.getAddress() = address;
		
		for (Vehicle v: br.getFleet()){
			this.fleet.add(v);
		}
		
		for (Equipment eq: br.getInventory()){
			this.inventory.add(eq);
		}
	}
	
	// Getters and Setters
	public int getBranchID(){
		return id;
	}
	
	public String getAddress(){
		return streetName;
	}
	
	public ArrayList<Vehicle> getFleet(){
		return fleet;
	}
	
	public ArrayList<Equipment> getInventory(){
		return inventory;
	}
	
	
	// public interface
	/**
	 * Modifies Branch Address.
	 * @param newBranchAddress New Branch Address.
	 */
	public void changeBranchAddress(String newBranchAddress)
	{
		this.address = newBranchAddress;
	}
	
	/**
	 * Add a Vehicle ID to list of Vehicle IDs.
	 * @param newVehicleID Vehicle ID to add to the list.
	 * 
	 */
	public void addVehicle(Vehicle newVehicle)
	{
		this.fleet.add(newVehicle);
		// ISSUE_1:The database needs to be updated of the addition process
	}
	
	/**
	 * Remove a Vehicle ID to list of Vehicle IDs.
	 * @param newVehicleID Vehicle ID to be removed from the list.
	 * @return success value, the vehicle might not be there
	 */
	public boolean removeVehicle(Vehicle removeVeh)
	{
		for(Vehicle v: fleet){
			if(v.getID() == removeVeh){
				return fleet.remove(v);
			}
		}
		//ISSUE_2: the database needs to be updated of the removal process
		
		return false;
	}
	
	public void addEquipment(Equipment newEquipment){
		inventory.add(newEquipment);
		// ISSUE_3:The database needs to be updated of the addition process for the equipment as well
	}
	
	public boolean removeEquipment(Equipment removeEq)
	{
		for(Equipment eq: inventory){
			if(eq.getID() == removeEq){
				return inventory.remove(v);
			}
		}
		//ISSUE_4: same database update notification
		
		return false;
	}
}
