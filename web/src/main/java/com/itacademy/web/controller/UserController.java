package com.itacademy.web.controller;

import com.itacademy.database.entity.User;
import com.itacademy.service.dto.UserDto;
import com.itacademy.service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.EDIT_PROFILE;
import static com.itacademy.web.urlpath.UrlPath.PROFILE;
import static com.itacademy.web.urlpath.UrlPath.SAVE_PROFILE;
import static com.itacademy.web.urlpath.UrlPath.USER;

@Controller
@RequestMapping(API)
@SessionAttributes({"currentUser"})
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping(USER)
    public String getPage(Model model) {
        model.addAttribute("users", userService.getAll());

        return "user";
    }

    @GetMapping(PROFILE)
    public String getProfile(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("currentUser", user);

        return "profile";
    }


    @GetMapping(EDIT_PROFILE)
    public String editProfile(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("currentUser", user);

        return "editProfile";
    }

    @PostMapping(SAVE_PROFILE)
    public String saveProfile(Model model, @ModelAttribute("currentUser") User user, UserDto userDto, PasswordEncoder passwordEncoder) {
        if(!userDto.getPassword().equals("")) {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        model.addAttribute("currentUser", userService.updateUser(user, userDto));

        return "editProfile";
    }
}
