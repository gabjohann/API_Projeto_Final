package com.github.api_projeto_final.zelda_service.service;

import  com.github.api_projeto_final.zelda_service.model.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZeldaService {

    public ZeldaApi findByIdGames(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String URL = String.format("https://zelda.fanapis.com/api/games/%s", id);
        return restTemplate.getForEntity(URL, ZeldaApi.class).getBody();
    }

    public ZeldaApiList listGames() {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://zelda.fanapis.com/api/games";
        return restTemplate.getForEntity(URL, ZeldaApiList.class).getBody();
    }

}