package security;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.sun.appserv.security.AppservPasswordLoginModule;

/**
 * Used to authenticate a user and start a login session. 
 * Hooks into glassfish's JAAS framework
 * @author Alex Daniels
 */
public class DIVALoginModule extends AppservPasswordLoginModule {

	/**
	 *Used by glassfish to authentication a user who would like to start a login session
	 */
	@Override
	protected void authenticateUser() throws LoginException {
		
		//Get the userName and Password given by the calling user
		
		String givenUsername = this.getUsername();
		char[] givenPasswordCharArray = this.getPasswordChar();
		String givenPassword = new String(givenPasswordCharArray);
		
		//Get the stored password for the given username
		
		AuthenticateDB db = new AuthenticateDB();
		String storedPassword;
		try {
			storedPassword = db.retrievePassword(givenUsername);
		} catch (SQLException e1) {
			throw new LoginException("Something went wrong with the database");
		}
		
		//If the stored password matches the given password
		if (givenPassword.equals(storedPassword)) {
	
			//Get the users type
			String userType;
			try {
				userType = db.getAccountType(givenUsername);
			} catch (IllegalArgumentException | SQLException e) {
				throw new LoginException("Somethings Wrong with the Database");
			}
			
			//Set the users groups based on it's type
			
			String[] groups = getGroups(userType);
			
			//commit user
			commitUserAuthentication(groups);
		}
		
		//else
		else {
			//Throw Login Exception
			throw new LoginException("Bad username or password");
		}
	}
	
	/**
	 * Returns a list of Strings, each string represents a group the calling user belongs to
	 * Used to map between AccountType and SecureGroup
	 * @param type The type of account of the calling user
	 * @return A list of Strings, each string represents a group the calling user belongs to
	 * @throws LoginException
	 */
	private String[] getGroups(String type) throws LoginException {
		
		//Set groups to hold a list of strings representing all the groups the calling users belongs
		String[] groups;
		
		//If type is Customer, add customer to groups
		if (type.equals("customer")) {
			groups = new String[]{"customer"};
		}
		
		//If tpye is SuperCustomer add supercustomer to groups
		else if (type.equals("super_customer")) {
			groups = new String[]{"supercustomer"};
		}
		
		//if type is Clerk add clerk to groups
		else if (type.equals("Clerk")) {
			groups = new String[]{"clerk"};
		}
		
		//if type is Manager or admin, add manager to groups
		else if (type.equals("Manager")) {
			groups = new String[]{"manager"};
		}
		
		//if type is SystemAdmin, add admin to groups.
		else if (type.equals("SystemAdmin")) {
			groups = new String[]{"admin"};
		}
		
		//If the user is not assosiated with any type or group - Throw a LoginException
		else {
			throw new LoginException("User is not part of any existring group. This error is liekly do to a misspelling in the LoginModule class");
		}
		
		//return groups
		return groups;
	}

}
