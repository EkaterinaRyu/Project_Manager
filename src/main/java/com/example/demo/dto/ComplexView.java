package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;


// класс-конструктор смешанной таблицы
@Data
@ToString
public class ComplexView {
    private Long project_id;
    private String project_name;
    private Long task_id;
    private String task_name;
    private String notes;
    private String deadline;
    private Long staff_id;
    private String staff_name;

    public ComplexView(Long project_id, String project_name, Long task_id, String task_name, String notes,
                       String deadline, Long staff_id, String staff_name) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.task_id = task_id;
        this.task_name = task_name;
        this.notes = notes;
        this.deadline = deadline;
        this.staff_id = staff_id;
        this.staff_name = staff_name;
    }

}