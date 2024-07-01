package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// класс-конструктор для доступа к таблице задач
@Data
@ToString
public class TaskStaff {
    private Long id;
    private String task_name;
    private String notes;
    private String deadline;
    private Long project_id;
    private Long staff_id;
    private String staff_name;

    public TaskStaff(Long id, String task_name, String notes, String deadline, Long project_id, Long staff_id, String staff_name) {
        this.id = id;
        this.task_name = task_name;
        this.notes = notes;
        this.deadline = deadline;
        this.project_id = project_id;
        this.staff_id = staff_id;
        this.staff_name = staff_name;
    }
}
