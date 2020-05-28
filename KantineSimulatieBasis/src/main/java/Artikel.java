package main.java;

import java.math.BigDecimal;

/**
 * Article.java is a class in which articles are saved with a given name and price.
 */
public class Artikel {
    /**
     * De prijs van het artikel
     */
    BigDecimal prijs;

    /**
     * De naam van het artikel.
     */
    String naam;

    /**
     * Constructor die standaard waardes geeft aan de variabelen.
     */
    public Artikel(){
    }

    /**
     * Constructor voor de Klasse artikel, initialiseerd de waarden van de variabelen.
     * Constructor for the article class, initializes the values of the variables.
     *
     * @param naam naam die aan het artikel toegewezen word
     * @param prijs prijs die aan het artikel toegewezen word
     */
    public Artikel(String naam, BigDecimal prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Maakt een StringBuilder met de naam en prijs variabele.
     * @return Een String met de naam en de prijs van het artikel
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append("Naam: ")
                .append(naam)
                .append("\nPrijs: ")
                .append(prijs);

        return str.toString();
    }

    /**
     * Haalt de prijs van het artikel op.
     *
     * @return double De prijs van het artikel
     */
    public BigDecimal getPrijs() {
        return prijs;
    }

    /**
     * Haalt de naam van het artikel op.
     *
     * @return De naam van het artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Veranderd de prijs van het artikel.
     *
     * @param prijs die aan het artikel word toegewezen
     */
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    /**
     * Veranderd de naam van het artikel.
     *
     * @param naam die aan het artikel word toegewezen
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
}