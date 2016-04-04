/**
* EquipmentDB is dependant on vehicleManagement.Equipment class, which is not implemented
 */
package databaseManagement;

import vehicleManagement.Equipment;
import java.sql.*;
import java.util.ArrayList;

/**
 * EquipmentDB creates, deletes, and modifies data related to Equipment
 * @author Saud (Sammy) Almahri
 *
 */
class EquipmentDB {
	
	private ConnectDB dbm;
	
	EquipmentDB() {
		dbm = new ConnectDB();
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
	 * searchAdditionalEquipments searches for a list of available equipments for a type
	 * @param t type of equipments
	 * @param branch_num the branch number where the equipment is located
	 * @throws SQLException 
	 * @pre a rental is underway
	 * @pre branch is valid
	 * @pre type is valid 
	 * @post list of equipments
	 */
	Equipment[] searchAdditionalEquipments(String type, int branch_num) throws SQLException {
		
		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		// 1- Connect to the database
		dbm.connect();
		
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT * FROM `equipment` WHERE location = " + branch_num + " AND eq_type=\"" + type +"\";";
		
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		
		
		
		while(rs.next()){
			
			equipmentList.add(new Equipment(rs.getInt("serial_num"), rs.getString("eq_type"),rs.getInt("location"))); // Add data according to Equipment class
		}
		dbm.disconnect();
		
		return equipmentList.toArray(new Equipment[equipmentList.size()]);
			
			
		}

}
