package webServiceManagement;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import accountManagement.*;

/**
 * A Web Service Interface to services provided by the AccountManager
 * Provides methods to remote clients and manages the context in which services
 * are invoked so the business logic can operate without much context.
 * @version 1
 * @since March 30, 2016
 * @author AlexDaniels
 */
@WebService
public class AccountManagerWebInterface {
	
	@Resource
	WebServiceContext context;
	
	/**
	 * Constructs an AccountWebServiceManager object
	 */
	public AccountManagerWebInterface() {
		
	}
	
	//------------Methods that can be called by an unauthenticated HTTPS user

//****IT IS VERY LIKELY THAT THIS WILL BE REMOVED AND PLACED INTO THE SECURITY SYSTEM TO RESTRICT PEOPLE FROM CALLING IT 1000 TIMES
	/**
	 * Web interface for the 'Add a New Customer" Service
	 * @param firstName The first name of the customer
	 * @param lastName The last name of the customer
	 * @param phoneNumber	The customers phone number
	 * @param emailAddress	The customers email address
	 * @param userName		The customers userName
	 * @param password		An encrypted version of The customers password
	 * @param address		The home address of the new customer
	 * @param city			The city the customer lives in
	 * @param province		The province the customer lives in
	 * @param zip			The customers zip code
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String addCustomerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, 
			String password, String address, String city, String province, String zip) {
		
		//Set responseString to hold the value returned to the caller
		
		String responseString;
		
		//Create an AccountManager and try to create a new account with the given parameters
		try {
			AccountManager am = new AccountManager();
			am.addCustomerAccount(firstName, lastName, phoneNumber, emailAddress, userName, password, -1, null, address, city, province, zip);
			
			//Set responseString to success
			responseString = "success";
		} 
		
		//If the AccountManager throws an error, set responseString to the appropriate return value
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
		
		//return responseString
		return responseString;
	}
	
	//--------Methods that can be called by an Registered Customer
	/*
	/**
	 * Web Interface for the "Changing a Username" Service
	 * @param newUserName The desired new username
	 * @pre usernameIsUnique(newUserName)
	 * @pos logout(user)
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	/*
	public String changeUserName(String newUserName, String Password) {
		
		//Declare variables to hold the response String
		String responseString = "Not Implemented";
		
		//Try
			//Create account manager
				
			//Get the calling users userName
			
			//Create an AccountManager and try to change the calling users username
		
			//set responsestring to success
		
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
		
		//return response string
		return responseString; 
	}
	*/
	
	/**
	 * Web Interface for the "Changing your own Password" Service
	 * @param oldPassword The users current password
	 * @param newPassword The users desired new password
	 * @pre oldPassword == getPassword(userName)
	 * @pos logout(user)
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String changePassword(String oldPassword, String newPassword) {
		
		//Declare variables to hold the response text
		String responseString;
			
		try {
			//Get the calling users userName
			String userName = context.getUserPrincipal().getName();
			
			//Create an AccountManager
			AccountManager am = new AccountManager();
				
			//Set authentic to true if the oldPassword is equal to the users current Password
			boolean authentic = am.getPassword(userName).equals(oldPassword);
				
			//If the request is authentic - change the calling users password
			if (authentic) {
				am.changePassword(userName, newPassword);
				responseString = "success";
			}
			else {
				responseString = "Wrong Password";
			}
		} 
		catch (SQLException e) {
			//If the account manager throws and error, assign the 
			//appropriate error message to the responseString
			responseString = "Exception - " + e.getMessage();	
		}
				
		//return response string
		return responseString;
	}
	
	/*
	/**
	 * Web Interface for "Changing a Customers Account Information" Service
	 * @param firstName The first name of the customer
	 * @param lastName The last name of the customer
	 * @param phoneNumber	The customers phone number
	 * @param emailAddress	The customers email address
	 * @pre user.type == customer
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	/*
	public String changeaccontinfo(String firstName, String lastName, String phoneNumber, String emailAddress) {
		
		//CAN'T IMPLEMENT UNTIL ITS WORKED OUT WHY THE ACCOUNT MANAGER METHOd TAKES TOO MANY PARAMS
		
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and change the 
			//calling users account information
		
			//set responseString to success
				
		//Catch
			//If the account manager throws and error, assign 
			//the appropriate error message to the responseString
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
	}
	*/
	
