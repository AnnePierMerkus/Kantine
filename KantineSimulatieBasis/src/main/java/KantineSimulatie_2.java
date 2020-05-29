package main.java;

import main.java.Test.Week2tests;
import main.java.Test.Week3tests;

import java.math.BigDecimal;
import java.util.*;

import static main.java.KantineSimulatie_1.DAGEN;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineAanbod;

    // random generator
    private Random random;

    // amount of articles
    private static final int AANTAL_ARTIKELEN = 4;

    // articles
    private static final String[] artikelNamen =
            new String[] {"Coffee", "PB sandwich", "Cheese sandwich", "Apple juice"};

    // prices
    private static BigDecimal[] artikelPrijzen = new BigDecimal[] {new BigDecimal("1.50"), new BigDecimal("2.10"), new BigDecimal("1.65"), new BigDecimal("1.65")};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] amount =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineAanbod = new KantineAanbod(artikelNamen, artikelPrijzen, amount);

        kantine.setKantineAanbod(kantineAanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return A random number
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelNamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = 100;
            int[] aantal = new int[aantalpersonen];
            double[] omzet = new double[aantalpersonen];

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {
                Persoon persoon = null;
                if (j < 89) {
                    persoon = new Student(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', 123, "links");
                } else if (j < 99) {
                    persoon = new Docent(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', "appie", "schoonmaker");
                } else if (j < 100) {
                    persoon = new KantineMedewerker(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', 8423, false);
                }
                System.out.println(persoon.toString());
                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                System.out.println(aantalartikelen);
                aantal[j] = aantalartikelen;
                Persoon customer = new Persoon(String.valueOf(j), "Anne Pier", "Merkus", new Datum(10, 7, 1998), 'M');
                Dienblad dienblad = new Dienblad(customer);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            Kassa kassa = kantine.getKassa();
            int dag = i + 1;

            StringBuilder str = new StringBuilder()
                    .append("\nDag: ")
                    .append(dag)
                    .append("\nDagtotaal:       ")
                    .append(kassa.getHoeveelheidGeldInKassa())
                    .append("\nAantal personen: ")
                    .append(aantalpersonen);
            System.out.println(str);

            // reset de kassa voor de volgende dag
           kassa.resetKassa();


            System.out.println("berekenGemiddeldeOmzet: " + Administratie.berekenGemiddeldeOmzet(omzet));
            System.out.println("berekenGemiddeldAantal: " + Administratie.berekenGemiddeledAantal(aantal));
        }
    }

    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_2 kantineSimulatie2 = new KantineSimulatie_2();
        kantineSimulatie2.simuleer(dagen);


        Week2tests week2 = new Week2tests();
        //week2.opgave2();
        //week2.opgave5();

        Week3tests week3 = new Week3tests();
       // week3.opgave1();
    }
}
