package main.java;

/**
 * The type Person.
 */
public class Persoon {
    /**
     * De Burger service number.
     */
    String burgerServiceNumber;
    /**
     * De voornaam.
     */
    String voornaam;
    /**
     * De achternaam.
     */
    String achternaam;
    /**
     * De geboortedatum.
     */
    Datum geboorteDatum;
    /**
     * De Gender.
     */
    char gender;

    /**
     * Instantiates a new Person.
     *
     * @param burgerServiceNumber De burger service number
     * @param voornaam            De voornaam
     * @param achternaam          De achternaam
     * @param geboorteDatum       De geboortedatum
     * @param gender              De gender
     */
    public Persoon(String burgerServiceNumber, String voornaam, String achternaam, Datum geboorteDatum, char gender)
    {
        setBurgerServiceNumber(burgerServiceNumber);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setGeboorteDatum(geboorteDatum);
        setGender(gender);
    }

    /**
     * Instantiates a new Person.
     *
     * @param burgerServiceNumber De burger service number
     * @param voornaam            De voornaam
     * @param achternaam          De achternaam
     */
    public Persoon(String burgerServiceNumber, String voornaam, String achternaam)
    {
        this(burgerServiceNumber, voornaam, achternaam, new Datum(), 'p');
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append(burgerServiceNumber)
                .append(", ")
                .append(voornaam)
                .append(", ")
                .append(achternaam)
                .append(", ")
                .append(getGeboorteDatum())
                .append(", ")
                .append(gender);

        return str.toString();
    }

    /**
     * Gets burger service number.
     *
     * @return de burger service number
     */
    public String getBurgerServiceNumber() {
        return burgerServiceNumber;
    }

    /**
     * Gets voornaam
     *
     * @return de voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Gets achternaam
     *
     * @return de achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Gets geboortedatum
     *
     * @return de geboortedatum
     */
    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    /**
     * Gets gender.
     *
     * @return de gender
     */
    public String getGender() {
        if (Character.toLowerCase(gender) == 'm')
        {
            return "Man";
        }
        else if (Character.toLowerCase(gender) == 'v')
        {
            return "Vrouw";
        }
        else
        {
            return "Onbekend";
        }
    }

    /**
     * Sets burger service number.
     *
     * @param burgerServiceNumber de burger service number
     */
    public void setBurgerServiceNumber(String burgerServiceNumber) {
        this.burgerServiceNumber = burgerServiceNumber;
    }

    /**
     * Sets voornaam.
     *
     * @param voornaam de voornaam
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Sets achternaam.
     *
     * @param achternaam de achternaam
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Sets geboortedatum
     *
     * @param geboorteDatum de geboortedatum
     */
    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
     * Sets gender.
     *
     * @param gender de gender
     */
    public void setGender(char gender) {
        if (Character.toLowerCase(gender) == 'm' || Character.toLowerCase(gender) == 'v') {
            this.gender = gender;
        }
        else
        {
            this.gender = 'o';
        }
    }
}
