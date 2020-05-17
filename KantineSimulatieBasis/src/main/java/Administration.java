package main.java;

public class Administration {

    /**
     * Amount of days in a week, static final because it never changes.
     */
    private static final int DAYS_IN_WEEK = 7;

    /**
     * Private constructor die niks doen voor de klasse Administration.
     */
    private Administration()
    {

    }
    /**
     * Calculates the average number inside the Array amount.
     *
     *
     * @param amount is an Array of type int
     * @return The average value of the values inside given Array.
     */
    public static double calculateAverageAmount(int[] amount) {
        double total = 0;
        for (int i = 0; i < amount.length; i++)
        {
            total += amount[i];
        }

        return total / amount.length;
    }

    /**
     * This method calculates the average of the double array revenue
     *
     * @param revenue is an Array of the type double containing the revenues of a given period.
     * @return The average revenue of the revenues inside given Array.
     */
    public static double calculateAverageRevenue(double[] revenue) {
        double total = 0;
        for (int i = 0; i < revenue.length; i++)
        {
            total += revenue[i];
        }

        return total / revenue.length;
    }

    /**
     * Method to calculate the daily revenue
     *
     * @param revenue is an Array of type double containing the revenue of each day over a given period of time.
     * @return The revenue of a given day over a period of time.
     */

    public static double[] calculateDailyRevenue(double[] revenue) {
        double[] temp = new double[DAYS_IN_WEEK];

        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while (j < revenue.length) {
                try {
                    temp[i] += revenue[i + DAYS_IN_WEEK * j];
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
