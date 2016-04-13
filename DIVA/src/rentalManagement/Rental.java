package rentalManagement;

/**
 * Rental has-a Reservation. 
 * @author Robin
 *
 */
public class Rental {
	
	private boolean is_paid_rental;
	private boolean is_paid_extra_charge;
	Reservation res;

	/**
	 * Default constructor should not be used
	 */
	public Rental(){
		res = null;
		is_paid_rental = false;
		is_paid_extra_charge = false;
	}
	
	/**
	 * Rental has a reservation
	 * @param r a reservation object
	 */
	public Rental(Reservation r){
		res = r;
		is_paid_rental = false;
		is_paid_extra_charge = false;
	}
	
	/**
	 * Set is_paid_rental
	 * @param f true or false
	 */
	public void setIsPaidRental(boolean f){
		is_paid_rental = f;
	}
	
	/**
	 * Set is_paid_extra_charge
	 * @param f true or false
	 */
	public void setIsPaidExtracharge (boolean f){
		is_paid_extra_charge = f;
	}
	
	/**
	 * Set rental reservation
	 * @param r reservation object
	 */
	public void setRentalReservation(Reservation r){
		res = r;
	}
	
	/**
	 * Get is_paid_rental
	 * @return is_paid_rental
	 */
	public boolean getIsPaidRental(){
		return is_paid_rental;
	}
	
	/**
	 * Get is_paid_extra_charge
	 * @return is_paid_extra_charge
	 */
	public boolean getIsPaidExtraCharge(){
		return is_paid_extra_charge;
	}
	
	/**
	 * Get reservation of rental
	 * @return reservation object
	 */
	public Reservation getRentalReservation(){
		return res;
	}
}
