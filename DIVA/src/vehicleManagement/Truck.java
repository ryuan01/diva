package vehicleManagement;

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

	public Truck(int id, String manufacturer, String year, String model, String color, String status, String path,
			String c, double ibl, double ibw, double ibh, int ca) {
		super(id, manufacturer, year, model, color, status, path);
		// TODO Auto-generated constructor stub
		this.truck_class = c;
		this.interior_b_l = ibl;
		this.interior_b_w = ibw;
		this.interior_b_h = ibh;
		this.capacity_kg = ca;
	}
	
}
