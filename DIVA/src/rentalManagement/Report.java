package rentalManagement;

import java.sql.Date;

/* Ben, extended to Accident report, and Inspection report*/

public abstract class Report {
	
	private Date reportDate;
	private String reportDescription;
	private String reportReservationID;
	
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
	public Report(Date d, String description, String reservID)
	{
		
	}
	
	/**
	 * Modifies report date.
	 * @param newDate New date of report.
	 */
	public void changeReportDate(Date newDate)
	{
		
	}
	
	/**
	 * Modifies report description.
	 * @param newDescription New description of report.
	 */
	public void changeReportDescription(String newDescription)
	{
		
	}
	
	/**
	 * Modifies report reservationID.
	 * @param newReportReservationID New report Reservation ID of report.
	 */
	public void changeReportReservationID(String newReportReservationID)
	{
		
	}
	
	/**
	 * Returns date of report.
	 * @return Date of report.
	 */
	public Date getReportDate()
	{
		return null;
	}
	
	/**
	 * Returns description of report.
	 * @return Description of report.
	 */
	public String getReportDescription()
	{
		return null;
	}
	
	/**
	 * Returns reservation ID of report.
	 * @return Reservation ID of report.
	 */
	public String getReportReservationID()
	{
		return null;
	}
}
