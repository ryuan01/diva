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
	
	ConnectDB dbm;
	
	
	VehicleDB() {
		// TODO Auto-generated constructor stub
		dbm = new ConnectDB();
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
	 * @param end_date 
	 * @param list
	 * @throws SQLException happens when the query didn't complete 
	 * @return
	 */
	Vehicle[] search(int branch_id, String type, String start_date, String end_date) throws SQLException{
		//create an arraylist to hold the result
  		
  		Vehicle[] vArray;
  		
  		dbm.connect();
  		if (type.equals("car")){
  			vArray = getCars(branch_id, start_date,end_date);
  		}
  		else if (type.equals("truck")){
  			vArray = getTrucks(branch_id,start_date,end_date);
  		}
  		else {
  			throw new IllegalArgumentException("Type can only be 'car' or 'truck'");
  		}
        dbm.disconnect();
        
        return vArray;
  	}
	
	private Vehicle[] getTrucks(int branch_id, String start_date, String end_date) throws SQLException{
		// TODO Auto-generated method stub
  		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
  		
  		Statement stmt = dbm.getConnection().createStatement();

        String query = "SELECT * FROM truck" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"truck.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"truck.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for rent'"
        		+" AND truck.vehicle_id NOT IN "
        		+"(SELECT truck.vehicle_id FROM truck INNER JOIN rental "
        		+" ON truck.vehicle_id = rental.vehicle_id" 
        		+" WHERE rental.end_date >= \'"+start_date+"\'"
        		+" AND rental.start_date < \'"+end_date+"\');";
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to list of branches
        while (rs.next()){
        	
        	//type isn't in database, need to be updated
        	//features isn't in database
        	
        	int id = rs.getInt("vehicle_id");
        	String v_class = rs.getString("class");
        	double bl = rs.getDouble("interior_b_l");
        	double bw = rs.getDouble("interior_b_w");
        	double bh = rs.getDouble("interior_b_h");
        	int capacity = rs.getInt("capacity_kg");
        	String manufacturer = rs.getString("manufacturer");
        	Date v_year = rs.getDate("v_year");
        	String model = rs.getString("model");
        	String color = rs.getString("color");
        	String status = rs.getString("sale_status");
        	String path = rs.getString("path");
        	
        	Truck t = new Truck(id, manufacturer, v_year, model, color, status, path,
        			v_class, bl,bw,bh,capacity);
        	vlist.add(t);
        }
        
        //clean up
        rs.close();
        stmt.close();	
        
        //change back to array
        Vehicle[] vArray = new Truck[vlist.size()];
        vArray = vlist.toArray(vArray);
        return vArray;
	}

	private Vehicle[] getCars(int branch_id, String start_date, String end_date) throws SQLException {
		// TODO Auto-generated method stub
  		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
  		Statement stmt = dbm.getConnection().createStatement();

        String query = "SELECT * FROM car" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"car.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"car.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for rent'"
        		+" AND car.vehicle_id NOT IN "
        		+"(SELECT car.vehicle_id FROM car INNER JOIN rental "
        		+" ON car.vehicle_id = rental.vehicle_id" 
        		+" WHERE rental.end_date >= \'"+start_date+"\'"
        		+" AND rental.start_date < \'"+end_date+"\');";
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to list of branches
        while (rs.next()){
        	
        	//type isn't in database, need to be updated
        	//features isn't in database
        	
        	int id = rs.getInt("vehicle_id");
        	String v_class = rs.getString("class");
        	int baggage = rs.getInt("baggage");
        	String door = rs.getString("door");
        	boolean transmission = rs.getBoolean("transmission");
        	boolean air_condition = rs.getBoolean("air_condition");
        	int capacity = rs.getInt("capacity");
        	int location = rs.getInt("location");
        	String manufacturer = rs.getString("manufacturer");
        	Date v_year = rs.getDate("v_year");
        	String model = rs.getString("model");
        	String color = rs.getString("color");
        	String status = rs.getString("sale_status");
        	String path = rs.getString("path");
        	
        	//need two helper methods: one for car, one for truck
        	//need to separate database for car types and truck types
        	Car c = new Car(id, manufacturer, v_year, model, color, status, path,
        			v_class, baggage, door, transmission, air_condition, capacity);
        	vlist.add(c);
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
