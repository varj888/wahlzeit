package org.wahlzeit.model;

/**
 * Created on 19.11.16.
 */

public class SphericCoordinate implements Coordinate {

    //public static final double EARTH_RADIUS_KM = 6371.0;

    private double latitude;
    private double longitude;
    private double radius;

    public double getX() {
        return radius * Math.sin(Math.toRadians(longitude))
                * Math.cos(Math.toRadians(latitude));
    }

    public double getY() {
        return radius * Math.sin(Math.toRadians(longitude))
                * Math.sin(Math.toRadians(latitude));
    }

    public double getZ() {
        return radius * Math.cos(Math.toRadians(longitude));
    }

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
     * @methodtype helper
     */

    public void checkLatitude(double latitude) throws IllegalArgumentException {
        // rad: +pi/2 -pi/2
        if((latitude < -90) || (latitude > 90)){
            throw new IllegalArgumentException();
        }
        this.latitude = latitude;
    }

    /**
     *
     * @methodtype query method
     * (setter)
     */

    public void setLatitude(double latitude) {
        checkLatitude(latitude);
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

    public void checkLongitude(double longitude) throws IllegalArgumentException {
        // rad: +pi -pi
        if((longitude < -180.0) || (longitude > 180.0)){
            throw new IllegalArgumentException();
        }
        this.longitude = longitude;
    }

    /**
     *
     * @methodtype query method
     * (setter)
     */

    public void setLongitude(double longitude) {
        checkLongitude(longitude);
    }

    /**
     *
     * @methodtype constructor
     */

    public SphericCoordinate(double radius, double longitude,
                             double latitude) {
        checkLatitude(latitude);
        checkLongitude(longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        //this.radius = EARTH_RADIUS_KM;
    }

    /**
     *
     * @methodtype conversion method
     */

    public CartesianCoordinate toCartesianCoordinate() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(getX(), getY(), getZ());
        return cartesianCoordinate;
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(Coordinate sc) {
        double distance = 0;
        if(sc.getClass() == SphericCoordinate.class){
            // Spheric and Spheric impl
            distance = getDistance((SphericCoordinate)sc);
        }else{
            // Spheric and Cartesian impl
            distance = getDistance((CartesianCoordinate) sc);
        }
        return distance;
    }

    /**
     *
     * @methodtype query method
     */

    // d = sqrt [ 2 - 2 cos long1 cos long2 cos(lat1-lat2) - 2 sin lat1 sin lat2] / r*r

    public double getDistance(SphericCoordinate sc) {
        double distance = 0;
        double quadRaduis1 = this.radius * this.radius;
        double quadRaduis2 = sc.radius * sc.radius;
        double twoRadius = 2*this.radius * sc.radius;
        double resRadius = quadRaduis1 + quadRaduis2 - twoRadius;
        double sinLongitude = Math.toRadians(Math.sin(longitude)*Math.sin(sc.longitude));
        double cosLatitude = Math.toRadians(Math.cos((latitude - sc.latitude)%360));
        double cosLongitude = Math.toRadians(Math.cos(longitude)*Math.cos(sc.longitude));
        distance = resRadius*sinLongitude * cosLatitude + cosLongitude;

//        distance = (2 - 2 * Math.cos(Math.toRadians(longitude))*Math.cos(Math.toRadians(sc.getLongitude()))
//                *Math.cos(Math.toRadians(latitude - sc.getLatitude()))
//                - 2 * Math.sin(Math.toRadians(latitude))*Math.sin(Math.toRadians(sc.latitude)))/(radius*radius);
        return distance;
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(CartesianCoordinate cc) {
        SphericCoordinate sc = cc.toSphericCoordinate();
        return getDistance(sc);
    }
}
