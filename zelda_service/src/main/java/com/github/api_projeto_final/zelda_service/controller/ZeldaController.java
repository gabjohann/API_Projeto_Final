package com.github.api_projeto_final.zelda_service.controller;

import com.github.api_projeto_final.zelda_service.service.ZeldaService;
import com.github.api_projeto_final.zelda_service.model.ZeldaApi;
import com.github.api_projeto_final.zelda_service.model.ZeldaApiList;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class ZeldaController {

    @Autowired
    ZeldaService zeldaService;
    @GetMapping("/games")
    public Flux<ZeldaApi> getAllGames(){
        return zeldaService.getGames();
    }

    @GetMapping("/games/{id}")
    public Mono<ZeldaApiList> getGameById(@PathVariable String id){
        return zeldaService.getGameByID(id);
    }
}