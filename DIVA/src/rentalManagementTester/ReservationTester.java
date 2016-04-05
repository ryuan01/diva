package rentalManagementTester;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import rentalManagement.RentalFacade;

public class ReservationTester {
	
	private static RentalFacade rf = new RentalFacade();

	public static void main(String[] args) {
	
		//create_reservation();
		
		int reservationID = 4;
		rf.findReservations(reservationID);
		
		//rf.modReservation(reservID, startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		//rf.findReservations(startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		
		//rf.cancelAnyReservation(reservID);
		//rf.findReservations(startDate, endDate, vehicleID, equipIDs, startBranchID, endBranchID, customerID, employeeID, status);
		

		
	}

	private static void create_reservation() {
		// TODO Auto-generated method stub
		String input = "2006-5-1 22:00:00 PDT";
	      
		String startD = "2007-5-1";
		String endD = "2007-6-23 ";
		
		int[] eqids = new int[2];
		eqids[0] = 1;
		eqids[1] = 2;
		
		try {
			rf.createReservation(startD,endD, 1, eqids, 2, 3, 
					1, "reserved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
