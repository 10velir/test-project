package com.itacademy.web.controller;

import com.itacademy.service.config.ServiceConfig;
import com.itacademy.service.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.CAR;

@Controller
@RequestMapping(API)
public class CarController {

    @GetMapping(CAR)
    public String getCar(Model model) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        model.addAttribute("cars", context.getBean(CarService.class).getAll());

        return "car";
    }
}
