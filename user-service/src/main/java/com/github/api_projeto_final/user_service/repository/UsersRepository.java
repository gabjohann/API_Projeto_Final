package com.github.api_projeto_final.user_service.repository;

import com.github.api_projeto_final.user_service.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByIdAndNameAndAge(Long id_user, String name, int age);

    Optional<UserModel> findByName(String name);
}
