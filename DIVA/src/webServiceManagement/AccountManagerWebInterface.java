package webServiceManagement;

/**
 * A Web Service Interface to services provided by the AccountManager
 * Provides methods to remote clients and manages the context in which services
 * are invoked so the business logic can operate without much context.
 * @version 1
 * @since March 30, 2016
 * @author AlexDaniels
 */
public class AccountManagerWebInterface {
	
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
	 * @pre userNameIsUnique(username)
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String addCustomerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		//Need more time to focus on how this will work.
		//Shouldn't just be a publicly accessible method.
		return new String("Not Implemeneted");
	}
	
	//--------Methods that can be called by an Registered Customer
	
	/**
	 * Web Interface for the "Changing a Username" Service
	 * @param newUserName The desired new username
	 * @pre usernameIsUnique(newUserName)
	 * @pos logout(user)
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
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
	
	/**
	 * Web Interface for the "Changing a Password" Service
	 * @param oldPassword The users current password
	 * @param newPassword The users desired new password
	 * @pre oldPassword == getPassword(userName)
	 * @pos logout(user)
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String changePassword(String oldPassword, String newPassword) {
		
		//Declare variables to hold the response text
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and 
			//change the calling users password
			
			//Set responseString to success
		
		//Catch
			//If the account manager throws and error, assign the 
			//appropriate error message to the responseString
				
		//return response string
		return responseString;
	}
	
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
	public String changeaccontinfo(String firstName, String lastName, String phoneNumber, String emailAddress) {
		
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
	
	/**
	 * Web Interface for the "Customer Joins Superclub" Service
	 * @param password The calling users password
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String joinsuperclub(String password) {
		
		//Declare variables to hold the response text
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and change the 
			//calling customer into a super customer
		
			//Set the response string to success
				
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Web Interface for a "Customer Deactivating their Own Account" Service
	 * @param password The calling users password
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String deactivateAccount(String password) {
		
		//Declare variables to hold the response text
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and try to 
			//deactivate the calling users account
		
			//Set responseString to success
				
		//Catch
			//If the account manager throws and error, assign 
			//the appropriate error message to the responseString
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
	}
	
	/**
	 * Web Interface for "Reactivating a Users Account" Service
	 * @param userName The calling users userName
	 * @param password The calling users password 
	 * @pre getAccount(userName).status == deactivated
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String reactivateaccount(String userName, String password) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and try to change the calling
			//user's account state to deactivated
				
		//Catch
			//If the account manager throws and error, assign 
			//the appropriate error message to the responseString
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
		
	}
	
	//--------Methods that can be called by an Super Customer
	
	/**
	 * Web Interface for the "Quit Super Club" Service
	 * @param password The password of the calling user
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String quitsuperclub(String password) {
		
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and change the calling
			//users account from Supercustomer to customer
		
			//set responseString to success
				
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
				
		//return response string
		return responseString; //METHOD NOT IMPLEMENTED
		
	}
	
	/**
	 * Web Interface for the "Search for a customer" Service
	 * @param emailAddress The email of the account being searched (Can choose All if not specified)
	 * @param userName  The userName of the account being searched (Can choose All if not specified)
	 * @param firstName	The firstName of the account being searched (Can choose All if not specified)
	 * @param lastName 	The lastName of the account being searched (Can choose All if not specified)
	 * @return a list of JSON Stringified customer objects that match the searched criteria
	 */
	public String[] searchForCustomers(String emailAddress, String userName, String firstName, String lastName) {
		
		//Declare variables to hold the response list of strings
		String[] responseList = {"Not Implemented"};
				
		//Try
			//Create an AccountManager and search for a list of
			//customers that match the given arguments
		
			//Turn the list of vehicles into a list of stringified 
			//vehicles and store them in responseList
				
		//Catch
			//If the account manager throws and error, assign 
			//the appropriate error message to the responseString
				
		//return response string
		return responseList; //METHOD NOT IMPLEMENTED
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
	 * @pre usernameIsUnique(userName)
	 * @pos getAccount(userName).type == clerk
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String addClerkAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
				
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and add a Clerk 
			//account with the given arguments
		
			//Set responseString to success
		
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
				
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
	 * @pre usernameIsUnique(userName)
	 * @pos getAccount(userName).type == manager
	 * @return A string describing the success of the transaction or the 
	 * error that caused the transaction to not succeed
	 */
	public String addManagerAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String userName, String password) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
						
		//Try
			//Get the calling users userName
		
			//Create an AccountManager and try to add a 
			//Manager account with the given arguments
		
			//set responseString to success 
			
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
						
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
	public String changeAUsersPassword(String userName, String newPassword) {
		
		//Declare variables to hold the response text and the AccountManager
		String responseString = "Not Implemented";
						
		//Try
			//Create an AccountManager and try to change the password
			//of the given user to the given newPassword
				
		//Catch
			//If the account manager throws and error, assign the appropriate
			//error message to the responseString
												
		//return response string
		return responseString;
	}
}
