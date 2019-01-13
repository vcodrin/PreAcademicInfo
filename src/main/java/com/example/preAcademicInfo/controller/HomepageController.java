package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.data.FunctionsSingletone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {


    @GetMapping("/home")
    public String home(){
        System.out.println(FunctionsSingletone.getInstance().getFunctions());
        return "home";
    }

}
