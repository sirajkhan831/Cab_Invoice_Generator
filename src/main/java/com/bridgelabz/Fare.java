package com.bridgelabz;

/**
 * @author -> Siraj
 * @version -> 1.0
 * @since -> 05/11/2021
 */
public class Fare {

    /**
     * This program generates fares for Cabs.
     */
    private double fare;                // Stores the fare per ride.
    private double totalFare;           // Stores the total fare for all the rides combined.
    private int totalRides;              // Stores the total number of rides.
    private boolean isPremium = false;    // Stores weather the customer is premium customer.

    public Fare(double distance, double minutes) {
        fareCalculator(distance, minutes);
    }

    public Fare(double distance, double minutes, boolean isPremium) {
        this.isPremium = isPremium;
        fareCalculator(distance, minutes);
    }

    /**
     * @param distance -> The amount of distance travelled by the customer per ride.
     * @param minutes  -> The amount of time taken for the ride.
     */
    private void fareCalculator(double distance, double minutes) {
        totalRides++;
        int MIN_FARE = 5;
        int PER_MINUTE = 1;
        int PER_KM = 10;
        if (isPremium) {
            MIN_FARE = 20;
            PER_MINUTE = 2;
            PER_KM = 15;
        }
        fare = ((distance * PER_KM) + (PER_MINUTE * minutes) + MIN_FARE);
        totalFare += fare;
    }

    /**
     * @param distance -> The amount of distance travelled by the customer per ride.
     * @param minutes  -> The amount of time taken for the ride.
     *                 Created to add fares for multiple rides of the customer
     */
    public void bookCab(double distance, double minutes) {
        fareCalculator(distance, minutes);
    }

    /**
     * @return -> Average fare cost per customer of the basis of their total fares and total rides.
     */
    public double averageFare() {
        return totalFare / totalRides;
    }

    /**
     * @return total combined fare for all the rides of customer.
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     * @return -> Total number of rides of the user.
     */
    public int getTotalRides() {
        return totalRides;
    }

    /**
     * @return -> Total fare per ride
     */
    public double getFare() {
        return fare;
    }
}
