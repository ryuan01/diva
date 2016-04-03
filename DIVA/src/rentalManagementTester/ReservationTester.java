package rentalManagementTester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import accountManagement.Account;
import databaseManagement.DatabaseManager;
import rentalManagement.RentalFacade;

public class ReservationTester {

	public static void main(String[] args) {
	    
		String input = "2006-5-1 22:00:00 PDT";
	      
		Date startD = stringToDate("2006-5-1 12:00:00 PDT");
		Date endD = stringToDate("2006-6-23 12:00:00 PDT");
		
		String[] eqids = new String[2];
		eqids[0] = "4322";
		eqids[1] = "4323";
		
		RentalFacade rf = new RentalFacade();
		
		rf.createReservation(startD,endD, "123", eqids, "1", "2", 
				"1001", "102", "ready");
		
		//rf.findReservations(startD, endD, , equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		
		//rf.modReservation(reservID, startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		//rf.findReservations(startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		
		//rf.cancelAnyReservation(reservID);
		//rf.findReservations(startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		

		
	}
	
	/**
	 * 
	 * @post may return NULL if there is exception
	 * @param input
	 * @return
	 */
	private static Date stringToDate(String input ){
	     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss zzz");
	     
	     Date t = null;
	      
	      try {
	    	  t = ft.parse(input);
	          //System.out.println("Parsed Date: " + t);
	      } catch (ParseException e) {
	    	  System.err.println(e);
	      }
	    return t;
	}

}
