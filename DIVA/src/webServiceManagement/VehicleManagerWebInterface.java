package webServiceManagement;

import java.sql.SQLException;
import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import vehicleManagement.*;

/**
 * A WeService End Point who extends the services of the 
 * VehicleManager to remote users of the DIVA system.
 * @Author Alex Daniels
 * @version 1.0
 * @since March 30th, 2016
 */
@WebService
@Path("/vehicle")
public class VehicleManagerWebInterface {
	
	public VehicleManagerWebInterface() {}

	/**
	 * Web Interface for the "Search For Vehicles Available For Rent" Service
	 * @param end_date the day the customer wants to return the car
	 * @param branch_id the branch_id of branch that the customer wishes to pick up
	 * @param start_date the day the customer wishes to start the rental
	 * @param type from set (car, truck)
	 * @return A list of Stringified vehicle objects or a List with a single
	 * String describing the error that occurred (eg "Illegal Parameter" or "No Vehicles Match The Criteria")
	 */
	@WebMethod
	@POST
	@Produces("text/xml")
	@Consumes("text/xml")
	public String[] SearchVehiclesForRent(int branch_id, String start_date, String end_date, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;;
		
		try {
			//Create a VehicleManager and try to search for a list of vehicles
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForVehicle(branch_id, start_date, end_date, type);
			
			//Turn the array of vehicles into an array of strings it
			stringList =  WebToolkit.toArrayOfStrings(vehicleList);
		} 
		
		//If an exception is thrown while trying to search for vehicles
		//Determine exact error and add it to the 0th index of stringArray
		catch (IllegalArgumentException e) {
			stringList = new String[]{"UNIMPLEMENTED!"};
		} 
		catch (SQLException e) {
			stringList =  new String[]{"UNIMPLEMENTED!"};
		} 
		catch (ParseException e) {
			stringList =  new String[]{"UNIMPLEMENTED!"};
		}
		
		//Return the stringList
		return stringList;
	}
	
	/**
	 * Web Interface for the "Search for Overdue Vehicles" Service 
	 * @param end_date the day the customer wants to return the car
	 * @param branch_id the branch_id of branch that the customer wishes to pick up
	 * @param start_date the day the customer wishes to start the rental
	 * @param type from set (car, truck)
	 * @return A list of stringified vehicle objects or a List with a single
	 * String describing the error that occurred (eg "Illegal Parameter" or "No Vehicles Match The Criteria")
	 */
	@WebMethod
	@POST
	@Produces("text/xml")
	@Consumes("text/xml")
	public String[] searchForOverdueVehicles(int branch_id, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;

		try {
			
			//Make a VehicleManager and search for overdue 
			//vehicles at the given branch
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForOverdue(branch_id, type);
			
			//turn the vehicle list into a list of stringified vehicles
			stringList = WebToolkit.toArrayOfStrings(vehicleList);
		} 
		
		//If an error is thrown, Determine the exact cause of the error 
		//and add an error string to the 0th index of stringList
		catch (SQLException e) {
			stringList =  new String[]{"UNIMPLEMENTED!"};
		}
		
		//Return the stringList
		return stringList;
	
	}
	
	/**
	 * Search for vehicles for rent, can be truck or car 
	 * @param end_date the day the customer wants to return the car
	 * @param branch_id the branch_id of branch that the customer wishes to pick up
	 * @param start_date the day the customer wishes to start the rental
	 * @param type from set (car, truck)
	 * @return A list of stringified vehicle objects or a List with a single
	 * String describing the error that occurred (eg "Illegal Parameter" or "No Vehicles Match The Criteria")
	 */
	@WebMethod
	@POST
	@Produces("text/xml")
	@Consumes("text/xml")
	public String[] searchForSale(int branch_id, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;
		
		try {
			//Declare a VehicleManager search for a list of vehicles for sale
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForSale(branch_id, type);
			
			//Turn the list of vehicles into a list of stringified vehicles and store it in responseString
			stringList = WebToolkit.toArrayOfStrings(vehicleList);
		} 
		
		//If an exception is thrown, Determine the cause of the error 
		//and set the 0th index of stringList to the appropriate error message
		catch (SQLException e) {
			stringList =  new String[]{"UNIMPLEMENTED!"};
		}
		
		//Return the stringList
		return stringList;
	
	}
	
