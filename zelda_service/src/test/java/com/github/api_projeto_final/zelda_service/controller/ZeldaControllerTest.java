package com.github.api_projeto_final.zelda_service.controller;

import com.github.api_projeto_final.zelda_service.dtos.zeldaDTO;
import com.github.api_projeto_final.zelda_service.model.DataGamesZelda;
import com.github.api_projeto_final.zelda_service.model.ZeldaApi;
import com.github.api_projeto_final.zelda_service.model.ZeldaApiList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class ZeldaControllerTest {
    @Autowired
    TestEntityManager entityManager;
    @Mock
    ZeldaController controller;
    @Mock
    WebClient webClient;
    @Mock
    DataGamesZelda dataGamesZelda;
    zeldaDTO zeldaDTO;

    @Test
    void getAllGamesSuccess() {
        String id1 = "1";
        zeldaDTO data1 = new zeldaDTO("Nome1", "Descrição1", "Desenvolvedor1", "Publisher1", "00/00/00", id1);
        this.createGame(data1);

        String id2 = "2";
        zeldaDTO data2 = new zeldaDTO("Nome2", "Descrição2", "Desenvolvedor2", "Publisher2", "00/00/00", id2);
        this.createGame(data2);

        Flux<ZeldaApi> result = this.controller.getAllGames();

        assertNotNull(result);
    }

    @Test
    void getAllGamesError() {
        String id3 = "3";
        zeldaDTO data3 = new zeldaDTO("Nome3", "Descrição3", "Desenvolvedor3", "Publisher3", "00/00/00", id3);
        this.createGame(data3);

        String id4 = "4";
        zeldaDTO data4 = new zeldaDTO("Nome4", "Descrição4", "Desenvolvedor4", "Publisher4", "00/00/00", id4);
        this.createGame(data4);

        Flux<ZeldaApi> result = this.controller.getAllGames();

        assertNotNull(result);
    }

    @Test
    void getGameByIdSuccess() {
        String id = "1";
        zeldaDTO data = new zeldaDTO("Nome1", "Descrição1", "Desenvolvedor1", "Publisher1", "00/00/00", id);
        this.createGame(data);

        Mono<ZeldaApiList> result = this.controller.getGameById(id);

        assertNotNull(result);
    }

    @Test
    void getGameByIdError() {
        String id = "2";

        Mono<ZeldaApiList> result = this.controller.getGameById(id);

        assertNull(result);
    }

    @BeforeEach
    private void createGame(zeldaDTO data){
        DataGamesZelda newGame = new DataGamesZelda(data);
        this.entityManager.persist(newGame);
    }
}