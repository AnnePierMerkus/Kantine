package main.java;

public class Student extends Persoon{


    int studentnummer;
    String studierichting;

    public Student(String burgerServiceNummer, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int studentnummer, String studierichting) {
        super(burgerServiceNummer, voornaam, achternaam, geboorteDatum, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public Student(String burgerServiceNummer, String voornaam, String achternaam, int studentnummer, String studierichting) {
        super(burgerServiceNummer, voornaam, achternaam);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
