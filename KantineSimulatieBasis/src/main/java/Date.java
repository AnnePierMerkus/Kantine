package main.java;

import java.util.Arrays;

/**
 * Date.java is a class which holds the date of birth for customers.
 */
public class Date {
	/**
	 * The date on which the person was born
	 *
	 * Must have a value between 1-31, or lower for certain months.
	 */
	private int day;

	/**
	 * The month in which the person was born.
	 *
	 * Must have a value between 1-12.
	 */
	private int month;

	/**
	 * The year in which the person was born.
	 *
	 * Must be between 1900 and 2100.
	 */
	private int year;

	/**
	 * Creates a new instance of Date and initializes the date of birth to 0-0-0.
	 */
	public Date()
	{
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	/**
	 * Creates a new instance of Date where the date of birth are the given values.
	 *
	 * @param day   the day on which the person was born.
	 * @param month the month in which the person was born.
	 * @param year  the year in which the person was born.
	 */
	public Date(int day, int month, int year) {
		this();
		if (doesDateExist(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	/**
	 * Gets day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Gets month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets day.
	 *
	 * @param day the day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Sets month.
	 *
	 * @param month the month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Sets year.
	 *
	 * @param year the year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Does date exist boolean.
	 *
	 * @param day   the day
	 * @param month the month
	 * @param year  the year
	 * @return the boolean
	 */
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
