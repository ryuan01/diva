package rentalManagement;

import java.util.Date;

/**
 * 
 * @author Robin
 *
 */
public class Report {
	
	
	private String objectClass;
	private int report_num;
	private Date reportDate;
<<<<<<< HEAD
	private String reportDescription;
=======
	private int reporting_clerk;
	private String comments;
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
	private int reportReservationID;
	
	
	//methods need to be changed.
	/**
	 * A Report with date, description, and associated reservation.
	 * @param d Date of report.
	 * @param description Description of report.
	 * @param reservID Reservation ID of report.
	 */
	public Report(Date d, String description, int reservID)
	{
		reportDate = d;
		reportReservationID = reservID;
	}
	
	/**
	 * Modifies report date.
	 * @param newDate New date of report.
	 */
	public void changeReportDate(Date newDate)
	{
		reportDate = newDate;
	}
	
	/**
<<<<<<< HEAD
	 * Modifies report description.
	 * @param newDescription New description of report.
	 */
	public void changeReportDescription(String newDescription)
	{
		reportDescription = newDescription;
	}
	
	/**
	 * Modifies report reservationID.
	 * @param newReportReservationID New report Reservation ID of report.
	 */
	public void changeReportReservationID(int newReportReservationID)
	{
		reportReservationID = newReportReservationID;
	}
	
	/**
=======
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
	 * Returns date of report.
	 * @return Date of report.
	 */
	public Date getReportDate()
	{
		return reportDate;
	}
<<<<<<< HEAD
	
	/**
	 * Returns description of report.
	 * @return Description of report.
	 */
	public String getReportDescription()
	{
		return reportDescription;
	}
	
	/**
	 * Returns reservation ID of report.
	 * @return Reservation ID of report.
	 */
	public int getReportReservationID()
	{
		return reportReservationID;
	}
=======
>>>>>>> 1ac1450bc4865cff61553c283d748ebc15b089e5
}
