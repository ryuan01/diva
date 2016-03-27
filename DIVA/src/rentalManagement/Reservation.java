package rentalManagement;
//Assumes Date object is passed instead of a primitive.
// Needs javadoc
public class Reservation {

	private Date date;
	private Vehicle vehicle;
	private Equipment[] equipment;
	private Branch startBranch;
	private Branch endBranch;
	private Account account;
	private String status;
	
	/**
	 * Creates empty Reservation.
	 */
	public Reservation()
	{
		date = new Date();
		vehicle = new Vehicle();
		equipment = new ArrayList<Equipment>();
		startBranch = new Branch();
		endBranch = new Branch();
		account = new Account();
	}
	
	/**
	 * Create a Reservation with Date, Vehicle, Equipment, Location.
	 * @param d Date of the reservation.
	 * @param v Vehicle of the reservation.
	 * @param e Equipment of the reservation.
	 * @param startBranch The branch Vehicle is Rented.
	 * @param endBranch The branch Vehicle is Returned.
	 * @param c The Customer Reservation belongs to. 
	 */
	public Reservation(Date d, Vehicle v, Equipment e, Branch startBranch, Branch endBranch, Customer c)
	{
		date = d;
		vehicle = v;
		equipment = e;
		location = l;
		account = a;
	}
	
	/**
	 * Compares if two reservations are equal.
	 * @param r Reservation to be compared.
	 * @return True if equal, False otherwise.
	 */
	public boolean equals(Reservation r)
	{
		if(this.date == r.getDate() && this.vehicle == r.getVehicle())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Modifies the date of Reservation.
	 * @param newDate The date to be changed.
	 * @pre newDate is not already reserved for the Vehicle.
	 */
	public void changeDate(Date newDate)
	{
		date = newDate;
	}
	
	/**
	 * Modifies the Vehicle of Reservation.
	 * @param newVehicle The Vehicle to be changed.
	 * @pre newVehicle is not already reserved.
	 */
	public void changeVehicle(Vehicle newVehicle)
	{
		vehicle = newVehicle;
	}
	
	//needs testing, could throw exception equipmentAlreadyReserved?
	/**
	 * Add the Equipment from Reservation.
	 * @param newEquipment The Equipment to be added.
	 * @pre newEquipment is not already reserved.
	 */
	public void addEquipment(Equipment newEquipment)
	{
		equipment = equipment.add(newEquipment);
		newEquipment.changeStatus(False);
	}
	
	//throws exception if toBeRemovedEquipment is not in the equipment list. (shouldn't happen)
	/**
	 * Removes the Equipment from Reservation.
	 * @param toBeRemovedEquipment The Equipment to be removed.
	 */
	public void removeEquipment(Equipment toBeRemovedEquipment)
	{
		for(int i = 0; i < equipment.size(); i++)
		{
			if(equipment.get(i).getID() = toBeRemovedEquipment.getID())
			{
				equipment.remove(i);
				toBeRemovedEquipment.changeStatus(True);
			}
		}
	}
	
	/**
	 * Modifies the startBranch of the Reservation.
	 * @param newStartBranch New startBranch of the Reservation.
	 */
	public void changeStartBranch(Branch newBranch)
	{
		startBranch = newStartBranch;
	}
	
	/**
	 * Modifies the endBranch of the Reservation.
	 * @param newEndBranch New endBranch of the Reservation.
	 */
	public void changeEndBranch(Branch newEndBranch)
	{
		endBranch = newEndBranch;
	}
	
	/**
	 * Modifies the Account the Reservation is assigned to.
	 * @param newAccount New Account the Reservation is assigned to.
	 * @pre Account is a valid Customer type.
	 */
	public void changeAccount(Account newAccount)
	{
		account = newAccount;
	}
	
	/**
	 * Returns the Date of the Reservation.
	 * @return Date of the Reservation.
	 */
	public Date getDate()
	{
		return date;
	}
	
	/**
	 * Returns the Vehicle of the Reservation.
	 * @return Vehicle of the Reservation.
	 */
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	/**
	 * Returns the list of Equipments of the Reservation.
	 * @return List of Equipments of the Reservation.
	 */
	public Equipment[] getEquipments()
	{
		return equipment;
	}
	
	/**
	 * Returns the startBranch of the Reservation.
	 * @return Starting branch of the Reservation.
	 */
	public Branch getStartBranch()
	{
		return startBranch;
	}
	
	/**
	 * Returns the endBranch of the Reservation.
	 * @return Ending branch of the Reservation.
	 */
	public Branch getEndBranch()
	{
		return endBranch;
	}
	
	/**
	 * Returns the Account of the Reservation.
	 * @return Account of the Reservation.
	 */
	public Account getAccount()
	{
		return account;
	}
	
}