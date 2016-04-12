package priceTester;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.PriceList;

import java.text.ParseException;

public class PaymentManagerTester {

	private static PaymentManager pm = new PaymentManager(); 
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	
	public static void main(String[] args){
		
		DatabaseManager db = DatabaseManager.getInstance();
		try {
			PriceList list = new PriceList(db);
			list.print();
			System.out.println(list.getPriceCar(1, 2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String start_date = ("2016-04-28 12:20:40");
		String end_date = ("2016-04-29 10:20:40");
		
/*		try{
			System.out.println(calculateCarPrice("poop",start_date,end_date));
		}
		catch(ParseException e){
			System.out.println(e.getMessage());
		}*/

	}

 private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
    long diffInMillies = date2.getTime() - date1.getTime();
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
 }
 
	public static BigDecimal calculateCarPrice(String carClass, String start_date, String end_date) throws ParseException{
		
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
		
		weekPrice = new BigDecimal(80);
		dayPrice = new BigDecimal(15);
		hourPrice = new BigDecimal(2.5);
		
		
		
		total = days.divide(new BigDecimal(7),0, RoundingMode.DOWN).multiply(weekPrice);
		total = total.add(days.remainder(new BigDecimal(7)).multiply(dayPrice));
		total = total.add(hours.multiply(hourPrice));

		
		return total;
		
	}
}
