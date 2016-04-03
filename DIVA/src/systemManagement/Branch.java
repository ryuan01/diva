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
	
	private int id; //-1 if uncreated
	private String address;
	private String city;
	private String province;
	private String zipcode;
	
	public Branch(int id,String address, String city, String province, String zipcode){
		
		this.id = id;
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
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
	 * Returns the Branch Address.
	 * @return Branch address to be returned.
	 */
	public String getBranchAddress()
	{
		return "";
	}

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
