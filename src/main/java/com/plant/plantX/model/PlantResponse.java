package com.plant.plantX.model;

import java.util.List;

public class PlantResponse {

    private String plantName;
    private String scientificName;
    private String description;
    private List<String> uses;
    private double confidence;

    public PlantResponse(String plantName, String scientificName,
                         String description, List<String> uses, double confidence) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.description = description;
        this.uses = uses;
        this.confidence = confidence;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getUses() {
        return uses;
    }

    public double getConfidence() {
        return confidence;
    }

}
