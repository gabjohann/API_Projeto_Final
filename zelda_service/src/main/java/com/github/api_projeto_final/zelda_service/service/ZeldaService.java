package com.github.api_projeto_final.zelda_service.service;

import com.github.api_projeto_final.zelda_service.model.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ZeldaService {
    private final WebClient webClient;
    public ZeldaService(WebClient.Builder builder){
        webClient = builder.baseUrl("https://zelda.fanapis.com/api/games").build();
    }

    public Flux<ZeldaApi> getGames(){
        log.info("Buscando Jogos");
        return webClient
                .get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,error -> Mono.error(new RuntimeException("Verifique os parâmetros informados!")))
                .bodyToFlux(ZeldaApi.class)
                ;
    }

    public Mono<ZeldaApiList> getGameByID(String id){
        log.info("Buscando jogo pelo!");
        return webClient
                .get()
                .uri("/{game_id}", id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,error -> Mono.error(new RuntimeException("Verifique os parâmetros informados!")))
                .bodyToMono(ZeldaApiList.class)
                ;
    }



}

//   private static final String apiGame = "https://zelda.fanapis.com/api/games";
// private static final String apiGameID = "https://zelda.fanapis.com/api/games/:game_ID";