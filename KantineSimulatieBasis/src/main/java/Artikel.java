package main.java;

/**
 * Article.java is a class in which articles are saved with a given name and price.
 */
public class Artikel {
    /**
     * De prijs van het artikel
     */
    double prijs;

    /**
     * De naam van het artikel.
     */
    String naam;

    /**
     * Lege constructor voor de Klasse Artikel.
     */
    public Artikel(){
        prijs = 0;
        naam = "Unknown";
    }

    /**
     * Constructor voor de Klasse artikel, initialiseerd de waarden van de variabelen.
     * Constructor for the article class, initializes the values of the variables.
     *
     * @param naam naam die aan het artikel toegewezen word
     * @param prijs prijs die aan het artikel toegewezen word
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Creates a stringbuilder creating a string with the name and price of the article.
     * @return A string with the name and price of the article
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append(naam)
                .append(", ")
                .append(prijs);

        return str.toString();
    }

    /**
     * Getter voor prijs
     *
     * @return De prijs van het artikel
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Getter voor Naam
     *
     * @return De naam van het artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter voor Prijs
     *
     * @param prijs die aan het artikel word toegewezen
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * Setter voor Naam
     *
     * @param naam die aan het artikel word toegewezen
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
}