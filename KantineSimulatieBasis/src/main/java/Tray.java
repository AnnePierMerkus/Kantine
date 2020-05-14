package main.java;


import java.util.ArrayList;
import java.util.Iterator;


public class Tray {
    private ArrayList<Article> articles;
    private Person customer;
    /**
     * Constructor
     */
    public Tray() {
        articles = new ArrayList<>();
    }

    public Tray(Person customer) {
        this.customer = customer;
    }


    /**
     * Getter for customer
     */
    public Person getCustomer() {
        return customer;
    }

    /**
     * Setter for customer
     *
     * @param customer customer
     */
    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    /**
     * Method to add Article to Tray
     *
     * @param article article
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
        for (Article article: articles) {
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
        int price = 0;
        for (Article article: articles) {
            price += article.getPrice();
        }

        return price;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public Iterator<Article> getArticlesIter() {
        return articles.iterator();
    }


}

