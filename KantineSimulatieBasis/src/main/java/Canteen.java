package main.java;

public class Canteen {

    private CashDesk cashDesk;
    private CheckoutLine checkoutLine;
    private CanteenSelection canteenSelection;
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
    public void loopPakSluitAan(Tray tray, String[] articlesnames) {
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
     *
     */

    public CashDesk getCashDesk() {
        return cashDesk;
    }

    public CanteenSelection getCanteenSelection() {
        return canteenSelection;
    }

    public void setCanteenSelection(CanteenSelection canteenSelection) {
        this.canteenSelection = canteenSelection;
    }
}
