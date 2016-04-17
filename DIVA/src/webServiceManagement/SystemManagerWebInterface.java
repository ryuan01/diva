package webServiceManagement;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import systemManagement.*;

/**
 * A WebService Endpoint who provides System Related Services to DIVA users
 * @author Alex Daniels
 * @since April 1, 2016
 */
@WebService
public class SystemManagerWebInterface {
	
	public SystemManagerWebInterface() {
	
	}
	
	/**
	 * Web Interface for the "Starting the System" Service
	 * @return A String describing the success or failure of the invocation
	 */
	@WebMethod
	public String startTheSystem() {
		
		String responseString;
		try {
			//Create a SystemManager and call start system
			SystemManager sm = new SystemManager();
			sm.startUp();
			
			//If the system manager doesn't throw an error, return the string "Success"
			responseString = "success";
		}
		
		//If the SystemManager throws and exception, set responseString to the appropriate error
		catch(Exception e) { //NEEDS TO BE THE SPECIFIC EXCEPTION THROWN BY THE sm
			responseString = "Exception - " + e.getMessage();
		}
		return responseString;
	}
		
	/**
	 * Web Interface for the "Shutting Down the System" Service
	 * @return A String describing the success or failure of the invocation
	 */
	@WebMethod
	public String shutdownTheSystem() {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
		
		try {
			//Create a SystemManager and try to shutdown the system
			SystemManager sm = new SystemManager();
			sm.shutDown(); 
			
			//If no error is thrown, set the response text to success
			responseString = "success";
		}
		
		//If the SystemManager throws and exception, set 
		//responseString to the appropriate error
		catch(Exception e) { //NEEDS TO BE THE SPECIFIC EXCEPTION THROWN BY THE sm
			responseString = "Exception - " + e.getMessage();
		}
		
		//Return the response String
		return responseString;
	}
	
	/**
	 * Web Interface for the "Adding a new Branch" Service
	 * @param address The address of the new branch
	 * @param city The city the new branch is located 
	 * @param province The province the new branch is located
	 * @param zipcode the zipcode of the new branch
	 * @return A string describing the success or failure of the invocation
	 */
	@WebMethod
	public String addBranch(String address,String city,String province,String zipcode) {
		
		//Set responseText to hold the value returned to the caller
		String responseString;
		
		try {
			//Create a new SystemManager and add a branch with the given attributes
			SystemManager sm = new SystemManager();
			sm.addBranch(address, city, province, zipcode);
			
			//If no exception is thrown, set responseString to success
			responseString = "success";
		} 
		
		//If the SystemManager throws an exception, set the 
		//responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//Return the responseString
		return responseString;
	}
	
	/**
	 * Web Interface for the "Remove a Branch" Service
	 * @param branchID the ID of the branch that is to be removed
	 * @return a string describing the success or failure of the invocation
	 */
	@WebMethod
	public String removeBranch(int branchID) {
		
		//Set responseText to hold the value returned to the caller
		String responseString;
				
		//Create a new SystemManager and 
		//try to remove the branch with the given branchID
		try {
			SystemManager sm = new SystemManager();
			sm.removeBranch(branchID);
			responseString = "success";
		} 
				
		//If the SystemManager throws an exception, set the responseString
		//to the appropriate error message
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//Return the responseString
		return responseString; 
	}
		
	/**
	 * Web interface for the "Search for a Branch" Service
	 * @param branchID The id of the branch to be returned as a stringified object
	 * @return A stringified branch object associated with the given ID
	 */
	@WebMethod
	public String getBranch(int branchID) {
		
		//Set responseString to hold the value returned to the caller
		String responseString;
		
		try {
			//Create a new SystemManager and try to search for 
			//a branch object with the given branchID.
			SystemManager sm = new SystemManager();
			Branch branch = sm.getBranch(branchID);
			
			 //Stringify and store the branch in responseString
			responseString = branch.toString();
		} 
		
		//If the SystemManager throws and exception, set 
		//the responseString to the appropriate error message
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//Return responseString		
		return responseString;
	}
	
	/**
	 * Web interface for the "Search for a Branch" Service
	 * @return A list of stringified branch object associated with the given ID
	 */
	@WebMethod
	public String[] getAllBranches() {
		
		//Set responseListto hold the value/values returned to the caller
		String[] responseList;
		
		try {
			//Create a new SystemManager and try to search for 
			//a branch object with the given branchID.
			SystemManager sm = new SystemManager();
			Branch[] branchList = sm.getAllBranch();
					
			
			 //Stringify and store the branch in responseString
			WebToolkit wtk = new WebToolkit();
			responseList = wtk.toArrayOfStrings(branchList);
		} 
		
		//If the SystemManager throws and exception, set 
		//the responseString to the appropriate error message
		catch (SQLException e) {
			responseList = new String[]{"Exception - " + e.getMessage()};
		}
		
		//Return responseString		
		return responseList;
	}
}
