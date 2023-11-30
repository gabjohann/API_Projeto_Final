package com.github.api_projeto_final.zelda_service.controller;


import com.github.api_projeto_final.zelda_service.model.*;
import com.github.api_projeto_final.zelda_service.service.ZeldaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/zelda")
@RequiredArgsConstructor
public class ZeldaController {

    private final ZeldaService zeldaService;

    @GetMapping("/{id}")
    public ResponseEntity<ZeldaApi> findByIdGames(@PathVariable String id) {
        return ResponseEntity.ok(zeldaService.findByIdGames(id));
    }

    @GetMapping("/")
    public ResponseEntity<ZeldaApiList> listGames() {
        return ResponseEntity.ok(zeldaService.listGames());
    }
}