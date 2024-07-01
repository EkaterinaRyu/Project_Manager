package com.example.demo.Repositories;

import com.example.demo.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// репозиторий таблицы сотрудник
public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Query("SELECT s FROM Staff s WHERE " +
            "CONCAT(s.id, ' ', s.first_name, ' ', s.last_name, ' ', s.occupation, ' ', s.birthdate, ' ', s.info) LIKE %?1%")
    List<Staff> search(String keyword);
}