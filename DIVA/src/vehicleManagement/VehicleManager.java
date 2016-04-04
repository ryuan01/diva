package vehicleManagement;


import java.sql.SQLException;
import java.util.Date;

import databaseManagement.DatabaseManager;
import systemManagement.Branch;
import paymentManagement.PaymentManager;

/**
 * 
 * A Vehicle Manager which manages the properties and operations of a vehicle. 
 *
 */

public class VehicleManager {
	
	private DatabaseManager db;
	
	public VehicleManager() {
		this.db = DatabaseManager.getInstance();
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
	 */
	public Vehicle[] searchForVehicle (int branch_id, Date start_date, Date end_date, String type) throws SQLException, IllegalArgumentException{
		//get list of vehicles
		Vehicle[] vlist = null;
		if (start_date.compareTo(new Date()) <= 0){
			throw new IllegalArgumentException("Start Date must be after today");
		}
		if (type.equals("car") || type.equals("truck")){
			vlist = db.search(branch_id, type, start_date);
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
	 */
	private void updatePrice(Vehicle[] vlist, String type, Date start_date, Date end_date) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		if (type.equals("car")){
			for (int i=0; i< vlist.length; i++){
				vlist[i].setPrice(PaymentManager.calculateCarPrice(((Car) vlist[i]).getCarClass(), start_date, end_date));
			}
		}
		else if (type.equals("truck")){
			for (int i=0; i< vlist.length; i++){
				vlist[i].setPrice(PaymentManager.calculateTruckPrice(((Truck) vlist[i]).getTruckClass(), start_date, end_date));
			}
		}
		else {
			throw new IllegalArgumentException("Type must be 'car' or 'truck'");
		}
	}

	public Vehicle[] searchForOverdue(int branch_id, String type){
		Vehicle[] vlist = null;
		vlist = db.search(branch_id, type);
		return vlist;
	}
	
	public Vehicle[] searchForSale(int branch_id, String type){
		Vehicle[] vlist = null;
		vlist = db.searchForSale(branch_id, type);
		return vlist;
	}
		
}