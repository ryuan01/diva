package rentalManagement;

import java.util.ArrayList;
import java.util.Date;

import accountManagement.Account;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

//Assumes Date object is passed instead of a primitive.
// Needs javadoc
public class Reservation {

	private Date date;
	private Vehicle vehicle;
	private ArrayList<Equipment> equipment;
	private Location location;
	private Account account;
	
	/**
	 * Creates empty Reservation.
	 */
	public Reservation()
	{
		date = new Date();
		vehicle = new Vehicle(0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null);
		equipment = new ArrayList<Equipment>();
		location = new Location();
		account = new Account();
	}
	
	/**
	 * Create a Reservation with Date, Vehicle, Equipment, Location.
	 * @param d Date of the reservation.
	 * @param v Vehicle of the reservation.
	 * @param e Equipment of the reservation.
	 * @param l Location of the reservation.
	 */
	public Reservation(Date d, Vehicle v, Equipment e, Location l, Account a)
	{
		/*
		date = d;
		vehicle = v;
		equipment = e;
		location = l;
		account = a;
		*/
	}
	
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
	
	public void changeDate(Date newDate)
	{
		date = newDate;
	}
	
	public void changeVehicle(Vehicle newVehicle)
	{
		vehicle = newVehicle;
	}
	
	//needs testing, could throw exception equipmentAlreadyReserved?
	public void addEquipment(Equipment newEquipment)
	{
		/*
		equipment = equipment.add(newEquipment);
		newEquipment.changeStatus(False);
		*/
	}
	
	//throws exception if toBeRemovedEquipment is not in the equipment list. (shouldn't happen)
	public void removeEquipment(Equipment toBeRemovedEquipment)
	{
		/*
		for(int i = 0; i < equipment.size(); i++)
		{
			if(equipment.get(i).getID() = toBeRemovedEquipment.getID())
			{
				equipment.remove(i);
				toBeRemovedEquipment.changeStatus(True);
			}
		}
		*/
	}
	
	public void changeLocation(Location newLocation)
	{
		location = newLocation;
	}
	
	public void changeAccount(Account newAccount)
	{
		account = newAccount;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	public ArrayList<Equipment> getEquipments()
	{
		return equipment;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
}