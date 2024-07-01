package com.example.demo.Services;

import com.example.demo.Entities.Task;
import com.example.demo.Repositories.TaskRepository;
import com.example.demo.dto.TaskStaff;
import com.example.demo.dto.TaskStaffInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// сервис для уравления таблицей задача с помощью методов репозитория
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public List<TaskStaffInt> taskListAll(String keyword) {
        if (keyword != null) {
            return taskRepo.searchTaskStaff(keyword);
        }
        return taskRepo.findAllTaskStaff();
    }
    public void taskSave(Task task) {
        taskRepo.save(task);
    }
    public Task taskGet(Long id) {
        return taskRepo.findById(id).get();
    }
    public void taskDelete(Long id) {
        taskRepo.deleteById(id);
    }
}
