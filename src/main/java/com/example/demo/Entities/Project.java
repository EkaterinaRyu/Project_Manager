package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

// сущность таблицы проект
@Table(name = "project")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String project_name;
    private String goal;
    private String field;
    private float budget;

    @OneToMany(targetEntity = Task.class)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    private List<Task> tasks;
}
