package com.itacademy.web.controller;

import com.itacademy.database.entity.User;
import com.itacademy.service.dto.LoginDto;
import com.itacademy.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.REGISTRATION;

@Controller
@RequestMapping(API + REGISTRATION)
@SessionAttributes({"currentUser"})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping
    public String registration(Model model, LoginDto dto) {
        if (!dto.getUsername().equals("") && !dto.getPassword().equals("")) {
            if (userService.getByLogin(dto.getUsername()).isPresent()) {
                return "login";
            } else {
                model.addAttribute("currentUser", userService.register(
                        User.builder()
                                .login(dto.getUsername())
                                .password(encoder.encode(dto.getPassword()))
                                .build()
                ));
                return "welcome";
            }
        } else return "registration";
    }
}
