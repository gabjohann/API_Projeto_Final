package com.github.api_projeto_final.user_service.service;

import com.github.api_projeto_final.user_service.dto.UserDTO;
import com.github.api_projeto_final.user_service.handler.GenericError;
import com.github.api_projeto_final.user_service.model.UserModel;
import com.github.api_projeto_final.user_service.repository.UsersRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;


    public UserModel addUser(@RequestBody @Valid UserDTO userDTO) {
        if (usersRepository.findByName(userDTO.getName()).isPresent()) {
            throw new GenericError("Usuário já cadastrado!");
        }

        UserModel newUser = new UserModel(userDTO.getName(), userDTO.getAge());

        return usersRepository.save(newUser);
    }

    public UserModel findUser(Long id_user, String name) {
        if (id_user != null) {
            return usersRepository.findById(id_user).orElseThrow(() -> new GenericError("Não foram encontrados registros para o ID: " + id_user));
        }

        if (name != null) {
            return usersRepository.findByName(name).orElseThrow(() -> new GenericError("Não foram encontrados registros para o nome: " + name));
        }

        throw new GenericError("Usuário não encontrado!");
    }

    public List<UserModel> findAllUsers() {
        return usersRepository.findAll();
    }

    public UserModel updateUser(Long id_user, String name, Integer age) {
     UserModel userModel = usersRepository.findById(id_user).orElseThrow(() -> new GenericError("Usuário de ID: " + id_user + " não encontrado"));

     if(name != null) {
         userModel.setName(name);
     }

     if (age != null) {
         userModel.setAge(age);
     }

     return usersRepository.save(userModel);
    }

    public void deleteUser(Long id_user) {
        usersRepository.deleteById(id_user);
    }
}
