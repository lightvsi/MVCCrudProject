package ru.lightvsi.springmvcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.lightvsi.springmvcapp.service.OrderDetailsService;

@SpringBootApplication
@EnableJpaRepositories
public class SpringMVCApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringMVCApp.class);
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringMVCApp.class, args);
    }

}
