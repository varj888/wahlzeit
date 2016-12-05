package org.wahlzeit.model;

/**
 * v.1.2
 *
 * Created on 19.11.16.
 */

public class CartesianCoordinate extends AbstractCoordinate {

    private double x;
    private double y;
    private double z;

    /**
     * @methodtype query method
     * (getter)
     */

    public double getX() {
        return x;
    }

    /**
     * @methodtype query method
     * (getter)
     */

    public double getY() {
        return y;
    }

    /**
     * @methodtype query method
     * (getter)
     */

    public double getZ() {
        return z;
    }

    /**
     * @methodtype constructor
     */

    public CartesianCoordinate(double x, double y, double z) {
        assertValidInput(x);
        assertValidInput(y);
        assertValidInput(z);
        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype conversion method
     */

    public CartesianCoordinate toCarthesian(){
        assertClassInvariants();
        return this;
    }
}