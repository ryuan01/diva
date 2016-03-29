/**
 * Class DatabaseManager is fully implemented and tested
 */

package databaseManagement;

/*Robin */
/*edited by Sammy*/
/**
 * DatabaseManager deals with connection to database
 * @author Robin, Sammy
 * @invariant dbname database name 
 * @invariant pw password for connection 
 */

public class DatabaseManager {
	

    //singieton design pattern
    private static DatabaseManager instance = null;
    
	/** 
	* Constructs a DatabaseManager
	* @post an only DatabasManager object is created
	*/
    private DatabaseManager(){

    }
    
    /**
     * Get the only databaseManager
     * @return an instance of databasemanager
     * @post databaseManager.instance != null
     */
    public static DatabaseManager getInstance(){
    	if (instance == null){
    		instance = new DatabaseManager();
    	}
    	return instance;
    }
    
    // AccountDB calls:
   
}
