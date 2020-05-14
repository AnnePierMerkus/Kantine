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
        Person customer = new Person("123456789", "Anne Pier", "Merkus", new Date(10, 7, 1998), 'M');
        Tray tray = new Tray(customer);

        tray.addTo(new Article("Test1", 12.50F));
        tray.addTo(new Article("Test2", 12.50F));

        checkoutLine.addToLine(tray);
    }

    /**
     * This method handles the checkout line.
     */
    public void handleCheckoutLine() {
        while (checkoutLine.lineExists()) {
            cashDesk.pay(checkoutLine.firstInLine());
        }
    }

    /**
     * This method counts the amount of cash in the cashdesk
     *
     * @return amount of cash in cashdesk
     */
    public double getCashAmountInCashDesk() {
        return cashDesk.getMoneyAmountInCashDesk();
    }

    /**
     * This method returns the amount of articles that were checked out at the cashdesk.
     *
     * @return amount of checked out articles
     */
    public int getArticlesAmount() {
        return cashDesk.getArticleAmount();
    }

    /**
     * This method resets the kept count of the amount of checked out articles en "empties" the content of the cashdesk.
     */
    public void resetCashDesk() {
        cashDesk.resetCashDesk();
    }
}
