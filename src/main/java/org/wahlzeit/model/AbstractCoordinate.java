package org.wahlzeit.model;

/**
 * v.1.2
 *
 * Created on 27.11.16.
 */
public abstract class AbstractCoordinate implements Coordinate {

        public boolean isEqual(Coordinate c){
            return Math.abs(this.getDistance(c)) == 0;
        }

        public double getDistance(Coordinate c){
            double distance = 0;
            assertClassInvariants();
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

        protected static boolean assertValidInput(double d){
            if(!(Double.isInfinite(d) || Double.isNaN(d))){
                if(d <= Double.MAX_VALUE){
                    return true;
                }
            }
            return false;
//            boolean b;
//            double input;
//            String inputString = String.valueOf(d);
//            try {
//                input = Double.parseDouble(inputString);
//            }catch (Exception ex){
//                ex.getMessage();
//            }
//            b = true;
//            return b;

        }

        protected boolean isValidCoordinate(Coordinate c){
            CartesianCoordinate cc = c.toCarthesian();
            if((assertValidInput(cc.getX())) && (assertValidInput(cc.getY()))
                    && (assertValidInput(cc.getZ()))){
                return true;
            }else {
                return false;
            }
        }

        protected void assertClassInvariants(){
            assert isValidCoordinate(this);
        }
}
