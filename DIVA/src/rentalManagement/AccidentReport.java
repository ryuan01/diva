package rentalManagement;

import java.math.BigDecimal;

import systemManagement.Location;

/**
 * An accident report is a special kind of report filled out when rented vehicles are in accident.
 * @author Robin
 *
 */
public class AccidentReport extends Report{

	//finish later
	//make a new location class
	private Location location;
	private String driver; //who is responsible
	private BigDecimal amount; //that the person has to pay the rental company
	
	public AccidentReport(String d, String description, int reservID, int milage, int gasLevel, String address, String city, String province, String zipcode, String driver, BigDecimal amount) {
		super(d, description, reservID, milage, gasLevel);
		// TODO Auto-generated constructor stub
		this.location = new Location(address,city,province,zipcode);
		this.driver = driver;
		this.amount = amount;
	}
	
	/**
	 * Get location
	 * @return Location object
	 */
	public Location getLocation(){
		return this.location;
	}
	
	/**
	 * Get Driver 
	 * @return driver name
	 */
	public String getDriver(){
		return this.driver;
	}
	
	/**
	 * Get amount
	 * @return amount owning because of the accident
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 * Set location of accident
	 * @param address street number and name
	 * @param city name of city 
	 * @param province from set {'AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT'}
	 * @param zipcode uniquely identifies this address  of format {[A-Z][0-9][A-Z][0-9][A-Z][0-9]}
	 */
	public void setLocation(String address, String city, String province, String zipcode){
		this.location.setAddress(address);
		this.location.setCity(city);
		this.location.setProvince(province);
		this.location.setZipcode(zipcode);
	
	}
	
	/**
	 * Set driver name
	 * @param driver name of driver
	 */
	public void setDriver(String driver){
		this.driver = driver;
	}
	
	/**
	 * Set amount
	 * @param amount amount owning 
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
}
