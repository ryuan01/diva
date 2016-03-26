package databaseManagement;

import vehicleManagement.Equipment;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EquipmentDB creates, deletes, and modifies data related to Equipment
 * @author Robin
 *
 */
public class EquipmentDB extends DatabaseManager{
	
	public EquipmentDB() {
		super();
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
	public void updateEquipmentStatus(Equipment e, int status){
		
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
	public Equipment[] searchAdditionalEquipments(String t, int branch_num) {
		
		// 1- Connect to the database
		super.connect();
		
		if (super.getConnection() == null)
		{
			return null;
		} else
		{
			try{
				Statement stmt = super.getConnection().createStatement();
				String query = "SELECT * FROM equipments WHERE location =" + branch_num +", eq_type" = t + ";" ;
				ResultSet rs = stmt.executeQuery(query);
				System.out.println(rs.getInt("serial_num"));
			} catch (SQLException e){
				System.err.println(e);
				return null;
			}
			
		}
	}

}
