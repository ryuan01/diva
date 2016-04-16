package rentalManagement;

/**
 * Rental has-a Reservation. 
 * @author Robin
 *
 */
public class Rental {
	
	private boolean is_paid_rental;
	private boolean is_paid_extra_charge;
	private boolean is_check_overdue;
	private boolean is_check_return_branch;
	private Reservation res;

	/**
	 * Default constructor should not be used
	 */
	public Rental(){
		res = null;
		is_paid_rental = false;
		is_paid_extra_charge = false;
		is_check_overdue = false;
		is_check_return_branch = false;		
	}
	
	/**
	 * Rental has a reservation
	 * @param r a reservation object
	 */
	public Rental(Reservation r){
		res = r;
		is_paid_rental = false;
		is_paid_extra_charge = false;
		is_check_overdue = false;
		is_check_return_branch = false;
	}
	
	public Rental(Reservation r, boolean is_paid_rental, boolean is_paid_extra_charge, boolean is_check_overdue, boolean is_check_return_branch){
		res = r;
		this.is_paid_rental = is_paid_rental;
		this.is_paid_extra_charge = is_paid_extra_charge;
		this.is_check_overdue = is_check_overdue;
		this.is_check_return_branch = is_check_return_branch;
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
	
	public boolean getIsCheckOverdue(){
		return this.is_check_overdue;
	}
	public boolean getIsCheckReturnBranch(){
		return this.is_check_return_branch;
	}
	public void setIsCheckOverdue(boolean is_check_overdue){
		this.is_check_overdue = is_check_overdue;
	}
	public void setIsCheckReturnBranch(boolean is_check_return_branch){
		this.is_check_return_branch = is_check_return_branch;
	}
	
	@Override
	public String toString() {
				
		//passing back dates in the format dd-mm-yyyy as Strings.
		return "{'is_paid_rental':'"+ this.is_paid_rental +"', 'is_paid_extra_charge':'"+this.is_paid_extra_charge+"',"
			+ "'reservationID':'"+this.res.getID()+"'}";
	}
}
