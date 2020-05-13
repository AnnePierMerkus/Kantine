package main.java;
public class Date {

	private int day;
	private int month;
	private int year;

	public Date()
	{
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	public Date(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean bestaatDatum(int day, int month, int year)
	{
		if (day >= 1)
		{
			if (month  >= 1 || month <= 12)
			{
				if (year >= 1900 || year <= 2100)
				{
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Getter for String view of date
	 *
	 * @return date of birth
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