	/**
	 * Web Interface for the "Customer Joins Superclub" Service
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String customerJoinsSuperclub() {
		
		//Declare variables to hold the response text
		String responseString;
		
		try {
				
			//Get the calling users userName
			String userName = context.getUserPrincipal().getName();
		
			//Create an AccountManager and change the 
			//calling customer into a super customer
			AccountManager am = new AccountManager();
			am.joinSuperClub(userName);
	
			//Set the response string to success
			responseString = "success";
		}
			
		//If the account manager throws and error, assign the appropriate
		//error message to the responseString
		catch(SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}		
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Web Interface for the "Clerk Signs up Customer for Superclub" Service
	 * @param userName The customer who would like to join superclub
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String clerkSignUpCustomerForSuperMembership(String userName) {
		
		//Declare variables to hold the response text
		String responseString;
				
		try {
				
			//Create an AccountManager and change the given customer into a super customer
			AccountManager am = new AccountManager();
			am.joinSuperClub(userName);
			
			//Set the response string to success
			responseString = "success";
		}
					
		//If the account manager throws and error, assign the appropriate
		//error message to the responseString
		catch(SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}		
		//return response string
		return responseString; 
	}
	
	//--------Methods that can be called by an Super Customer
	
	/**
	 * Web Interface for the "Quit Super Club" Service
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String customerQuitSuperclub() {
		
		
		//Declare variables to hold the response text and the AccountManager
		String responseString;
		
		try {
			//Get the calling users userName
			String userName = context.getUserPrincipal().getName();
				
			//Create an AccountManager and change the calling users account from Supercustomer to customer
			AccountManager am = new AccountManager();
			am.leaveSuperCLub(userName);
				
			//set responseString to success
			responseString = "success";
		} 
			
		//If the account manager throws and error, assign the appropriate
		//error message to the responseString
		catch (SQLException e) {
			responseString = "Exception - " + e.getMessage();
		}
				
		//return response string
		return responseString;
		
	}
	
	/**
	 * Web Interface for the "Clerk Down grades A Customer from SuperCustomer" Service
	 * @param userName The username of the customer who would like to quit superclub
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String clerkDowngradesSuperCustomerToRegularCustomer(String userName) {	
		
		//Declare variables to hold the response text and the AccountManager
		String responseString;
				
		try {
			//Create an AccountManager and change the calling users account from Supercustomer to customer
			AccountManager am = new AccountManager();
			am.leaveSuperCLub(userName);
			
			//set responseString to success
			responseString = "success";
		} 
		catch (SQLException e) {
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
			responseString = "Exception - " + e.getMessage();
		}
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
		
	}
	
	/**
	 * Web Interface for the "Search for a Customer by Phone Number" Service
	 * @param phoneNumber The phone number of the account being searched (Can choose All if not specified)
	 * @return a list of JSON Stringified customer objects that match the searched criteria
	 */
	@WebMethod
	public String[] searchForCustomersByPhone(String phoneNumber) {
		
		//Declare variables to hold the response list of strings
		String[] responseList;
			
		try {
			//Create an AccountManager and search for a list of
			//customers that match the given arguments
			AccountManager am = new AccountManager();
			Account[] customerList = am.searchAccountByPhoneNumber(phoneNumber);
			
			//Turn the list of Accounts into a list of stringified 
			//accounts and store them in responseList
			responseList = WebToolkit.toArrayOfStrings(customerList);
		} 
		
		//If the account manager throws and error, assign 
		//the appropriate error message to the first index of responseList
		catch (SQLException e) {
				responseList = new String[]{"Exception - " + e.getMessage()};
		}
		
		//return response string
		return responseList;
	}
	
	/**
	 * Web Interface for the "Search for a Customer by Phone Number" Service
	 * @param lastName The last name of the account being searched (Can choose All if not specified)
	 * @return a list of JSON Stringified customer objects that match the searched criteria
	 */
	@WebMethod
	public String[] searchForCustomersByLastName(String lastName) {
		
		//Declare variables to hold the response list of strings
		String[] responseList;
			
		try {
			//Create an AccountManager and search for a list of
			//customers that match the given arguments
			AccountManager am = new AccountManager();
			Account[] customerList = am.searchAccountByLastName(lastName);
			
			//Turn the list of Accounts into a list of stringified 
			//accounts and store them in responseList
			responseList = WebToolkit.toArrayOfStrings(customerList);
		} 
		
		//If the account manager throws and error, assign 
		//the appropriate error message to the first index of responseList
		catch (SQLException e) {
				responseList = new String[]{"Exception - " + e.getMessage()};
		}
		
		//return response string
		return responseList;
	}
	
	/**
	 * Web Interface for the "Search for a Customer by Phone Number" Service
	 * @param userName The user name of the account being searched (Can choose All if not specified)
	 * @return a list of JSON Stringified customer objects that match the searched criteria
	 */
	@WebMethod
	public String[] searchForCustomersByuserName(String userName) {
		
		//Declare variables to hold the response list of strings
		String[] responseList;
			
		try {
			//Create an AccountManager and search for a list of
			//customers that match the given arguments
			AccountManager am = new AccountManager();
			Account[] customerList = am.searchAccountByLastName(userName);
			
			//Turn the list of Accounts into a list of stringified 
			//accounts and store them in responseList
			responseList = WebToolkit.toArrayOfStrings(customerList);
		} 
		
		//If the account manager throws and error, assign 
		//the appropriate error message to the first index of responseList
		catch (SQLException e) {
				responseList = new String[]{"Exception - " + e.getMessage()};
		}
		
		//return response string
		return responseList;
	}
	
