package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public void whenGiven10KmAnd4MinutesAndFareAs109_shouldReturnEqual() {
        Fare fare = new Fare(10, 4);
        Assert.assertEquals(fare.getTotalFare(), 109, 0.5);
    }

    @Test
    public void whenGivenMultipleRides_ifRequiredFarePerRide_shouldReturnEqual() {
        Fare fare = new Fare(2,0);
        Assert.assertEquals(fare.getFare(),25,0.5);
        fare.bookCab(4,2);
        Assert.assertEquals(fare.getFare(),47,0.5);
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
}
