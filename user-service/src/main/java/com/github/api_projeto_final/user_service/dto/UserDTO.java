package com.github.api_projeto_final.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "O nome do usuário é obrigatório!")
    private String name;

    @NotEmpty(message = "A idade do usuário é obrigatória!")
    private int age;


    //O Lombok não estava ativando os Getter e Setter automaticamente. Criei esses de maneira temporária.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
