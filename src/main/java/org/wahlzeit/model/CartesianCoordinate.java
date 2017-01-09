package org.wahlzeit.model;
import java.util.HashMap;
import java.util.Objects;

@PatternInstance(
        patternName = "Template",
        participants = {"AbstractProduct", "ConcreteProduct"}
)

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    private static HashMap<Coordinate, Coordinate> instances = new HashMap<Coordinate, Coordinate>();

    /**
     * @methodtype query method
     * (getter)
     */

    public static CartesianCoordinate getInstance(double x, double y, double z){
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
        CartesianCoordinate coordinateInMap;
        synchronized (instances){
            coordinateInMap = (CartesianCoordinate)instances.get(coordinate);
            if(coordinateInMap == null){
                coordinateInMap = coordinate;
                instances.put(coordinateInMap, coordinateInMap);
            }
        }
        return coordinateInMap;
    }

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
        assertIsValidInput(x);
        assertIsValidInput(y);
        assertIsValidInput(z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype conversion method
     */

    public CartesianCoordinate toCarthesian(){
        return getInstance(this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}