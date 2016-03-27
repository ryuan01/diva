package databaseManagement;

/*Robin */
/**
 * DatabaseManager deals with connection to database
 * @author Robin
 * @invariant dbname database name 
 * @invariant pw password for connection 
 */
public class DatabaseManager {
	
	protected static String dbname;
	protected String pw;
	
	/**
	 * Constructs a DatabaseManager
	 * @param db a db name
	 * @param pass an encrypted password
	 * @pre db and pass are valid
	 * @post a DatabasManager object is created
	 */
	public DatabaseManager(String db, String pass) {
		dbname = db;
		pw = pass;
	}
	
	/**
	 * Connect to database
	 * @pre !isConnect()
	 * @post isConnected() 
	 */
	public void connect() {
	}
	
	/**
	 * Disconnect to database
	 * @pre isConnected()
	 * @post !isConnect()
	 */
	public void disconnect() {
	}
	
	/**
	 * Checks if there is a connection
	 * @pre none
	 * @post returns true if there is a connection, otherwise false 
	 */
	public boolean isConnected() {
		return false;
	}

}
