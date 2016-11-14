package org.wahlzeit.model;

/**
 * Created on 12.11.16.
 */
public class ArtPhotoFactory extends PhotoFactory {

    /**
     * @methodtype factory
     */

    public ArtPhoto createArtPhoto() {
        return new ArtPhoto();
    }

    /**
     * @methodtype factory
     */

    public ArtPhoto createArtPhoto(PhotoId id) {
        return new ArtPhoto(id);
    }
}
