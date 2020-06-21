package main.java;

import java.math.BigDecimal;
import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, BigDecimal> prijzen;

    private static final int MIN_ARTIKELEN = 10;
    private String kortingArtikelNaam;

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen, het tweede argument is
     * eenlijst met prijzen en het derde argument is een lijst met hoeveelheden. Let op: de
     * dimensies van de drie arrays moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] articleName, BigDecimal[] price, int[] amount) {
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        startVoorraad = new HashMap<String, Integer>();
        prijzen = new HashMap<String, BigDecimal>();
        for (int i = 0; i < articleName.length; i++) {
            ArrayList<Artikel> artikels = new ArrayList<Artikel>();
            for (int j = 0; j < amount[i]; j++) {
                artikels.add(new Artikel(articleName[i], price[i]));
            }
            startVoorraad.put(articleName[i], amount[i]);
            prijzen.put(articleName[i], price[i]);
            aanbod.put(articleName[i], artikels);
        }
    }

    public void setKorting(String kortingArtikelNaam, BigDecimal percentage)
    {
        ArrayList<Artikel> kortingArtikel = aanbod.get(kortingArtikelNaam);
        for (Artikel a : kortingArtikel) {
            a.setKorting(a.getPrijs().multiply(percentage));
        }

        this.kortingArtikelNaam = kortingArtikelNaam;
    }

    private void vulVoorraadAan(String productnaam) {
        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);

        int startHoeveelheid = startVoorraad.get(productnaam);
        int huidigeHoeveelheid = huidigeVoorraad.size();

        BigDecimal prijs = prijzen.get(productnaam);
        BigDecimal korting = prijs.multiply(new BigDecimal("0.2"));
        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
            huidigeVoorraad.add(productnaam.equals(kortingArtikelNaam) ? new Artikel(productnaam, prijs, korting) : new Artikel(productnaam, prijs));
        }
        aanbod.put(productnaam, huidigeVoorraad);
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= MIN_ARTIKELEN) {
                vulVoorraadAan(a.getNaam());
            }
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productName (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productName) {
        return getArtikel(getArrayList(productName));
    }
}
