package com.itacademy.web.controller;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.service.dto.CarDto;
import com.itacademy.service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Objects;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.CAR;
import static com.itacademy.web.urlpath.UrlPath.EDIT_CAR;
import static com.itacademy.web.urlpath.UrlPath.LEASE;
import static com.itacademy.web.urlpath.UrlPath.SAVE_CAR;
import static com.itacademy.web.urlpath.UrlPath.SEARCH;

@Controller
@RequestMapping(API + CAR)
@SessionAttributes({"currentCar", "carVersion"})
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public String getCar(Model model, Integer nextPage) {
        if (nextPage == null) {
            nextPage = 0;
        }
        Page<Car> all = carService.getAll(nextPage);

        if (all.hasPrevious()) {
            model.addAttribute("previousPage", all.previousPageable().getPageNumber());
        }

        if (all.hasNext()) {
            model.addAttribute("nextPage", all.nextPageable().getPageNumber());
        }
        model.addAttribute("cars", all);
        return "car";
    }

    @PostMapping
    public String getCarByPost(Model model) {
        model.addAttribute("cars", carService.getAll());

        return "car";
    }

    @PostMapping(EDIT_CAR)
    public String editCar(Model model, Integer carId) {
        Car carById = carService.getCarById(carId);
        model.addAttribute("currentCar", carById);
        model.addAttribute("carVersion", carById.getVersion());

        return "editCar";
    }

    @PostMapping(SAVE_CAR)
    public String saveCar(Model model, @ModelAttribute("carVersion") Long version, @ModelAttribute("currentCar") Car car, CarDto dto) {
        car.setVersion(version);
        model.addAttribute("currentCar", carService.mapDtoToCar(dto, car));

        return "editCar";
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
