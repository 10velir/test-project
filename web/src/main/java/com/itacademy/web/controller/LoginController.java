package com.itacademy.web.controller;

import com.itacademy.service.dto.LoginDto;
import com.itacademy.service.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping
    public String getPage() {
        return "login";
    }

    @PostMapping()
    public String login(Model model, LoginDto loginDto) {
        model.addAttribute("currentUser", userService.getByLogin(loginDto.getUsername()));

        return userService.login(loginDto)
                .map(user -> "redirect:/api/profile")
                .orElse("login");
    }
}
