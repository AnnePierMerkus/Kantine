package main.java;

/**
 * Persoon.java in deze klas worden personen opgeslagen, met hun BSN (Burger Service Nummer), voornaam, achternaam, geboortedatum en geslacht.
 */
public class Persoon {
    /**
     * Het Burger service nummer van de persoon.
     */
    String burgerServiceNummer;

    /**
     * De voornaam van de persoon.
     */
    String voornaam;

    /**
     * De achternaam van de persoon.
     */
    String achternaam;

    /**
     * De geboortedatum van de persoon.
     */
    Datum geboorteDatum;

    /**
     * Het geslacht van de persoon.
     */
    char geslacht;

    private BetaalWijze betaalWijze;
    /**
     * Maakt een nieuwe instantie van de klasse persoon en zet de gegeven waardes in de variabelen.
     *
     * @param burgerServiceNummer Het Burger Service Nummer die aan de persoon wordt gegeven.
     * @param voornaam            De voornaam die aan de persoon wordt gegeven.
     * @param achternaam          De achternaam die aan de persoon wordt gegeven.
     * @param geboorteDatum       De geboortedatum die aan de persoon wordt gegeven.
     * @param geslacht            Het geslacht dat aan de persoon wordt gegeven.
     */
    public Persoon(String burgerServiceNummer, String voornaam, String achternaam, Datum geboorteDatum, char geslacht)
    {
        setBurgerServiceNumber(burgerServiceNummer);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setGeboorteDatum(geboorteDatum);
        setGender(geslacht);
    }

    /**
     * Maakt een nieuwe instantie van de klasse persoon en neemt niet voor alle variabelen een waarde mee.
     * Dit is indien een persoon zijn geboortedatum/geslacht anoniem wil houden.
     *
     * @param burgerServiceNummer Het Burger Service Nummer die aan de persoon wordt gegeven.
     * @param voornaam            De voornaam die aan de persoon wordt gegeven.
     * @param achternaam          De achternaam die aan de persoon wordt gegeven.
     */
    public Persoon(String burgerServiceNummer, String voornaam, String achternaam)
    {
        this(burgerServiceNummer, voornaam, achternaam, new Datum(), 'o');
    }

    /**
     *  Maakt een StringBuilder met alle informatie van de persoon erin.
     *
     * @return Een String met alle informatie van de persoon.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append("\nBurger Service Nummer: ")
                .append(burgerServiceNummer)
                .append("\nVoornaam: ")
                .append(voornaam)
                .append("\nAchternaam: ")
                .append(achternaam)
                .append("\nGeboortedatum: ")
                .append(getGeboorteDatum())
                .append("\nGeslacht: ")
                .append(getGeslacht());

        return str.toString();
    }

    /**
     * Haalt het  Burger Service Nummer van de persoon op.
     *
     * @return het Burger Service Nummer van de persoon.
     */
    public String getBurgerServiceNummer() {
        return burgerServiceNummer;
    }

    /**
     * Haalt de voornaam van de persoon op.
     *
     * @return de voornaam van de persoon.
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Haalt de achternaam van de persoon op.
     *
     * @return de achternaam van de persoon.
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Haalt de geboortedatum van de persoon op.
     *
     * @return de geboortedatum van de persoon.
     */
    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    /**
     * Zet de character van geslacht om naar een string.
     *
     * @return het geslacht van de persoon in een String vorm.
     */
    public String getGeslacht() {
        switch (geslacht)
        {
            case 'm':
                return "Man";
            case 'v':
                return "Vrouw";
            default:
                return "Onbekend";
        }
    }

    public BetaalWijze getBetaalWijze() {
        return betaalWijze;
    }

    /**
     * Veranderd het Burger Service Nummer van de persoon.
     *
     * @param burgerServiceNummer het Burger Service Nummer die de persoon moet krijgen.
     */
    public void setBurgerServiceNumber(String burgerServiceNummer) {
        this.burgerServiceNummer = burgerServiceNummer;
    }

    /**
     * Veranderd de voornaam van de persoon.
     *
     * @param voornaam de voornaam die de persoon moet krijgen.
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Veranderd de achternaam van de persoon.
     *
     * @param achternaam de achternaam die de persoon moet krijgen.
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Veranderd de geboortedatum van de persoon.
     *
     * @param geboorteDatum  de geboortedatum die de persoon moet krijgen.
     */
    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
     * Controleert of het gegeven geslacht bestaat, zo niet wordt deze op onbekend gezet.
     *
     * @param geslacht het geslacht van de persoon
     */
    public void setGender(char geslacht) {
        geslacht = Character.toLowerCase(geslacht);

        if (geslacht == 'm' || geslacht == 'v') {
            this.geslacht = geslacht;
        }
        else
        {
            this.geslacht = 'o';
        }
    }

    public void setBetaalWijze(BetaalWijze betaalWijze) {
        this.betaalWijze = betaalWijze;
    }
}
