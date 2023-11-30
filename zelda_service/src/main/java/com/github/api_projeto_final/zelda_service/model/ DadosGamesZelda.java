package com.zelda.zeldaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DadosGamesZelda {

    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;

}

/* Formato Json que vem da Query api zelda
            "name": "The Legend of Zelda",
            "description": "The Legend of Zelda is the first installment of the Zelda series. It centers its plot around a boy named Link, who becomes the central protagonist throughout the series. It came out as early as 1986 for the Famicom in Japan, and was later released in the western world, including Europe and the US in 1987. It has since then been re-released several times, for the Nintendo GameCube as well as the Game Boy Advance. The Japanese version of the game on the Famicom is known as The Hyrule Fantasy: The Legend of Zelda. ",
            "developer": "Nintendo R&D 4",
            "publisher": "Nintendo",
            "released_date": " February 21, 1986",
            "id": "5f6ce9d805615a85623ec2b7"
*/