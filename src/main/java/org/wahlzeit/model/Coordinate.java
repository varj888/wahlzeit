package org.wahlzeit.model;

/**
 * Coordinate.java
 *
 * v.1.3
 *
 * Created on 30.10.16.
 */

public interface Coordinate {

    double getDistance(Coordinate secondCoordinate);

    boolean isEqual(Coordinate c);

    CartesianCoordinate toCarthesian();
}
