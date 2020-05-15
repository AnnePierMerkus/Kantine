package main.java;

import java.util.Stack;
import java.util.Iterator;


public class Tray {
    private Stack<Article> articles;
    private Person customer;
    /**
     * Constructor
     */
    public Tray() {
        articles = new Stack<>();
    }

    public Tray(Person customer) {
        this.customer = customer;
        articles = new Stack<>();
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
        articles.push(article);
    }

    /**
     * Method to get amount of articles on tray
     *
     * @return Amount of articles
     */
    public int getArticleAmount() {
        return articles.size();
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

    public Stack<Article> getArticles() {
        return articles;
    }

    public Iterator<Article> getArticlesIter() {
        return articles.iterator();
    }


}

