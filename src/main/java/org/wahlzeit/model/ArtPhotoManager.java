package org.wahlzeit.model;

import java.util.ArrayList;

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

    public ArrayList<ArtPhoto> artPhotos = new ArrayList<>();

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void addArtPhoto(ArtPhoto artPhoto){
        artPhotos.add(artPhoto);
    }

    /**
     *
     * @methodtype mutation method
     */

    public void deleteArtPhoto(ArtPhoto artPhoto){
        if(artPhotos.contains(artPhoto)){
            artPhotos.remove(artPhoto);
        }
    }
}
