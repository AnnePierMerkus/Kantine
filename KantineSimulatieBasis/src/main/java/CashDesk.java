package main.java;

public class CashDesk {

    /**
     * Constructor
     */
    public CashDesk(CheckoutLine checkoutLine) {
        // method body omitted
    }

    /**
     * Request the amount of articles en the total price. Add these numbers up to the control values that are being kept for the Cashdesk.
     * This implementation will be replaced later by the actual payment of the customer/person.
     *
     * @param customer that needs to pay
     */
    public void pay(Tray customer) {
        // method body omitted
    }

    /**
     * Returns the amount of articles that has passed the cashdesk, from the moment that the method resetValues is called.
     *
     * @return amount of articles
     */
    public int articleAmount() {
        // method body omitted
    }

    /**
     * Gives the total value of articles that has passed the cashdesk, from the moment that the method resetCashDesk is called.
     *
     * @return amount of money in the cashdesk
     */
    public double moneyAmountInCashDesk() {
        // method body omitted
    }

    /**
     * Resets the value of the total checked out articles and the total of cash in de cashDesk.
     */
    public void resetKassa() {
        // method body omitted
    }
}
