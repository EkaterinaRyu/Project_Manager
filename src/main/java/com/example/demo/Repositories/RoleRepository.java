package com.example.demo.Repositories;

import com.example.demo.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий таблицы роль
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
