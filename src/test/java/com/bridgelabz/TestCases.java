package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public void whenGiven10KmAnd4MinutesAndFareAs109_shouldReturnEqual() {
        Fare fare = new Fare(10,4);
        Assert.assertEquals(fare.getTotalFare(),109,0.5);
    }

    @Test
    public void whenGivenMultipleRides_ifAdded_shouldReturnEqual() {
        Fare fare = new Fare(4,2);
        fare.bookCab(10,8);
        Assert.assertEquals(fare.getTotalFare(),160,0.5);
    }
}
