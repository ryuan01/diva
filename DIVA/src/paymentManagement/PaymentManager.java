package paymentManagement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.SuperCustomer;
import databaseManagement.DatabaseManager;
import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;
import vehicleManagement.Car;
import vehicleManagement.Truck;

public class PaymentManager {

	private static BigDecimal tax;
	private static PriceList priceList;
	private static DatabaseManager db;
	
/**
 * A payment Manager that creates and holds a list of receipts. 
 * The payment Manager is responsible for the money flow of the system. 	
 * @throws SQLException 
 */
	public PaymentManager(){
		tax = new BigDecimal("0.07");
		db = DatabaseManager.getInstance();
		priceList = new PriceList();
	}
	
	public void populatePriceList() throws SQLException{
		priceList.populate();
	}

	/**
	 * Creates a new Receipt that contains the following arguments
	 * @param price
	 * @param vehicle_rented
	 * @param duration
	 * @param dropoff_location
	 * @return receipt
	 */
	public Receipt create_new_Receipt(BigDecimal price, String vehicle_rented, String dropoff_location){
		//Receipt receipt = new Receipt(numReceipts, price, dropoff_location, dropoff_location, dropoff_location);
		//return receipt;
		return null;
	}
/**
 * Gets the Number of Receipts in the Array.
 * @return
 */
/*	public int getNumReceipts() {
		return numReceipts;
	}*/

/**
 * Sets the number of Receipts in the Array
 * @param numReceipts
 */
/*	public void setNumReceipts(int numReceipts) {
		this.numReceipts = numReceipts;
	}*/
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	
	/**
	 * Calculates the final price of the transaction
	 * @param vehicleType
	 * @param insurance
	 * @return final_price
	 */
	// format of date "yyyy-mm-dd hh:mm:ss"
	public BigDecimal calculateCarPrice(String carClass, String start_date, String end_date) throws ParseException{
		
		
		//System.out.println("inputs " + carClass + " " + start_date + " "+end_date);
		
		DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = startDateFormat.parse(start_date);
		
		DateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate = endDateFormat.parse(end_date);
		
		BigDecimal total;
		
		long daysDuration = getDateDiff(startDate,endDate,TimeUnit.DAYS);
		long hoursDuration = getDateDiff(startDate,endDate,TimeUnit.HOURS);
		BigDecimal days = new BigDecimal(daysDuration);
		BigDecimal hours = new BigDecimal(hoursDuration);
		hours = hours.remainder(new BigDecimal(24));
		
		BigDecimal weekPrice = BigDecimal.ZERO;
		BigDecimal dayPrice = BigDecimal.ZERO;
		BigDecimal hourPrice = BigDecimal.ZERO;
		
		//weekly rates
		switch(carClass){
			case "economy":
				weekPrice = priceList.getPriceCar(0, 2); 
				dayPrice = priceList.getPriceCar(0, 1); 
				hourPrice = priceList.getPriceCar(0, 0); break;
			case "compact":
				//System.out.println("im inside compact");
				weekPrice = priceList.getPriceCar(1, 2); 
				dayPrice = priceList.getPriceCar(1, 1); 
				hourPrice = priceList.getPriceCar(1, 0); 
				
				//System.out.println(dayPrice + " " + weekPrice + " " + hourPrice);
				break;
			case "midsized":
				weekPrice = priceList.getPriceCar(2, 2); 
				dayPrice = priceList.getPriceCar(2, 1); 
				hourPrice = priceList.getPriceCar(2, 0); break;
			case "standard":
				weekPrice = priceList.getPriceCar(3, 2);
				dayPrice = priceList.getPriceCar(3, 1); 
				hourPrice = priceList.getPriceCar(3, 0); break;
			case "fullsized":
				weekPrice = priceList.getPriceCar(4, 2); 
				dayPrice = priceList.getPriceCar(4, 1); 
				hourPrice = priceList.getPriceCar(4, 0); break;
			case "premium":
				weekPrice = priceList.getPriceCar(5, 2); 
				dayPrice = priceList.getPriceCar(5, 1); 
				hourPrice = priceList.getPriceCar(5, 0); break;
			case "luxury":
				weekPrice = priceList.getPriceCar(6, 2); 
				dayPrice = priceList.getPriceCar(6, 1);
				hourPrice = priceList.getPriceCar(6, 0); break;
			case "SUV":
				weekPrice = priceList.getPriceCar(7, 2); 
				dayPrice = priceList.getPriceCar(7, 1); 
				hourPrice = priceList.getPriceCar(7, 0); break;
			case "van":
				weekPrice = priceList.getPriceCar(8, 2);
				dayPrice = priceList.getPriceCar(8, 1); 
				hourPrice = priceList.getPriceCar(8, 0); break;
			}
		 
		total = days.divide(new BigDecimal(7),0, RoundingMode.DOWN).multiply(weekPrice);
		total = total.add(days.remainder(new BigDecimal(7)).multiply(dayPrice));
		total = total.add(hours.multiply(hourPrice));
		
		//System.out.println("total is: " + total);
		return total;
		
	}

