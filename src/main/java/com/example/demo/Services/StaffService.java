package com.example.demo.Services;

import com.example.demo.Entities.Staff;
import com.example.demo.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// сервис для уравления таблицей сотрудник с помощью методов репозитория
@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepo;

    public List<Staff> staffListAll(String keyword) {
        if (keyword != null) {
            return staffRepo.search(keyword);
        }
        return staffRepo.findAll();
    }

    public void staffSave(Staff staff) {
        staffRepo.save(staff);
    }
    public Staff staffGet(Long id) {
        return staffRepo.findById(id).get();
    }
    public void staffDelete(Long id) {
        staffRepo.deleteById(id);
    }
}