package main.java;

import java.util.Arrays;

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

	public Date(int day, int month, int year) {
		this();
		if (doesDateExist(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
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

	public boolean doesDateExist(int day, int month, int year)
	{
		if (day >= 1 && day <= 31)
		{
			if (month  >= 1 || month <= 12)
			{
				if (month == 2)
				{
					if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
					{
						if (day > 29)
						{
							return false;
						}
					}
					else if (day > 28)
					{
						return false;
					}
				}
				else if (Arrays.asList(4, 6, 9, 11).contains(month))
				{
					if (day > 30)
					{
						return false;
					}
				}

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
