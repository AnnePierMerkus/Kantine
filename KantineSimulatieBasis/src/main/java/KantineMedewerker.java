package main.java;

public class KantineMedewerker extends Persoon {


    int medewerkersnummer;

    boolean magAchterKassa;

    public KantineMedewerker(String burgerServiceNummer, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int medewerkersnummer, boolean magAchterKassa) {
        super(burgerServiceNummer, voornaam, achternaam, geboorteDatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magAchterKassa = magAchterKassa;
    }

    public KantineMedewerker(String burgerServiceNummer, String voornaam, String achternaam, int medewerkersnummer, boolean magAchterKassa) {
        super(burgerServiceNummer, voornaam, achternaam);
        this.medewerkersnummer = medewerkersnummer;
        this.magAchterKassa = magAchterKassa;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "\nType: Kantinemedewerker" + str;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isMagAchterKassa() {
        return magAchterKassa;
    }

    public void setMagAchterKassa(boolean magAchterKassa) {
        this.magAchterKassa = magAchterKassa;
    }


}
