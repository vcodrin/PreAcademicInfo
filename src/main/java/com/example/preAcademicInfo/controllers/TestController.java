package com.example.preAcademicInfo.controllers;

import com.example.preAcademicInfo.model.Profile;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {"/","/test"}, method = RequestMethod.GET)
    public String index(){
//        User user = new User("admin","admin","mail@mail.com", Profile.ADMIN);
//        userRepository.save(user);

        return "test";
    }
}
