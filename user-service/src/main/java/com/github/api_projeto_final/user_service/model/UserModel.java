package com.github.api_projeto_final.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "zelda_database")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    @NotBlank
    private String name;
    @NotBlank
    private int age;

    //O Lombok não estava ativando os Getter e Setter automaticamente. Criei esses de maneira temporária.

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

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

    public UserModel(@NotBlank(message = "O nome do usuário é obrigatório!") String name, @NotEmpty(message = "A idade do usuário é obrigatória!") int age) {}
}