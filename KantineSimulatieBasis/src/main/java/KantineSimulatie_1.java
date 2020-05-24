package main.java;

public class KantineSimulatie_1 {

    private Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie_1() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen het aantal dagen voor het simuleren.
     */
    public void simulate(int dagen) {

        // herhaal voor elke dag
        for (int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j < 10 + i; j++) {
                // Gecomment na verwijderde code.
                //kantine.loopPakSluitAan();
            }

            // verwerk rij voor de kassa

            kantine.verwerkRijVoorKassa();

            Kassa kassa = kantine.getKassa();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("dag " + dagen + " " + kassa.getAantalArtikelen() + " artikelen.");
            System.out.println("dag " + dagen + " " + kassa.getHoeveelheidGeldInKassa() + " euro in de kassa.");

            // reset de kassa voor de volgende dag
            kassa.resetKassa();
        }
    }

    /**
     * Start a simulation
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_1 kantineSimulatie1 = new KantineSimulatie_1();
        kantineSimulatie1.simulate(dagen);
    }
}
