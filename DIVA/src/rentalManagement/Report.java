package rentalManagement;

import java.util.Date;

/* Ben, extended to Accident report, and Inspection report*/

public class Report {
	
	private Date reportDate;
	private String reportDescription;
	private int reportReservationID;
	
	/**
	 * A Report with date, description, and associated reservation.
	 */
	public Report()
	{
		
	}
	
	/**
	 * A Report with date, description, and associated reservation.
	 * @param d Date of report.
	 * @param description Description of report.
	 * @param reservID Reservation ID of report.
	 */
	public Report(Date d, String description, int reservID)
	{
		reportDate = d;
		reportDescription = description;
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
	 * Returns date of report.
	 * @return Date of report.
	 */
	public Date getReportDate()
	{
		return reportDate;
	}
	
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
}
