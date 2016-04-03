package rentalManagement;

import java.math.BigDecimal;
import java.sql.Date;

public class AccidentReport extends Report{

	private String damageDescription;
	private BigDecimal extraPayment;
	
	/**
	 * An accident report with damage description and extra payment amount.
	 */
	public AccidentReport()
	{
		super();
	}
	
	/**
	 * An accident report with Report attributes and damage description and extra payment amount.
	 * @param d Date of report.
	 * @param description Description of report.
	 * @param reservID Reservation ID associated with the report.
	 * @param dmgDes Damage description of the report.
	 * @param extraPay Extra payments of the report.
	 */
	public AccidentReport(Date d, String description, int reservID,String dmgDes, BigDecimal extraPay)
	{
		super(d,description,reservID);
		damageDescription = dmgDes;
		extraPayment = extraPay;
	}
	
	/**
	 * Modifies the Damage description.
	 * @param newDescription New damage description.
	 */
	public void changeDamageDescription(String newDescription)
	{
		damageDescription = newDescription;
	}
	
	/**
	 * Modifies the extra payment amount.
	 * @param newPayment New extra payment amount.
	 */
	public void changeExtraPayment(BigDecimal newPayment)
	{
		extraPayment = newPayment;
	}
	
	/**
	 * Returns the damage description.
	 * @return Damage description of the report.
	 */
	public String getDamageDescription()
	{
		return damageDescription;
	}
	
	/**
	 * Returns the extra payment amount.
	 * @return Extra payment amount of the report.
	 */
	public BigDecimal getExtraPayment()
	{
		return extraPayment;
	}
}
