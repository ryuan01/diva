package rentalManagement;

import webSerivceManagement.ArrayOfStringsable;

/**
 * Inpsection report
 * @author Robin
 *
 */
public class Report implements ArrayOfStringsable{
	
	private String objectClass;
	private int report_num;
	private String reportDate;
	private String reportDescription;
	private int reportReservationID;
	private String type; //can be accident or inspection report 
	
	
	//methods need to be changed.
	/**
	 * A Report with date, description, and associated reservation.
	 * @param d Date of report.
	 * @param description Description of report.
	 * @param reservID Reservation ID of report.
	 */
	public Report(String d, String description, int reservID, String type)
	{
		objectClass = getClass().getName();
		report_num = -1; //this need to be updated from database 
		reportDate = d;
		reportDescription = description;
		reportReservationID = reservID;
		this.type = type;
	}
	
	/**
	 * Modifies report date.
	 * @param newDate New date of report.
	 */
	public void changeReportDate(String newDate)
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
	public String getReportDate()
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
	
	/**
	 * Get report ID
	 * @return ID
	 */
	public int getReportId(){
		return report_num;
	}
	
	/**
	 * Get report type 
	 * @return type {inspection, accident}
	 */
	public String getType(){
		return type;
	}
	
	public String getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
}
