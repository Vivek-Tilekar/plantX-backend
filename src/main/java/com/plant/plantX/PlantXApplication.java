package com.plant.plantX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlantXApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantXApplication.class, args);
	}

}
