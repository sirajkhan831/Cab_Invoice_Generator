package com.bridgelabz;

/**
 * @author -> Siraj
 * @version -> 1.0
 * @since  -> 05/11/2021
 */
public class Fare {

    /**
     * This program generates fares for Cabs
     */
    private double totalFare;           // Stores the total fare for all the ride combined.

    public Fare(double distance, double minutes) {
        fareCalculator(distance, minutes);
    }

    public Fare() {
    }

    /**
     *
     * @param distance -> The amount of distance travelled by the customer per ride.
     * @param minutes -> The amount of time taken for the ride.
     */
    private void fareCalculator(double distance, double minutes) {
        int MIN_FARE = 5;
        int PER_MINUTE = 1;
        totalFare += ((distance * 10) + (PER_MINUTE * minutes) + MIN_FARE);
    }

    /**
     *
     * @param distance -> The amount of distance travelled by the customer per ride.
     * @param minutes -> The amount of time taken for the ride.
     * Created to add fares for multiple rides of the customer
     */
    public void bookCab(double distance, double minutes){
        fareCalculator(distance, minutes);
    }

    /**
     *
     * @return total combined fare for all the rides of customer.
     */
    public double getTotalFare() {
        return totalFare;
    }
}
