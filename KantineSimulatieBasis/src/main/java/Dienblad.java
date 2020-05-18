package main.java;

import java.util.Stack;
import java.util.Iterator;


public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;
    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack<>();
    }

    public Dienblad(Persoon klant) {
        this.klant = klant;
        artikelen = new Stack<>();
    }


    /**
     * Getter voor klant
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Setter voor klant
     *
     * @param klant klant
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel artikel
     */
    public void addTo(Artikel artikel) {
        artikelen.push(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        int prijs = 0;
        for (Artikel artikel : artikelen) {
            prijs += artikel.getPrijs();
        }

        return prijs;
    }

    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }

    public Iterator<Artikel> getArtikelenIter() {
        return artikelen.iterator();
    }


}

