package accountManagement;

import webServiceManagement.ArrayOfStringsable;

public class SuperCustomer extends Customer implements ArrayOfStringsable{

	private int points;
	//need to implement
	

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param phoneNumber
	 * @param email
	 * @param loginId
	 * @param id
	 * @param cc
	 * @param name_on_card
	 * @param street
	 * @param city
	 * @param province
	 * @param zip
	 * @param points
	 */
	public SuperCustomer(String firstname, String lastname, String phoneNumber, String email, String loginId, int id,
			long cc, String name_on_card, String street, String city, String province, String zip,int points) {
			super(firstname,  lastname, phoneNumber, email, loginId, id,
					cc, name_on_card, street, city,province, zip);
			this.points = points;
			super.objectClass = getClass().getName();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * Overrides toString() method
	 */
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'fisrtName':'"+this.getFirstname()
				+"','lastname':'"+this.getLastname()+"',"+"'phoneNumber;':'"+this.getPhoneNumber()
				+"','email':'"+this.getEmail()+"','status':'"+this.getLoginId()
				+"','objectClass':'"+this.getObjectClass()+"', 'standing':'"+this.getStanding()
				+"','cc_num':'"+this.getCc_num()+"', 'name_on_card':'"+this.getName_on_card()
				+"','street_name':'"+super.getLocation().getAddress()+"', 'city':'"+super.getLocation().getCity()
				+"','province':'"+super.getLocation().getProvince()+"', 'zip':'"+super.getLocation().getZipcode()
				+"','points':'"+this.points
				+"'}";
	}
}
