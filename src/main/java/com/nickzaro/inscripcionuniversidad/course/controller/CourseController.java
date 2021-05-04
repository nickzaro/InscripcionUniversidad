package com.nickzaro.inscripcionuniversidad.course.controller;

import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = {"/"})
    public String listar(Model model){
        model.addAttribute("title","Course List");
        model.addAttribute("listOfCourses",courseService.findOrderAll());
        return "course/index";
    }

    @GetMapping(value = "/delete/{courseId}")
    public String deleteCourse(@PathVariable(value = "courseId") Long courseId, Model model, RedirectAttributes flash){
        if(courseId >=0){
            courseService.removeCourse(courseId);
            flash.addFlashAttribute("success", "Course removed successfully");
        }
        return "redirect:/course/";
    }

}
