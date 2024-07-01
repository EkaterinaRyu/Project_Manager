package com.example.demo.Config;

import org.springframework.context.annotation.Configuration; // Конфигурационный класс обьединяет все классы в одно springboot-приложение
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // Помогает в управлении основным контроллерами
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Позволяет настраивать конфигурациионный класс с целью управления контроллерами

// данный интерфейс позволяет настроить пакеты, по которым следует искать контроллеры,
// а также включить или выключить различные фильтры, интерсепторы и конвертеры ввода/вывода.
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // метод позволяет настроить представления, которые вернутся из вызова методов контроллеров.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

}
