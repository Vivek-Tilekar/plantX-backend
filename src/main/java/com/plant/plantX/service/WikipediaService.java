package com.plant.plantX.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WikipediaService {

    @Cacheable(value = "wikiCache", key = "#plantName")
    public JsonNode getPlantDescription(String plantName) {

        try {
            String formattedName = plantName.replace(" ", "_");

            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + formattedName;

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "PlantApp/1.0 vivekbca111@gmail.com");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        try {
//
//            String formattedName = plantName.replace(" ", "_");
//
//            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + formattedName;
//
//            RestTemplate restTemplate = new RestTemplate();
//
//            // ✅ ADD HEADERS
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("User-Agent", "PlantApp/1.0 vivekbca111@gmail.com");
//
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//
//            ResponseEntity<String> response = restTemplate.exchange(
//                    url,
//                    HttpMethod.GET,
//                    entity,
//                    String.class
//            );
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode json = mapper.readTree(response.getBody());
//
//            return json.path("extract").asText();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "No detailed description available.";
//        }
    }
}
