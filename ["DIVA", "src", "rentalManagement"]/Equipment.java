package rentalManager;
// needs javadoc and locks
public class Equipment {

	private String type;
	private int id;
	// true if available, false if already reserved.
	private boolean status;
	
	public Equipment()
	{
		type = "";
		id = "";
		status = "";
	}
	
	public Equipment(String t, int i, boolean s)
	{
		type = t;
		id = i;
		status = s;
	}
	
	public void changeType(String newType)
	{
		type = newType;
	}
	
	public void changeID(int newID)
	{
		id = newID;
	}
	
	public void changeStatus(boolean newStatus)
	{
		status = newStatus;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean getStatus()
	{
		return status;
	}
}

