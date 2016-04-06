package vehicleManagement;

import webSerivceManagement.ArrayOfStringsable;

/**
 * 
 * A Car Class which represents the type of a Vehicle.
 *
 */
public class Car extends Vehicle implements ArrayOfStringsable{

	private String car_class; 
	private int baggage;
	private String door;
	private boolean transmission;
	private boolean air_condition;
	private int capacity;

	/**
	 * Create a car object 
	 * @param id uniquely identifies car 
	 * @param manufacturer who made this car
	 * @param year year of purchase
	 * @param model model of car
	 * @param color color of car 
	 * @param status from set(for rent, for sale, sold)
	 * @param path relative path to a picture
	 * @param c class of car from set ('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van')
	 * @param b number of baggage a car can hold
	 * @param d number of a door this car has
	 * @param tran auto transmission or manual transmission
	 * @param ac air conditioning or no air air conditioning
	 * @param ca how many people this car can sit
	 */
	public Car(int id, String manufacturer, String year, String model, String color, String status, String path,
			String c, int b, String d, boolean tran, boolean ac, int ca) {
		super(id, manufacturer, year, model, color, status, path);
		car_class = c;
		baggage = b;
		door = d;
		transmission = tran;
		air_condition = ac;
		capacity = ca;
	}
	
	/**
	 * Get baggage capacity of a car
	 * @return number of baggage capacity
	 */
	public int getBaggage(){
		return baggage;
	}
	/**
	 * Get number of doors of a car
	 * @return number of doors
	 */
	public String getDoor(){
		return door;
	}
	/**
	 * Get transmission status of a car
	 * @return true if there is auto transmission, otherwise false
	 */
	public boolean getTransmission(){
		return transmission;
	}
	/**
	 * Get air conditioning status of a car
	 * @return true if there is air conditioning, otherwise false
	 */
	public boolean getAC(){
		return air_condition;
	}
	/**
	 * Get capacity of car
	 * @return maximum number of passengers
	 */
	public int getCapacity(){
		return capacity;
	}
	/**
	 * Get class of a car 
	 * @return a class from set ('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van')
	 */
	public String getCarClass(){
		return car_class;
	}
	/**
	 * Set class of a car
	 * @param c class
	 * @pre c is from set ('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van')
	 * @post car_class = c
	 */
	public void setCarClass(String c){
		this.car_class = c;
	}
	/**
	 * Set baggage capacity of a car
	 * @param i baggage capacity 
	 * @pre i is unsigned, from set {2,4,5,8}
	 * @post baggage = i
	 */
	public void setBaggage(int i){
		baggage = i;
	}
	/**
	 * Set number of doors of a car
	 * @param d number of doors
	 * @pre d is from set ('2/3','4/5','2','4')
	 * @post door = d
	 */
	public void setDoor(String d){
		door = d;
	}
	/**
	 * Set transmission status of a car
	 * @param f true or false
	 * @post transmission = f
	 */
	public void setTransmission(boolean f){
		transmission = f;
	}
	/**
	 * Set air condition status of a car
	 * @param f true or false
	 * @post air_condition = f
	 */
	public void setAC(boolean f){
		air_condition = f;
	}
	/**
	 * Set capacity of a car
	 * @param c capacity of a car
	 * @pre c is from set (2,4,5,8)
	 * @post capacity = c
	 */
	public void setCapacity(int c){
		capacity = c;
	}
	
	/**
	 * Overrides toString() method
	 */
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'manufacturer':'"+this.getManufacturer()
				+"','v_year':'"+this.getYear()+"',"+"'model':'"+this.getModel()
				+"','color':'"+this.getColor()+"','status':'"+this.getStatus()
				+"','path':'"+this.getPath()+"', 'objectClass':'"+this.getObjectClass()
				+"','rentalPrice':'"+this.getPrice()+"','car_class':'"+this.car_class
				+"','baggage':'"+this.baggage+"','door':'"+this.door
				+"','transmission':'"+this.transmission+"','air_condition':'"+this.air_condition
				+"','capacity':'"+this.capacity+"'}";
	}
}

