/**
 * @Author: Saud (Sammy) Almahri
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
	
<<<<<<< HEAD
	private int id; //-1 if uncreated
=======
	
	private String objectClass;
	private String id;
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
	private String address;
	private String city;
	private String province;
	private String zipcode;
	
<<<<<<< HEAD
	public Branch(int id,String address, String city, String province, String zipcode){
		
		this.id = id;
=======
	public Branch(String address, String city, String province, String zipcode){
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
		this.status = getClass().getName();
	}
<<<<<<< HEAD
=======
	/* not sure what this is for <- robin
	public Branch(Branch br){
		br.getBranchID() = id
		br.getAddress() = address;
		
		for (Vehicle v: br.getFleet()){
			this.fleet.add(v);
		}
		
		for (Equipment eq: br.getInventory()){
			this.inventory.add(eq);
		}
	}*/
	
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
	
	// public interface
	/**
	 * Modifies Branch Address.
	 * @param newBranchAddress New Branch Address.
	 */
	public void changeBranchAddress(String newBranchAddress)
	{
		this.address = newBranchAddress;
	}
<<<<<<< HEAD
=======

	
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
		return id;
	}
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
	
	/**
	 * Returns the Branch Address.
	 * @return Branch address to be returned.
	 */
	public String getBranchAddress()
	{
		return "";
	}
<<<<<<< HEAD
=======
	
	/**
	 * Returns the list of Vehicle IDs.
	 * @return List of Vehicle IDs.s
	 *
	 * @return success value, the vehicle might not be there
	 */
	public boolean removeVehicle(Vehicle removeVeh)
	{
		/**for(Vehicle v: fleet){
			if(v.getID() == removeVeh){
				return fleet.remove(v);
			}
		}*/
		//ISSUE_2: the database needs to be updated of the removal process
		
		return false;
	}
	
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5

	public String getStreetName() {
		// TODO Auto-generated method stub
		return address;
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}

	public String getProvince() {
		// TODO Auto-generated method stub
		return province;
	}

	public String getZipCode() {
		// TODO Auto-generated method stub
		return zipcode;
	}
}
