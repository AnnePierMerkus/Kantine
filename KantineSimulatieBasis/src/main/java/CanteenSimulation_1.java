package main.java;

public class CanteenSimulation_1 {

    private Canteen canteen;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public CanteenSimulation_1() {
        canteen = new Canteen();
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
                canteen.loopPakSluitAan();
                // kantine.(...);
            }

            // verwerk rij voor de kassa

            canteen.handleCheckoutLine();

            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("dag " + days + canteen.getArticlesAmount() + " artikelen.");
            System.out.println("dag " + days + canteen.getCashAmountInCashDesk() + " euro in de kassa.");

            // reset de kassa voor de volgende dag
            canteen.resetCashDesk();
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
