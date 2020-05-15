package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckoutLine {
    LinkedList<Tray> customerLine;

    /**
     * Constructor
     */
    public CheckoutLine() {
        customerLine = new LinkedList<Tray>();
    }

    /**
     * Persoon slides to the end of the checkout line
     *
     * @param customer
     */
    public void addToLine(Tray customer) {
       customerLine.add(customer);
    }

    /**
     * Incase a line exist, remove the first customer out of the row and return this. If there
     * is no line this method returns null.
     *
     *
     * @return first Customer in line or null if no line exists
     */
    public Tray firstInLine() {

        if (lineExists()) {
            Tray firstCustomer = customerLine.get(0);
            customerLine.remove(0);
            return firstCustomer;
        }else {
            return null;
        }
    }

    /**
     * This method looks if there is an line
     *
     * @return if there's a row or not
     */
    public boolean lineExists() {
        return !customerLine.isEmpty();
    }
}
