package org.wahlzeit.model;

/**
 * Location.java
 *
 * v.1.0
 *
 * 30.10.16.
 */
public class Location {

    public Coordinate coordinate;
    public final double earthRadius = 6371000;

    // d = r * delta(sigma)
    // delta(sigma) = acos(sin(fi1) * sin(fi2) + cos(fi1) * cos(fi2) * cos(delta(lambda)))
    // delta(lambda) = [lambda1 - lambda2] (absolute)

    // fi = latitude
    // lambda = longitude

    public double getDistance(Location firstLocation, Location secondLocation)
            throws NullPointerException {
        if((firstLocation != null) && (secondLocation != null)){
            if((firstLocation.coordinate != null) && (secondLocation.coordinate != null)){
                double centralAngle = Math.acos(Math.sin(firstLocation.coordinate.getLatitude())
                        * Math.sin(secondLocation.coordinate.getLatitude())
                        + Math.cos(firstLocation.coordinate.getLatitude())
                        * Math.cos(secondLocation.coordinate.getLatitude())
                        * Math.cos(Math.abs(firstLocation.coordinate.getLongitude()
                        - secondLocation.coordinate.getLongitude())));
                return earthRadius * centralAngle;
            }
        }
        throw new  NullPointerException("Location or/and Coordinate can not be null");
    }
}
