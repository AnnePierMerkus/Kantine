package main.java;

public class Pinpas extends BetaalWijze {
    /**
     * Krediet van de persoon.
     */
    private double kredietLimiet;

    /**
     * Methode om kredietLimiet te setten
     *
     * @param kredietLimiet
     */
    public void setKredietLimiet(double kredietLimiet) {
        this.kredietLimiet = kredietLimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if ((saldo - tebetalen) >= kredietLimiet)
        {
            saldo -= tebetalen;
            return;
        }
        throw new TeWeinigGeldException("Je hebt te weinig geld, de betaling wordt gecancelt.");

    }
}
