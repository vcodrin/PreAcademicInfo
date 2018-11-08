package com.example.preAcademicInfo.controllers;

import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model){
        model.put("user",new User());
        model.put("items", new ArrayList<String>(Arrays.asList("ceva","alteceva","...")));
        return "loginPage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("user") User user, HttpServletRequest request, Errors errors, BindingResult bindingResult, Map<String, Object> model){

//        String username = request.getParameter("username");
//        String parola = request.getParameter("parola");
//        System.out.println(username + " " + parola);
        if (bindingResult.hasErrors()){
            model.put("errors",errors);
            model.put("user", new User());
            return "redirect:/login";
        }
        System.out.println(user);
        return "loginPage";
    }
}
