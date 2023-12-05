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
}
