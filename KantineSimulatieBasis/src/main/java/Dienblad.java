package main.java;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

/**
 * Dienblad.java in deze klasse wordt een persoon opgeslagen die bij het dienblad hoort, en een lijst met artikelen die op het dienblad liggen.
 */
public class Dienblad {

    /**
     * Een ArrayList met artikelen die aan het dienblad worden toegevoegd en later afgerekend bij de kassa.
     */
    private Stack<Artikel> artikelen;

    /**
     * De klant die dit dienblad gebruikt om te winkelen.
     */
    private Persoon klant;


    /**
     * Constructor zonder parameters die artikelen ArrayList initialiseerd.
     */
    public Dienblad() {
        artikelen = new Stack<>();
    }

    /**
     * Constructor met parameter die de variabelen een waarde geeft.
     * @param klant de klant die bij het dienblad hoort.
     */
    public Dienblad(Persoon klant) {
        this.klant = klant;
        artikelen = new Stack<>();
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
        artikelen.push(artikel);
    }

    /**
     * Haalt de lijst van artikelen op die op het dienblad liggen.
     *
     * @return De lijst met artikelen op het dienblad.
     */
    public Stack<Artikel> getArtikelen() {
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

