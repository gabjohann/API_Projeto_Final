package com.github.api_projeto_final.zelda_service.model;

import lombok.Data;

import java.util.List;

@Data
public class ZeldaApiList {

    private Boolean success;
    private Integer count;
    private List<DataGamesZelda> data;

}