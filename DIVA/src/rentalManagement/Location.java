package rentalManagement;
/**
 * A Location with Street address, zip code, city, country.
 * @author Ben
 *
 */

// access and mutators potentially not needed, since if location is changed the entire object will be changed instead
public class Location {

	private String streetAddress;
	private String zipCode;
	private String city;
	private String country;
	
	/**
	 * Initializes streetAddress, zipCode, city, country to empty Strings.
	 */
	public Location()
	{
		streetAddress = "";
		zipCode = "";
		city = "";
		country = "";
	}
	
	/**
	 * Initializes streetAddress, zipCode, city, country to params.
	 */
	public Location(String street, String zip, String city, String country)
	{
		streetAddress = street;
		zipCode = zip;
		this.city = city;
		this.country = country;
	}
	
	/**
	 * Changes street address to newAddress.
	 * @param newAddress Address to be updated.
	 */
	public void changeAddress(String newAddress)
	{
		streetAddress = newAddress;
	}
	
	/**
	 * Changes zip code to newZip.
	 * @param newZip Zip code to be changed.
	 */
	public void changeZipCode(String newZip)
	{
		zipCode = newZip;
	}
	
	/**
	 * Changes city to newCity.
	 * @param newCity City to be changed.
	 */
	public void changeCity(String newCity)
	{
		city = newCity;
	}
	
	/**
	 * Changes country to newCountry.
	 * @param newCountry Country to be changed.
	 */
	public void changeCountry(String newCountry)
	{
		country = newCountry;
	}
	
	/**
	 * Returns address of Location.
	 * @return Address to be returned.
	 */
	public String getAddress()
	{
		return streetAddress;
	}
	
	/**
	 * Return zip code of Location.
	 * @return Zip code to be returned.
	 */
	public String getZip()
	{
		return zipCode;
	}
	
	/**
	 * Return city of Location.
	 * @return City to be returned.
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Return country of Location.
	 * @return Country to be returned.
	 */
	public String getCountry()
	{
		return country;
	}
	
	public boolean equals(Location l)
	{
		if(this.streetAddress == l.getAddress() && this.zipCode == l.getZip())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
