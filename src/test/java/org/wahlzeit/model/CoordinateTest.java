package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test cases for the Coordinate class
 *
 * v.1.0
 *
 * 30.10.16.
 */
public class CoordinateTest {

    @Test(expected = IllegalArgumentException.class)
    public void latitudeValueNotInRange(){
        Coordinate coord = new Coordinate(91.1, 181.2);
        coord.getLatitude();
    }

    @Test(expected = IllegalArgumentException.class)
    public void longitudeValueNotInRange(){
        Coordinate coord = new Coordinate(91.1, 181.2);
        coord.getLongitude();
    }
}
