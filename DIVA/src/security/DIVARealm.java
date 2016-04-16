package security;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import com.sun.appserv.security.AppservRealm;
import com.sun.enterprise.security.auth.realm.BadRealmException;
import com.sun.enterprise.security.auth.realm.InvalidOperationException;
import com.sun.enterprise.security.auth.realm.NoSuchRealmException;
import com.sun.enterprise.security.auth.realm.NoSuchUserException;

/**
 * A custom Authentication Realm that hooks into GlassFish's JAAS framework
 * @author Alex Daniels
 */
public class DIVARealm extends AppservRealm {

	private static final String JAAS_CONTEXT="jaas-context";

	@Override
	public void init(Properties properties) throws BadRealmException, NoSuchRealmException {

		//Get the jaas-context
		String propJaasContext=properties.getProperty(JAAS_CONTEXT);
		
		//If the jaas-context is not null - set the JAAS_CONTEXT property value
		if (propJaasContext!=null) {
			setProperty(JAAS_CONTEXT, propJaasContext);
	   }
	}
	  
	/**
	 * Returns a string describing the type of authorization provided by this realm
	 * @return a string describing the type of authorization provided by this realm
	 */
	@Override
	public String getAuthType() {
		return "DIVA-Authorization";
	}
		
	/**
	 * Returns an enumeration of strings 
	 * One string for each valid Security Groups supported by 
	 */
	@Override
	public Enumeration<String> getGroupNames(String user) throws InvalidOperationException, NoSuchUserException {
	   
		//Set an empty vector to hold Strings
		Vector<String> vector = new Vector<>();
	   
		//Add all group names to the vector
		vector.add("customer");
		vector.add("supercustomer");
		vector.add("clerk");
		vector.add("manager");
		vector.add("admin");
	   
		//Return the vector
		return vector.elements();
	}
}
