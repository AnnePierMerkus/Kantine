package main.java;


import java.util.ArrayList;

public class Artikel {
    float price;
    String name;

    public Artikel(){


    }

    public Artikel(String name, float price) {
        this.name = name;
        this.price = price;
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