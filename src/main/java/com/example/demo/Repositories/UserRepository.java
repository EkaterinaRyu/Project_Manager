package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий таблицы пользователь
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
