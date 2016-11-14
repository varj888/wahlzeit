package org.wahlzeit.model;

/**
 * Created on 12.11.16.
 */
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
}
