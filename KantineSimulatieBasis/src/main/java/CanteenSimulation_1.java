package main.java;

public class CanteenSimulation_1 {

    private Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public CanteenSimulation_1() {
        kantine = new Kantine();
    }

    /**
     * This method simulates an amount of days passing in the canteen
     *
     * @param days
     */
    public void simulate(int days) {

        // herhaal voor elke dag
        for (int i = 0; i < days; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j < 10 + i; j++) {
                Persoon customer = new Persoon("123456789", "Anne Pier", "Merkus", new Datum(10, 7, 1998), 'M');
                Dienblad dienblad = new Dienblad(customer);

                String[] articlenames = {"Test1", "Test2"};
                dienblad.addTo(new Artikel("Test1", 12.50F));
                dienblad.addTo(new Artikel("Test2", 12.50F));

                kantine.loopPakSluitAan(dienblad, articlenames);
                // kantine.(...);
            }

            // verwerk rij voor de kassa

            kantine.verwerkRijVoorKassa();
            Kassa cashdesk = kantine.getKassa();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("dag " + days + " " + cashdesk.getAantalArtikelen() + " artikelen.");
            System.out.println("dag " + days + " " + cashdesk.getHoeveelheidGeldInKassa() + " euro in de kassa.");

            // reset de kassa voor de volgende dag
            cashdesk.resetKassa();
        }
    }

    /**
     * Start a simulation
     */
    public static void main(String[] args) {
        int days;

        if (args.length == 0) {
            days = DAGEN;
        } else {
            days = Integer.parseInt(args[0]);
        }
        CanteenSimulation_1 canteenSimulation1 = new CanteenSimulation_1();
        canteenSimulation1.simulate(days);
    }
}
