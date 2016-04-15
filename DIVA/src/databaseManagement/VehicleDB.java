package databaseManagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
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
	
	private ConnectDB dbm;
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
	
	VehicleDB() {
		// TODO Auto-generated constructor stub
		dbm = new ConnectDB();
	}

	/**
	 * updateVehicleLocation updates the branch that the vehicle belongs to
	 * @param v vehicle
	 * @param b branch
	 * @throws SQLException 
	 * @pre isValidVehicle(v)
	 * @pre isValidBranch(b)
	 * @post v.branch = b
	 */
	void updateVehicleLocation(int v_key_value, int b_key_value) throws SQLException{
		dbm.connect();
		Statement stmt = dbm.getConnection().createStatement();

        String query = "UPDATE `branch_vehicle` SET `location`= " 
        		+b_key_value+" WHERE `vehicle_id` = "+v_key_value+";";
        stmt.executeUpdate(query);
        stmt.close();	

		dbm.disconnect();
		
	}
	
	void addVehicleLocation(int v_key_value, int b_key_value) throws SQLException{
		dbm.connect();
		Statement stmt = dbm.getConnection().createStatement();

        String query = "INSERT INTO `branch_vehicle` VALUES (" + v_key_value +", "+b_key_value+")";
        stmt.executeUpdate(query);
        stmt.close();	

		dbm.disconnect();
	}
	

	/**
	 * updateVehicleStatus updates the status of an vehicle
	 * @param v vehicle
	 * @param status status {for rent, for sale, sold}
	 * @throws SQLException 
	 * @pre isValidVehicle(v)
	 * @pre status is one of {for rent, for sale, sold}
	 * @post v.status = status
	 */
	void updateVehicleStatus(int v_key_value, String status) throws SQLException{
		dbm.connect();
		Statement stmt = dbm.getConnection().createStatement();

        String query = "UPDATE `vehicle` SET `sale_status` = \'" 
        		+status+"\' WHERE `vehicle_id` = "+v_key_value+";";
        stmt.executeUpdate(query);
        stmt.close();	

		dbm.disconnect();
	}
	
	//create
	/**
	 * addVehicle creates an new entry in TABLE VEHICLE
	 * @param v vehicle
	 * @throws SQLException 
	 * @pre isValidVehicle(v)
	 * @post a new entry in TABLE VEHICLE
	 */
	void addCar(Car v) throws SQLException {
		//add to vehicle
		addVehicle(v);
		//add to car after
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
        String query = "INSERT INTO `car`(`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`)"
        		+" VALUES ("+v.getID()+", \'"+v.getVehicleClass()+"\', "+v.getBaggage()
        		+", \'"+v.getDoor()+"\', "+(v.getTransmission()? 1: 0)+", "
        		+(v.getAC()? 1:0)+", "+v.getCapacity()+");";
       // System.out.println(query);
	    stmt.executeUpdate(query);
	    stmt.close();
	    dbm.disconnect();
	}


	void addTruck(Truck v) throws SQLException {
		//add to vehicle
		addVehicle(v);
		//add to truck after 
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
        String query = "INSERT INTO `truck`(`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`)"
        		+" VALUES ("+v.getID()+", \'"+v.getVehicleClass()+"\', "+new BigDecimal(v.getBL())
        		+", "+new BigDecimal(v.getBW())+", "+new BigDecimal(v.getBH())+", "+v.getCapacity()+");";
        //System.out.println(query);
	    stmt.executeUpdate(query);
	    stmt.close();
	    dbm.disconnect();		
	}
	
	/**
	 * Add vehicle entry to table vehicle
	 * @param v vehicle object
	 * @pre v.id is -1
	 * @pre update v.id 
	 * @throws SQLException
	 */
	private void addVehicle(Vehicle v) throws SQLException{
		//check if id should be auto increment or already exist
		
		//add the entry
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		String query = "INSERT INTO `vehicle`(`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`)";
  		//id isn't set 
  		if (v.getID() == -1){
        	query +=" VALUES (NULL, ";
  		}
  		else{ // id is set 
  			query +=" VALUES ( "+v.getID()+", ";
  		}
  		query += "\'"+v.getManufacturer()+"\', \'"+v.getYear()+"\', \'"+v.getModel()+"\', \'"+v.getColor()+"\', \'"+v.getStatus()+"\', \'"+v.getPath()+"\');";
  		System.out.println(query);
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        
        //the following is used when there is auto generated key
        ResultSet rs=stmt.getGeneratedKeys();
        if (rs.next()) {
           v.setID(rs.getInt(1)); 
        }
        
        //clean up
        stmt.close();
        dbm.disconnect();
	}

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
  		
  		if (type.equals("car")){
  			vArray = getCars(branch_id, start_date,end_date);
  		}
  		else if (type.equals("truck")){
  			vArray = getTrucks(branch_id,start_date,end_date);
  		}
  		else {
  			throw new IllegalArgumentException("Type can only be 'car' or 'truck'");
  		}
        
        return vArray;
  	}
	
	private Vehicle[] getTrucks(int branch_id, String start_date, String end_date) throws SQLException{
		// TODO Auto-generated method stub
        String query = "SELECT * FROM truck" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"truck.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"truck.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for rent'"
        		+" AND truck.vehicle_id NOT IN "
        		+"(SELECT truck.vehicle_id FROM truck INNER JOIN reservation "
        		+" ON truck.vehicle_id = reservation.vehicle_id" 
        		+" WHERE reservation.end_date >= \'"+start_date+"\'"
        		+" AND reservation.start_date < \'"+end_date+"\');";
        return executeQueryTruck(query);
	}

	/**
	 * Helper for returning a list of Trucks
	 * @param query SQL for searching some criteria of trucks
	 * @return list of trucks matching that criteria
	 * @throws SQLException
	 */
	private Vehicle[] executeQueryTruck(String query) throws SQLException {
		// TODO Auto-generated method stub
  		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
  		
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to list of branches
        while (rs.next()){
        	
        	//type isn't in database, need to be updated
        	//features isn't in database
        	
        	int id = rs.getInt("vehicle_id");
        	String v_class = rs.getString("class");
        	BigDecimal bl = rs.getBigDecimal("interior_b_l");
        	BigDecimal bw = rs.getBigDecimal("interior_b_w");
        	BigDecimal bh = rs.getBigDecimal("interior_b_h");
        	int capacity = rs.getInt("capacity_kg");
        	String manufacturer = rs.getString("manufacturer");
        	String v_year = df.format(rs.getDate("v_year"));
        	String model = rs.getString("model");
        	String color = rs.getString("color");
        	String status = rs.getString("sale_status");
        	String path = rs.getString("path");
        	
        	Truck t = new Truck(id, manufacturer, v_year, model, color, status, path,
        			v_class, bl.toString(),bw.toString(),bh.toString(),capacity);
        	vlist.add(t);
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        //change back to array
        Vehicle[] vArray = new Truck[vlist.size()];
        vArray = vlist.toArray(vArray);
        return vArray;
	}

	/**
	 * 
	 * @param branch_id
	 * @param start_date
	 * @param end_date
	 * @return
	 * @throws SQLException
	 */
	private Vehicle[] getCars(int branch_id, String start_date, String end_date) throws SQLException {
		// TODO Auto-generated method stub
        String query = "SELECT * FROM car" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"car.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"car.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for rent'"
        		+" AND car.vehicle_id NOT IN "
        		+"(SELECT car.vehicle_id FROM car INNER JOIN reservation "
        		+" ON car.vehicle_id = reservation.vehicle_id" 
        		+" WHERE reservation.end_date >= \'"+start_date+"\'"
        		+" AND reservation.start_date < \'"+end_date+"\');";
        return executeQueryCar(query);
	}

	/**
	 * Helper for returning list of cars (happens often so grouped together)
	 * @param query SQL for wanting a list of cars with desirable attributes
	 * @return
	 * @throws SQLException 
	 */
	private Vehicle[] executeQueryCar(String query) throws SQLException {
		// TODO Auto-generated method stub
  		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        //parse result and add to list of vehicles
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
        	String manufacturer = rs.getString("manufacturer");
        	String v_year = df.format(rs.getDate("v_year"));
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
        dbm.disconnect();
        
        
        //change back to array
        Vehicle[] vArray = new Car[vlist.size()];
        vArray = vlist.toArray(vArray);
        return vArray;
	}

	/**
	 * searchCars searches a list of cars in a specific branch for-sale
	 * @param branch_id a branch
	 * @throws SQLException 
	 * @pre branch must be valid 
	 * @post list of cars matching for sale
	 */	
	Vehicle[] searchForsaleCars(int branch_id) throws SQLException {
		// TODO Auto-generated method stub
        String query = "SELECT * FROM car" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"car.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"car.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for sale'";
		return executeQueryCar(query);
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch for-sale
	 * @param branch a branch
	 * @throws SQLException 
	 * @pre branch must be valid 
	 * @post list of trucks matching for sale 
	 */	
	Vehicle[] searchForsaleTrucks(int branch_id) throws SQLException {
        String query = "SELECT * FROM truck" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"truck.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"truck.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    + branch_id
        		+" AND sale_status = 'for sale'";
        return executeQueryTruck(query);
	}

	/**
	 * searchCars searches a list of cars in a specific branch overdue
	 * @param branch_id a branch
	 * @throws SQLException 
	 * @pre branch must be valid 
	 * @post list of cars matching overdue 
	 */	
	Vehicle[] searchOverdueCars(int branch_id) throws SQLException {
		
		String current_date = df.format(new java.util.Date());
        String query = "SELECT * FROM car" 
        		+" INNER JOIN branch_vehicle  ON "
        		+"car.vehicle_id = branch_vehicle.vehicle_id " 
        	    +" INNER JOIN vehicle ON "
        	    +"car.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    +branch_id
        		+" AND sale_status = 'for rent'"
        		+" AND car.vehicle_id IN "
        		+"(SELECT vehicle_id FROM (SELECT car.vehicle_id, car.class, car.baggage, car.door, car.transmission, car.air_condition, car.capacity, "
        		+ " reservation.customer, reservation.start_date, reservation.end_date, reservation.start_branch, reservation.end_branch, reservation.balance, "
        		+" rental.is_paid_rental, rental.is_paid_extra_charge "
        		+" FROM car INNER JOIN reservation "
        		+" ON car.vehicle_id = reservation.vehicle_id "
				+" INNER JOIN rental "
        		+" ON rental.reservation_id = reservation.reservation_id) tmpTable"
        		+" WHERE tmpTable.end_date < \'"+current_date+"\'"
        		+");";
        return executeQueryCar(query);
	}
	
	/**
	 * searchTrucks searches a list of trucks in a specific branch overdue
	 * @param branch a branch
	 * @throws SQLException 
	 * @pre branch must be valid 
	 * @post list of trucks matching overdue
	 */	
	Vehicle[] searchOverdueTrucks(int branch_id) throws SQLException {
		
		String current_date = df.format(new java.util.Date());
        String query = "SELECT * FROM truck"
        		+" INNER JOIN branch_vehicle  ON "
        		+" truck.vehicle_id = branch_vehicle.vehicle_id "
        	    +" INNER JOIN vehicle ON "
        	    +" truck.vehicle_id = vehicle.vehicle_id AND "
        		+" branch_vehicle.location = "
        	    + branch_id
        		+" AND sale_status = 'for rent' "
        		+" AND truck.vehicle_id "
				+" IN "
				+" (SELECT vehicle_id FROM (SELECT truck.vehicle_id, truck.class, truck.interior_b_l, truck.interior_b_w, truck.interior_b_h, truck.capacity_kg , "
				+" reservation.customer, reservation.start_date, reservation.end_date, reservation.start_branch, reservation.end_branch, reservation.balance, "
				+" rental.is_paid_rental, rental.is_paid_extra_charge "
				+" FROM truck INNER JOIN reservation "
        		+" ON truck.vehicle_id = reservation.vehicle_id "
				+" INNER JOIN rental "
        		+" ON rental.reservation_id = reservation.reservation_id) tmpTable "
        		+" WHERE tmpTable.end_date < \'"+current_date+"\');";
        return executeQueryTruck(query);
	}

	/**
	 * Helper to remove vehicle from 'vehicle' table after it is no longer a foreign constraint
	 * @pre always called inside removeCar or removeTruck
	 * @param vehicle_id
	 * @throws SQLException 
	 */
	private void removeVehicle(int vehicle_id) throws SQLException {
		// TODO Auto-generated method stub
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
		String query = "DELETE FROM `vehicle` WHERE `vehicle_id` = "+vehicle_id;
	    stmt.executeUpdate(query);
	    
	    stmt.close();
	    dbm.disconnect();
	}

	/**
	 * Delete car from car table 
	 * @param vehicle_id
	 * @throws SQLException
	 */
	void removeCar(int vehicle_id) throws SQLException {
		// TODO Auto-generated method stub
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
		String query = "DELETE FROM `car` WHERE `vehicle_id` = "+vehicle_id;
	    stmt.executeUpdate(query);
	    
	    //remove from 'vehicle as well'
	    removeVehicle(vehicle_id);
	    
	    stmt.close();
	    dbm.disconnect();
	}

	/**
	 * 
	 * @param vehicle_id
	 * @throws SQLException
	 */
	void removeTruck(int vehicle_id) throws SQLException {
		// TODO Auto-generated method stub
  		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
		String query = "DELETE FROM `truck` WHERE `vehicle_id` = "+vehicle_id;
	    stmt.executeUpdate(query);
	    
	    //remove from 'vehicle as well'
	    removeVehicle(vehicle_id);
	    
	    stmt.close();
	    dbm.disconnect();		
	}
	 /**
	  * Search for an vehicle according to its ID
	  * @param vehicle_id
	  * @return
	 * @throws SQLException 
	  */
	 Vehicle search(int vehicle_id) throws SQLException {
		// TODO Auto-generated method stub
		 //System.out.println(vehicle_id);
		 String query; 
		//is this a truck or car
		if (isTruck(vehicle_id)){
			query = " SELECT *"
					+"FROM  `truck` INNER JOIN `vehicle` WHERE  vehicle.vehicle_id = " +vehicle_id;
			Truck[] trucks = (Truck[]) executeQueryTruck(query);
			return trucks[0];
		}
		else { // this is a truck
			query = " SELECT *"
					+"FROM `car` INNER JOIN `vehicle` WHERE vehicle.vehicle_id = "+ vehicle_id;
			Car[] cars = (Car[]) executeQueryCar(query);
			return cars[0];
		}
	}

	private boolean isTruck(int vehicle_id) throws SQLException {
		// TODO Auto-generated method stub
 		dbm.connect();
  		Statement stmt = dbm.getConnection().createStatement();
  		String query  = "SELECT `vehicle_id` from truck WHERE `vehicle_id` = "+ vehicle_id;
        ResultSet rs = stmt.executeQuery(query);
        //if there is any rs
        if (rs.next()){
            rs.close();
            stmt.close();	
            dbm.disconnect();
        	return true;
        }
        rs.close();
        stmt.close();	
        dbm.disconnect();
		return false;
	}	

	
	/**
	 * getVehicleStatus gets the status of a vehicle
	 * status can be {reserved, rented, sold, damanged, available}
	 * @param v vehicle
	 * @pre isValidVehicle(v)
	 * @post vehicle status is returned
	 */
	/* not relevant anymore, because vehicle state is implicit to reservation
	 * maybe version 2.0 add this feature
	String getvehiclestatus(String v_key_value) {
		return null;
	}*/

}
