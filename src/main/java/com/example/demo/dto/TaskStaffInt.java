package com.example.demo.dto;

// интерфейс для вывода данных из таблицы задач в шаблон
public interface TaskStaffInt {
    Long getId();
    String getTask_name();
    String getNotes();
    String getDeadline();
    Long getProject_id();
    Long getStaff_id();
    String getStaff_name();
}
