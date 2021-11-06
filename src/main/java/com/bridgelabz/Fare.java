package com.bridgelabz;

import java.sql.*;

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
     *
     * @param fare -> Current fare of the registered user
     * @param userID -> user ID of the registered user
     * @throws SQLException -
     */
    public void userRepository(Fare fare, String userID) throws SQLException {
        boolean columnExists = false;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cab", "siraj", "password");
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Cab WHERE PersonID = ?");
        selectStatement.setString(1, userID);
        ResultSet set = selectStatement.executeQuery();
        set.next();
        String rideNumber = Integer.toString((set.getInt("TotalRides")) + (1));
        ResultSetMetaData metaData = set.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            if (metaData.getColumnName(i).equals("Ride" + rideNumber)) {
                columnExists = true;
            }
        }
        if (!columnExists) {
            PreparedStatement alterStatement = connection.prepareStatement("ALTER TABLE Cab ADD COLUMN Ride" + rideNumber + " int null");
            alterStatement.execute();
        }
        PreparedStatement updateFareStatement = connection.prepareStatement("UPDATE Cab SET Ride" + rideNumber + " = ? WHERE PersonID = ?");
        updateFareStatement.setString(1, Double.toString(fare.getTotalFare()));
        updateFareStatement.setString(2, userID);
        updateFareStatement.execute();
        PreparedStatement updateTotalRidesStatement = connection.prepareStatement("UPDATE Cab SET TotalRides = ? WHERE PersonID = ?");
        updateTotalRidesStatement.setString(1, rideNumber);
        updateTotalRidesStatement.setString(2, userID);
        updateTotalRidesStatement.execute();
        PreparedStatement updateAverageFareStatement = connection.prepareStatement("UPDATE Cab SET AverageFare = ? WHERE PersonID = ?");
        double averageFare = ((set.getDouble("AverageFare")) + (fare.getTotalFare()) / 2);
        updateAverageFareStatement.setString(1, Double.toString(averageFare));
        updateAverageFareStatement.setString(2, userID);
        updateAverageFareStatement.execute();
    }

    /**
     * @param userID -> Registered User ID of the customer
     * @return -> Total number of rides of the given user
     * @throws SQLException -
     */
    public int getUserTotalRides(String userID) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cab", "siraj", "password");
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Cab WHERE PersonID = ?");
        selectStatement.setString(1, userID);
        ResultSet set = selectStatement.executeQuery();
        set.next();
        return set.getInt("TotalRides");
    }

    /**
     * @param userID -> Registered User ID of the customer
     * @return -> AverageFare of the given user
     * @throws SQLException -
     */
    public int getUserAverageFare(String userID) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cab", "siraj", "password");
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Cab WHERE PersonID = ?");
        selectStatement.setString(1, userID);
        ResultSet set = selectStatement.executeQuery();
        set.next();
        return set.getInt("AverageFare");
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
