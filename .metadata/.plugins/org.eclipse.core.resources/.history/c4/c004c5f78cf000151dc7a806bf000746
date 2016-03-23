package rentalManager;

import java.util.Date;

import accountManager.Account;
import vehicleManager.Equipment;
import vehicleManager.Vehicle;

// assumes param objects are already constructed, such as Vehicle, list of Equipments, Location, and Date.
public class RentalManager {

	// should be contained i think, since every branch should have a unique manager
	private static ReserveManager reservMan;
	
	public RentalManager()
	{
		reservMan = new ReserveManager();
	}
	
	public void createReservation(Date date, Vehicle v, Equipment[] equips, Location location, Account acc)
	{
		reservMan.addReservation(date, v, equips, location, acc);
	}
	
	public void cancelReservation(Reservation r)
	{
		reservMan.removeReservation(r);
	}
	
	// does not deal with illegal params
	public Reservation[] searchReservation(Object o)
	{
		return null;
		//return reservMan.searchReservations(o);
	}
	
	public void changeReservationDetail(Object o)
	{
		//reservMan.changeReservation(o);
	}
	
	public void addReservationEquipment(Reservation r, Equipment e)
	{
		//reservMan.addReservationEquipment(r, e);
	}
	
	public void removeReservationEquipment(Reservation r, Equipment e)
	{
		//reservMan.removeReservationEquipment(r, e);
	}
	
	public void createRental() {
	}
	
	public void createReturn() {
	}
	
}
