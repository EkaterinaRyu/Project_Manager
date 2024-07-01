package com.example.demo.Services;

import com.example.demo.Entities.Project;
import com.example.demo.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// сервис для уравления таблицей проект с помощью методов репозитория
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository proRepo;

    public List<Project> proListAll(String keyword) {
        if (keyword != null) {
            return proRepo.search(keyword);
        }
        return proRepo.findAll();
    }

    public void proSave(Project project) {
        proRepo.save(project);
    }
    public Project proGet(Long id) {
        return proRepo.findById(id).get();
    }
    public void proDelete(Long id) {
        proRepo.deleteById(id);
    }
}