	/**
	 * Web Interface for the 'Add a new Car to the Database' Service
	 * @param manufacturer who made this car
	 * @param year year of purchase
	 * @param model model of car
	 * @param color color of car 
	 * @param status from set(for rent, for sale, sold)
	 * @param path relative path to a picture
	 * @param classOfCar class of car from set ('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van')
	 * @param baggage number of baggage a car can hold
	 * @param doors number of a door this car has
	 * @param transmition auto transmission or manual transmission
	 * @param airconditioning air conditioning or no air air conditioning
	 * @param capacity how many people this car can sit
	 * @return String describing the success of failure of the invocation
	 */
	public String addCar(String manufacturer, String year, String model, String color, String status, String path,
			String classOfCar, int baggage, String doors, boolean transmition, boolean airconditioning, int capacity) {
		
		//Declare responseString to hold the returned value
		String responseString = "Not Implemented";
	
		try {
			//Create a VehicleManager and try to add a new car based on the given arguments
			VehicleManager vm = new VehicleManager();
			vm.addCar(manufacturer, year, model, color, status, path, classOfCar, baggage, doors, transmition, airconditioning, capacity);
			responseString = "success";
		} 
		
		//If the VehicleManager throws an exception, 
		//set the 0th index of responseList to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "UNIMPLEMENTED!";
		} 
		catch (SQLException e) {
			responseString = "UNIMPLEMENTED!";
		}
		
		//Return the response String
		return responseString;
	}
	
	/**
	 * Web Interface for the 'Add a new Truck to the Database' Service
	 * @param manufacturer who made this car
	 * @param year year of purchase
	 * @param model model of car
	 * @param color color of car 
	 * @param status from set(for rent, for sale, sold)
	 * @param path relative path to a picture
	 * @param type The sub type of truck
	 * @param interiorLength interior Length in feet
	 * @param interiorWidth interior width in feet
	 * @param interiorHeight height in feet 
	 * @param maxCapacityInKG maximum kg that a truck can hold
	 * @return A String describing the success of failure of the invocation
	 */
	public String addTruck(String manufacturer, String year, String model, String color, String status, String path,
			String type, String interiorLength, String interiorWidth, String interiorHeight, int maxCapacityInKG) {
		
		//Declare variables to hold the response text
		String responseString;
				
		//Create a VehicleManager and try to add a new car based on the given arguments
		try {
			VehicleManager vm = new VehicleManager();
			vm.addTruck(manufacturer, year, model, color, status, path,
					type, interiorLength, interiorWidth, interiorHeight, maxCapacityInKG);
			responseString = "success";
		} 
				
		//If the VehicleManager throws an exception, set the responseText
		//to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "Not Implemented";
		} 
		catch (SQLException e) {
			responseString = "Not Implemented";		
		}
				
		//return the responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the 'Change Vehicle's Owning Branch' Service
	 * @param vehicleID The vehcileID of the vehicle whose branchID you wish to change
	 * @param branchID the branchID of the new owning branch of the vehicle passed as an argument
	 * @return A string describing the success of the invocation
	 */
	public String changeVehicleBranch(int vehicleID, int branchID) {
		//Declare variables to hold the response text 
		String responseString = "Not Implemented";
	
		try {
			//Create a vehicleManager and try to modify the branchID of the vehicle
			VehicleManager vm = new VehicleManager();
			vm.changeVehicleBranch(vehicleID, branchID);
			
			//Set the response String to success
			responseString = "Success";
		} 
		
		//If the VehicleManager throws an exception, set the 
		//responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Not Implemented";
		}		
		
		//return the responseString
		return responseString;
	}

	/**
	 * Web Interface for the "Change the State of a Vehicle" Service
	 * @param vehicleID The vehcileID of the vehicle whose branchID you wish to change
	 * @param newState The state the given vehicle should be changed to
	 * @return A string describing the success or failure of invocation
	 */
	public String changeVehicleState(int vehicleID, String newState) {
		
		//Declare variables to hold the response text
		String responseString;
		
		try {
			//Create a vehicle manager
			VehicleManager vm = new VehicleManager();
			
			//Change the state of the given given vehicle to the given state
			vm.changeVehicleState(vehicleID, newState);
			
			//Set the response string to success
			responseString = "success";
		} 
				
		//If the VehicleManager throws an exception, set the
		//responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Not Implemented";
		}		
		
		//return the responseString
		return responseString;
	}
}
