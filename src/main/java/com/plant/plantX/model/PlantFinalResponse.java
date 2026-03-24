package com.plant.plantX.model;

import java.util.List;

public class PlantFinalResponse {

    private String imageUrl;
    private String plantName;
    private String scientificName;
    private double confidence;
    private String description;
    private List<String> uses;

    private String commonName;
    private String family;
    private String genus;
    private String imageUrlWiki;



    public PlantFinalResponse(String imageUrl,
                              String plantName,
                              String scientificName,
                              double confidence,
                              String description,
                              List<String> uses,
                              String commonName,
                              String family,
                              String genus,
                              String imageUrlWiki) {
        this.imageUrl = imageUrl;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.confidence = confidence;
        this.description = description;
        this.uses = uses;
        this.commonName = commonName;
        this.family = family;
        this.genus = genus;
        this.imageUrlWiki = imageUrlWiki;
    }

    // getters
    public String getImageUrl() { return imageUrl; }
    public String getPlantName() { return plantName; }
    public String getScientificName() { return scientificName; }
    public double getConfidence() { return confidence; }
    public String getDescription() { return description; }
    public List<String> getUses() { return uses; }
    public String getCommonName() {
        return commonName;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public String getImageUrlWiki() {
        return imageUrlWiki;
    }
}
