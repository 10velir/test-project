package com.itacademy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.HOME;

@Controller
@RequestMapping(API + HOME)
public class HomeController {

    @GetMapping()
    public String getPage() {
        return "home";
    }

    @PostMapping()
    public String getPageByPost() {
        return "home";
    }
}
