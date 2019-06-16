package com.itacademy.web.controller;

import com.itacademy.database.repository.UserRepository;
import com.itacademy.service.config.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.USER;

@Controller
@RequestMapping(API)
public class UserController {

    @GetMapping(USER)
    public String getPage(Model model) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        model.addAttribute("users", context.getBean(UserRepository.class).findAll());

        return "user";
    }
}
