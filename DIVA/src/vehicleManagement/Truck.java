package vehicleManagement;

import java.math.BigDecimal;

import webSerivceManagement.ArrayOfStringsable;

/**
 * 
 * A Truck Class which represents the type of a Vehicle.
 *
 */

public class Truck extends Vehicle implements ArrayOfStringsable{

	private String truck_class;
	//changed dimensions to strings because of bigdecimal, decimal, and double inconsistency
	//between SQL and Java
	private String interior_b_l;
	private String interior_b_w;
	private String interior_b_h;
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
	public Truck(int id, String manufacturer, String year, String model, String color, String status, String path,
			String c, String ibl, String ibw, String ibh, int ca) {
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
	public String getBL(){
		return this.interior_b_l;
	}
	/**
	 * Get interior width of a truck
	 * @return interior width in foot and inches 
	 */
	public String getBW(){
		return this.interior_b_w;
	}
	/**
	 * Get interior height of a truck
	 * @return interior height in foot and inches 
	 */
	public String getBH(){
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
	 * @pre input is initialized using String so it is exact 
	 * @post interior_b_l = l
	 */
	public void setBL(BigDecimal l){
		this.interior_b_l =l.toString();
	}
	/**
	 * Set interior width
	 * @param w width in foot
	 * @pre input is initialized using String so it is exact 
	 * @post interior_b_w = w
	 */
	public void setBW(BigDecimal w){
		this.interior_b_w = w.toString();
	}
	/**
	 * Set interior height
	 * @param h height in foot
	 * @pre input is initialized using String so it is exact  
	 * @post interior_b_h = h
	 */
	public void setBH(BigDecimal h){
		this.interior_b_h=h.toString();
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
	
	/**
	 * Overrides toString() method
	 */
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'manufacturer':'"+this.getManufacturer()
				+"','v_year':'"+this.getYear()+"',"+"'model':'"+this.getModel()
				+"','color':'"+this.getColor()+"','status':'"+this.getStatus()
				+"','path':'"+this.getPath()+"', 'objectClass':'"+this.getObjectClass()
				+"','rentalPrice':'"+this.getPrice()+"','truck_class':'"+this.truck_class
				+"','interior_b_l':'"+this.interior_b_l+"','interior_b_w':'"+this.interior_b_w
				+"','interior_b_h;':'"+this.interior_b_h+"','capacity_kg':'"+this.capacity_kg
				+"'}";
	}
	
}
