package org.wahlzeit.model;
import java.io.Serializable;

/**
 * Created on 12.11.16.
 */
public class ArtPhoto extends Photo implements Serializable {

    private ArtPhotoManager artPhotoManager = this.getArtPhotoManager();
    private ArtPhotoCategory artPhotoCategory = ArtPhotoCategory.NO_CATEGORY;

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

    public ArtPhoto(Photo photo){
        super(photo.getId());
    }

    /**
     *
     * @methodtype constructor
     */

    public ArtPhoto(PhotoId id){
        super(id);
    }

    /**
     *
     * @methodtype constructor
     */

    public ArtPhoto(ArtPhotoCategory artPhotoCategory){
        super();
        this.artPhotoCategory = artPhotoCategory;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtPhotoCategory getArtPhotoCategory(){
        return artPhotoCategory;
    }

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void setArtPhotoCategory(ArtPhotoCategory setCategory){
        assertIsValidArtPhotoCategory(setCategory);
        this.artPhotoCategory = setCategory;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtPhotoManager getArtPhotoManager(){
        return ArtPhotoManager.getInstance();
    }

    protected void assertIsValidArtPhotoCategory(ArtPhotoCategory category){
        if(category == null){
            throw new IllegalArgumentException("ArtPhotoCategory can't be null");
        }
    }
}
