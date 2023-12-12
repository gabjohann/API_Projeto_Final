package com.github.api_projeto_final.user_service.controller;

import com.github.api_projeto_final.user_service.model.UserModel;
import com.github.api_projeto_final.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService ;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/find")
    public ResponseEntity<UserModel> searchUser(
            @RequestParam(required = false) Long id_user,
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(userService.findUser(id_user, name));
    }

}
