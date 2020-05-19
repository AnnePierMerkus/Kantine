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
			System.out.print("Geldige datum");
		}
		else
		{
			System.out.print("Ongeldige datum");
		}
	}

	/**
	 * Controleert of de gegeven datum ook daadwerkelijk bestaat.
	 *
	 * @param day    De gegeven dag om te controleren.
	 * @param month  De gegeven maand om te controleren.
	 * @param year   Het gegeven jaar om te controleren.
	 * @return als de datum bestaat true, anders false.
	 */
	public boolean bestaatDatum(int day, int month, int year)
	{
		if (day >= 1 && day <= 31)
		{
			switch (month) {
				case 2:
					if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
						if (day > 29) {
							return false;
						}
					}
					else if (day > 28) {
						return false;
					}
					break;

				case 4:
				case 6:
				case 9:
				case 11:
					if (day > 30) {
						return false;
					}
					break;

				default:
					if (month > 12 || month < 1)
						return false;
					break;
			}

			return year >= 1900 && year <= 2100;
		}

		return false;
	}

	/**
	 * Haalt de geboortedag op.
	 *
	 * @return de dag waarop de persoon geboren is.
	 */
	public int getDag() {
		return dag;
	}

	/**
	 * Haalt de geboortemaand op.
	 *
	 * @return de maand waarin de persoon geboren is.
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * Haalt het geboortejaar op.
	 *
	 * @return het jaar waarin de persoon geboren is.
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * Veranderd de geboortedag van de persoon.
	 *
	 * @param dag geeft de nieuwe dag die ingesteld moet worden als geboortemdag.
	 */
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
	 * Veranderd de geboortemaand van de persoon.
	 *
	 * @param maand geeft de nieuwe maand die ingesteld moet worden als geboortemaand.
	 */
	public void setMaand(int maand) {
		this.maand = maand;
	}

	/**
	 * Veranderd het geboortejaar van de persoon.
	 *
	 * @param jaar geeft het nieuwe jaar die ingesteld moet worden als geboortejaar.
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	/**
	 * Getter voor String weergave van datum
	 *
	 * @return geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
