package main.java;

public class Card extends PayMethod {



    private double creditLimit;

    /**
     * Methode to set creditLimit
     *
     * @param creditLimit
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Method to finalize payment
     */
    public boolean pay(double amountToPay) {
        // method body omitted
    }
}
