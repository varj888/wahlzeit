package org.wahlzeit.model;

import org.wahlzeit.services.mailing.MailingException;

/**
 * v.1.2
 *
 * Created on 19.11.16.
 */

public class SphericCoordinate extends AbstractCoordinate {

    private double latitude;
    private double longitude;
    private double radius;

    private double x;
    private double y;
    private double z;

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
        assertIsValidInput(latitude);
        checkLatitude(latitude);
        this.latitude = latitude;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype query method
     * (setter)
     */

    public void setLongitude(double longitude) {
        assertIsValidInput(longitude);
        checkLongitude(longitude);
        this.longitude = longitude;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getX() {
        x = radius * (Math.sin((Math.toRadians(longitude))))
                * (Math.cos(Math.toRadians(latitude)));
        assertIsValidInput(x);
        return x;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getY() {
        y = radius * (Math.sin((Math.toRadians(longitude))))
                * (Math.sin(Math.toRadians(latitude)));
        assertIsValidInput(y);
        return y;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getZ() {
        z = radius * (Math.cos((Math.toRadians(longitude))));
        assertIsValidInput(z);
        return z;
    }

    /**
     *
     * @methodtype constructor
     */

    public SphericCoordinate(double latitude, double longitude, double radius) {
        setLatitude(latitude);
        setLongitude(longitude);
        assertIsValidRadius(radius);
        this.radius = radius;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype conversion method
     */

    public CartesianCoordinate toCarthesian(){
        double x = getX();
        double y = getY();
        double z = getZ();

        return new CartesianCoordinate(x, y, z);
    }

    protected void assertIsValidRadius(double radius){
        assertIsValidInput(radius);
        if(radius < 0)
            throw new IllegalArgumentException("Radius can't be negative");
    }
}
