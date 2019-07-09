package com.itacademy.web.controller;

import com.itacademy.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.WELCOME;

@Controller
@RequestMapping(API+WELCOME)
@SessionAttributes({"currentUser"})
@RequiredArgsConstructor
public class WelcomeController {

    private final UserService userService;

    @GetMapping
    public String getPage(Model model, SecurityContextHolder securityContextHolder) {
        String userName;
        Object principal = securityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
            System.out.println("user name: " + userName);
        } else {
            userName = principal.toString();
        }
        model.addAttribute("currentUser", userService.findByLogin(userName));
        return "welcome";
    }

    @PostMapping
    public String getPage2() {
        return "welcome";
    }
}
