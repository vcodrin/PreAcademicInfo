package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.constants.Profile;
import com.example.preAcademicInfo.model.Group;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import com.example.preAcademicInfo.service.UserService;
import com.example.preAcademicInfo.utils.EnvUtil;
import com.example.preAcademicInfo.utils.FormModelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final EnvUtil env;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, PasswordEncoder encoder, EnvUtil env) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.env = env;
    }

    @GetMapping(value = "/login")
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

        ValidationError error = new ValidationError();
        User userForLogin = userService.verifyLogin(user,error);
        if (userForLogin == null && error.isEmpty()){
            error = new ValidationError("user.notFound", env.getEnv());
        }
        if (!error.isEmpty()) {
            model.addAttribute("error", error);
            model.addAttribute("forgotPassword", "/forgotPassword");
            return "login";
        }
        request.getSession().setAttribute("username",user.getUsername());
        request.getSession().setAttribute("role", userForLogin.getProfile());
        return "redirect:/home";
    }

    @GetMapping(value = "/forgotPassword")
    public String forgotPassword(Model model){
        return "forgotPassword";
    }

    @PostMapping(value = "/forgotPassword")
    public String forgotPassword(HttpServletRequest request){

        String email = (String) request.getAttribute("email");
        String nrMatricol = (String) request.getAttribute("nrMatricol");
        String newPassword = (String) request.getAttribute("newPassword");
        List<Error> errors = new ArrayList<>();
        userService.createPasswordChangeRequest(email, nrMatricol, newPassword, errors);
        if (errors.isEmpty()){
            return "redirect:/login";
        }
        return "forgotPassword";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("role");
        request.getSession().removeAttribute("username");
        try {
            request.logout();
        } catch (ServletException e) {
//            e.printStackTrace();
        }
        return "redirect:/login";
    }
}
