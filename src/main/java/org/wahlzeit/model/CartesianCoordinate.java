package org.wahlzeit.model;

/**
 * Created on 19.11.16.
 */

public class CartesianCoordinate implements Coordinate {

    private double x;
    private double y;
    private double z;

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    /**
     *
     * @methodtype constructor
     */

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype conversion method
     */

    public SphericCoordinate toSphericCoordinate(){
        double radius = Math.sqrt(Math.toRadians((x*x) + (y*y) + (z*z)));
        double longitude = Math.acos(Math.toRadians(z/radius));
        double latitude = Math.atan(Math.toRadians(y/x));
        SphericCoordinate sphericCoordinate =
                new SphericCoordinate(radius, latitude, longitude);
        return sphericCoordinate;
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(Coordinate c){
        double distance = 0;
        if(c.getClass() == CartesianCoordinate.class){
            distance = getDistance((CartesianCoordinate)c);
        }
        else {
            distance = getDistance((SphericCoordinate)c);
        }
        return distance;
    }

    /**
     *
     * @methodtype query method
     */

    public double getDistance(CartesianCoordinate sc){
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

    /**
     *
     * @methodtype query method
     */

    public double getDistance(SphericCoordinate sc){
        CartesianCoordinate cc = sc.toCartesianCoordinate();
        return getDistance(cc);
    }
}
