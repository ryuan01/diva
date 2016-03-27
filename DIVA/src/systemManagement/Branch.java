package systemManagement;

//import vehicleManagement.Vehicle;
import java.util.ArrayList;

public class Branch {
	
	private int id;
	private String streetName;
	private String city;
	private String province;
	private String zipcode;
	// ArrayList<Vehicle> fleet;
	
	public Branch(String streetName, String city, String province, String zipcode){
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	// Getters and Setters
	public String getStreetName(){
		return streetName;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getProvince(){
		return province;
	}
	
	public String getZipCode(){
		return zipcode;
	}
	
	// public interface
}
