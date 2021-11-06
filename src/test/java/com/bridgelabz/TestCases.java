package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class TestCases {

    @Test
    public void whenGiven10KmAnd4MinutesAndFareAs109_shouldReturnEqual() {
        Fare fare = new Fare(10, 4);
        Assert.assertEquals(fare.getTotalFare(), 109, 0.5);
    }

    @Test
    public void whenGivenMultipleRides_ifRequiredFarePerRide_shouldReturnEqual() {
        Fare fare = new Fare(2, 0);
        Assert.assertEquals(fare.getFare(), 25, 0.5);
        fare.bookCab(4, 2);
        Assert.assertEquals(fare.getFare(), 47, 0.5);
    }

    @Test
    public void whenGivenMultipleRides_ifAdded_shouldReturnEqual() {
        Fare fare = new Fare(4, 2);
        fare.bookCab(10, 8);
        Assert.assertEquals(fare.getTotalFare(), 160, 0.5);
    }

    @Test
    public void whenGivenMultipleRides_ifRequiredTotalRides_shouldReturnEqual() {
        Fare fare = new Fare(5, 3);
        fare.bookCab(4, 2);
        fare.bookCab(6, 1);
        Assert.assertEquals(fare.getTotalRides(), 3);
    }

    @Test
    public void whenGivenMultipleRides_ifRequiredAverageFare_shouldReturnEqual() {
        Fare fare = new Fare(5, 3);
        fare.bookCab(4, 2);
        fare.bookCab(6, 1);
        Assert.assertEquals(fare.averageFare(), 57, 0.5);
    }

    @Test
    public void whenGivenPremiumRide_shouldReturnEqual() {
        Fare fare = new Fare(5, 4, true);
        Assert.assertEquals(fare.getFare(), 103, 0.1);
    }

    @Test
    public void whenGivenUserID_ifRequiredTotalRides_shouldReturnEqual() throws SQLException {
        Fare fare = new Fare(46, 20);
        String userID = "2";
        Assert.assertEquals(4,fare.getUserTotalRides(userID));
    }

    @Test
    public void whenGivenUserID_ifRequiredAverageFare_shouldReturnEqual() throws SQLException{
        Fare fare = new Fare(21,22);
        String userID = "3";
        Assert.assertEquals(1018,fare.getUserAverageFare(userID));
    }
}
