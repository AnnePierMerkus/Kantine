package main.java;

public class Docent extends Persoon {

    String afkorting;

    String afdeling;

    public Docent(String burgerServiceNummer, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String afkorting, String afdeling) {
        super(burgerServiceNummer, voornaam, achternaam, geboorteDatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    public Docent(String burgerServiceNummer, String voornaam, String achternaam, String afkorting, String afdeling) {
        super(burgerServiceNummer, voornaam, achternaam);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "\nType: Docent" + str;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }







}
