package main.java;

public class Canteen {

    private CashDesk cashDesk;
    private CheckoutLine checkoutLine;

    /**
     * Constructor
     */
    public Canteen() {
        checkoutLine = new CheckoutLine();
        cashDesk = new CashDesk(checkoutLine);
    }

    /**
     * In this method a person and tray are created and linked to each other. Create 2 articles and add these
     * to the tray. Finally the Person gets added to the Checkout line.
     */
    public void loopPakSluitAan() {
        // method body omitted
    }

    /**
     * This method handles the checkout line.
     */
    public void handleCheckoutLine() {
        while () {
            // omitted
        }
    }

    /**
     * This method counts the amount of cash in the cashdesk
     *
     * @return amount of cash in cashdesk
     */
    public double cashAmountInCashDesk() {
        // method body omitted
    }

    /**
     * This method returns the amount of articles that were checked out at the cashdesk.
     *
     * @return amount of checked out articles
     */
    public int articlesAmount() {
        // method body omitted
    }

    /**
     * This method resets the kept count of the amount of checked out articles en "empties" the content of the cashdesk.
     */
    public void resetCashDesk() {
        // method body omitted
    }
}
