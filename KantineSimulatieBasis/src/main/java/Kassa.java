package main.java;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * Kassa.java is de klasse waarin alle afgerekende artikelen en de prijs voor die artikelen wordt bijgehouden.
 */
public class Kassa {
    /**
     * Aantal artikelen dat de kassa is binnengekomen op een dag.
     */
    int aantalArtikelen;

    /**
     * Geld dat in de kassa is gekomen op een dag.
     */
    BigDecimal geldInKassa;


    /**
     * Constructor voor de klasse Kassa die de variabelen op 0 zet.
     */
    public Kassa(KassaRij kassaRij) {
        aantalArtikelen = 0;
        geldInKassa = BigDecimal.ZERO;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        BigDecimal totaal = new BigDecimal(0);
        int klantArtikelenAantal = 0;

        Iterator<Artikel> it = klant.getArtikelenIter();

        while (it.hasNext()) {
            totaal = totaal.add(it.next().getPrijs());
            klantArtikelenAantal++;

        }
        //System.out.println(totaal);

        geldInKassa = geldInKassa.add(totaal);
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
    public BigDecimal getHoeveelheidGeldInKassa() {
        return geldInKassa;
    }


    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        geldInKassa = BigDecimal.ZERO;
    }
}
