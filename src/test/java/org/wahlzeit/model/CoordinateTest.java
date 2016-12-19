package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the SphericCoordinate
 * and for CartesianCoordinate classes
 *
 * v.1.2
 *
 * 27.11.16.
 */
public class CoordinateTest {

    private double delta = 0.5;

    @Test(expected = IllegalArgumentException.class)
    public void latitudeValueNotInRange(){
        Coordinate coord = SphericCoordinate.getInstance(91.1, 181.2, 22222);
    }

    @Test(expected = IllegalArgumentException.class)
    public void longitudeValueNotInRange(){
        Coordinate coord = SphericCoordinate.getInstance(91.1, 181.2, 22222);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createSphericCoordinateWrongValuesTest() {
        SphericCoordinate sc = SphericCoordinate.getInstance(123, 222, 11111);
    }

    @Test
    public void getDistanceEqualCartesianTest(){
        CartesianCoordinate cc1 = CartesianCoordinate.getInstance(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        CartesianCoordinate cc2 = CartesianCoordinate.getInstance(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        double actualRes = cc1.getDistance(cc2);
        double expectedRes = 0;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void getDistanceSphericTest(){
        SphericCoordinate sc1 = SphericCoordinate.getInstance(34.55, 43.90, 100);
        SphericCoordinate sc2 = SphericCoordinate.getInstance(28.15, 88.23, 100);
        double actualRes = sc1.getDistance(sc2);
        double expectedRes = 82;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void getDistanceSphericToCartesianTest(){
        SphericCoordinate sc = SphericCoordinate.getInstance(22, 33, 100);
        CartesianCoordinate ccExpected = CartesianCoordinate.getInstance(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        assertEquals(sc.getDistance(ccExpected), 951, delta);
    }

    @Test
    public void getDistanceBothCoordinatesTest(){
        CartesianCoordinate cc = CartesianCoordinate.getInstance(199.7801015013779, 6299.8157297895266, 895.3927238766871);
        SphericCoordinate scExpected = SphericCoordinate.getInstance(1.4296819575887, 1.5390948960652, 6366.2640887911);
        CartesianCoordinate cc1 = scExpected.toCarthesian();
        assertEquals(cc.getX(), cc1.getX(), delta);
        assertEquals(cc.getY(), cc1.getY(), delta);
        assertEquals(cc.getZ(), cc1.getZ(), delta);
        assertEquals(scExpected.getX(), cc1.getX(), delta);
        assertEquals(scExpected.getY(), cc1.getY(), delta);
        assertEquals(scExpected.getZ(), cc1.getZ(), delta);
        double dist1 = cc.getDistance(cc1);
        double dist2 = cc1.getDistance(cc);
        assertEquals(dist1, dist2, delta);
    }
}
