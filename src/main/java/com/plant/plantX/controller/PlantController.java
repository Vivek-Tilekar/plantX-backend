package com.plant.plantX.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.plant.plantX.model.PlantFinalResponse;
import com.plant.plantX.model.PlantResponse;
import com.plant.plantX.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plant")
@CrossOrigin(origins = "*")
public class PlantController {

    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private PlantNetService plantNetService;

    @Autowired
    private PlantInfoService plantInfoService;

    @Autowired
    private WikipediaService wikipediaService;


    @GetMapping("/test")
    public String tests() {
        System.out.println("API Hitted");

        return "Test Successful";
    }

    @PostMapping(
            value = "/identify",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> identifyPlant(
            @RequestPart("image") MultipartFile image
    ) {
        System.out.println("Request hit identify API");
//        System.out.println(mail);
        String imageUrl = cloudinaryService.uploadImage(image);

        JsonNode plantNetJson = plantNetService.identifyPlant(image);

        String scientificName = plantNetJson
                .path("results")
                .get(0)
                .path("species")
                .path("scientificNameWithoutAuthor")
                .asText();

        double confidence = plantNetJson
                .path("results")
                .get(0)
                .path("score")
                .asDouble();

        // Wikipedia
        JsonNode wikiJson = wikipediaService.getPlantDescription(scientificName);

        String description = wikiJson.path("extract").asText();
        String wikiImage = wikiJson.path("thumbnail").path("source").asText();

        // Trefle
        JsonNode trefleJson = plantInfoService.getPlantInfo(scientificName);
        JsonNode plant = trefleJson.path("data").get(0);

        String commonName = plant.path("common_name").asText();
        String family = plant.path("family").asText();
        String genus = plant.path("genus").asText();

        List<String> uses = List.of(
                "Medicinal use",
                "Herbal remedy",
                "Skin care"
        );

        PlantFinalResponse response = new PlantFinalResponse(
                imageUrl,
                scientificName,
                scientificName,
                confidence,
                description,
                uses,
                commonName,
                family,
                genus,
                wikiImage
        );

        return ResponseEntity.ok(response);
    }
}

//d65Q54NKUqdH41RKdPRNhhAmSws

//716793575316329
