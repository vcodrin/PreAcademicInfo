package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.constants.BracketAttribute;
import com.example.preAcademicInfo.model.Bracket;
import com.example.preAcademicInfo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/addGroup")
    public String addGroup(Model model){

        addToModel(model, new Bracket());
        return "addGroup";
    }

    @PostMapping(value = "/addGroup")
    public String addGroup(@Valid @ModelAttribute("bracket") Bracket bracket, BindingResult bindingResult, Model model, Errors errors){

        groupService.saveGroup(bracket, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", errors);
            addToModel(model,bracket);
            return "addGroup";
        }

        return "redirect:/home";
    }



    private void addToModel(Model model, Bracket bracket){
        model.addAttribute("model","bracket");
        model.addAttribute("bracket", bracket);
        model.addAttribute("attributes", BracketAttribute.values);
    }
}