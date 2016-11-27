package org.wahlzeit.model;

/**
 * v.1.1
 *
 * Created on 19.11.16.
 */

public class SphericCoordinate extends AbstractCoordinate {

    private double latitude;
    private double longitude;

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getLatitude() {
        return this.latitude;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getLongitude() {
        return this.longitude;
    }

    /**
     *
     * @methodtype helper
     */

    public void checkLatitude(double latitude) throws IllegalArgumentException {
        // rad: +pi/2 -pi/2
        if((latitude < -90.0) || (latitude > 90.0)){
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     * @methodtype helper
     */

    public void checkLongitude(double longitude) throws IllegalArgumentException {
        // rad: +pi -pi
        if((longitude < -180.0) || (longitude > 180.0)){
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     * @methodtype query method
     * (setter)
     */

    public void setLatitude(double latitude) {
        checkLatitude(latitude);
        this.latitude = latitude;
    }

    /**
     *
     * @methodtype query method
     * (setter)
     */

    public void setLongitude(double longitude) {
        checkLongitude(longitude);
        this.longitude = longitude;
    }

    /**
     *
     * @methodtype constructor
     */

    public SphericCoordinate(double latitude, double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(Coordinate c) {
        double distance = 0;
        if (this.isEqual(c)){
            distance = this.doGetDistance((SphericCoordinate)c);
        }else {
            SphericCoordinate sc = ((CartesianCoordinate)c).toSphericCoordinate();
            distance = this.doGetDistance(sc);
        }
        return distance;
    }

    /**
     *
     * @methodtype helper method
     */

    public double doGetDistance(SphericCoordinate c){
        double distance = 0;
        double fi1 = Math.toRadians(this.latitude);
        double fi2 = Math.toRadians(c.latitude);
        double deltaFi = Math.toRadians(c.getLatitude() - this.latitude);
        double deltaLambda = Math.toRadians(c.getLongitude() - this.longitude);
        double a = Math.pow(Math.sin(deltaFi/2), 2) + Math.cos(fi1) * Math.cos(fi2) *
                Math.pow(Math.sin(deltaLambda/2), 2);
        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        distance = EARTH_RADIUS_KM * b;
        return distance;
    }
}
