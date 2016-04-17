import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import accountManagement.Account;
import accountManagement.AccountManager;
import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;
import paymentManagement.PriceList;
import paymentManagement.Receipt;
import rentalManagement.RentalFacade;
import rentalManagement.Reservation;

public class Main {
	public static void main(String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String startD = "2016-05-01 14:00:00";
		Date current_time = new Date();
	System.out.println(sdf.format(current_time));
	System.out.println(startD);
	try {
		System.out.println(sdf.parse(startD));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
