package com.github.api_projeto_final.zelda_service.controller;

import com.github.api_projeto_final.zelda_service.dtos.zeldaDTO;
import com.github.api_projeto_final.zelda_service.model.DataGamesZelda;
import com.github.api_projeto_final.zelda_service.model.ZeldaApi;
import com.github.api_projeto_final.zelda_service.model.ZeldaApiList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.swing.text.html.parser.Entity;
import javax.xml.crypto.Data;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ZeldaControllerTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    ZeldaController zeldaController;

    @Test
    void getAllGames() {
    }

    @Test
    void getGameByIdSuccess() {
        String id = "";
        zeldaDTO data = new zeldaDTO("Nome1", "Descrição1", "Desenvolvedor1", "Publisher1", "00/00/00", id);
        this.createGame(data);

        Mono<ZeldaApiList> result = this.zeldaController.getGameById(id);

/*        assertThat(result.isPresent()).isTrue();*/
    }

    @Test
    void getGameByIdError() {
    }

    private DataGamesZelda createGame(zeldaDTO data){
        DataGamesZelda newGame = new DataGamesZelda(data);
        this.entityManager.persist(newGame);
        return newGame;
    }
}