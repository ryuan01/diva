package vehicleManagement;

/**
 * 
 * A Car Class which represents the type of a Vehicle.
 *
 */
public class Car extends Vehicle{

	public String car_class; 
	// can be one of: {economy, compact, midsized, standard, fullsized, premium, luxury, SUV, van};
	private int baggage;
	private String door;
	private boolean transmission;
	private boolean air_condition;
	private int capacity;

	/**
	 * 
	 * @param id
	 * @param manufacturer
	 * @param year
	 * @param model
	 * @param color
	 * @param status
	 * @param path
	 * @param c
	 * @param b
	 * @param d
	 * @param tran
	 * @param ac
	 * @param ca
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
	
	public Car_class getClass(){
		return c_Class;
	}

}

