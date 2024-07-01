package com.example.demo.Repositories;

import com.example.demo.Entities.Task;
import com.example.demo.dto.TaskStaffInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// репозиторий таблицы задача
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t " +
            "WHERE CONCAT(t.id, ' ', t.task_name, ' ', t.notes, ' ', t.deadline, ' ', t.project_id, ' ', t.staff_id) LIKE %?1%")
    List<Task> search(String keyword);

    @Query("SELECT new com.example.demo.dto.TaskStaff(t.id, t.task_name, t.notes, t.deadline, t.project_id, t.staff_id, " +
            "CONCAT(s.first_name, ' ', s.last_name)) FROM Task t LEFT JOIN Staff s on t.staff_id = s.id " +
            "WHERE CONCAT(t.id, ' ', t.task_name, ' ', t.notes, ' ', t.deadline, ' ', t.project_id, ' ', " +
            "t.staff_id, ' ', s.first_name, s.last_name) LIKE %?1%")
    List<TaskStaffInt> searchTaskStaff(String keyword);

    @Query("SELECT new com.example.demo.dto.TaskStaff(t.id, t.task_name, t.notes, t.deadline, t.project_id, t.staff_id, " +
            "CONCAT(s.first_name, ' ', s.last_name)) FROM Task t LEFT JOIN Staff s on t.staff_id = s.id")
    List<TaskStaffInt> findAllTaskStaff();
}