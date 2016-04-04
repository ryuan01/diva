package systemManagement;
/**
 * Branch is a location where customers can rent/buy cars/trucks and employees work at.
 * @Author: Saud (Sammy) Almahri, Robin
 * @date April 3 2016 
 */
public class Branch {
	
	private String objectClass;
	private int id;
	private String address;
	private String city;
	private String province;
	private String zipcode;
	
	/**
	 * Create a branch
	 * @param address number and street
	 * @param city city
	 * @param province province from set('AB', 'BC', 'MB', 'NB', 'NL', 'NS', 'NT', 'NU') because this is Canada only
	 * @param zipcode uniquely identifies address 
	 */
	public Branch(int id, String address, String city, String province, String zipcode){
		this.id = id;
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
		this.objectClass = getClass().getName();
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
		return address+" "+city+" "+province+" "+zipcode;
	}
	
	/**
	 * It doesn't make sense to modify an address separately, therefore they need to be edited together
	 * @param address
	 * @param city
	 * @param province
	 * @param zipcode
	 */
	public void setFullAddress(String address, String city, String province, String zipcode){
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
	}
}
