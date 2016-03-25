package rentalManagement;

public class ReserveManager {
	
	/**
	 * A Manager for adding, removing, and modifying Reservations and its attributes.
	 */
	public ReserveManager()
	{
	}
	
	// assumes Vehicle has status state and changeStatus method. Potential requires locking
	/**
	 * Creates a Reservation with a date, vehicle, list of equipments, location, and account.
	 * @param date Date of the Reservation.
	 * @param vehicle Vehicle of the Reservation.
	 * @param equips Equips of the Reservation.
	 * @param startB The Branch Vehicle is Rented.
	 * @param endB The Branch Vehicle is Returned.
	 * @param acc Account of the Reservation.
	 */
	public void addReservation(Date date, Vehicle vehicle, Equipment[] equips, Branch startB, Branch endB, Account acc)
	{
	}
	
	// assumes Vehicle has status state and changeStatus method. Potential requires locking
	/**
	 * Removes a Reservation that belongs to the Customer account itself.
	 * @param c A Customer account.
	 * @param r The Reservation to be removed.
	 * @pre Reservation r belongs to Customer c
	 */
	public void removeReservation(Customer c,Reservation r)
	{
	}
	
	/**
	 * Removes a Reservation that belongs to anyone, can only be called by an Employee.
	 * @param e An Employee account.
	 * @param r The Reservation to be removed.
	 * @pre Method is called by an Employee.
	 */
	public void removeReservation(Employee e,Reservation r)
	{
	}
	
	// Assume Account has equals() method *Overloaded
	/**
	 * Searches for the list of Reservations belonging to a Customer Account.
	 * @param c The Customer Account to be searched.
	 * @return List of Reservations belonging to a Customer.
	 */
	public Reservation[] searchReservations(Customer c)
	{
	}
	
	// assumes Vehicle has overriden equals() method *Overloaded
	/**
	 * Searches Reservations that a Vehicle is assigned to.
	 * @param v Vehicle to search for.
	 * @return List of Reservations that a Vehicle is assigned to.
	 */
	public Reservation[] searchReservations(Vehilce v)
	{
	}
	
	//*Overloaded
	/**
	 * Searches Reservations that a Branch has.
	 * @param b Branch to search for.
	 * @return List of Reservations that a Branch has.
	 */
	public Reservation[] searchReservations(Branch b)
	{
	}
		
	//*Overloaded
	/**
	 * Searches Reservations that a Date is assigned to.
	 * @param d Date to search for.
	 * @return List of Reservations that a Date is assigned to.
	 */
	public ArrayList<Reservation> searchReservations(Date d)
	{
		return tempReservList;
	}
		
	//*Overloaded
	/**
	 * Modifies the Date of a Reservation.
	 * @param r The Reservation to be modified.
	 * @param newDate The Date to be modified.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public void changeReservation(Reservation r, Date newDate)
	{
	}

	// *Overloaded
	/**
	 * Modifies the Location of a Reservation.
	 * @param r The Reservation to be modified.
	 * @param newLocation The Location to be modified.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 */
	public void changeReservation(Reservation r, Location newLocation)
	{
	}
	
	/**
	 * Modifies the Vehicle of a Reservation.
	 * @param r The Reservation to be modified.
	 * @param newVehicle The Vehicle to be modified.
	 * @pre Only Reservation Account owner or Employee calls this method.
	 * @post All Equipments are also removed.
	 */
	public void changeReservation(Reservation r, Vehicle newVehicle)
	{
	}
	
	/**
	 * Adds an Equipment to the Reservation.
	 * @param r Reservation to be modified.
	 * @param newEquipment Equipment to be added.
	 */
	public void addReservationEquipment(Reservation r, Equipment newEquipment)
	{
	}
	
	/**
	 * Removes an Equipment to the Reservation.
	 * @param r Reservation to be modified
	 * @param removedEquipment Equipment to be removed.
	 */
	public void removeReservationEquipment(Reservation r, Equipment removedEquipment)
	{
	}
	
	
	
	
}