package main.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {
    //LinkedList<Dienblad> wachtrij;

    /**
     * De wachtrij bij de kassa.
     */
    ArrayList<Dienblad> wachtrij;

    /**
     * Constructor voor kassarij die een nieuwe wachtrij aanmaakt.
     */
    public KassaRij() {
        wachtrij = new ArrayList<>();
    }

    /**
     * Persoon sluit achter in de rij aan.
     *
     * @param klant de klant die achteraan de rij sluit.
     */
    public void sluitAchteraan(Dienblad klant) {
       wachtrij.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null als de rij leeg is.
     */
    public Dienblad eerstePersoonInRij() {
        return erIsEenRij() ? wachtrij.remove(0) : null;
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return !wachtrij.isEmpty();
    }
}
