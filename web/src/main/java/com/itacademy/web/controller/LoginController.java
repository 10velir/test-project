package com.itacademy.web.controller;

import com.itacademy.database.entity.User;
import com.itacademy.service.config.ServiceConfig;
import com.itacademy.service.service.UserService;
import com.itacademy.web.dto.LoginDto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.LOGIN;

@Controller
@RequestMapping(API + LOGIN)
@SessionAttributes({"currentUser"})
public class LoginController {

    @GetMapping
    public String getPage() {
        return "login";
    }

    @PostMapping()
    public String save(Model model, LoginDto loginDto) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login(loginDto.getUsername(), loginDto.getPassword());
        model.addAttribute("currentUser", user);

        return "welcome";
    }
}
