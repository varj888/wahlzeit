package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the SphericCoordinate
 * and for CartesianCoordinate classes
 *
 * v.1.1
 *
 * 30.10.16.
 */
public class CoordinateTest {

    private double delta = 0.000001;

//    @Test(expected = IllegalArgumentException.class)
//    public void latitudeValueNotInRange(){
//        Coordinate coord = new Coordinate(91.1, 181.2);
//        coord.getLatitude();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void longitudeValueNotInRange(){
//        Coordinate coord = new Coordinate(91.1, 181.2);
//        coord.getLongitude();
//    }

    @Test(expected = IllegalArgumentException.class)
    public void createSphericCoordinateWrongValuesTest() {
        SphericCoordinate sc = new SphericCoordinate(123, 360, 222);
    }

    @Test
    public void getDistanceCartesianTest(){
        CartesianCoordinate cc1 = new CartesianCoordinate(12, 34.55, 43.90);
        CartesianCoordinate cc2 = new CartesianCoordinate(45, 28.15, 88.23);
        double actualRes = cc1.getDistance(cc2);
        double expectedRes = 55.633703;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void conversionSphericToCartesianTest(){
        SphericCoordinate sc = new SphericCoordinate(6371, 60.0, 30.0);
        CartesianCoordinate cc = sc.toCartesianCoordinate();
        CartesianCoordinate ccExpected = new CartesianCoordinate(5995.20111, 1918.706498, 982.73599);
        assertEquals(ccExpected.getX(), cc.getX(), delta);
        assertEquals(ccExpected.getY(), cc.getY(), delta);
        assertEquals(ccExpected.getZ(), cc.getZ(), delta);
    }

    @Test
    public void getDistanceSphericTest(){
        SphericCoordinate sc1 = new SphericCoordinate(6371, 34.55, 43.90);
        SphericCoordinate sc2 = new SphericCoordinate(6371, 28.15, 88.23);
        double actualRes = sc1.getDistance(sc2);
        double expectedRes = 1.2;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void getDistanceCartesianToSphericTest(){
        CartesianCoordinate cc = new CartesianCoordinate(12.2, 222, 345.2);
        SphericCoordinate scExpected = new SphericCoordinate(6371, 2, 3);
        SphericCoordinate sc = cc.toSphericCoordinate();
        assertEquals(scExpected.getLatitude(), sc.getLatitude(), delta);
        assertEquals(scExpected.getLongitude(), sc.getLongitude(), delta);
    }

    @Test
    public void getDistanceSphericToCartesianTest(){
        SphericCoordinate sc = new SphericCoordinate(6371, 12.2, 22.12);
        CartesianCoordinate ccExpected = new CartesianCoordinate(2, 3, 1);
        CartesianCoordinate cc = sc.toCartesianCoordinate();
        assertEquals(ccExpected.getX(), sc.getX(), delta);
        assertEquals(ccExpected.getY(), sc.getY(), delta);
        assertEquals(ccExpected.getZ(), sc.getZ(), delta);
    }
}
