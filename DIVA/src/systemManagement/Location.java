package systemManagement;

/**
 * Separate location address from other class.
 * @author Robin
 *
 */
public class Location {
	private String address;
	private String city;
	private String province;
	private String zipcode;
	
	/**
	 * Create a location
	 * @param address street number and street name
	 * @param city name of city
	 * @param province from set {'AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT'}
	 * @param zipcode uniquely identifies this address  of format {[A-Z][0-9][A-Z][0-9][A-Z][0-9]}
	 */
	public Location (String address, String city, String province, String zipcode){
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	/**
	 * Get address
	 * @return address 
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * Get city
	 * @return city
	 */
	public String getCity(){
		return city;
	}
	
	/**
	 * Get province
	 * @return province
	 */
	public String getProvince(){
		return province;
	}
	
	/**
	 * Get zipcode
	 * @return zipcode
	 */
	public String getZipcode(){
		return zipcode;
	}
	
	/**
	 * Set address of location 
	 * @param address street name and street number
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Set province
	 * @param province name of province from set {'AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT'}
	 */
	public void setProvince(String province){
		this.province = province;
	}
	
	/**
	 * Set city
	 * @param city name of city
	 */
	public void setCity(String city){
		this.city = city;
	}
	
	/**
	 * Set zipcode
	 * @param zipcode of format {[A-Z][0-9][A-Z][0-9][A-Z][0-9]}
	 */
	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

}
