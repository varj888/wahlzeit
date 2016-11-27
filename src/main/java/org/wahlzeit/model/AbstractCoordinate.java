package org.wahlzeit.model;

/**
 * v.1.0
 *
 * Created on 27.11.16.
 */
public abstract class AbstractCoordinate implements Coordinate {

        public boolean isEqual(Coordinate c){
        if(this.isCartesian() ==
                c.isCartesian()){
            return true;
        }
            return false;
    }

    public boolean isCartesian(){
        if(this instanceof CartesianCoordinate){
            return true;
        }else if(this instanceof SphericCoordinate){
            return false;
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
