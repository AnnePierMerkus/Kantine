package main.java;

import java.util.Arrays;

/**
 * Date.java is a class which holds the date of birth for customers.
 */
public class Datum {
	/**
	 * De dag waarop de persoon geboren is
	 *
	 * Moet een waarde hebben van 1 t/m 31, of lager voor bepaalde maanden.
	 * Must have a value between 1-31, or lower for certain months.
	 */
	private int dag;

	/**
	 * De maand waarin de persoon geboren is.
	 *
	 * Moet een waarde hebben van 1 t/m 12.
	 * Must have a value between 1-12.
	 */
	private int maand;

	/**
	 * Het jaar waarin de persoon geboren is.
	 *
	 * Moet tussen het jaar 1900 en 2100 zitten.
	 */
	private int jaar;

	/**
	 * Creërt een nieuwe instantie of Datum en initialiseert de geboortedatum op 0-0-0,
	 * Creates a new instance of Date and initializes the date of birth to 0-0-0.
	 */
	public Datum()
	{
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}

	/**
	 * Creërt een nieuwe instantie of Datum waar de geboortedatum de gegeven waarden zijn
	 * Creates a new instance of Date where the date of birth are the given values.
	 *
	 * @param dag   De dag waarop de persoon geboren is.
	 * @param maand De maand waarin de persoon geboren is
	 * @param jaar  Het jaar waarin de persoon geboren is.
	 */
	public Datum(int dag, int maand, int jaar) {
		this();
		if (bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	/**
	 * Gets dag.
	 *
	 * @return de dag
	 */
	public int getDag() {
		return dag;
	}

	/**
	 * Gets maand.
	 *
	 * @return de maand
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * Gets year.
	 *
	 * @return de year
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * Sets dag.
	 *
	 * @param dag de dag
	 */
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
	 * Sets maand.
	 *
	 * @param maand de maand
	 */
	public void setMaand(int maand) {
		this.maand = this.maand;
	}

	/**
	 * Sets jaar.
	 *
	 * @param jaar het jaar
	 */
	public void setJaar(int jaar) {
		this.jaar = this.jaar;
	}

	/**
	 * Bestaat datum boolean.
	 *
	 * @param day    De dag
	 * @param month  De maand
	 * @param year   Het Jaar
	 * @return de boolean
	 */
	public boolean bestaatDatum(int day, int month, int year)
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
	 * Getter voor String view of datum
	 * Getter for String view of date
	 *
	 * @return geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
