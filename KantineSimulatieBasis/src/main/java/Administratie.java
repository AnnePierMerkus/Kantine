package main.java;

public class Administratie {

    /**
     * Aantal dagen in een week, deze is static final omdat deze nooit verandert.
     */
    private static final int DAGEN_IN_WEEK = 7;

    /**
     * Private constructor die niks doen voor de klasse Administration.
     */
    private Administratie()
    {

    }
    /**
     * Berekent de gemiddelde waarde van de aantallen Array aantal.
     *
     *
     * @param aantal is een array van type Int
     * @return De gemmidelde waarde van de aantallen in de Array aantal
     */
    public static double berekenGemiddeledAantal(int[] aantal) {
        double totaal = 0;
        for (int i = 0; i < aantal.length; i++)
        {
            totaal += aantal[i];
        }

        return totaal / aantal.length;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet is een Array van het type double waarin de omzetten van een gegeven tijdsperiode worden opgeslagen.
     * @return de gemiddelde omzet van de omzetten die in de array staan
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        for (int i = 0; i < omzet.length; i++)
        {
            totaal += omzet[i];
        }

        return totaal / omzet.length;
    }

    /**
     * Methode om dagelijkse omzet te berekenen
     *
     * @param omzet is een Array van het type double waarin de dagomzetten van een gegeven tijdsperiode worden opgeslagen.
     * @return De dagelijkse omzet van een gegeven dag over een tijdsperiode.
     */

    public static double[] berekenDagelijkseOmzet(double[] omzet) {
        double[] temp = new double[DAGEN_IN_WEEK];

        for(int i = 0; i < DAGEN_IN_WEEK; i++) {

            for (int j = 0; j < omzet.length; j++) {
                try {
                    temp[i] += omzet[i + DAGEN_IN_WEEK * j];
                }
                catch(Exception e)
                {
                    break;
                }
            }
        }
        return temp;
    }
}
