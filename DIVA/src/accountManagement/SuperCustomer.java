package accountManagement;

import webServiceManagement.ArrayOfStringsable;

public class SuperCustomer extends Customer implements ArrayOfStringsable{

	/**
	 * Amount of superRent points in SuperCustomer account
	 */
	private int points;

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
	public SuperCustomer(Customer customer ,int points) {
			
		super(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber(),
				customer.getEmail(), customer.getLoginId(),customer.getID(), 
				customer.getCc_num(), customer.getExpireDate(),customer.getName_on_card(), customer.getLocation().getAddress(),
				customer.getLocation().getCity(), customer.getLocation().getProvince(),
				customer.getLocation().getZipcode(), customer.getStanding());
		this.points = points;
		super.objectClass = getClass().getName();
	}

	/**
	 * 
	 * @return Amount of superRent points in SuperCustomer account
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * @param points Amount of superRent points in SuperCustomer account
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	/**
	 * @override super.toString()
	 */
	@Override
	public String toString(){
		return "{'id':'"+ this.getID() +"', 'fisrtName':'"+this.getFirstname()
				+"','lastname':'"+this.getLastname()+"',"+"'phoneNumber;':'"+this.getPhoneNumber()
				+"','email':'"+this.getEmail()+"','status':'"+this.getLoginId()
				+"','objectClass':'"+this.getObjectClass()+"', 'standing':'"+this.getStanding()
				+"','name_on_card':'"+this.getName_on_card()
				+"','street_name':'"+super.getLocation().getAddress()+"', 'city':'"+super.getLocation().getCity()
				+"','province':'"+super.getLocation().getProvince()+"', 'zip':'"+super.getLocation().getZipcode()
				+"','points':'"+this.points
				+"'}";
	}
}
