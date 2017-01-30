package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<Art, Art> arts = new HashMap<>();
    public HashMap<ArtType, ArtType> artTypes = new HashMap();

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void addArt(Art art) {
        arts.put(art, art);
    }

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void addArtType(ArtType artType){
        artTypes.put(artType, artType);
    }

    /**
     *
     * @methodtype mutation method
     */

    public synchronized void removeArt(Art art){
        if(arts.containsKey(art)){
            arts.remove(art);
        }
    }

    /**
     *
     * @methodtype mutation method
     */

    public synchronized void removeArtType(ArtType artType){
        if(artTypes.containsKey(artType)){
            artTypes.remove(artType);
        }
    }

    public Art createArt(ArtType artType){
        Art art = new Art(artType);
        arts.put(art, art);
        return art;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtType getArtType(Art art){
        return art.getArtType();
    }

    /**
     *
     * @methodtype mutation method
     */

    public void setArtType(Art art, ArtType artType){
        art.setArtType(artType);
    }
}
