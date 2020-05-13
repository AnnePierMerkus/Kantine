package main.java;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class Tray {
    private ArrayList<Artikel> articles;

    /**
     * Constructor
     */
    public Tray() {
        articles = new ArrayList<>();
    }

    /**
     * Method to add Article to Tray
     *
     * @param article
     */
    public void addTo(Artikel article) {
        articles.add(article);
    }

    /**
     * Method to get amount of articles on tray
     *
     * @return Amount of articles
     */
    public int getArticleAmount() {
        int amount = 0;
        for (Artikel article: articles
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

