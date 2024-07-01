package com.example.demo.Repositories;

import com.example.demo.Entities.Project;
import com.example.demo.dto.ComplexViewInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// репозиторий таблицы проект и смешанной таблицы
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p WHERE CONCAT(p.id, ' ', p.project_name, ' ', p.goal, ' ', p.field, ' ', p.budget) LIKE %?1%")
    List<Project> search(String keyword);

    @Query("SELECT new com.example.demo.dto.ComplexView(p.id, p.project_name, t.id, t.task_name, t.notes, t.deadline, " +
            "s.id, CONCAT(s.first_name, ' ', s.last_name)) FROM Project p JOIN p.tasks t JOIN Staff s on t.staff_id = s.id " +
            "WHERE CONCAT(p.id, ' ', p.project_name, ' ', t.id, ' ', t.task_name, ' ', t.notes, ' ', t.deadline, ' ', s.id, " +
            "' ', s.last_name, ' ', s.first_name) LIKE %?1%")
    List<ComplexViewInt> getTaskByProject(String keyword);
//    @Query("SELECT new com.example.demo.dto.ProjectTask(p.project_id, p.project_name, t.task_name, t.notes, t.deadline) " +
//            "FROM Project p JOIN p.tasks t WHERE CONCAT(p.project_id, ' ', p.project_name, ' ', t.task_name, ' ', t.notes, ' ', t.deadline) LIKE %?1%")
//    List<ProjectTaskInt> getTaskByProject(String keyword);

    @Query("SELECT new com.example.demo.dto.ComplexView(p.id, p.project_name, t.id, t.task_name, t.notes, t.deadline, s.id, " +
            "CONCAT(s.first_name, ' ', s.last_name)) FROM Project p JOIN p.tasks t LEFT JOIN Staff s on t.staff_id = s.id")
    List<ComplexViewInt> findAllTasksByProject();
//    @Query("SELECT new com.example.demo.dto.ProjectTask(p.project_id, p.project_name, t.task_name, t.notes, t.deadline) " +
//            "FROM Project p JOIN p.tasks t")
//    List<ProjectTaskInt> findAllTasksByProject();
}
