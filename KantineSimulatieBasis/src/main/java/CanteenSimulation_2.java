package main.java;

import java.util.*;

import static main.java.CanteenSimulation_1.DAGEN;

public class CanteenSimulation_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineAanbod;

    // random generator
    private Random random;

    // amount of articles
    private static final int AANTAL_ARTIKELEN = 4;

    // articles
    private static final String[] articleNames =
            new String[] {"Coffee", "PB sandwich", "Cheese sandwich", "Apple juice"};

    // prices
    private static double[] articlePrices = new double[] {1.50, 2.10, 1.65, 1.65};

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
    public CanteenSimulation_2() {
        System.out.println(Administratie.berekenGemiddeldeOmzet(new double[] {567.70, 498.25, 458.90}));
        kantine = new Kantine();
        random = new Random();
        int[] amount =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineAanbod = new KantineAanbod(articleNames, articlePrices, amount);

        kantine.setKantineAanbod(kantineAanbod);
    }

    /**
     * Method to create a array with random numbers of given length with numbers between min and max
     *
     * @param length
     * @param min
     * @param max
     * @return The array with random numbers
     */
    private int[] getRandomArray(int length, int min, int max) {
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Method to generate a random number between min and max.
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
     * @param indexes
     * @return Tha array with article names
     */
    private String[] giveArticleNames(int[] indexes) {
        String[] articles = new String[indexes.length];

        for (int i = 0; i < indexes.length; i++) {
            articles[i] = articleNames[indexes[i]];

        }

        return articles;
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
            int personAmount = getRandomValue(4, 10);

            // laat de personen maar komen...
            for (int j = 0; j < personAmount; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int articleArmount = getRandomValue(2, 6);
                Persoon customer = new Persoon("123456789", "Anne Pier", "Merkus", new Datum(10, 7, 1998), 'M');
                Dienblad dienblad = new Dienblad(customer);



                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(articleArmount, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = giveArticleNames(tepakken);

                for (int k = 0; k < artikelen.length; k++)
                {
                    dienblad.addTo(kantineAanbod.getArtikel(artikelen[k]));
                }

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan


                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            Kassa kassa = kantine.getKassa();
            System.out.println("Dagtotaal van vandaag: " + kassa.getHoeveelheidGeldInKassa());
            System.out.println("Aantal personen vandaag: " + personAmount);

            // reset de kassa voor de volgende dag
           kassa.resetKassa();
        }
    }

    public static void main(String[] args) {
        int days;

        if (args.length == 0) {
            days = DAGEN;
        } else {
            days = Integer.parseInt(args[0]);
        }
        CanteenSimulation_2 canteenSimulation2 = new CanteenSimulation_2();
        canteenSimulation2.simuleer(days);
    }


}
