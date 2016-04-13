package systemManagement;

import webServiceManagement.ArrayOfStringsable;

/**
 * Branch is a location where customers can rent/buy cars/trucks and employees work at.
 * @Author: Saud (Sammy) Almahri, Robin
 * @date April 3 2016 
 */
public class Branch implements ArrayOfStringsable{
	
	private String objectClass;
	private int id;
	private Location location;
	
	/**
	 * Create a branch
	 * @param address number and street
	 * @param city city
	 * @param province province from set('AB', 'BC', 'MB', 'NB', 'NL', 'NS', 'NT', 'NU') because this is Canada only
	 * @param zipcode uniquely identifies address 
	 */
	public Branch(int id, String address, String city, String province, String zipcode){
		this.id = id;
		this.location = new Location(address, city, province, zipcode);
		this.objectClass = getClass().getName();
	}
	
	/**
	 * Get location of a branch
	 * @return location
	 */
	public Location getLocation(){
		return this.location;
	}
	/**
	 * Get id of branch
	 * @return id
	 * @pre id is unique
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Get address of branch
	 * @return address 
	 */
	public String getFullAddress(){
		return location.getAddress() +" "+location.getCity()+" "+ location.getProvince() + " " + location.getZipcode();
	}
	
	/**
	 * It doesn't make sense to modify an address separately, therefore they need to be edited together
	 * @param address
	 * @param city
	 * @param province
	 * @param zipcode
	 */
	public void setFullAddress(String address, String city, String province, String zipcode){
		this.location.setAddress(address);
		this.location.setCity(city);
		this.location.setProvince(province);
		this.location.setZipcode(zipcode);
	}
	/**
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
	
	public String toString() {
		return "{'objectClass':'"+ this.objectClass +"', 'id':'"+this.id+"',"
			+	"'address':'"+this.location.getAddress()+"',"+"'city':'"+this.location.getCity()+"',"
			+ "'province':'"+this.location.getProvince()+"',"+"'zip':'"+this.location.getZipcode()+"'}";
	}
}
