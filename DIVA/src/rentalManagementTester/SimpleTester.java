package rentalManagementTester;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

public class SimpleTester {

	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	
	public static void main(String[] args){
		
		String start_date = ("2016-03-28 12:20:40");
		String end_date = ("2016-03-28 14:20:40");
		
		try{
			DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate = startDateFormat.parse(start_date);
			
			DateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date endDate = endDateFormat.parse(end_date);
			
			long duration = getDateDiff(startDate,endDate,TimeUnit.MINUTES);
			System.out.println(duration);
		}
		catch(ParseException e){
			System.out.println(e.getMessage());
		}

	}

 private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
    long diffInMillies = date2.getTime() - date1.getTime();
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
 }
}