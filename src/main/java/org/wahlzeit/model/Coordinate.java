package org.wahlzeit.model;

/**
 * Coordinate.java
 *
 * v.1.0
 *
 * 30.10.16.
 */
public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() throws IllegalArgumentException {
        if((latitude >= -90.0) && (latitude <= 90.0)){
            return latitude;
        }
        throw new IllegalArgumentException();
    }

    public double getLongitude() throws IllegalArgumentException {
        if((longitude >= -180.0) && (longitude <= 180.0)){
            return longitude;
        }
        throw new IllegalArgumentException();
    }
}
