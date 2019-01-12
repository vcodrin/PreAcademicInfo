package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import com.example.preAcademicInfo.service.UserService;
import com.example.preAcademicInfo.utils.EnvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;


    private final EnvUtil env;

    @Autowired
    public UserController(UserService userService, EnvUtil env) {
        this.userService = userService;
        this.env = env;
    }

    @GetMapping(value = {"/", "/login"})
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("action", "/login");
        model.addAttribute("forgotPassword", "/forgotPassword");
        return "login";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "/addUser";
        }

        userService.save(user, new ArrayList<>());
        return "test";

    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {

        System.out.println(user);
        ValidationError error = userService.verifyLogin(user);
        if (!error.isEmpty()) {
            model.addAttribute("error", error);
            model.addAttribute("forgotPassword", "/forgotPassword");
            return "login";
        }
        request.setAttribute("username",user.getUsername());
        request.setAttribute("role", user.getProfile());
        return "test";
    }

    @GetMapping(value = "/forgotPassword")
    public String forgotPassword(Model model){
        return "forgotPassword";
    }

    @PostMapping(value = "/forgotPassword")
    public String forgotPassword(Model model, HttpServletRequest request){

        String email = (String) request.getAttribute("email");
        String nrMatricol = (String) request.getAttribute("nrMatricol");
        String newPassword = (String) request.getAttribute("newPassword");
        List<Error> errors = new ArrayList<>();
        userService.createPasswordChangeRequest(email, nrMatricol, newPassword, errors);
        if (errors.isEmpty()){
            return "successPasswordChange";
        }
        return "forgotPassword";
    }
}
