package main.java;


import java.util.ArrayList;

public class Article {
    float price;
    String name;

    public Article(){


    }

    public Article(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append(name)
                .append(", ")
                .append(price);

        return str.toString();
    }

    //Getters and setters for Price and Name

    /**
     * Getter for Price
     *
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter for Name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for price
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Setter for Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}