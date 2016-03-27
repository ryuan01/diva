package rentalManagement;

import java.sql.Date;

public class InspectionReport extends Report{

	private Date maintenanceDate;
	
	/**
	 * An inspection report with Report attributes and maintenance date if applicable.
	 */
	public InspectionReport()
	{
		super();
	}
	
	/**
	 * An inspection report with Report attributes and maintenance date if applicable.
	 * @param d Date of report.
	 * @param description Description of report.
	 * @param reservID Reservation ID assocaited with the report.
	 */
	public InspectionReport(Date d, String description, String reservID)
	{
		super(d,description,reservID);
	}
	
	/**
	 * Sets a new maintenance date.
	 * @param newMaintenanceDate New vehicle maintenance date.
	 */
	public void setMaintenanceDate(Date newMaintenanceDate)
	{
		
	}
	
	/**
	 * Gets a maintenance date.
	 * @return The maintenance date of the vehicle.
	 */
	public Date getMaintenanceDate()
	{
		return null;
	}
}
