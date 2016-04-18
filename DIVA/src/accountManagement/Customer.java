package accountManagement;

import systemManagement.Location;
import webServiceManagement.ArrayOfStringsable;

public class Customer extends Account implements ArrayOfStringsable{
	private String standing;
	private String cc_num;
	private String name_on_card;
	private String expire_date;
	private Location location;
	
	/**
	 * constructor without password;
	 * @param firstname first name of customer
	 * @param lastname last name of customer
	 * @param phoneNumber phone number of customer of format 10 digits 
	 * @param email email of customer (format checked by front end)
	 * @param loginId unique login username
	 * @param id unique ID 
	 * @param cc credit card number (should always be encrypted)
	 * @param expire_date expire date of credit card
	 * @param name_on_card the name of card holder
	 * @param address street number and street name
	 * @param city city of address
	 * @param province province of address (limited to Canada, shorthanded as two upper-case letters
	 * @param zip ZIP code following format [A-Z][0-9][A-Z][0-9][A-Z][0-9]
	 * @param standing can be 'Good', 'Probation', 'Suspended' (this feature is not used in this version)
	 */
	public Customer(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, int id,
			String cc, String expire_date, String name_on_card, String address, 
			String city, String province, String zip, String standing) {
		
		super(firstname, lastname, phoneNumber, email, loginId, id);
		
		this.location = new Location (address, city, province, zip);
		this.cc_num = cc;
		this.expire_date = expire_date;
		this.name_on_card = name_on_card;
		super.objectClass = getClass().getName();
		this.standing = standing;
	}

	/**
	 * Constructor with password
	 * @param firstname first name of customer
	 * @param lastname last name of customer
	 * @param phoneNumber phone number of customer of format 10 digits 
	 * @param email email of customer (format checked by front end)
	 * @param loginId unique login username
	 * @param id unique ID 
	 * @param password encrypted(hashed) password of customer
	 * @param cc credit card number (should always be encrypted)
	 * @param expire_date expire date of credit card
	 * @param name_on_card the name of card holder
	 * @param address street number and street name
	 * @param city city of address
	 * @param province province of address (limited to Canada, shorthanded as two upper-case letters
	 * @param zip ZIP code following format [A-Z][0-9][A-Z][0-9][A-Z][0-9]
	 * @param standing can be 'Good', 'Probation', 'Suspended' (this feature is not used in this version)
	 */
	public Customer(String firstname, String lastname, String phoneNumber, 
			String email, String loginId, int id, 
			String password, String cc, String expire_date, String name_on_card, 
			String address, String city, String province, String zip, String standing) 
	{	
		super(firstname, lastname, phoneNumber, email, loginId, password);
		
		this.location = new Location (address, city, province, zip);
		this.cc_num = cc;
		this.expire_date = expire_date;
		this.name_on_card = name_on_card;
		super.objectClass = getClass().getName();
		this.standing = standing;
	}
	
	/**
	 * Get expire date of credit card on file
	 * @return expire date
	 */
	public String getExpireDate(){
		return this.expire_date;
	}
	
	/**
	 * Set expire date
	 * @param date	expre date
	 */
	public void setExpireDate(String date){
		this.expire_date = date;
	}
	
	/**
	 * Get standing of customer
	 * @return customer standing
	 */
	public String getStanding() {
		return standing;
	}

	/**
	 * Set standing of customer
	 * @param standing customer standing
	 */
	public void setStanding(String standing) {
		this.standing = standing;
	}

	/**
	 * Get encrypted credit card of customer
	 * @return customer encrypted credit-card number
	 */
	public String getCc_num() {
		return cc_num;
	}

	/**
	 * Set credit card of customer (encrypted)
	 * @param cc_num customer encrypted credit-card number
	 */
	public void setCc_num(String cc_num) {
		this.cc_num = cc_num;
	}

	/**
	 * Get credit card holder's name on file
	 * @return name on customer credit card
	 */
	public String getName_on_card() {
		return name_on_card;
	}

	/**
	 * Set credit card holder's name on file
	 * @param name_on_card name on customer credit card
	 */
	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	/**
	 * Get location of customer
	 * @return the location of customer's address object
	 */
	public Location getLocation() {
		return this.location;
	}
	
	/**
	 * Turns the data associated with this object into a JSON String
	 */
	@Override
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
