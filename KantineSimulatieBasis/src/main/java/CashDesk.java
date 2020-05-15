package main.java;

import java.util.Iterator;

public class CashDesk {
    int articleAmount;
    int cashInDesk;


    /**
     * Constructor
     */
    public CashDesk(CheckoutLine checkoutLine) {
        articleAmount = 0;
        cashInDesk = 0;
    }

    /**
     * Request the amount of articles and the total price. Add these numbers up to the control values that are being kept for the Cashdesk.
     * This implementation will be replaced later by the actual payment of the customer/person.
     *
     * @param customer that needs to pay
     */
    public void pay(Tray customer) {
        Iterator<Article> it = customer.getArticlesIter();
        int total = 0;
        int customerArticlesAmount = 0;

        while (it.hasNext()) {
            total += it.next().getPrice();
            customerArticlesAmount++;
        }

        cashInDesk+= total;
        articleAmount+= customerArticlesAmount;
    }

    /**
     * Returns the amount of articles that has passed the cashdesk, from the moment that the method resetCashDesk is called.
     *
     * @return amount of articles
     */
    public int getArticleAmount() {
        return articleAmount;
    }

    /**
     * Gives the total value of articles that has passed the cashdesk, from the moment that the method resetCashDesk is called.
     *
     * @return amount of money in the cashdesk
     */
    public double getMoneyAmountInCashDesk() {
        return cashInDesk;
    }

    /**
     * Resets the value of the total checked out articles and the total of cash in de cashDesk.
     */
    public void resetCashDesk() {
        articleAmount = 0;
        cashInDesk = 0;
    }
}
