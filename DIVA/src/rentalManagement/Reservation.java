package rentalManagement;

import java.io.IOException;
import java.util.Date;
import java.util.Arrays;

import accountManagement.Account;
import accountManagement.Customer;
import systemManagement.Branch;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

//Assumes Date object is passed instead of a primitive.
// Needs javadoc
public class Reservation {

	private Date startDate;
	private Date endDate;
	private int vehicleID;
	private int[] equipmentIDs;
	private int startBranchID;
	private int endBranchID;
	private int customerAccountID;
	private String status;
	private int employeeAccountID;
	private int reservID;
	
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
		status = "";
		employeeAccountID = 0;
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
	public Reservation(Date startDate, Date endDate, int vehID, int[] e, int startBranch, int endBranch, int cusID, int empID, String s, 
			 int id)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		vehicleID = vehID;
		equipmentIDs = e;
		startBranchID = startBranch;
		endBranchID = endBranch;
		customerAccountID = cusID;
		status = s;
		employeeAccountID = empID;
		reservID = id;
	}
	
	/**
	 * Modifies the starting date of Reservation.
	 * @param newDate The start date to be changed.
	 */
	public void changeStartDate(Date newDate)
	{
		startDate = newDate;
	}
	
	/**
	 * Modifies the ending date of Reservation.
	 * @param newDate The end date to be changed.
	 */
	public void changeEndDate(Date newDate)
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
	 * Modifies the Employee account login ID the Reservation is assigned to.
	 * @param newAccountID Employee Account login ID the Reservation is assigned to.
	 */
	public void changeEmployeeAccountID(int newAccountID)
	{
		this.employeeAccountID = newAccountID;
	}
	
	/**
	 * Modifies the Status of Reservation.
	 * @param newStatus New status of Reservation.
	 */
	public void changeStatus(String newStatus)
	{
		this.status = newStatus;
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
	public Date getStartingDate()
	{
		return this.startDate;
	}
	
	/**
	 * Returns the end Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public Date getEndDate()
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
	 * Returns the Employee Account login ID of the Reservation.
	 * @return Employee Account login ID of the Reservation.
	 */
	public int getEmployeeAccountID()
	{
		return employeeAccountID;
	}
	
	/**
	 * Returns the status of Reservation.
	 * @return Status of Reservation.
	 */
	public String getStatus()
	{
		return this.status;
	}
	
	/**
	 * Returns the ID of Reservation.
	 * @return ID of Reservation.
	 */
	public int getID()
	{
		return this.reservID;
	}
	
}