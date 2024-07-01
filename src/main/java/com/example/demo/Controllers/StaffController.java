package com.example.demo.Controllers;

import com.example.demo.Entities.Staff;
import com.example.demo.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    // маппинг страницы сотрудников
    @RequestMapping("/staff")
    public String showStaff(Model model, @Param("keyword") String keyword) {
        List<Staff> listStaff = staffService.staffListAll(keyword);
        model.addAttribute("listStaff", listStaff);
        model.addAttribute("keyword", keyword);
        return "view/staff_table";
    }
    // создание новой записи о сотруднике
    @RequestMapping("/staff/new")
    public String newStaff(Model model) {
        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        return "new_object/new_staff";
    }
    // сохранеие записи о сотруднике
    @RequestMapping(value = "/staff/save", method = RequestMethod.POST)
    public String saveStaff(@ModelAttribute("staff") Staff staff) {
        staffService.staffSave(staff);
        return "redirect:/staff";
    }
    // редактирование записи по id
    @RequestMapping("/staff/edit/{id}")
    public ModelAndView editStaff(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_object/edit_staff");
        Staff staff = staffService.staffGet(id);
        mav.addObject("staff", staff);
        return mav;
    }
    // удаление записи по id
    @RequestMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable(name="id") Long id) {
        staffService.staffDelete(id);
        return "redirect:/staff";
    }
}