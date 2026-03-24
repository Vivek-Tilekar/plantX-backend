package com.plant.plantX.service;

import com.plant.plantX.model.PlantResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PlantService {
    public PlantResponse identifyPlant() {

        return new PlantResponse(
                "Aloe Vera",
                "Aloe barbadensis",
                "Aloe Vera is a medicinal plant known for skin healing properties.",
                Arrays.asList(
                        "Skin treatment",
                        "Burn healing",
                        "Hair care"
                ),
                0.92
        );
    }
}


//https://yflix.to/watch/jolly-llb-3.erped#ep=1