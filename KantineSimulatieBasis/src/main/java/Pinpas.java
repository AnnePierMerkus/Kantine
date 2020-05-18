package main.java;

public class Pinpas extends BetaalWijze {



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
    public boolean betaal(double tebetalen) {
        // method body omitted
        return false;
    }
}
