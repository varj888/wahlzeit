package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ArtPhotoManager extends PhotoManager {

    protected static final ArtPhotoManager instance = new ArtPhotoManager();

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public final static ArtPhotoManager getInstance() {
        return instance;
    }

    public HashMap<ArtPhoto, ArtPhoto> artPhotos = new HashMap<>();

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void addArtPhoto(ArtPhoto artPhoto){
        artPhotos.put(artPhoto, artPhoto);
    }

    /**
     *
     * @methodtype mutation method
     */

    public void deleteArtPhoto(ArtPhoto artPhoto){
        if(artPhotos.containsKey(artPhoto)){
            artPhotos.remove(artPhoto);
        }
    }
}
