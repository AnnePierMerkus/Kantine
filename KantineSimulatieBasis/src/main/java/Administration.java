package main.java;

public class Administration {

    /**
     * This method calculates the average of the Array amount
     *
     *
     * @param amount
     * @return the average
     */
    public double calculateAverageAmount(int[] amount) {
        // method body omitted
    }

    /**
     * This method calculates the average revenue of the double array (revenue)
     *
     * @param revenue
     * @return The average
     */
    public double calculateAverageRevenue(double[] revenue) {
        // method body omitted
    }

    /**
     * Method to calculate the daily revenue
     *
     *
     *
     * @param revenue
     * @return array (7 elementen) with daily revenues
     */

    public static double[] calculateDailyRevenue(double[] revenue) {
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while ( ... ) {
                temp[i] += revenue[i + 7 * j];

                // omitted

            }
        }
        return temp;
    }
}
