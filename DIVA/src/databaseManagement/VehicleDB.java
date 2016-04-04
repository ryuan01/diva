package databaseManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/* Robin */
/**
 * VehicleDB creates, deletes, and modifies data related to Vehicle. 
 * @author Robin
 *
 */
class VehicleDB {
	
	VehicleDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * updateVehicleLocation updates the branch that the vehicle belongs to
	 * @param v vehicle
	 * @param b branch
	 * @pre isValidVehicle(v)
	 * @pre isValidBranch(b)
	 * @post v.branch = b
	 */
	void updateVehicleLocation(String v_key_value, String b_key_value){
		
	}
	

	/**
	 * updateVehicleStatus updates the status of an vehicle
	 * @param v vehicle
	 * @param status status {reserved, rented, damaged, available, sold}
	 * @pre isValidVehicle(v)
	 * @pre status is one of {reserved, rented, damaged, available, sold}
	 * @post v.status = status
	 */
	void updateVehicleStatus(String v_key_value, int status){
		
	}
	
	//create
	/**
	 * addVehicle creates an new entry in TABLE VEHICLE
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post a new entry in TABLE VEHICLE
	 */
	void addVehicle(Vehicle v) {
	}
	//need to confirm with whoever is doing rental to see the list

	/**
	 * Generic search searches a list of cars available for rental in a specific branch starting specific day
	 * @param c
	 * @param branch_id
	 * @param type
	 * @param start_date
	 * @param list
	 * @throws SQLException happens when the query didn't complete 
	 * @return
	 */
	Vehicle[] search(int branch_id, String type, Date start_date) throws SQLException{
		//create an arraylist to hold the result
  		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
  		
  		//convert date to SQL type
  		java.sql.Date sqlDate = new java.sql.Date(start_date.getTime());
  		
  		//type will decide which table to combine with 
        Statement stmt = c.createStatement();

        String query = "SELECT * FROM " 
        		+type+" INNER JOIN branch_vehicle  ON "
        		+type+".vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +type+".vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +Integer.parseInt(branch_id)
        		+" AND sale_status = 'for rent' "
        	    +" AND "+type+".vehicle_id NOT IN "
        	    +"(SELECT "+type+".vehicle_id FROM " 
        	    +type+" INNER JOIN rental ON "+type+".vehicle_id = rental.vehicle_id "
        	    +" WHERE rental.end_date >= "
        	    +sqlDate+");";
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to list of branches
        while (rs.next()){
        	
        	//type isn't in database, need to be updated
        	//features isn't in database
        	
        	int id = rs.getInt("serial_num");
        	int location = rs.getInt("location");
        	String license_plate = rs.getString("license_plate_number");
        	String manufacturer = rs.getString("manufacturer");
        	String year_model = rs.getString("year_model");
        	String color = rs.getString("color");
        	String status = rs.getString("sale_status");
        	int capacity = rs.getInt("capacity");
        	
        	//need two helper methods: one for car, one for truck
        	//need to separate database for car types and truck types
        	Vehicle v = new Car(id, String.valueOf(location), capacity, "economy", manufacturer, year_model, color, status, "No feature available");
        	vlist.add(v);
        }
        
        //clean up
        rs.close();
        stmt.close();
        
        //change back to array
        Vehicle[] vArray = new Car[vlist.size()];
        vArray = vlist.toArray(vArray);
        
        return vArray;
  	}
	
	/**
	 * searchCars searches a list of cars in a specific branch for-sale
	 * @param branch_id a branch
	 * @pre branch must be valid 
	 * @post list of cars matching for sale
	 */	
	Car[] searchForsaleCars(int branch_id) {
		return null;
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch for-sale
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of trucks matching for sale 
	 */	
	Truck[] searchForsaleTrucks(int branch) {
		return null;
	}

	/**
	 * searchCars searches a list of cars in a specific branch overdue
	 * @param branch_id a branch
	 * @pre branch must be valid 
	 * @post list of cars matching overdue 
	 */	
	Car[] searchOverdueCars(int branch_id) {
		return null;
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch overdue
	 * @param branch a branch
	 * @pre branch must be valid 
	 * @post list of trucks matching overdue
	 */	
	Truck[] searchOverdueTrucks(int branch) {
		return null;
	}	

	//Alex can you propagate this change?
	//Actually I think this whole method should be inside Vehicle class
	//because it is a getter.
	//so getting vehicles by searching them will load a Vehicle object
	//and calling v.status will return status? 
	/**
	 * getVehicleStatus gets the status of a vehicle
	 * status can be {reserved, rented, sold, damanged, available}
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post vehicle status is returned
	 */
	String getvehiclestatus(String v_key_value) {
		return null;
	}

}
