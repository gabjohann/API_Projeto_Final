package com.github.api_projeto_final.user_service.repository;

import com.github.api_projeto_final.user_service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByIdAndNameAndAge(Long id, String name, int age);
}
