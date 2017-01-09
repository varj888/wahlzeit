package org.wahlzeit.model;
import java.util.HashMap;

@PatternInstance(
        patternName = "Template",
        participants = {"AbstractProduct", "ConcreteProduct"}
)

public class SphericCoordinate extends AbstractCoordinate {

    private final double latitude;
    private final double longitude;
    private final double radius;

    private static HashMap<Coordinate, Coordinate> instances = new HashMap<>();

    /**
     * @methodtype query method
     * (getter)
     */

    public static SphericCoordinate getInstance(double latitude, double longitude, double radius){
        SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude, radius);
        SphericCoordinate coordinateInMap;
        synchronized (instances){
            coordinateInMap = (SphericCoordinate)instances.get(coordinate);
            if(coordinateInMap == null){
                coordinateInMap = coordinate;
                instances.put(coordinateInMap, coordinateInMap);
            }
        }
        return coordinateInMap;
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
     * (getter)
     */

    public double getX() {
        final double x = radius * (Math.sin((Math.toRadians(longitude))))
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
        final double y = radius * (Math.sin((Math.toRadians(longitude))))
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
        final double z = radius * (Math.cos((Math.toRadians(longitude))));
        assertIsValidInput(z);
        return z;
    }

    /**
     *
     * @methodtype constructor
     */

    public SphericCoordinate(double latitude, double longitude, double radius) {
        checkLatitude(latitude);
        this.latitude = latitude;
        checkLongitude(longitude);
        this.longitude = longitude;
        assertIsValidRadius(radius);
        this.radius = radius;
    }

    /**
     *
     * @methodtype conversion method
     */

    public CartesianCoordinate toCarthesian(){
        final double x = getX();
        final double y = getY();
        final double z = getZ();

        return CartesianCoordinate.getInstance(x, y, z);
    }

    protected void assertIsValidRadius(double radius){
        assertIsValidInput(radius);
        if(radius < 0)
            throw new IllegalArgumentException("Radius can't be negative");
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
