package com.plant.plantX.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class PlantInfoService {

    @Value("${trefle.api_key}")
    private String API_KEY;

    @Cacheable(value = "trefleCache", key = "#plantName")
    public JsonNode getPlantInfo(String plantName) {

        try {
            String url = "https://trefle.io/api/v1/plants/search?token="
                    + API_KEY + "&q=" + plantName;

            RestTemplate restTemplate = new RestTemplate();

            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
