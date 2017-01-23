package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;

public class ArtManager extends ObjectManager {

    protected static final ArtManager instance = new ArtManager();

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public final static ArtManager getInstance() {
        return instance;
    }

    public ArrayList<Art> arts = new ArrayList<>();
    public ArrayList<ArtType> artTypes = new ArrayList<>();

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void setArts(Art art){
        arts.add(art);
    }

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void setArtTypes(ArtType artType){
        artTypes.add(artType);
    }

    /**
     *
     * @methodtype mutation method
     */

    public void removeArts(Art art){
        if(arts.contains(art)){
            arts.remove(art);
        }
    }

    /**
     *
     * @methodtype mutation method
     */

    public void removeArtTypes(ArtType artType){
        if(artTypes.contains(artType)){
            artTypes.remove(artType);
        }
    }
}
