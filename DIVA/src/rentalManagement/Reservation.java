package rentalManagement;

import java.sql.Date;

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
	private String vehicleID;
	private String[] equipmentIDs;
	private String startBranchID;
	private String endBranchID;
	private String customerAccountID;
	private String status;
	private String employeeAccountID;
	private String reservID;
	
	/**
	 * Creates empty Reservation.
	 */
	public Reservation()
	{

	}
	
	/**
	 * Create a Reservation with start and end Date, Vehicle, Equipment, starting and ending branch, customer and employee id, status, and ID
	 * @param startDate Starting date of Reservation.
	 * @param endDate Ending date of Reservation.
	 * @param v Vehicle ID of the reservation.
	 * @param e Equipment ID of the reservation.
	 * @param startBranch The branch ID Vehicle is Rented.
	 * @param endBranch The branch ID Vehicle is Returned.
	 * @param c The Customer log in ID Reservation belongs to. 
	 * @param s The Status of the Reservation.
	 * @param empl The Employee log in ID Reservation belongs to.
	 * @param id The Reservation ID.
	 */
	public Reservation(Date startDate, Date endDate, Vehicle v, String[] e, String startBranch, String endBranch, String c, String s, 
			String empl, String id)
	{
	}
	
	/**
	 * Compares if two reservations are equal.
	 * @param r Reservation to be compared.
	 * @return True if equal, False otherwise.
	 */
	public boolean equals(Reservation r)
	{
		return true;
	}
	
	/**
	 * Modifies the starting date of Reservation.
	 * @param newDate The start date to be changed.
	 */
	public void changeStartDate(Date newDate)
	{
		
	}
	
	/**
	 * Modifies the ending date of Reservation.
	 * @param newDate The end date to be changed.
	 */
	public void changeEndDate(Date newDate)
	{
		
	}
	
	/**
	 * Modifies the Vehicle ID of Reservation.
	 * @param newVehicleID The Vehicle ID to be changed.
	 */
	public void changeVehicleID(String newVehicleID)
	{

	}
	
	//needs testing, could throw exception equipmentAlreadyReserved?
	/**
	 * Add the Equipment ID from Reservation.
	 * @param newEquipmentID The Equipment ID to be added.
	 */
	public void addEquipmentID(String newEquipmentID)
	{
	
	}
	
	//throws exception if toBeRemovedEquipment is not in the equipment list. (shouldn't happen)
	/**
	 * Removes the Equipment ID from Reservation.
	 * @param toBeRemovedEquipmentID The Equipment ID to be removed.
	 */
	public void removeEquipmentID(String toBeRemovedEquipmentID)
	{
	
	}
	
	/**
	 * Modifies the startBranch ID of the Reservation.
	 * @param newStartBranch New startBranch ID of the Reservation.
	 */
	public void changeStartBranchID(String newBranchID)
	{
		
	}
	
	/**
	 * Modifies the endBranch ID of the Reservation.
	 * @param newEndBranch New endBranch ID of the Reservation.
	 */
	public void changeEndBranchID(String newEndBranchID)
	{
		
	}
	
	/**
	 * Modifies the Customer account the Reservation is assigned to.
	 * @param newAccount Customer Account the Reservation is assigned to.
	 */
	public void changeCustomerAccount(String newAccountID)
	{
		
	}

	/**
	 * Modifies the Employee account login ID the Reservation is assigned to.
	 * @param newAccountID Employee Account login ID the Reservation is assigned to.
	 */
	public void changeEmployeeAccountID(String newAccountID)
	{
		
	}
	
	/**
	 * Modifies the Status of Reservation.
	 * @param newStatus New status of Reservation.
	 */
	public void changeStatus(String newStatus)
	{
		
	}
	
	/**
	 * Modifies the ID of Reservation.
	 * @param newID New ID of Reservation.
	 */
	public void changeID(String newID)
	{
		
	}
	
	/**
	 * Returns the Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public Date getStartingDate()
	{
		return null;
	}
	
	/**
	 * Returns the end Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public Date getEndDate()
	{
		return null;
	}
	
	/**
	 * Returns the Vehicle ID of the Reservation.
	 * @return Vehicle ID of the Reservation.
	 */
	public String getVehicleID()
	{
		return vehicleID;
	}
	
	/**
	 * Returns the list of Equipment IDs of the Reservation.
	 * @return List of Equipment IDsof the Reservation.
	 */
	public String[] getEquipments()
	{
		return equipmentIDs;
	}
	
	/**
	 * Returns the startBranch ID of the Reservation.
	 * @return Starting branch ID of the Reservation.
	 */
	public String getStartBranchID()
	{
		return startBranchID;
	}
	
	/**
	 * Returns the endBranch ID of the Reservation.
	 * @return Ending branch ID of the Reservation.
	 */
	public String getEndBranchID()
	{
		return endBranchID;
	}
	
	/**
	 * Returns the Customer Account login ID of the Reservation.
	 * @return Customer Account login ID of the Reservation.
	 */
	public String getCustomerAccountID()
	{
		return customerAccountID;
	}
	
	/**
	 * Returns the Employee Account login ID of the Reservation.
	 * @return Employee Account login ID of the Reservation.
	 */
	public String getEmployeeAccountID()
	{
		return employeeAccountID;
	}
	
	/**
	 * Returns the status of Reservation.
	 * @return Status of Reservation.
	 */
	public String getStatus()
	{
		return "";
	}
	
	/**
	 * Returns the ID of Reservation.
	 * @return ID of Reservation.
	 */
	public String getID()
	{
		return "";
	}
	
}