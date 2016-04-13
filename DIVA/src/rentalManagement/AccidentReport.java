package rentalManagement;

import java.math.BigDecimal;

import systemManagement.Location;

/**
 * An accident report is a special kind of report filled out when rented vehicles are in accident.
 * @author Robin
 *
 */
public class AccidentReport{

	private int report_id;
	private int clerkID;
	private String accident_date;
	private String description;
	private int rentalID;
	private Location location;
	private String driver; //who is responsible
	private BigDecimal amount; //that the person has to pay the rental company
	
	public AccidentReport(int clerkID, String accident_date, String description, int rentalID, String address, 
			String city, String province, String zipcode, String driver, BigDecimal amount, int r_num) {
		// TODO Auto-generated constructor stub
		this.report_id = r_num;
		this.clerkID = clerkID;
		this.accident_date = accident_date;
		this.description = description;
		this.rentalID = rentalID;
		this.location = new Location(address,city,province,zipcode);
		this.driver = driver;
		this.amount = amount;
	}
	
	/**
	 * Get ID of this accident report
	 * @return ID
	 */
	public int getID(){
		return this.report_id;
	}
	/**
	 * Get clerk who processes this report
	 * @return ID of this clerk
	 */
	public int getClerkID(){
		return this.clerkID;
	}
	
	/**
	 * Get the date that this accident report was filed
	 * @return date 
	 */
	public String getDate(){
		return this.accident_date;
	}
	
	/**
	 * Get description on this accident
	 * @return description
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * Get the rental ID that is associated with this accident
	 * @return rental ID
	 */
	public int getRentalID(){
		return this.rentalID;
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
	 * Set accident report ID
	 * @param id report ID
	 */
	public void setID(int id){
		this.report_id = id;
	}
	/**
	 * Set clerk ID of this report
	 * @param id clerk ID
	 */
	public void setClerkID(int id){
		this.clerkID = id;
	}
	
	/**
	 * Set accident date
	 * @param d accident date
	 */
	public void setAccidentDate(String d){
		this.accident_date = d;
	}
	
	/**
	 * Set the description
	 * @param d description
	 */
	public void setDescription(String d){
		this.description = d;
	}
	
	/**
	 * Set the ID of rental for this accident
	 * @param id rental ID
	 */
	public void setRentalID(int id){
		this.rentalID = id;
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
	
	@Override
	public String toString() {
				
		//passing back dates in the format dd-mm-yyyy as Strings.
		return "{'report_id':'"+ this.report_id +"', 'clerkID':'"+this.clerkID+"',"
			+	"'accident_date':'"+this.accident_date+"',"+"'description':'"+description+"',"
			+ "'rentalID':'"+this.rentalID+"',"+"'address':'"+this.location.getAddress()+"',"
			+ "'city':'"+this.location.getCity()+"',"+"'province':'"+this.location.getProvince()+"',"
			+ "'driver':'"+this.driver+"','zip':'"+this.location.getZipcode()+"',"
			+ "'amount':'"+this.amount+"'}";
	}
}
