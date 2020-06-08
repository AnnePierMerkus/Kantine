package main.java;
public class Contant extends BetaalWijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo >= tebetalen)
        {
            saldo -= tebetalen;
            return;
        }

        throw new TeWeinigGeldException("Je hebt te weinig geld, de betaling wordt gecancelt.");
    }
}
