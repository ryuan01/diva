package accountManagement;

public class Customer extends Account{
	private String standing;
	private long cc_num;
	private String name_on_card;
	private String street_name;
	private String city;
	private String province;
	private String zip;
	
	public Customer(String firstname, String lastname, String phoneNumber, String email, String loginId, int id,
			long cc, String name_on_card, String street, String city, String province, String zip) {
		super(firstname, lastname, phoneNumber, email, loginId, id);
		// TODO Auto-generated constructor stub
		this.cc_num = cc;
		this.name_on_card = name_on_card;
		this.street_name = street;
		this.city = city;
		this.province = province;
		this.zip=zip;
		super.objectClass = getClass().getName();
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
	 * @return the street_name
	 */
	public String getStreet_name() {
		return street_name;
	}

	/**
	 * @param street_name the street_name to set
	 */
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
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
				+"','street_name':'"+this.street_name+"', 'city':'"+this.city
				+"','province':'"+this.province+"', 'zip':'"+this.zip
				+"'}";
	}

}
