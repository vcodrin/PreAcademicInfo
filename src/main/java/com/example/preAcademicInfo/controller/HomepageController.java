package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.data.Function;
import com.example.preAcademicInfo.data.FunctionsSingletone;
import com.example.preAcademicInfo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomepageController {


    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){

        String profile = (String) request.getSession().getAttribute("role");
        model.addAttribute("functions", userFunctions(profile));


        return "home";
    }

    private List<Function> userFunctions(String profile) {
        Profile p = Profile.valueOf(profile, Profile.values);
        if (p == null){
            return new ArrayList<>();
        }
        ArrayList<Function> functions = new ArrayList<>();
        for (Function function : FunctionsSingletone.getInstance().getFunctions()){
            if (function.getProfile().equals(p.getName())){
                functions.add(function);
            }
        }
        return functions;
    }

}
