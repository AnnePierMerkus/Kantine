package main.java;


import java.util.ArrayList;


public class Tray {
    private ArrayList<Article> articles;

    /**
     * Constructor
     */
    public Tray() {
        articles = new ArrayList<>();
    }

    /**ddddfsd
     * Method to add Article to Tray
     *
     * @param article
     */
    public void addTo(Article article) {
        articles.add(article);
    }

    /**
     * Method to get amount of articles on tray
     *
     * @return Amount of articles
     */
    public int getArticleAmount() {
        int amount = 0;
        for (Article article: articles
             ) {
                amount++;
        }
        return amount;
    }

    /**
     * Method to get the total price of the articles on the tray
     *
     * @return Total price
     */
    public double getTotalPrice() {
        // method body omitted
    }
}

