package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test cases for the Location class
 *
 * v.1.0
 *
 * 30.10.16.
 */
public class LocationTest {

    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void locationIsNullShouldThrowException1() {
        Location first = new Location();
        first.coordinate = new Coordinate(3.5, 2.2);
        Location second = null;
        first.getDistance(first, second);
    }

    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void locationIsNullShouldThrowException2() {
        Location first = null;
        Location second = new Location();
        second.coordinate = new Coordinate(3.5, 2.2);
        first.getDistance(first, second);
    }
}
