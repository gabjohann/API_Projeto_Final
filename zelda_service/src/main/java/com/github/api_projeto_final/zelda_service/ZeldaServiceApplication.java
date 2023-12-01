package com.github.api_projeto_final.zelda_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.api_projeto_final.zelda_service", "com.github.api_projeto_final.zelda_service.controller"})
public class ZeldaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeldaServiceApplication.class, args);
	}

}
