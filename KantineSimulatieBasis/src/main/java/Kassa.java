package main.java;

import java.util.Iterator;

public class Kassa {
    int aantalArtikelen;
    int geldInKassa;


    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        aantalArtikelen = 0;
        geldInKassa = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Iterator<Artikel> it = klant.getArtikelenIter();
        int totaal = 0;
        int klantArtikelenAantal = 0;

        while (it.hasNext()) {
            totaal += it.next().getPrijs();
            klantArtikelenAantal++;
        }

        geldInKassa += totaal;
        aantalArtikelen += klantArtikelenAantal;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int getAantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double getHoeveelheidGeldInKassa() {
        return geldInKassa;
    }


    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */

    public void resetKassa() {
        aantalArtikelen = 0;
        geldInKassa = 0;
    }
}
