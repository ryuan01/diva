package accountManagement;

import systemManagement.Location;
import webServiceManagement.ArrayOfStringsable;

public class Customer extends Account implements ArrayOfStringsable{
	private String standing;
	private long cc_num;
	private String name_on_card;
	private Location location;
	
	public Customer(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, int id,
			long cc, String name_on_card, String address, 
			String city, String province, String zip, String standing) {
		
		super(firstname, lastname, phoneNumber, email, loginId, id);
		// TODO Auto-generated constructor stub
		
		this.location = new Location (address, city, province, zip);
		this.cc_num = cc;
		this.name_on_card = name_on_card;
		super.objectClass = getClass().getName();
		this.standing = standing;
	}
	
	// with password
	public Customer(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, int id, 
			String password, long cc, String name_on_card, 
			String address, String city, String province, String zip) {
		
		// the super with password
		super(firstname, lastname, phoneNumber, email, loginId, password);
		this.location = new Location (address, city, province, zip);
		this.cc_num = cc;
		this.name_on_card = name_on_card;
		super.objectClass = getClass().getName();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the standing
	 */
	public String getStanding() {
		return standing;
	}

	/**
	 * @param standing the standing to set
	 */
	public void setStanding(String standing) {
		this.standing = standing;
	}

	/**
	 * @return the cc_num
	 */
	public long getCc_num() {
		return cc_num;
	}

	/**
	 * @param cc_num the cc_num to set
	 */
	public void setCc_num(long cc_num) {
		this.cc_num = cc_num;
	}

	/**
	 * @return the name_on_card
	 */
	public String getName_on_card() {
		return name_on_card;
	}

	/**
	 * @param name_on_card the name_on_card to set
	 */
	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	/**
	 * @return the location of customer's home
	 */
	public Location getLocation() {
		return this.location;
	}
	
	/**
	 * Overrides toString() method
	 */
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'fisrtName':'"+this.getFirstname()
				+"','lastname':'"+this.getLastname()+"',"+"'phoneNumber':'"+this.getPhoneNumber()
				+"','email':'"+this.getEmail()+"','status':'"+this.getLoginId()
				+"','objectClass':'"+this.getObjectClass()+"', 'standing':'"+this.standing
				+"','cc_num':'"+this.cc_num+"', 'name_on_card':'"+this.name_on_card
				+"','street_name':'"+this.location.getAddress()+"', 'city':'"+this.location.getCity()
				+"','province':'"+this.location.getProvince()+"', 'zip':'"+this.location.getZipcode()
				+"'}";
	}

}
