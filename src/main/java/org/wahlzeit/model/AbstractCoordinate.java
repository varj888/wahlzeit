package org.wahlzeit.model;

@PatternInstance(
        patternName = "Template",
        participants = {"AbstractProduct"}
)

public abstract class AbstractCoordinate implements Coordinate {

        public boolean isEqual(Coordinate c){
            assertIsValidCoordinate(c);
            return Math.abs(this.getDistance(c)) == 0;
        }

        public double getDistance(Coordinate c){
            assertIsValidCoordinate(c);
            double distance = 0;
            CartesianCoordinate c1 = toCarthesian();
            CartesianCoordinate c2 = c.toCarthesian();

            double distX = c1.getX() - c2.getX();
            double distY = c1.getX() - c2.getX();
            double distZ = c1.getZ() - c2.getZ();
            double distQuadX = (Math.pow(distX, 2));
            double distQuadY = (Math.pow(distY, 2));
            double distQuadZ = (Math.pow(distZ, 2));
            distance = Math.sqrt(distQuadX + distQuadY + distQuadZ);

            return distance;
        }

        protected void assertIsValidInput(double d){
            if((Double.isInfinite(d) || Double.isNaN(d) || (d >= Double.MAX_VALUE))){
                    throw new IllegalArgumentException("Invalid input for the value " + d);
            }
        }

        protected void assertIsNotNullCoordinate(Coordinate c){
            if(c == null)
                throw new IllegalArgumentException("Coordinate can't be null");
        }

        protected void assertIsValidCoordinate(Coordinate c){
            assertIsNotNullCoordinate(c);
            CartesianCoordinate cc = c.toCarthesian();
            assertIsValidInput(cc.getX());
            assertIsValidInput(cc.getY());
            assertIsValidInput(cc.getZ());
        }
}
