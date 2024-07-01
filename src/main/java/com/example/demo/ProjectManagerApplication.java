package com.example.demo;

import org.springframework.boot.SpringApplication; // Класс, предоставляющий возможность запуска Spring приложения
import org.springframework.boot.autoconfigure.SpringBootApplication; // Определяем класс в качестве запускающего объекта, осуществляющего сканирование по всем зависимостям
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer; // Предоставляет функционал для запуска Spring приложения в формате WAR (Web Archive)
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ProjectManagerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }

}


