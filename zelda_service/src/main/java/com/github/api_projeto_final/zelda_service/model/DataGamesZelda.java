package com.github.api_projeto_final.zelda_service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DataGamesZelda {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;
}