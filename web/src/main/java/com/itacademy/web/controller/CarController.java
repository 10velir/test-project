package com.itacademy.web.controller;

import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.CAR;
import static com.itacademy.web.urlpath.UrlPath.LEASE;
import static com.itacademy.web.urlpath.UrlPath.SEARCH;

@Controller
@RequestMapping(API + CAR)
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public String getCar(Model model) {
        model.addAttribute("cars", carService.getAll());

        return "car";
    }

    @PostMapping
    public String getCarByPost(Model model) {
        model.addAttribute("cars", carService.getAll());

        return "car";
    }

    @PostMapping(SEARCH)
    public String getCarsWithFilter(Model model, CarSearchFilter searchFilter) {
        model.addAttribute("cars", carService.getWithFilters(searchFilter));

        return "car";
    }

    @PostMapping(LEASE)
    public String lease(Model model, Integer carId) {
        model.addAttribute("currentCar", carService.getCarById(carId));

        return "lease";
    }
}
