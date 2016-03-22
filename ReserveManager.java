package rentalManager;

public class ReserveManager {
	
	// makes Reservations more searchable, otherwise reservations would be stored in Accounts.
	private ArrayList<Reservation> listOfReservations;
	
	public ReserveManager()
	{
		listOfReservations = new ArrayList<Reservation>();
	}
	
	// assumes Vehicle has status state and changeStatus method. Potential requires locking
	public void addReservation(Date date, Vehicle vehicle, ArrayList<Equipment> equips, Location location, Account acc)
	{
		reserv = new Reservation(date, vehicle, equips, location, acc);
		listOfReservations.add(reserv);
		vehicle.changeStatus("Reserved");
	}
	
	// assumes Vehicle has status state and changeStatus method. Potential requires locking
	public void removeReservation(Reservation r)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.get(i).getVehicle.changeStatus("Available");
				listOfReservations.remove(i);
			}
		}
	}
	
	// Assume Account has equals() method *Overloaded
	public ArrayList<Reservation> searchReservations(Account acc)
	{
		tempReservList = new ArrayList<Reservation>();
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).getAccount().equals(acc))
			{
				tempReservList.add(listOfReservations.get(i));
			}
		}
		return tempReservList;
	}
	
	// assumes Vehicle has overriden equals() method *Overloaded
	public ArrayList<Reservation> searchReservations(Vehilce v)
	{
		tempReservList = new ArrayList<Reservation>();
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).getVehicle().equals(v))
			{
				tempReservList.add(listOfReservations.get(i));
			}
		}
		return tempReservList;
	}
	
	// only accessible for manager? *Overloaded
	public ArrayList<Reservation> searchReservations(Location l)
	{
		tempReservList = new ArrayList<Reservation>();
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).getLocation().equals(l))
			{
				tempReservList.add(listOfReservations.get(i));
			}
		}
		return tempReservList;
	}
		
	//*Overloaded
	public ArrayList<Reservation> searchReservations(Date d)
	{
		tempReservList = new ArrayList<Reservation>();
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).getDate().equals(d))
			{
				tempReservList.add(listOfReservations.get(i));
			}
		}
		return tempReservList;
	}
		
	//*Overloaded
	public void changeReservation(Reservation r, Date newDate)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.changeDate(newDate);
			}
		}
	}

	// *Overloaded
	public void changeReservation(Reservation r, Location newLocation)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.changeLocation(newLocation);
			}
		}
	}
	
	public void changeReservation(Reservation r, Vehicle newVehicle)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.changeVehicle(newVehicle);
			}
		}
	}
	
	public void addReservationEquipment(Reservation r, Equipment newEquipment)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.addEquipment(newEquipment);
			}
		}
	}
	
	public void removeReservationEquipment(Reservation r, Equipment removedEquipment)
	{
		for(int i = 0; i < listOfReservations.size(); i++)
		{
			if(listOfReservations.get(i).equals(r))
			{
				listOfReservations.removeEquipment(removedEquipment);
			}
		}
	}
	
	
	
	
}
