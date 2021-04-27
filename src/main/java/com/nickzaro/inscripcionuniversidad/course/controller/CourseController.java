package com.nickzaro.inscripcionuniversidad.course.controller;

import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = {"/listar","/"})
    public String listar(Model model){
        model.addAttribute("title","List of Courses");
        model.addAttribute("listOfCourses",courseService.findAll());
        return "course/listar";
    }

}
