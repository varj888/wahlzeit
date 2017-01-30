package org.wahlzeit.model;

public class Art {

    private ArtManager artManager = this.getArtManager();

    private ArtType artType;

    /**
     *
     * @methodtype constructor
     */

    public Art(ArtType artType){
        this.artType = artType;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtManager getArtManager(){
        return ArtManager.getInstance();
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtType getArtType(){
        return artType;
    }

    /**
     *
     * @methodtype mutation method
     * (setter)
     */

    public void setArtType(ArtType artType){
        this.artType = artType;
    }
}
