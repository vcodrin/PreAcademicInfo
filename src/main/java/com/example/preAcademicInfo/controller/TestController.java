package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.constants.Profile;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    private final Environment env;

    @Autowired
    public TestController(UserRepository userRepository, PasswordEncoder encoder, Environment env) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.env = env;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index(Model model){
        User user = new User("admin",encoder.encode("admin"),"mail@mail.com", Profile.ADMIN.getName());
        userRepository.save(user);
        return "test";
    }
}
