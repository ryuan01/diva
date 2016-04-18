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
	
	/**
	 * default constructor
	 */
	EquipmentDB() {
		dbm = new ConnectDB();
	}
	
	/**
	 * searchAdditionalEquipments searches for a list of available equipments for a type
	 * @param type 		type of equipments
	 * @param branch_num 	the branch number where the equipment is located
	 * @param end_date 	equipment availability end date
	 * @param start_date 	equipment availability start date
	 * @return an array of equipment that meet the parameter
	 * @throws SQLException 
	 */
	Equipment[] searchAdditionalEquipments(String type, int branch_num, String start_date, String end_date) throws SQLException {
		
		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		// 1- Connect to the database
		dbm.connect();
		
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT * FROM `equipment` WHERE location = " + branch_num 
					+ " AND eq_type=\'" + type +"\'"
					+ " AND serial_num NOT IN "
					+ "(SELECT `serial_num` FROM (SELECT `rented_equipment`.`reservation_id`, `rented_equipment`.`equipment_id` AS `serial_num`, `start_date`,`end_date` "
					+ "FROM `rented_equipment` INNER JOIN `reservation` ON rented_equipment.`reservation_id` = `reservation`.`reservation_id` "
					+ "WHERE `end_date` >= (\'"+start_date+"\' - INTERVAL 1 DAY) AND `start_date` <= \'"+end_date+"\' ) AS tmpTable)";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		
		
		
		while(rs.next()){
			
			equipmentList.add(new Equipment(rs.getInt("serial_num"), rs.getString("eq_type"),rs.getInt("location"))); // Add data according to Equipment class
		}
		dbm.disconnect();
		
		return equipmentList.toArray(new Equipment[equipmentList.size()]);
			
			
	}
	
	/**
	 * Add a new equipment to the database
	 * @param branch_id 		the id number of the branch to where the equipment is added
	 * @param equipment_type 	one of 'ski rack','child safety seat', 'lift gate', or'car-towing eq'
	 * @throws SQLException 
	 */
	void addEquipment(int branch_id, String equipment_type) throws SQLException{
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
        String query = "INSERT INTO `equipment`(`serial_num`, `location`, `eq_type`) VALUES (NULL,"
        		+branch_id+", \'"+equipment_type+"\')";

	    stmt.executeUpdate(query);
	    stmt.close();
	    dbm.disconnect();
	}

	/**
	 * Get a type of equipment by its ID
	 * @param equipment_id
	 * @return equipment type, one of 'ski rack','child safety seat', 'lift gate', or'car-towing eq'
	 * @throws SQLException 
	 */
	String getEquipmentType(int equipment_id) throws SQLException {
		dbm.connect();
		
		Statement stmt = dbm.getConnection().createStatement();
		String query = "SELECT `eq_type` FROM `equipment` WHERE "
				+"`serial_num` ="+equipment_id;
		//System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);

		if(rs.next()){
			
			return rs.getString("eq_type");
		} else{
			dbm.disconnect();
			return null; //did not find a match
		}
	}

}
