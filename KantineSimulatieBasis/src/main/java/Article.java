package main.java;

/**
 * Article.java is a class in which articles are saved with a given name and price.
 */
public class Article {
    /**
     * The price of the article
     */
    float price;

    /**
     * The name of the arciel
     */
    String name;

    /**
     * Empty constructor for the article class.
     */
    public Article(){
        price = 0;
        name = "Unknown";
    }

    /**
     * Constructor for the article class, initializes the values of the variables.
     *
     * @param name to be given to the article
     * @param price to be given to the article
     */
    public Article(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Creates a stringbuilder creating a string with the name and price of the article.
     * @return A string with the name and price of the article
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append(name)
                .append(", ")
                .append(price);

        return str.toString();
    }

    /**
     * Getter for Price
     *
     * @return The price of the article
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter for Name
     *
     * @return The name of the article
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for price
     *
     * @param price to be given to the article
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Setter for Name
     *
     * @param name to be given to the article
     */
    public void setName(String name) {
        this.name = name;
    }
}