package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

// сущность таблицы задача
@Table(name = "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task_name;
    private String notes;
    private String deadline;
    private Long project_id;
    private Long staff_id;

//    @ManyToOne
//    @JoinColumn(name="project_id")
//    private Project project;

    @OneToOne(targetEntity = Staff.class)
    @JoinColumn(name="id", referencedColumnName = "staff_id")
    private Staff staff;
}
