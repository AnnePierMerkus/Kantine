package main.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

/**
 * Dienblad.java in deze klasse wordt een persoon opgeslagen die bij het dienblad hoort, en een lijst met artikelen die op het dienblad liggen.
 */
public class Dienblad {

    //private Stack<Artikel> artikelen;
    /**
     * Een ArrayList met artikelen die aan het dienblad worden toegevoegd en later afgerekend bij de kassa.
     */
    private ArrayList<Artikel> artikelen;

    /**
     * De klant die dit dienblad gebruikt om te winkelen.
     */
    private Persoon klant;


    /**
     * Constructor zonder parameters die artikelen ArrayList initialiseerd.
     */
    public Dienblad() {
        artikelen = new ArrayList<>();
    }

    /**
     * Constructor met parameter die de variabelen een waarde geeft.
     * @param klant de klant die bij het dienblad hoort.
     */
    public Dienblad(Persoon klant) {
        this.klant = klant;
        artikelen = new ArrayList<>();
    }


    /**
     * Haalt de klant op die bij dit dienblad hoort.
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Geeft een nieuwe klant aan dit dienblad.
     *
     * @param klant de klant die het dienblad nu beet heeft.
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel artikel dat aan het dienblad wordt toegevoegd.
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen op het dienblad
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs van de artikelen op het dienblad.
     */
    public BigDecimal getTotaalPrijs() {
        BigDecimal prijs = BigDecimal.ZERO;
        for (Artikel artikel : artikelen) {
            prijs = prijs.add(artikel.getPrijs());
        }

        return prijs;
    }

    /**
     * Haalt de lijst van artikelen op die op het dienblad liggen.
     *
     * @return De lijst met artikelen op het dienblad.
     */
    public ArrayList<Artikel> getArtikelen() {
        return artikelen;
    }

    /**
     * Haalt de iterator op van de lijst met artikelen die op het dienblad liggen.
     *
     * @return De iterator die bij de lijst van artikelen hoort.
     */
    public Iterator<Artikel> getArtikelenIter() {
        return artikelen.iterator();
    }


}

