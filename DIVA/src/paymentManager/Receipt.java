package paymentManager;

public class Receipt {

	private double price;
	private String vehicle_rented;
	private String duration;
	private String dropoff_location;
	
	public Receipt() {
		
	}

	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getVehicle_rented() {
		return vehicle_rented;
	}

	public void setVehicle_rented(String vehicle_rented) {
		this.vehicle_rented = vehicle_rented;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDropoff_location() {
		return dropoff_location;
	}

	public void setDropoff_location(String dropoff_location) {
		this.dropoff_location = dropoff_location;
	}
	
	
	
}
