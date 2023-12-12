package com.github.api_projeto_final.zelda_service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ZeldaApiList {
    private Boolean success;
    private Integer count;
    private DataGamesZelda data;
}