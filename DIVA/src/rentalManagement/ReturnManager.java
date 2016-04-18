package rentalManagement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;

import databaseManagement.DatabaseManager;
import paymentManagement.PaymentManager;



class ReturnManager {

	private DatabaseManager dbConnection;
	private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private PaymentManager paymentManager;
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	ReturnManager()
	{
		dbConnection = DatabaseManager.getInstance();
		paymentManager = new PaymentManager();
	}
	
	/**
	 * A Manager that creates Reports and Receipts for an ending Rental.
	 */
	ReturnManager(DatabaseManager db)
	{
		dbConnection = db;
	}

	
	/**
	 * Compares with current Date object if Reservation is overdue.
	 * @param reservID Reservation ID of Rental to be checked.
	 * @return True if overdue, False otherwise.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	boolean checkIfOverdue(int reservID) throws ParseException, SQLException
	{
		// if reservation end date is before current date.
		String current_date = sdf.format(new java.util.Date());
		String due_date = dbConnection.getReservationEndDate(reservID);
		if(sdf.parse(due_date).before(sdf.parse(current_date)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	BigDecimal addOverdueExtraCharge(int rental_id, String current_date) throws SQLException, ParseException {
		// [x] dbm --> rentalDB.getReturnDate 
		// [] balance = paymentManager.getOverduePrice(start_date, current_date)
		// [x] dbm --> rentalDB.addToBalance(rental_id, balance)
		// [x] dbm --> rentalDB.setIsPaidExtraCharge(false);
		// [x] return balance
		String endDate;
		String vehicle_type;
		BigDecimal newBalance = new BigDecimal("0");
		BigDecimal currentBalance;
		
		
		Rental rental = dbConnection.getRental(rental_id);
		vehicle_type = dbConnection.getTypeOfVehicle(rental.getRentalReservation().getVehicleID());
		endDate = rental.getRentalReservation().getEndDate();
		newBalance = paymentManager.calculateOverduePrice(current_date, endDate, vehicle_type);
		currentBalance = dbConnection.getBalance(rental_id).add(newBalance);
		
		dbConnection.addToBalance(rental_id, currentBalance);
		return newBalance;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Check if the branch returned to is not the branch that the customer wishes to return to at time of booking
	 * @param rental_id
	 * @param current_branch_id 
	 * @param current_branch_id
	 * @return true if it is wrong, false if they are different
	 * @throws SQLException
	 */
	boolean checkReturnBranch(int rental_id, int current_branch_id) throws SQLException {
		Rental rental = dbConnection.getRental(rental_id);
		if (rental.getRentalReservation().getEndBranchID() != current_branch_id){
			return true;
		}
		return false;
	}

	/**
	 * Add extra charges for a customer who returned to the wrong branch
	 * @param rental_id
	 * @param current_branch_id 
	 * @return
	 */
	BigDecimal addWrongReturnBranchExtraCharge(int rental_id, int current_branch_id) throws SQLException {
		// TODO Auto-generated method stub
		BigDecimal newBalance = new BigDecimal("0");
		BigDecimal currentBalance;
		
		newBalance = paymentManager.calculateWrongReturnBranchPrice();
		currentBalance = dbConnection.getBalance(rental_id).add(newBalance);
		
		dbConnection.addToBalance(rental_id, currentBalance);
		return newBalance;
	}

	void changeRentalStatusExtraCharge(int rental_id, boolean status) throws SQLException {
		// TODO Auto-generated method stub
		dbConnection.changeRentalStatus(rental_id,"is_paid_extra_charge", status);
	}

	/**
	 * Compare the two inspection reports for a rental
	 * @param rentalID
	 * @return
	 * @throws Exception 
	 */
	BigDecimal compareReports(int rentalID) throws Exception {
		BigDecimal balance = new BigDecimal("0.00");
		//get the two reports
		Report[] reports = dbConnection.searchInspectionReport(rentalID);
		if (reports.length < 2){
			throw new Exception("Must have two reports, one before rental and one after rental to compare them");
		}
		//compare gas tank
		int gaslevel_before = reports[0].getGasLevel();
		int gaslevel_after = reports[1].getGasLevel();
		if (gaslevel_before > gaslevel_after){
			balance = paymentManager.calculateGasLevelPrice(gaslevel_before, gaslevel_after);
			//System.out.println("balance gaslevel is "+balance);
		}
		//compare milage in KM
		int milage_km_before = reports[0].getMilage();
		int milage_km_after = reports[1].getMilage();
		int extra_milage = milage_km_after - milage_km_before - Report.MAX_MILEGE;
		if ( extra_milage > 0) {//extra milage to be charged
			int v_id = dbConnection.getReservationVehicleID(rentalID);
			String v_type = dbConnection.getTypeOfVehicle(v_id);
			balance = balance.add(paymentManager.calculateExtraKMPrice(extra_milage,v_type)).setScale(2, RoundingMode.CEILING);
			//System.out.println("balance km is "+balance);
		}
		//update this balance to database
		dbConnection.addToBalance(rentalID, balance);
		return balance;
	}
}
