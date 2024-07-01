package com.example.demo.Controllers;

import com.example.demo.Entities.Project;
import com.example.demo.Services.ProjectService;
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
public class ProjectController {
    @Autowired
    private ProjectService proService;

    // маппинг страницы проектов
    @RequestMapping("/")
    public String showProjects(Model model, @Param("keyword") String keyword) {
        List<Project> listProject = proService.proListAll(keyword);
        model.addAttribute("listProject", listProject);
        model.addAttribute("keyword", keyword);
        return "view/project_table";
    }
    // создание нового проекта
    @RequestMapping("/new")
    public String newProject(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "new_object/new_project";
    }
    // сохранение записи в таблице проекты
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("project") Project project) {
        proService.proSave(project);
        return "redirect:/";
    }
    // редактирование записи по id
    @RequestMapping("/edit/{id}")
    public ModelAndView editProject(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_object/edit_project");
        Project project = proService.proGet(id);
        mav.addObject("project", project);
        return mav;
    }
    // удаление записи по id
    @RequestMapping("/delete/{id}")
    public String deleteProject(@PathVariable(name="id") Long id) {
        proService.proDelete(id);
        return "redirect:/";
    }
}
