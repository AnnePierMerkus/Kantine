package main.java;

import java.util.*;

public class CanteenSimulation_2 {

    // kantine
    private Canteen canteen;

    // kantineaanbod
    private CanteenSelection canteenSelection;

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
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

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
        canteen = new Canteen();
        random = new Random();
        int[] amount =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        canteenSelection = new CanteenSelection(articleNames, articlePrices, amount);

        canteen.setCanteenSelection(canteenSelection);
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
     * This method simulates an amount of days passing in the canteen
     *
     * @param days
     */
    public void simuleer(int days) {
        // for lus voor days
        for(int i = 0; i < days; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int personAmount = ... ;

            // laat de personen maar komen...
            for (int j = 0; j < personAmount; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int articleArmount = ... ;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                array int[] tepakken = getRandomArray(
                    articleArmount, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = giveArticleNames(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan

            }

            // verwerk rij voor de kassa

            // druk de dagtotalen af en hoeveel personen binnen

            // zijn gekomen

            // reset de kassa voor de volgende dag

        }
    }
}
