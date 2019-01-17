package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.constants.CourseAttribute;
import com.example.preAcademicInfo.constants.StudentAttribute;
import com.example.preAcademicInfo.model.Student;
import com.example.preAcademicInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/addStudent")
    public String addStudent(Model model){

        addToModel(model, new Student());
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, HttpServletRequest request, Model model, Errors errors){

        studentService.saveStudent(student, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", errors);
            addToModel(model,student);
            return "/addStudent";
        }


        return "redirect:/home";
    }

    private void addToModel(Model model, Student student){
        model.addAttribute("model","student");
        model.addAttribute("student", student);
        model.addAttribute("attributes", StudentAttribute.values);
    }
}
