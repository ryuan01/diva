package webServiceManagement;

import java.sql.SQLException;
import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import vehicleManagement.*;

/**
 * A WeService End Point who extends the services of the 
 * VehicleManager to remote users of the DIVA system.
 * @Author Alex Daniels
 * @version 1.0
 * @since March 30th, 2016
 */
@WebService
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
	public String[] SearchVehiclesForRent(int branch_id, String start_date, String end_date, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;;
		
		try {
			//Create a VehicleManager and try to search for a list of vehicles
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForVehicle(branch_id, start_date, end_date, type);
			
			//Turn the array of vehicles into an array of strings it
			WebToolkit wtk = new WebToolkit();
			stringList = wtk.toArrayOfStrings(vehicleList);
		} 
		
		//If an exception is thrown while trying to search for vehicles
		//Determine exact error and add it to the 0th index of stringArray
		catch (IllegalArgumentException e) {
			stringList = new String[]{"Exception - " + e.getMessage()};
		} 
		catch (SQLException e) {
			stringList =  new String[]{"Exception - " + e.getMessage()};
		} 
		catch (ParseException e) {
			stringList =  new String[]{"Exception - " + e.getMessage()};
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
	public String[] searchForOverdueVehicles(int branch_id, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;

		try {
			
			//Make a VehicleManager and search for overdue 
			//vehicles at the given branch
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForOverdue(branch_id, type);
			
			//turn the vehicle list into a list of stringified vehicles
			WebToolkit wtk = new WebToolkit();
			stringList = wtk.toArrayOfStrings(vehicleList);
		} 
		
		//If an error is thrown, Determine the exact cause of the error 
		//and add an error string to the 0th index of stringList
		catch (SQLException e) {
			stringList =  new String[]{"Exception - " + e.getMessage()};
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
	public String[] searchForSale(int branch_id, String type) {
	
		//Declare a list of strings that will be returned to the user
		String[] stringList;
		
		try {
			//Declare a VehicleManager search for a list of vehicles for sale
			VehicleManager vm = new VehicleManager();
			Vehicle[] vehicleList = vm.searchForSale(branch_id, type);
			
			//Turn the list of vehicles into a list of stringified vehicles and store it in responseString
			WebToolkit wtk = new WebToolkit();
			stringList = wtk.toArrayOfStrings(vehicleList);
		} 
		
		//If an exception is thrown, Determine the cause of the error 
		//and set the 0th index of stringList to the appropriate error message
		catch (SQLException e) {
			stringList = new String[]{"Exception - " + e.getMessage()};
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
	 * @param branchID of the branch that will own this vehicle
	 * @return String describing the success of failure of the invocation
	 */
	@WebMethod
	public String addCar(String manufacturer, String year, String model, String color, String status, String path,
			String classOfCar, int baggage, String doors, boolean transmition, boolean airconditioning, int capacity, int branchID) {
		
		//Declare responseString to hold the returned value
		String responseString;
	
		try {
			//Create a VehicleManager and try to add a new car based on the given arguments
			VehicleManager vm = new VehicleManager();
			vm.addCar(manufacturer, year, model, color, status, path, classOfCar, baggage, doors, transmition, airconditioning, capacity, branchID);
			responseString = "success";
		} 
		
		//If the VehicleManager throws an exception, 
		//set the 0th index of responseList to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "Exception - " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
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
	 * @param branchID of the branch that will own this vehicle
	 * @return A String describing the success of failure of the invocation
	 */
	@WebMethod
	public String addTruck(String manufacturer, String year, String model, String color, String status, String path,
			String type, String interiorLength, String interiorWidth, String interiorHeight, int maxCapacityInKG, int branchID) {
		
		//Declare variables to hold the response text
		String responseString;
				
		//Create a VehicleManager and try to add a new car based on the given arguments
		try {
			VehicleManager vm = new VehicleManager();
			vm.addTruck(manufacturer, year, model, color, status, path,
					type, interiorLength, interiorWidth, interiorHeight, maxCapacityInKG, branchID);
			responseString = "success";
		} 
				
		//If the VehicleManager throws an exception, set the responseText
		//to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "Exception - " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();		
		}
				
		//return the responseString
		return responseString;
	}
	
	/**
	 *Web Interface for the 'Delete a new car from the Database' Service
	 * @param vehicleID The ID of the vehicle the caller wishes to remove from the database
	 * @return A string describing the success of the invocation
	 */
	public String removeCar(int vehicleID) {
		//Declare variables to hold the response text
		String responseString;
						
		try {
			//Create a VehicleManager and try to remove the given car 
			VehicleManager vm = new VehicleManager();
			vm.removeCar(vehicleID);
			responseString = "success";
		} 
						
		//If the VehicleManager throws an exception, set the responseText
		//to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "Exception - " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();		
		}
						
		//return the responseString
		return responseString;
	}
	
	/**
	 *Web Interface for the 'Delete a new truck from the Database' Service
	 * @param vehicleID The ID of the vehicle the caller wishes to remove from the database
	 * @return A string describing the success of the invocation
	 */
	public String removeTruck(int vehicleID) {
		//Declare variables to hold the response text
		String responseString;
						
		try {
			//Create a VehicleManager and try to remove the given car 
			VehicleManager vm = new VehicleManager();
			vm.removeTruck(vehicleID);
			responseString = "success";
		} 
						
		//If the VehicleManager throws an exception, set the responseText
		//to the appropriate error message
		catch (IllegalArgumentException e) {
			responseString = "Exception - " + e.getMessage();
		} 
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();		
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
		String responseString;
	
		try {
			//Create a vehicleManager and try to modify the branchID of the vehicle
			VehicleManager vm = new VehicleManager();
			vm.changeVehicleBranch(vehicleID, branchID);
			
			//Set the response String to success
			responseString = "success";
		} 
		
		//If the VehicleManager throws an exception, set the 
		//responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();		
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
			responseString = "Exception - " + e.getMessage();		
		}		
		
		//return the responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Search for Available Equiptment" Service
	 * @param type Either car or truck
	 * @param branch_num The number of the branch that owns the equiptment 
	 * @param start_date The day the customers rental begins
	 * @param end_date The date the customers rental ends
	 * @return A list of JSON stringified Equptment Objects that are relevant to the given parameters
	 */
	@WebMethod
	public String[] searchForEquipments(String type, int branch_num, String start_date, String end_date) {
		
		//Declare variables to hold the value returned to the caller
		String[] responseList;
				
		try {
			//Create a vehicle manager
			VehicleManager vm = new VehicleManager();
					
			//Search for equiptment that matches the given arguments
			Equipment[] equiptmentList = vm.searchForEquipments(type, branch_num, start_date, end_date);
					
			//Set response list to a list of stringified equiptment objects
			WebToolkit wtk = new WebToolkit();
			responseList = wtk.toArrayOfStrings(equiptmentList);
		} 
						
		//If the VehicleManager throws an exception, set the first index of
		//responseList to the appropriate error message
		catch (SQLException e) {
			responseList = new String[]{ "Exception - " + e.getMessage()};		
		}		
				
		//return the responseList
		return responseList;
	}
	
	public String addEquipment(int branch_id, String equipment_type) {
		
		//Declare variables to hold the response text
		String responseString;
				
		try {
			//Create a vehicle manager and add a new equptment record based on the given arguments
			VehicleManager vm = new VehicleManager();
			vm.addEquipment(branch_id, equipment_type);
			
			//Set the response string to success
			responseString = "success";
		} 
						
		//If the VehicleManager throws an exception, set the
		//responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();		
		}		
				
		//return the responseString
		return responseString;
	}
	
	
}
