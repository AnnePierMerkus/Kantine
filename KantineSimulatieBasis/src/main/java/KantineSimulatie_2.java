package main.java;

import main.java.Test.Week2tests;
import main.java.Test.Week3tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        int[] aantal = new int[dagen];
        double[] omzet = new double[dagen];

        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            String kortingArtikelNaam = artikelNamen[random.nextInt(artikelNamen.length)];
            kantineAanbod.setKorting(kortingArtikelNaam, new BigDecimal("0.2"));

            // laat de personen maar komen..
            for (int j = 0; j < 1; j++) {
                Persoon persoon = null;
                int randomPersoon = random.nextInt(100);
                if (randomPersoon < 89) {
                    persoon = new Student(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', 123, "links");

                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(500);
                    persoon.setBetaalWijze(pinpas);
                }
                else if (randomPersoon < 99) {
                    persoon = new Docent(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', "appie", "schoonmaker");

                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(100);
                    persoon.setBetaalWijze(pinpas);
                }
                else if (randomPersoon < 100) {
                    persoon = new KantineMedewerker(String.valueOf(j), "Anne Pier", "Merkus",
                            new Datum(10, 7, 1998), 'M', 8423, false);

                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(500);
                    persoon.setBetaalWijze(pinpas);
                }

                Dienblad dienblad = new Dienblad(persoon);
                if (persoon != null) {
                    //System.out.println(persoon.toString());
                }

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

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

            aantal[i] = kassa.getAantalArtikelen();
            omzet[i] = kassa.getHoeveelheidGeldInKassa().doubleValue();

           /* int dag = i + 1;

            StringBuilder str = new StringBuilder()
                    .append("\nDag: ")
                    .append(dag)
                    .append("\nDagtotaal:       ")
                    .append(kassa.getHoeveelheidGeldInKassa())
                    .append("\nAantal personen: ");
            //System.out.println(str);
            */
            // reset de kassa voor de volgende dag
            kassa.resetKassa();
            kantineAanbod.setKorting(kortingArtikelNaam, new BigDecimal("0"));
        }

        BigDecimal[] omzetPerDag = Administratie.berekenDagelijkseOmzet(omzet);

        StringBuilder str = new StringBuilder()
                .append("\nGemiddelde antal artikelen per dag: ")
                .append(Administratie.berekenGemiddeledAantal(aantal))
                .append("\nGemiddelde Omzet per dag: ")
                .append(Administratie.berekenGemiddeldeOmzet(omzet))
                .append("\nOmzet op maandag: ").append(omzetPerDag[0]).append("\nOmzet op dinsdag: ").append(omzetPerDag[1]).append("\nOmzet op woensdag: ").append(omzetPerDag[2])
                .append("\nOmzet op donderdag: ").append(omzetPerDag[3]).append("\nOmzet op vrijdag: ").append(omzetPerDag[4]).append("\nOmzet op zaterdag: ").append(omzetPerDag[5])
                .append("\nOmzet op zondag: ").append(omzetPerDag[6]);
        //System.out.println(str);
    }

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("KantineSimulatie");
    private static EntityManager manager;

    public static void main(String[] args) {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        System.out.println(manager);
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_2 kantineSimulatie2 = new KantineSimulatie_2();
        kantineSimulatie2.simuleer(dagen);

        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }
}
