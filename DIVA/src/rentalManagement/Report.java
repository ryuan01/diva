package rentalManagement;

import java.sql.Date;

/**
 * 
 * @author Robin
 *
 */
public class Report {
	
	
	private String objectClass;
	private int report_num;
	private Date reportDate;
	private int reporting_clerk;
	private String comments;
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
	 * Returns date of report.
	 * @return Date of report.
	 */
	public Date getReportDate()
	{
		return reportDate;
	}
}
