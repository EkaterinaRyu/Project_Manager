package com.example.demo.Services;

import com.example.demo.Entities.Project;
import com.example.demo.Repositories.ProjectRepository;
import com.example.demo.dto.ComplexViewInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// сервис для уравления смешанной таблицей с помощью методов репозитория
@Service
public class ComplexViewService {
    @Autowired
    private ProjectRepository proRepo;

    public List<ComplexViewInt> ptListAll(String keyword) {
        if (keyword != null) {
            return proRepo.getTaskByProject(keyword);
        }
        return proRepo.findAllTasksByProject();
    }
    public Project proGet(Long id) {
        return proRepo.findById(id).get();
    }
}
