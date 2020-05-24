package main.java;

/**
 * Kantine.java is de klassa waarin de rij van de kassa wordt afgehandled.
 */
public class Kantine {
    /**
     * De kassa waarmee betalen worden afgehandled.
     */
    private Kassa kassa;

    /**
     * De rijd die voor de kassa staat
     */
    private KassaRij kassaRij;

    /**
     * Hoeveel voorraad de kantine heeft van ekl artikel.
     */
    private KantineAanbod kantineAanbod;

    /**
     * Constructor voor de klasse kantine, maakt nieuwe kassarije en kassa aan.
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
        for (int k = 0; k < artikelNamen.length; k++)
        {
            dienblad.voegToe(kantineAanbod.getArtikel(artikelNamen[k]));
        }
        kassaRij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassaRij.erIsEenRij()) {
            //System.out.println(kassaRij.wachtrij.size());
            kassa.rekenAf(kassaRij.eerstePersoonInRij());
        }
    }

    /**
     * Haalt de kassa variabele op.
     *
     * @return de huidige kassa instantie.
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Haalt de kantineAanbod variabele op.
     *
     * @return de huidige kantineaanbod instantie
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    /**
     * Geeft een nieuwe waarde aan kantineAanbod.
     *
     * @param kantineAanbod de instantie die in de variabele kantineAanbod komt.
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}
