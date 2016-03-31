package rentalManagement;

public class ReservationDate {

	
	private int year;
	private int month;
	private int date;
	private int hour;
	private int minute;
	
	public ReservationDate()
	{
		this.year = 0;
		this.month = 0;
		this.date = 0;
		this.hour = 0;
		this.minute = 0;
	}
	
	public ReservationDate(int year, int month, int date, int hour, int minute)
	{
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.minute = minute;
	}
	
	public static String toString(ReservationDate d)
	{
		return d.getYear() + "/" + d.getMonth() + "/" + d.getDate() + "/" + d.getHour() + "/" + d.getMinute();
	}
	
	public void setYear(int newYear)
	{
		year = newYear;
	}
	
	public void setMonth(int newMonth)
	{
		year = newMonth;
	}
	
	public void setDate(int newDate)
	{
		year = newDate;
	}
	
	public void setHour(int newHour)
	{
		year = newHour;
	}
	
	public void setMinute(int newMinute)
	{
		year = newMinute;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute;
	}
}