	//--------Methods that can be called by a Manager 
	
	/**
	 * Web Interface for the "Adding a Clerk Account" service
	 * @param firstName The first name of the new clerk
	 * @param lastName The last name of the new clerk
	 * @param phoneNumber the phone number of the new clerk
	 * @param emailAddress the email address of the new clerk
	 * @param userName The clerks new username
	 * @param password The clerks new password
	 * @param works_at The branchID that the clerk works at
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String addClerkAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password, int works_at) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString;
		
		//Set type to clerk
		String type = "Clerk";
		
		try {
			//Create an AccountManager and add a Clerk account with the given arguments
			AccountManager am = new AccountManager();
			am.addEmployeeAccount(firstName, lastName, phoneNumber, emailAddress, userName, password, works_at, type);
			
			//Set responseString to success
			responseString = "success";
		} 
		
		catch (SQLException e) {
			//If the account manager throws and error, assign the 
			//appropriate error message to the responseString
			responseString = "Exception - " + e.getMessage();
		}
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
	}
	
	//--------Methods that can be called by a System Administrator
	
	/**
	 * Web Interface for the "Adding a Manager Account" service
	 * @param firstName The first name of the new manager
	 * @param lastName The last name of the new manager
	 * @param phoneNumber the phone number of the new manager
	 * @param emailAddress the email address of the new manager
	 * @param userName The managers new username
	 * @param password The managers new password
	 * @param works_at The branchID of the branch the Manager will Manage
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String addManagerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password, int works_at) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString;
		
		//Set type to Manager
		String type = "Manager";
				
				try {
					//Create an AccountManager and add a Manager account with the given arguments
					AccountManager am = new AccountManager();
					am.addEmployeeAccount(firstName, lastName, phoneNumber, emailAddress, userName, password, works_at, type);
					
					//Set responseString to success
					responseString = "success";
				} 
				
				catch (SQLException e) {
					//If the account manager throws and error, assign the 
					//appropriate error message to the responseString
					responseString = "Exception - " + e.getMessage();
				}
						
				//return response string
				return responseString; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Web Interface for the "System Administrator Changes a Users Password" Service
	 * @param userName the username of the account whose password is to be changed
	 * @param newPassword the new password of the given user
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	@WebMethod
	public String changeAUsersPassword(String userName, String newPassword) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString;

			try {
				//Create an AccountManager and try to change the password
				//of the given user to the given newPassword
				AccountManager am = new AccountManager();
				am.changePassword(userName, newPassword);
				
				//Set responseString to success
				responseString = "success";
				
			} 
			
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
			catch (SQLException e) {
				responseString = "Exception - " + e.getMessage();
			}
												
		//return response string
		return responseString;
	}
	
	/**
	 * Returns the userName from the session context rather than the database
	 * @return The userName assosiated with the context in which this method was invoked
	 */
	@WebMethod
	public String getContextUserName() {
		
		//Set responseString to the calling users userName
		String responseString = context.getUserPrincipal().getName();
		
		//If the calling users has a null userName, set responseString to an Error message
		if (responseString == null) {
			responseString = "Exception - The user does not have a sessionID";
		}
		
		//return responseString
		return responseString;
	}

	/**
	 * Returns the group that the user belongs to
	 * @return the users authorizationID (customer, supercustomer, clerk, manager or admin)
	 */
	@WebMethod
	public String getContextGroupID() {
		
		//Set responseString to hold the users groupID
		String responseString;
		
		if (context.isUserInRole("customer")) {
			responseString="customer";
		}
		else if (context.isUserInRole("supercustomer")) {
			responseString="supercustomer";
		}
		else if (context.isUserInRole("clerk")) {
			responseString="clerk";
		}
		else if (context.isUserInRole("manager")) {
			responseString="manager";
		}
		else if (context.isUserInRole("admin")) {
			responseString="admin";
		}
		else {
			responseString="Exception - User is not in any acceptable role";
		}
		//Return the response String
		return responseString;
	}
	
	/**
	 * The method invalidates the session associated with the calling user, effectively 'logging'
	 * them out of their current login session.
	 */
	@WebMethod
	public void logout() {
		
		//Get the MessageConext
		MessageContext mc = context.getMessageContext();
		
		//Get the session object associated with the calling user
		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		
		//Invalidate the calling users current session - Effectively 'logging' the user out
		session.invalidate();
	}
}
