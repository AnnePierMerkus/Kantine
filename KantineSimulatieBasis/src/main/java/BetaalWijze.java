package main.java;

public abstract class BetaalWijze {

    protected double saldo;

    /**
     * Methode om krediet te initialiseren
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;
}
