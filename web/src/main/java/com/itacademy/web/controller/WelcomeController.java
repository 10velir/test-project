package com.itacademy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.WELCOME;

@Controller
@RequestMapping(API+WELCOME)
public class WelcomeController {

    @GetMapping
    public String getPage() {
        return "welcome";
    }

    @PostMapping
    public String getPage2() {
        return "welcome";
    }
}
