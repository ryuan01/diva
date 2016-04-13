package security;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import com.sun.appserv.security.AppservRealm;
import com.sun.enterprise.security.auth.realm.BadRealmException;
import com.sun.enterprise.security.auth.realm.InvalidOperationException;
import com.sun.enterprise.security.auth.realm.NoSuchRealmException;
import com.sun.enterprise.security.auth.realm.NoSuchUserException;

public class DIVARealm extends AppservRealm {

	private static final String JAAS_CONTEXT="jaas-context";

	@Override
	   public void init(Properties properties) throws BadRealmException, NoSuchRealmException {

	       // Pass the properties declared in the console to the system
			System.out.println("Getting JAAS_CONTEXT");
	       String propJaasContext=properties.getProperty(JAAS_CONTEXT);
	       if (propJaasContext!=null) {
	          setProperty(JAAS_CONTEXT, propJaasContext);
	          System.out.println("Properties Set");
	       }
	   }
	  
	    @Override
	    public String getAuthType() {
	       return "DIVA-Authorization";
	    }

	    @Override
	    public Enumeration<String> getGroupNames(String user) throws InvalidOperationException, NoSuchUserException {
	   
	        Vector<String> vector = new Vector<>();
	   
	        //Set all group names
	        vector.add("customer");
	        vector.add("supercustomer");
	        vector.add("clerk");
	        vector.add("manager");
	        vector.add("admin");
	   
	        return vector.elements();
	     }
}
