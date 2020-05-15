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
                Person customer = new Person("123456789", "Anne Pier", "Merkus", new Date(10, 7, 1998), 'M');
                Tray tray = new Tray(customer);

                String[] articlenames = {"Test1", "Test2"};
                tray.addTo(new Article("Test1", 12.50F));
                tray.addTo(new Article("Test2", 12.50F));

                canteen.loopPakSluitAan(tray, articlenames);
                // kantine.(...);
            }

            // verwerk rij voor de kassa

            canteen.handleCheckoutLine();
            CashDesk cashdesk = canteen.getCashDesk();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("dag " + days + cashdesk.getArticleAmount() + " artikelen.");
            System.out.println("dag " + days + cashdesk.getMoneyAmountInCashDesk() + " euro in de kassa.");

            // reset de kassa voor de volgende dag
            cashdesk.resetCashDesk();
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