package com.example.demo.dto;

// интерфейс для вывода данных в смешанную таблицу
public interface ComplexViewInt {
    Long getProject_id();
    String getProject_name();
    String getTask_name();
    String getNotes();
    String getDeadline();
    Long getTask_id();
    Long getStaff_id();
    String getStaff_name();
}
