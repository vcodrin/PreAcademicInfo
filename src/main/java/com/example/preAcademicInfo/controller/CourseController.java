package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.bases.Record;
import com.example.preAcademicInfo.constants.CourseAttribute;
import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.service.CourseService;
import com.example.preAcademicInfo.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public void addAttrituesToModel(Model model) {
        model.addAttribute("modelAttribute", "course");
        model.addAttribute("course", new Course());
        model.addAttribute("action", "/addCourse");
        model.addAttribute("inputAttributes", CourseAttribute.values);
    }

    @GetMapping(value = "/addCourse")
    public String addCourse(Model model) {
        addAttrituesToModel(model);
        return "addCourse";
    }

    @PostMapping(value = "/addCourse")
    public String addCourse(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult, Model model, HttpServletRequest request) {


        Map<String,String[]> values = RequestUtils.getParametersValues(CourseAttribute.checkboxes,request);

        List<ValidationError> errors = new ArrayList<>();
        courseService.createCourse(course, values, errors);
        if (bindingResult.hasErrors()) {
            addAttrituesToModel(model);
            return "addCourse";
        }
        return "addCourse";
    }
}
