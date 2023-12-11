package com.github.api_projeto_final.zelda_service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.api_projeto_final.zelda_service.dtos.zeldaDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DataGamesZelda {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;

    public String getId() {
        return id;
    }

    public DataGamesZelda(zeldaDTO data){
        this.name = data.name();
        this.description = data.description();
        this.developer = data.developer();
        this.publisher = data.publisher();
        this.released_date = data.released_date();
        this.id = data.id();
    }
}