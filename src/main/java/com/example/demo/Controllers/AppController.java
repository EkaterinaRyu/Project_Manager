package com.example.demo.Controllers;

import org.springframework.stereotype.Controller; // Задаем класс в качестве контроллера в рамках концепции MVC
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    // маппинг страницы об авторе
    @RequestMapping("/author")
    public String showAuthor(){
        return "view/author";
    }
}

