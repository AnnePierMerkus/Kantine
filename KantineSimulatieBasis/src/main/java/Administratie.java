package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

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
    public static BigDecimal berekenGemiddeledAantal(int[] aantal) {
        BigDecimal totaal = BigDecimal.ZERO;
        for (int i = 0; i < aantal.length; i++)
        {
            totaal = totaal.add(BigDecimal.valueOf(aantal[i]));
        }

        return totaal.divide(BigDecimal.valueOf(aantal.length), 4, RoundingMode.FLOOR).stripTrailingZeros();
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet is een Array van het type double waarin de omzetten van een gegeven tijdsperiode worden opgeslagen.
     * @return de gemiddelde omzet van de omzetten die in de array staan
     */
    public static BigDecimal berekenGemiddeldeOmzet(double[] omzet) {
        BigDecimal totaal = BigDecimal.ZERO;
        for (int i = 0; i < omzet.length; i++)
        {
            totaal = totaal.add(BigDecimal.valueOf(omzet[i])) ;
        }

        return totaal.divide(BigDecimal.valueOf(omzet.length), 4, RoundingMode.FLOOR).stripTrailingZeros();
    }

    /**
     * Methode om dagelijkse omzet te berekenen
     *
     * @param omzet is een Array van het type double waarin de dagomzetten van een gegeven tijdsperiode worden opgeslagen.
     * @return De dagelijkse omzet van een gegeven dag over een tijdsperiode.
     */

    public static BigDecimal[] berekenDagelijkseOmzet(double[] omzet) {
        BigDecimal[] temp = new BigDecimal[DAGEN_IN_WEEK];
        Arrays.fill(temp, BigDecimal.ZERO);

        for(int i = 0; i < DAGEN_IN_WEEK; i++) {
            for (int j = 0; j < omzet.length; j++) {

                int dag = i + DAGEN_IN_WEEK * j;
                if (dag >= omzet.length) {
                    break;
                }

                temp[i] = temp[i].add(BigDecimal.valueOf(omzet[dag]));
            }
        }
        return temp;
    }
}