	public BigDecimal calculateTruckPrice(String truckClass, String start_date, String end_date) throws ParseException{
		
		DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = startDateFormat.parse(start_date);
		
		DateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate = endDateFormat.parse(end_date);
		
		BigDecimal total;
		
		long daysDuration = getDateDiff(startDate,endDate,TimeUnit.DAYS);
		long hoursDuration = getDateDiff(startDate,endDate,TimeUnit.HOURS);
		BigDecimal days = new BigDecimal(daysDuration);
		BigDecimal hours = new BigDecimal(hoursDuration);
		hours = hours.remainder(new BigDecimal(24));
		
		BigDecimal weekPrice = BigDecimal.ZERO;
		BigDecimal dayPrice = BigDecimal.ZERO;
		BigDecimal hourPrice = BigDecimal.ZERO;
		
		//weekly rates
		switch(truckClass){
			case "24-foot":
				weekPrice = priceList.getPriceCar(0, 2); 
				dayPrice = priceList.getPriceCar(0, 1); 
				hourPrice = priceList.getPriceCar(0, 0); break;
			case "15-foot":
				weekPrice = priceList.getPriceCar(1, 2); 
				dayPrice = priceList.getPriceCar(1, 1); 
				hourPrice = priceList.getPriceCar(1, 0); break;
			case "12-foot":
				weekPrice = priceList.getPriceCar(2, 2); 
				dayPrice = priceList.getPriceCar(2, 1); 
				hourPrice = priceList.getPriceCar(2, 0); break;
			case "box-truck":
				weekPrice = priceList.getPriceCar(3, 2);
				dayPrice = priceList.getPriceCar(3, 1); 
				hourPrice = priceList.getPriceCar(3, 0); break;
			case "cargo-van":
				weekPrice = priceList.getPriceCar(4, 2); 
				dayPrice = priceList.getPriceCar(4, 1); 
				hourPrice = priceList.getPriceCar(4, 0); break;
			
			}
		
		total = days.divide(new BigDecimal(7),0, RoundingMode.DOWN).multiply(weekPrice);
		total = total.add(days.remainder(new BigDecimal(7)).multiply(dayPrice));
		total = total.add(hours.multiply(hourPrice));
		
		return total;
	}
	
	public BigDecimal calculateLateprice(int reservID) throws ParseException, SQLException{
		
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);
		
		String reservEndDate = db.getReservationEndDate(reservID);
		Vehicle reservVehicle = db.getReservationVehicle(reservID);
		
		if(reservVehicle instanceof Car)
		{
			Car reservCar = (Car)reservVehicle;
			
			return calculateCarPrice(reservCar.getCarClass(),reservEndDate,reportDate);
		}
		else if(reservVehicle instanceof Truck)
		{
			Truck reservTruck = (Truck)reservVehicle;
			return calculateTruckPrice(reservTruck.getTruckClass(),reservEndDate,reportDate);
		}
		else
		{
			return null;
		}
	}
	
	public int moneyToPoints(BigDecimal money)
	{
		return 0;
	}

	/**
	 * I don't think this should be static 
	 * @param reservID
	 */
	
	//don't want static! 
public void makePayment(Account a, BigDecimal price) {
	// TODO Auto-generated method stub
	// should create a receipt for the payment and pass it to interface to show user.
	// should prompt interface to try again if payment fails.
	boolean payment = false;
	
	while(payment == false)
	{
		
	}
	
	if(a instanceof SuperCustomer)
	{
		//AccountManager.accumulatePoints(a.getID(), PaymentManager.moneyToPoints(price));
	}
}

	public static BigDecimal calculateRentprice(int reservID) {
		// TODO Auto-generated method stub
		return null;
	}
}
