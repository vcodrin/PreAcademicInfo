package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.constants.Constants;
import com.example.preAcademicInfo.constants.StudentAttribute;
import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.model.Student;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.service.CourseService;
import com.example.preAcademicInfo.service.StudentService;
import com.example.preAcademicInfo.service.UserService;
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
import java.util.List;

@Controller
public class StudentController {

    private final UserService userService;
    private final StudentService studentService;
    private final CourseService courseService;


    @Autowired
    public StudentController(UserService userService, StudentService studentService, CourseService courseService) {
        this.userService = userService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping(value = "/addStudent")
    public String addStudent(Model model) {

        addToModel(model, new Student());
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, HttpServletRequest request, Model model, Errors errors) {

        studentService.saveStudent(student, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", errors);
            addToModel(model, student);
            return "/addStudent";
        }


        return "redirect:/home";
    }

    @GetMapping(value = "/myCourses")
    public String myCourses(Model model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute(Constants.USERNAME);
        String role = (String) request.getSession().getAttribute(Constants.ROLE);
        User user = userService.findLoggedUser(username, role);
        if (user == null) {
            return "redirect:/home";
        }
        model.addAttribute("courses", user.getStudent().getCourses());
        return "myCourser";
    }

    private void addToModel(Model model, Student student) {
        model.addAttribute("model", "student");
        model.addAttribute("student", student);
        model.addAttribute("attributes", StudentAttribute.values);
    }
}
