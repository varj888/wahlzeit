package org.wahlzeit.model;

/**
 * Coordinate.java
 *
 * v.1.1
 *
 * 30.10.16.
 */

public interface Coordinate {

    public double getX();

    public double getY();

    public double getZ();

    public double getDistance(Coordinate secondCoordinate);

}
