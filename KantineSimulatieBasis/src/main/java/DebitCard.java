package main.java;

public class DebitCard extends BetaalWijze {



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
    public boolean betaal(double tebetalen) {
        // method body omitted
        return false;
    }
}
