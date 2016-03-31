package rentalManagementTester;

import java.util.Date;

import databaseManagement.DatabaseManager;
import rentalManagement.RentalFacade;
import rentalManagement.Reservation;
import rentalManagement.ReservationDate;

public class ReservationTester {

	public static void main(String[] args) {
		
		DatabaseManager db = new DatabaseManager();
		
		ReservationDate startD = new ReservationDate(2006,5,1,12,0);
		ReservationDate endD = new ReservationDate(2006,6,23,12,0);
		
		RentalFacade rf = new RentalFacade(db);
		
		rf.createReservation(startD,endD, "123", "12/23", "001", "003", 
				"1001", "102", "Ready", "10001");
		
	}

}
