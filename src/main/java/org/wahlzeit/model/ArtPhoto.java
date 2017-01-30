package org.wahlzeit.model;
import java.io.Serializable;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractProduct", "ConcreteProduct"}
)

public class ArtPhoto extends Photo implements Serializable {

    private ArtPhotoManager artPhotoManager = this.getArtPhotoManager();
    private Art art;

    /**
     *
     * @methodtype constructor
     */

    public ArtPhoto(){
        super();
    }

    /**
     *
     * @methodtype constructor
     */

    public ArtPhoto(PhotoId photoId) {
        super(photoId);
    }

    /**
     *
     * @methodtype constructor
     */

    public ArtPhoto(PhotoId photoId, Art art){
        super(photoId);
        this.art = art;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public Art getArt(){
        return art;
    }

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void setArt(Art art){
        assertIsValidArtPhotoCategory(art);
        this.art = art;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtPhotoManager getArtPhotoManager(){
        return ArtPhotoManager.getInstance();
    }

    /**
     *
     * @methodtype assertion method
     */

    protected void assertIsValidArtPhotoCategory(Art art){
        if(art == null){
            throw new IllegalArgumentException("Art can't be null");
        }
    }
}
