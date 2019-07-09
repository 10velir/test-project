package com.itacademy.web.controller;

import com.itacademy.service.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.urlpath.UrlPath.PASSPORT;

@Controller
@RequestMapping(PASSPORT)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PassportController {

    private final PassportService passportService;

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("passports", passportService.getAll());

        return "passport";
    }
}
