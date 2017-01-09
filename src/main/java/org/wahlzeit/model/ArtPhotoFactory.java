package org.wahlzeit.model;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractFactory", "ConcreteFactory"}
)

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
