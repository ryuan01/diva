package priceTester;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.PriceList;
import paymentManagement.Receipt;

import java.text.ParseException;

public class PaymentManagerTester {

	private static PaymentManager pm = new PaymentManager(); 
	
	public static void main(String[] args){
		
		test_pay_card_onfile();

	}

 private static void test_pay_card_onfile() {
		// TODO Auto-generated method stub
		try {
			Receipt r = pm.makePaymentByCardOnFile(null,19, "jdoe01");
			System.out.println(r.toString());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
