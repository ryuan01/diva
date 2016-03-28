/**
* EquipmentDB is dependant on vehicleManagement.Equipment class, which is not implemented
 */
package databaseManagement;

import vehicleManagement.Equipment;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * EquipmentDB creates, deletes, and modifies data related to Equipment
 * @author Robin, Sammy
 *
 */
class EquipmentDB {
	
	public EquipmentDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * updateEquipmentStatus updates the status of an equipment
	 * @param e equipment
	 * @param status status {rented, damaged, available}
	 * @pre isValidEquipment(e)
	 * @pre status is one of {rented, damaged, available}
	 * @post e.status = status
	 */
	public void updateEquipmentStatus(String e_key_value, int status){
		// "status" is not in the database
		// It should return a boolean determining the success of the update process
	}
	
	

	/**
	 * Checks if this is an equipment
	 * @param t type
	 * @param n name
	 * @pre t must be one of the proposed one
	 * @post true if it is, false if it is not
	 */
	private boolean isEquipment(String t, String n) {
		return false;
	}
	
	/**
	 * 
	 * @param e_key_value
	 * @return
	 */
	public String getEquipment(String e_key_value){
		return e_key_value;
		
	}
	
	/**
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public String getEquipment(String type, String name){
		return name;
	}
	
	/**
	 * searchAdditionalEquipments searches for a list of available equipments for a type
	 * @param t type of equipments
	 * @param branch_num the branch number where the equipment is located
	 * @pre a rental is underway
	 * @pre branch is valid
	 * @pre t is valid 
	 * @post list of equipments
	 */
	//should not use arraylist 
	public ArrayList<Equipment> searchAdditionalEquipments(String t, String branch_num) {
		
		// 1- Connect to the database
		super.connect();
		
		if (super.getConnection() == null)
		{
			return null;
		} else
		{
			try{
				Statement stmt = super.getConnection().createStatement();
				String query = "SELECT * FROM equipments WHERE location =" + Integer.toString(branch_num)+ "AND eq_type=" + t +";";
				ResultSet rs = stmt.executeQuery(query);
			
				ArrayList<Equipment> equipmentList = new ArrayList<Equipment>() ;
				
				while(rs.next()){
					equipmentList.add(new Equipment(rs.getInt("serial_num"), query)); // Add data according to Equipment class
				}
				super.disconnect();
				
				return equipmentList;
			} catch (SQLException e){
				System.err.println(e);
				return null;
			}
			
		}

}
