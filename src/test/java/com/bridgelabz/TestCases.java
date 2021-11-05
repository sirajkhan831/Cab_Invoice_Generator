package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public void whenGiven10KmAnd4MinutesAndFareAs109_shouldReturnEqual() {
        Fare fare = new Fare(10,4);
        Assert.assertEquals(fare.getTotalFare(),109,0.5);
    }
}
