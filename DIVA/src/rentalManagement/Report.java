package rentalManagement;

import webServiceManagement.ArrayOfStringsable;

/**
 * Inpsection report
 * @author Robin
 *
 */
public class Report implements ArrayOfStringsable{
	
	public static final int MAX_MILEGE = 500; //meant it is by KM 
	private String objectClass;
	private int report_num;
	private int report_clerk_id;
	private String reportDate;
	private String reportDescription;
	private int reportRentalID;
	private int milage; //0 - MAX_MILEGE
	private int gasLevel; //unsigned int between 0-100
	private String reportState; 
	
	
	//methods need to be changed.

	/**
	 *  A Report with date, description, and associated reservation.
	 * @param d
	 * @param description
	 * @param rentalID
	 * @param milage
	 * @param gasLevel
	 */
	public Report(int clerk_id, String date, String description, int rentalID, int milage, int gasLevel, int report_num, String state)
	{
		this.report_num = report_num;
		objectClass = getClass().getName();
		report_num = -1; //this need to be updated from database 
		report_clerk_id = clerk_id;
		reportDate = date;
		reportDescription = description;
		reportRentalID = rentalID;
		this.milage = milage;
		this.gasLevel = gasLevel;
		this.reportState = state; 
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
		reportRentalID = newReportReservationID;
	}
	
	/**
	 * Modifies the reporting clerk id
	 * @param clerk_id identifies clerk
	 */
	public void changeReportClerk(int clerk_id){
		report_clerk_id = clerk_id;
	}
	
	/**
	 * Returns reporting clerk ID
	 * @return ID that identifies which clerk is in charge of this report. 
	 */
	public int getReportClerk(){
		return report_clerk_id;
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
		return reportRentalID;
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
	
	public void setGasLevel(int g){
		gasLevel = g;
	}
	
	public void setMilage(int m){
		milage = m;
	}
	
	public int getGasLevel(){
		return gasLevel;
	}
	
	public int getMilage(){
		return milage;
	}
	
	public void setReportState(String state){
		this.reportState = state;
	}
	public String getReportState(){
		return this.reportState;
	}
	
	@Override
	public String toString() {
				
		//passing back dates in the format dd-mm-yyyy as Strings.
		return "{'objectClass':'"+this.objectClass+"',"
			+	"'report_num':'"+this.report_num+"',"+"'report_clerk_id':'"+report_clerk_id+"',"
			+ "'reportDate':'"+this.reportDate+"',"+"'reportDescription:'"+this.reportDescription+"',"
			+ "'reportRentalID':'"+this.reportRentalID+"',"+"',"+"'state':'"+this.reportState+"'milage':'"+this.milage+"',"
			+ "'gasLevel':'"+this.gasLevel+"'}";
	}
}
