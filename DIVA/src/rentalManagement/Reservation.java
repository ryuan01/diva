package rentalManagement;

import java.math.BigDecimal;
import java.util.Arrays;

import accountManagement.Account;
import webServiceManagement.ArrayOfStringsable;

//Assumes Date object is passed instead of a primitive.
// Needs javadoc
public class Reservation implements ArrayOfStringsable{

	private String startDate;
	private String endDate;
	private int vehicleID;
	private int[] equipmentIDs;
	private int startBranchID;
	private int endBranchID;
	private int customerAccountID;
	//private int employeeAccountID; <-- won't be stored
	private int reservID;
	//needs a field that says "balance of this reservation"
	private BigDecimal balance;
	
	/**
	 * Creates empty Reservation.
	 */
	public Reservation()
	{
		startDate = null;
		endDate = null;
		vehicleID = 0;
		equipmentIDs = new int[0];
		startBranchID = 0;
		endBranchID = 0;
		customerAccountID = 0;
		// -1 means this doesn't exit
		reservID = -1;
		
	}
	
	/**
	 * Create a Reservation with start and end Date, Vehicle, Equipment, starting and ending branch, customer and employee id, status, and ID
	 * @param startDate2 Starting date of Reservation.
	 * @param endDate2 Ending date of Reservation.
	 * @param v Vehicle ID of the reservation.
	 * @param e Equipment ID of the reservation.
	 * @param startBranch The branch ID Vehicle is Rented.
	 * @param endBranch The branch ID Vehicle is Returned.
	 * @param c The Customer log in ID Reservation belongs to. 
	 * @param s The Status of the Reservation.
	 * @param empl The Employee log in ID Reservation belongs to.
	 * @param id The Reservation ID.
	 */
	public Reservation(String startD, String endD, int vehID, int[] e, int startBranch, int endBranch, int cusID, 
			 int id, BigDecimal amount)
	{
		this.startDate = startD;
		this.endDate = endD;
		vehicleID = vehID;
		equipmentIDs = e;
		startBranchID = startBranch;
		endBranchID = endBranch;
		customerAccountID = cusID;
		reservID = id;
		balance = amount;
	}
	
	/**
	 * Modifies the starting date of Reservation.
	 * @param newDate The start date to be changed.
	 */
	public void changeStartDate(String newDate)
	{
		startDate = newDate;
	}
	
	/**
	 * Modifies the ending date of Reservation.
	 * @param newDate The end date to be changed.
	 */
	public void changeEndDate(String newDate)
	{
		endDate = newDate;
	}
	
	/**
	 * Modifies the Vehicle ID of Reservation.
	 * @param newVehicleID The Vehicle ID to be changed.
	 */
	public void changeVehicleID(int newVehicleID)
	{
		vehicleID = newVehicleID;
	}
	
	/**
	 * Add the Equipment ID from Reservation.
	 * @param newEquipmentID The Equipment ID to be added.
	 */
	public void addEquipmentID(int[] newEquipmentID)
	{
		Arrays.copyOf(equipmentIDs,equipmentIDs.length + 1);
	}
	
	//Not implemented yet.
	/**
	 * Removes the Equipment ID from Reservation.
	 * @param toBeRemovedEquipmentID The Equipment ID to be removed.
	 */
	public void removeEquipmentID(int toBeRemovedEquipmentID)
	{
	
	}
	
	/**
	 * Modifies the startBranch ID of the Reservation.
	 * @param newStartBranch New startBranch ID of the Reservation.
	 */
	public void changeStartBranchID(int newBranchID)
	{
		startBranchID = newBranchID;
	}
	
	/**
	 * Modifies the endBranch ID of the Reservation.
	 * @param newEndBranch New endBranch ID of the Reservation.
	 */
	public void changeEndBranchID(int newEndBranchID)
	{
		endBranchID = newEndBranchID;
	}
	
	/**
	 * Modifies the Customer account the Reservation is assigned to.
	 * @param newAccount Customer Account the Reservation is assigned to.
	 */
	public void changeCustomerAccount(int newAccountID)
	{
		this.customerAccountID = newAccountID;
	}
	
	/**
	 * Modifies the ID of Reservation.
	 * @param newID New ID of Reservation.
	 */
	public void changeID(int newID)
	{
		this.reservID = newID;
	}
	
	/**
	 * Returns the Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public String getStartingDate()
	{
		return this.startDate;
	}
	
	/**
	 * Returns the end Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public String getEndDate()
	{
		return this.endDate;
	}
	
	/**
	 * Returns the Vehicle ID of the Reservation.
	 * @return Vehicle ID of the Reservation.
	 */
	public int getVehicleID()
	{
		return vehicleID;
	}
	
	/**
	 * Returns the list of Equipment IDs of the Reservation.
	 * @return List of Equipment IDsof the Reservation.
	 */
	public int[] getEquipments()
	{
		return equipmentIDs;
	}
	
	/**
	 * Returns the startBranch ID of the Reservation.
	 * @return Starting branch ID of the Reservation.
	 */
	public int getStartBranchID()
	{
		return startBranchID;
	}
	
	/**
	 * Returns the endBranch ID of the Reservation.
	 * @return Ending branch ID of the Reservation.
	 */
	public int getEndBranchID()
	{
		return endBranchID;
	}
	
	/**
	 * Returns the Customer Account login ID of the Reservation.
	 * @return Customer Account login ID of the Reservation.
	 */
	public int getCustomerAccountID()
	{
		return customerAccountID;
	}
	
	/**
	 * Returns the ID of Reservation.
	 * @return ID of Reservation.
	 */
	public int getID()
	{
		return this.reservID;
	}
	
	public BigDecimal getBalance(){
		return balance;
	}
	
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}
	
	public String toString() {
		
		//Format equiptmentID's
		
		String equipIDArray = this.formatEquiptmentIds(this.equipmentIDs);
		
		//passing back dates in the format dd-mm-yyyy as Strings.
		return "{'startDate':'"+ this.startDate +"', 'endDate':'"+this.endDate+"',"
			+	"'vehicleID':'"+this.vehicleID+"',"+"'equipmentIds':'"+equipIDArray+"',"
			+ "'startBranchID':'"+this.startBranchID+"',"+"'endBranchID':'"+this.endBranchID+"',"
			+ "'customerAccountID':'"+this.customerAccountID+"',"
			+ "'reservID':'"+this.reservID+"'}";
	}
	
	private String formatEquiptmentIds(int[] array) {
		String formattedArray = "[";
		for (int i = 0; i < array.length; i++) {
			String currentId = ""+array[i];
			formattedArray += currentId + ",";
		}
		formattedArray += "]";
		return formattedArray;
	}
	
}