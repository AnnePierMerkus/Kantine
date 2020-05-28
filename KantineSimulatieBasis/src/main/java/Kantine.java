package main.java;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassaRij;
    private KantineAanbod kantineAanbod;
    /**
     * Constructor
     */
    public Kantine() {
        kassaRij = new KassaRij();
        kassa = new Kassa(kassaRij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelNamen) {
        kassaRij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassaRij.erIsEenRij()) {
            kassa.rekenAf(kassaRij.eerstePersoonInRij());
        }
    }

    /**
     *
     */
    public Kassa getKassa() {
        return kassa;
    }

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}
