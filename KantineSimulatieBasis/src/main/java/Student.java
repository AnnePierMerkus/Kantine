package main.java;

public class Student extends Persoon {
    /**
     * Studenten nummer van deze student.
     */
    int studentnummer;

    /**
     * Studie die deze student volgt.
     */
    String studierichting;

    public Student(String burgerServiceNummer, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int studentnummer, String studierichting) {
        super(burgerServiceNummer, voornaam, achternaam, geboorteDatum, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "\nType: Student" + str;
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
