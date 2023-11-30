package com.zelda.zeldaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class ZeldaApiList {

    private Boolean success;
    private Integer count;
    private List<DadosGamesZeldaDTO> data;

}