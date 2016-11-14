package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

/**
 * Created on 14.11.16.
 */
public enum ArtPhotoCategory implements EnumValue {

    RENAISSANCE(0),
    BAROQUE(1),
    IMPRESSIONISM(2),
    POST_IMPRESSIONISM(3),
    SYMBOLISM(4),
    EXPRESSIONISM(5),
    CUBISM(6),
    OTHER(7),
    NO_CATEGORY(8);

    private int key;

    private ArtPhotoCategory(int key){
        this.key = key;
    }

    private static ArtPhotoCategory[] allValues = {
            RENAISSANCE,
            BAROQUE,
            IMPRESSIONISM,
            POST_IMPRESSIONISM,
            SYMBOLISM,
            EXPRESSIONISM,
            CUBISM,
            OTHER,
            NO_CATEGORY
    };

    public String[] values = {
            "Renaissance", "Baroque", "Impressionism",
            "Post-impressionism", "Symbolism",
            "Expressionism", "Cubism", "Other", "No category"
    };

    /**
     * @methodtype conversion
     */
    public int asInt(){
        return key;
    }

    /**
     * @methodtype conversion
     */
    public String asString() {
        return values[key];
    }

    /**
     * @methodtype get
     */
    public ArtPhotoCategory[] getAllValues(){
        return allValues;
    }

    /**
     * @methodtype get
     */
    public String getTypeName(){
        return allValues[key].toString();
    }
}
