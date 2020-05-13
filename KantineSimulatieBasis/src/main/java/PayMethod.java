package main.java;

public abstract class PayMethod {

    protected double saldo;

    /**
     * Method to initialize credit
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Method to finalize payment
     *
     * @param amountToPay
     * @return Boolean to loof if there is enough saldo
     */
    public abstract boolean pay(double amountToPay);
}
