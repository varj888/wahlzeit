package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

public class ArtType {

    private ArtCategory artCategory;
    private ArtManager artManager;

    public ArtType(ArtCategory artCategory){
        this.artCategory = artCategory;
        this.artManager = ArtManager.getInstance();
    }

    public ArtCategory getArtCategory(){
        return  artCategory;
    }

    public void setArtCategory(ArtCategory artCategory){
        this.artCategory = artCategory;
    }

    public enum ArtCategory implements EnumValue {

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

        ArtCategory(int key) {
            this.key = key;
        }

        private static ArtCategory[] allValues = {
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
        public int asInt() {
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
        public ArtCategory[] getAllValues() {
            return allValues;
        }

        /**
         * @methodtype get
         */
        public String getTypeName() {
            return allValues[key].toString();
        }
    }
}
