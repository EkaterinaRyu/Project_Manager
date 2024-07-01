package com.example.demo.Controllers;

import com.example.demo.Entities.Task;
import com.example.demo.Services.TaskService;
import com.example.demo.dto.TaskStaffInt;
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
public class TaskController {
    @Autowired
    private TaskService taskService;

    // маппинг страницы задачи
    @RequestMapping("/task")
    public String showTasks(Model model, @Param("keyword") String keyword) {
        List<TaskStaffInt> listTaskStaff = taskService.taskListAll(keyword);
        model.addAttribute("listTaskStaff", listTaskStaff);
        model.addAttribute("keyword", keyword);
        return "view/task_table";
    }
    // создание новой задачи
    @RequestMapping("/task/new")
    public String newTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "new_object/new_task";
    }
    // сохранение задачи в таблице
    @RequestMapping(value = "/task/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.taskSave(task);
        return "redirect:/task";
    }
    // редактирование задачи по id
    @RequestMapping("/task/edit/{id}")
    public ModelAndView editTask(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_object/edit_task");
        Task task = taskService.taskGet(id);
        mav.addObject("task", task);
        return mav;
    }
    // удаление задачи по id
    @RequestMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable(name="id") Long id) {
        taskService.taskDelete(id);
        return "redirect:/task";
    }
}
