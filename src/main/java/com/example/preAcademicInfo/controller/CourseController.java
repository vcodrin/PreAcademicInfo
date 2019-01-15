package com.example.preAcademicInfo.controller;

import com.example.preAcademicInfo.bases.Record;
import com.example.preAcademicInfo.constants.CourseAttribute;
import com.example.preAcademicInfo.data.FunctionsSingletone;
import com.example.preAcademicInfo.dto.CourseDTO;
import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.model.laboratory.Laboratory;
import com.example.preAcademicInfo.model.lecture.Lecture;
import com.example.preAcademicInfo.model.seminar.Seminar;
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

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    private void addAttributesToModel(Model model) {
        model.addAttribute("modelAttribute", "courseDTO");
        model.addAttribute("courseDTO", new CourseDTO());
        model.addAttribute("action", "/addCourse");
        model.addAttribute("inputAttributes", CourseAttribute.values);
        model.addAttribute("common", CourseAttribute.common);
        model.addAttribute("laboratory",new Laboratory());
        model.addAttribute("lecture",new Lecture());
        model.addAttribute("seminar",new Seminar());
    }

    @GetMapping(value = "/addCourse")
    public String addCourse(Model model) {
        addAttributesToModel(model);
        return "addCourse";
    }

    @PostMapping(value = "/addCourse")
    public String addCourse(@Valid @ModelAttribute("courseDTO") CourseDTO courseDTO, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            addAttributesToModel(model);
            return "addCourse";
        }
        List<ValidationError> errors = new ArrayList<>();
        String seminar = RequestUtils.getParameterValue(CourseAttribute.SEMINAR, request);
        String laboratory = RequestUtils.getParameterValue(CourseAttribute.LABORATORY, request);
        String lecture = RequestUtils.getParameterValue(CourseAttribute.LECTURE, request);

        courseService.createCourse(courseDTO,seminar,laboratory,lecture, errors);
        if (!errors.isEmpty()){
            model.addAttribute("errors", errors);
            addAttributesToModel(model);
            return "addCourse";
        }
        return "redirect:/main";
    }
}
