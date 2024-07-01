package com.example.demo.Controllers;

import com.example.demo.Services.ComplexViewService;
import com.example.demo.dto.ComplexViewInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ComplexViewController {
    @Autowired
    private ComplexViewService ptService;

    // маппинг станицы со смешанной таблицей
    @RequestMapping("/complex_view")
    public String showProjects(Model model, @Param("keyword") String keyword) {
        List<ComplexViewInt> listComplexView = ptService.ptListAll(keyword);
        model.addAttribute("listComplexView", listComplexView);
        model.addAttribute("keyword", keyword);
        return "view/complex_view";
    }
}
