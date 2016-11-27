package org.wahlzeit.model;

/**
 * Coordinate.java
 *
 * v.1.2
 *
 * Created on 30.10.16.
 */

public interface Coordinate {

    double EARTH_RADIUS_KM = 6371.0;

    double getDistance(Coordinate secondCoordinate);

    boolean isEqual(Coordinate c);

    boolean isCartesian();
}
