package org.wahlzeit.model;

public class Art {

    private ArtManager artManager = this.getArtManager();

    private ArtType artType;
    private ArtPhoto artPhoto;

    public Art(ArtType artType){
        this.artType = artType;
    }

    public Art(ArtType artType, ArtPhoto artPhoto){
        this.artType = artType;
        this.artPhoto = artPhoto;
    }

    /**
     *
     * @methodtype query method
     * (getter)
     */

    public ArtManager getArtManager(){
        return ArtManager.getInstance();
    }
}
