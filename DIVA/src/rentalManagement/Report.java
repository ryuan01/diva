package rentalManagement;

import webServiceManagement.ArrayOfStringsable;

/**
 * Inpsection report
 * @author Robin
 *
 */
public class Report implements ArrayOfStringsable{
	
	private static final int MAX_MILEGE = 0; 
	private String objectClass;
	private int report_num;
	private String reportDate;
	private String reportDescription;
	private int reportReservationID;
	private int milage; //0 - MAX_MILEGE
	private int gasLevel; //unsigned int between 0-100
	
	
	//methods need to be changed.

	/**
	 *  A Report with date, description, and associated reservation.
	 * @param d
	 * @param description
	 * @param reservID
	 * @param milage
	 * @param gasLevel
	 */
	public Report(String d, String description, int reservID, int milage, int gasLevel)
	{
		objectClass = getClass().getName();
		report_num = -1; //this need to be updated from database 
		reportDate = d;
		reportDescription = description;
		reportReservationID = reservID;
		this.milage = milage;
		this.gasLevel = gasLevel;
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
	
	
	public String getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
}
