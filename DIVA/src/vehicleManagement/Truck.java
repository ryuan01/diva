package vehicleManagement;

import java.util.Date;

/**
 * 
 * A Truck Class which represents the type of a Vehicle.
 *
 */

public class Truck extends Vehicle{

	//wait to be done
	private String truck_class;
	private double interior_b_l;
	private double interior_b_w;
	private double interior_b_h;
	private int capacity_kg;

	/**
	 * Create a truck 
	 * @param id uniquely identifies car 
	 * @param manufacturer who made this car
	 * @param year year of purchase
	 * @param model model of car
	 * @param color color of car 
	 * @param status from set(for rent, for sale, sold)
	 * @param path relative path to a picture
	 * @param c truck class from set ('24-foot', '15-foot', '12-foot', 'box-truck')
	 * @param ibl interior length in foot
	 * @param ibw interior width in foot
	 * @param ibh interior width in foot 
	 * @param ca maximum kg that a truck can hold
	 */
	public Truck(int id, String manufacturer, Date year, String model, String color, String status, String path,
			String c, double ibl, double ibw, double ibh, int ca) {
		super(id, manufacturer, year, model, color, status, path);
		// TODO Auto-generated constructor stub
		this.truck_class = c;
		this.interior_b_l = ibl;
		this.interior_b_w = ibw;
		this.interior_b_h = ibh;
		this.capacity_kg = ca;
	}
	
	/**
	 * Get truck class
	 * @return truck class
	 * @post truck class from set ('24-foot', '15-foot', '12-foot', 'box-truck')
	 */
	public String getTruckClass(){
		return truck_class;
	}
	/**
	 * Get interior length of a truck
	 * @return interior length in foot and inches 
	 */
	public double getBL(){
		return this.interior_b_l;
	}
	/**
	 * Get interior width of a truck
	 * @return interior width in foot and inches 
	 */
	public double getBW(){
		return this.interior_b_w;
	}
	/**
	 * Get interior height of a truck
	 * @return interior height in foot and inches 
	 */
	public double getBH(){
		return this.interior_b_h;
	}
	/**
	 * Get capacity of truck
	 * @return capacity in kg
	 */
	public int getCapacity(){
		return this.capacity_kg;
	}
	/**
	 * Set truck class 
	 * @param c class of truck
	 * @pre c is from set ('24-foot', '15-foot', '12-foot', 'box-truck')
	 * @post truck_class =c
	 */
	public void setTruckClass(String c){
		this.truck_class=c;
	}
	/**
	 * Set interior length
	 * @param l length in foot
	 * @post interior_b_l = l
	 */
	public void setBL(double l){
		this.interior_b_l =l;
	}
	/**
	 * Set interior width
	 * @param w width in foot
	 * @post interior_b_w = w
	 */
	public void setBW(double w){
		this.interior_b_w = w;
	}
	/**
	 * Set interior height
	 * @param h height in foot
	 * @post interior_b_h = h
	 */
	public void setBH(double h){
		this.interior_b_h=h;
	}
	/**
	 * Set capacity of truck
	 * @param c capacity in kg
	 */
	public void setCapacity(int c){
		this.capacity_kg = c;
	}
	/**
	 * Get all interior at once as a String
	 * @return all interior
	 */
	public String getInterior(){
		return "length: "+interior_b_l+" width: "+this.interior_b_w+" height: "+this.interior_b_h;
	}
	
}
