package org.wahlzeit.model;

/**
 * v.1.1
 *
 * Created on 19.11.16.
 */

public class CartesianCoordinate extends AbstractCoordinate {

    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getX(){
        return this.x;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getY(){
        return this.y;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public double getZ(){
        return this.z;
    }

    /**
     *
     * @methodtype constructor
     */

    public CartesianCoordinate(){

    }

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        if (!isEarthCoordinate()) {
            throw new IllegalArgumentException("This is not valid Earth Coordinate");
        }
    }

    private boolean isEarthCoordinate(){
        double coordRadius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return (Math.abs(EARTH_RADIUS_KM - coordRadius)) <= 2;
    }

    /**
     *
     * @methodtype conversion method
     */

    public SphericCoordinate toSphericCoordinate(){
        double latitude = Math.acos(z/EARTH_RADIUS_KM);
        double longitude = Math.atan2(y,x);
        return new SphericCoordinate(Math.toDegrees(latitude), Math.toDegrees(longitude));
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(Coordinate c){
        double distance = 0;
        if(this.isEqual(c)){
            distance = doGetDistance((CartesianCoordinate)c);
        } else {
            distance = this.toSphericCoordinate().getDistance(c);
        }
        return distance;
    }

    /**
     *
     * @methodtype helper method
     */

    public double doGetDistance(CartesianCoordinate sc){
        double distance = 0;

        double distX = this.x - sc.getX();
        double distY = this.y - sc.getY();
        double distZ = this.z - sc.getZ();
        double distQuadX = (Math.pow(distX, 2));
        double distQuadY = (Math.pow(distY, 2));
        double distQuadZ = (Math.pow(distZ, 2));
        distance = Math.sqrt(distQuadX + distQuadY + distQuadZ);
        return distance;
    }
}
