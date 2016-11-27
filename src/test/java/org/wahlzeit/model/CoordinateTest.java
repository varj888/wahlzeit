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
        Coordinate coord = new SphericCoordinate(91.1, 181.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void longitudeValueNotInRange(){
        Coordinate coord = new SphericCoordinate(91.1, 181.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createSphericCoordinateWrongValuesTest() {
        SphericCoordinate sc = new SphericCoordinate(123, 222);
    }

    @Test
    public void getDistanceEqualCartesianTest(){
        CartesianCoordinate cc1 = new CartesianCoordinate(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        CartesianCoordinate cc2 = new CartesianCoordinate(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        double actualRes = cc1.getDistance(cc2);
        double expectedRes = 0;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void getDistanceSphericTest(){
        SphericCoordinate sc1 = new SphericCoordinate(34.55, 43.90);
        SphericCoordinate sc2 = new SphericCoordinate(28.15, 88.23);
        double actualRes = sc1.getDistance(sc2);
        double expectedRes = 4235;
        assertEquals(expectedRes, actualRes, delta);
    }

    @Test
    public void getDistanceSphericToCartesianTest(){
        SphericCoordinate sc = new SphericCoordinate(22, 33);
        CartesianCoordinate ccExpected = new CartesianCoordinate(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        assertEquals(sc.getDistance(ccExpected), 7129, delta);
    }

    @Test
    public void getDistanceBothCoordinatesTest(){
        CartesianCoordinate cc = new CartesianCoordinate(-299.7801015013779, 6299.8157297895266, 895.3927238766871);
        SphericCoordinate scExpected = new SphericCoordinate(81.919753795836, 92.724395199765);
        SphericCoordinate sc = cc.toSphericCoordinate();
        assertEquals(scExpected.getLatitude(), sc.getLatitude(), delta);
        assertEquals(scExpected.getLongitude(), sc.getLongitude(), delta);
        double dist1 = cc.getDistance(sc);
        double dist2 = sc.getDistance(cc);
        assertEquals(dist1, dist2, delta);
    }
}
