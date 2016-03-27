package databaseManagement;

import systemManagement.Branch;

/**
 * BranchDB creates, deletes, and modifies data related to Branch
 * @author Robin
 *
 */
public class BranchDB extends DatabaseManager{

  	public BranchDB() {
  		  super();
  		  // TODO Auto-generated constructor stub
  	}
  	
  	/**
  	 * addBranch creates an new entry in TABLE BRANCH
  	 * @param b branch
  	 * @pre isValidBranch(b)
  	 * @post a new entry in TABLE BRANCH
  	 */
  	public void addBranch(Branch b){
  		
  	}
  	
  	//delete
  
  	/**
  	 * removeBranch removes an entry in TABLE BRANCH
  	 * @param b branch
  	 * @pre for all v:Vehicle, v.branch != b
  	 * @pre for all e:Employee, e.branch != b
  	 * @post an entry in TABLE BRANCH is removed
  	 */
  	public void removebranch(Branch b){
  		
  	}
  	
  	/**
  	 * 
  	 * @param b
  	 */
  	public void changeBranch(Branch b){
  		
  	}
}
