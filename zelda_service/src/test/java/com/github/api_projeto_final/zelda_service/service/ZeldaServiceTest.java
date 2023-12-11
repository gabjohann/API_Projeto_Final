package com.github.api_projeto_final.zelda_service.service;

import com.github.api_projeto_final.zelda_service.dtos.zeldaDTO;
import com.github.api_projeto_final.zelda_service.model.DataGamesZelda;
import com.github.api_projeto_final.zelda_service.model.ZeldaApi;
import com.github.api_projeto_final.zelda_service.model.ZeldaApiList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class ZeldaServiceTest {
    @Mock
    ZeldaService zeldaService;
    @Mock
    WebClient webClient;
    @Mock
    DataGamesZelda dataGamesZelda;
    zeldaDTO zeldaDTO;

    @Test
    void getGameByIdSuccess() {
        zeldaDTO = new zeldaDTO("Nome1", "Descrição1", "Desenvolvedor1", "Publisher1", "00/00/00", "1");

        Mono.when(zeldaService.getGameByID(dataGamesZelda.getId()).thenReturn(zeldaDTO));

        Mono<ZeldaApiList> jogo = zeldaService.getGameByID(dataGamesZelda.getId());

        assertEquals(Collections.singletonList(zeldaDTO), jogo);
        Mockito.verify(zeldaService).getGameByID(dataGamesZelda.getId());
        verifyNoMoreInteractions(zeldaService);
    }

    @Test
    void getGameByIdError() {
        Mono.when(zeldaService.getGameByID(dataGamesZelda.getId()).thenReturn(zeldaDTO == null));

        Mono<ZeldaApiList> jogo = zeldaService.getGameByID(dataGamesZelda.getId());

        assertNotEquals(Collections.singletonList(zeldaDTO), jogo);
        Mockito.verify(zeldaService).getGameByID(dataGamesZelda.getId());
        verifyNoMoreInteractions(zeldaService);
    }

    @Test
    void getAllGamesSuccess() {
        zeldaDTO = new zeldaDTO("Nome1", "Descrição1", "Desenvolvedor1", "Publisher1", "00/00/00", "1");

        Flux<ZeldaApi> jogosLista = this.zeldaService.getGames();

        assertNotNull(jogosLista);
    }

    @Test
    void getAllGamesError() {
        Flux<ZeldaApi> jogosLista = this.zeldaService.getGames();

        assertNull(jogosLista);
    }
}
