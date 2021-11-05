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
    private double fare;
    private int totalRides;

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
    private double fareCalculator(double distance, double minutes) {
        totalRides++;
        int MIN_FARE = 5;
        int PER_MINUTE = 1;
        fare = ((distance * 10) + (PER_MINUTE * minutes) + MIN_FARE);
        totalFare += fare;
        return fare;
    }

    /**
     *
     * @param distance -> The amount of distance travelled by the customer per ride.
     * @param minutes -> The amount of time taken for the ride.
     * Created to add fares for multiple rides of the customer
     */
    public double bookCab(double distance, double minutes){
        return fareCalculator(distance, minutes);
    }

    /**
     *
     * @return -> Average fare cost per customer of the basis of their total fares and total rides.
     */
    public double averageFare(){
        return totalFare / totalRides;
    }

    /**
     *
     * @return total combined fare for all the rides of customer.
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     *
     * @return -> Total number of rides of the user.
     */
    public int getTotalRides() {
        return totalRides;
    }
}
