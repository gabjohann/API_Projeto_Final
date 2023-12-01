package com.github.api_projeto_final.zelda_service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ZeldaApi {
    private Boolean success;
    private List<DataGamesZelda> data;
}