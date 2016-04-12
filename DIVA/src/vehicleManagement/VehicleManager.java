package vehicleManagement;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;

/**
 * 
 * A Vehicle Manager which manages the properties and operations of a vehicle. 
 *
 */

public class VehicleManager {
	
	private DatabaseManager db;
	private PaymentManager pm;
	
	public VehicleManager() {
		this.db = DatabaseManager.getInstance();
		this.pm = new PaymentManager();
	}
	
	/**
	 * Search for vehicles for rent, can be truck or car 
	 * @param branch_id the branch_id of branch that the customer wishes to pick up
	 * @param start_date the day the customer wishes to start the rental
	 * @param type from set (car, truck)
	 * @return list of vehicles available in that branch
	 * @pre start_date > new Date()
	 * @pre type is from (car, truck)
	 * @post list of vehicles available at that branch
	 * @throws SQLException searching illegal type
	 * @throws IllegalArgumentException searching illegal type, or illegal date
	 * @throws ParseException 
	 */
	public Vehicle[] searchForVehicle (int branch_id, String start_date, String end_date, String type) throws SQLException, IllegalArgumentException, ParseException{
		//get list of vehicles
		Vehicle[] vlist = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (sdf.parse(start_date).after(sdf.parse(end_date))){
			throw new IllegalArgumentException("Start Date must be after today");
		}
		if (type.equals("car") || type.equals("truck")){
			vlist = db.search(branch_id, type, start_date, end_date);
		}
		else {
			throw new IllegalArgumentException("Type must be 'car' or 'truck'");
		}
		//update their prices
		updatePrice(vlist,type,start_date,end_date);
		return vlist;
	}
	
	/**
	 * Helper to calculate rental price based on date ranges and type
	 * @param vlist
	 * @param type
	 * @param start_date
	 * @param end_date
	 * @throws IllegalArgumentException
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	private void updatePrice(Vehicle[] vlist, String type, String start_date, String end_date) throws IllegalArgumentException, ParseException, SQLException{
		// TODO Auto-generated method stub
		pm.populatePriceList();
		if (type.equals("car")){
			for (int i=0; i< vlist.length; i++){
				//System.out.printf("inputs in udatePrice: %s %s %s\n", ((Car) vlist[i]).getCarClass(), start_date, end_date);
				BigDecimal n = pm.calculateCarPrice(((Car) vlist[i]).getCarClass(), start_date, end_date);
				//System.out.println("price is : " + n);
				vlist[i].setPrice(n);
			}
		}
		else if (type.equals("truck")){
			for (int i=0; i< vlist.length; i++){
				vlist[i].setPrice(pm.calculateTruckPrice(((Truck) vlist[i]).getTruckClass(), start_date, end_date));
			}
		}
		else {
			throw new IllegalArgumentException("Type must be 'car' or 'truck'");
		}
	}

	/**
	 * 
	 * @param branch_id
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public Vehicle[] searchForOverdue(int branch_id, String type) throws SQLException{
		Vehicle[] vlist = null;
		vlist = db.search(branch_id, type);
		return vlist;
	}
	
	/**
	 * 
	 * @param branch_id
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public Vehicle[] searchForSale(int branch_id, String type) throws SQLException{
		Vehicle[] vlist = null;
		vlist = db.searchForSale(branch_id, type);
		return vlist;
	}
	
	/**
	 * Add a car and assign a branch to it 
	 * @param id
	 * @param manufacturer
	 * @param year
	 * @param model
	 * @param color
	 * @param status
	 * @param path
	 * @param c
	 * @param b
	 * @param d
	 * @param tran
	 * @param ac
	 * @param ca
	 * @throws SQLException 
	 * @throws IllegalArgumentException 
	 */
	public void addCar(String manufacturer, String year, String model, String color, String status, String path,
			String c, int b, String d, boolean tran, boolean ac, int ca, int branch_id) throws IllegalArgumentException, SQLException{
		int id = -1; //let database auto increment id 
		Car a_car = new Car (id, manufacturer, year, model, color, status, path,c, b, d, tran,ac, ca);
		db.addVehicle(a_car);
		db.addVehicleLocation(a_car.getID(), branch_id);
	}
	
	/**
	 * 
	 * @param id
	 * @param manufacturer
	 * @param year
	 * @param model
	 * @param color
	 * @param status
	 * @param path
	 * @param c
	 * @param ibl
	 * @param ibw
	 * @param ibh
	 * @param ca
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public void addTruck(String manufacturer, String year, String model, String color, String status, String path,
			String c, String ibl, String ibw, String ibh, int ca, int branch_id) throws IllegalArgumentException, SQLException{
		int id = -1; //let database auto increment id 
		Truck truck = new Truck (id, manufacturer, year, model, color, status, path,  c, ibl, ibw, ibh, ca);
		db.addVehicle(truck);
		db.addVehicleLocation(truck.getID(), branch_id);
	}
	
	//remove
	public void removeCar(int vehicle_id) throws SQLException{
		db.removeVehicle(vehicle_id,"car");
	}
	
	public void removeTruck(int vehicle_id) throws SQLException{
		db.removeVehicle(vehicle_id, "truck");
	}

	/**
	 * Update the state of a vehicle
	 * @param v vehicle_id
	 * @param status from set {for sale, for rent, sold, damaged}
	 * @throws SQLException
	 */
	public void changeVehicleState(int v, String status) throws SQLException{
		db.updateVehicleStatus(v, status);
	}
	
	// vehicle branch change
	/**
	 * Update the owning branch of a vehicle
	 * @param v vehicle_id
	 * @param b branch_id
	 * @throws SQLException
	 */
	public void changeVehicleBranch(int v, int b) throws SQLException{
		db.updateVehicleLocation(v, b);
	}
}