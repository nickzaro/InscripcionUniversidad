package com.nickzaro.inscripcionuniversidad.student.controller;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import com.nickzaro.inscripcionuniversidad.student.service.IStudentService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/{id}")
    public String index(@PathVariable(value = "id") Long id, Model model){
        Student student = studentService.findById(id);
        //TODO: implementar el tema de student null
        model.addAttribute("student",student);
        List<Course> courseList= student.getCourses().stream().
                sorted(Comparator.comparing(Course::getNameOfCourse)).collect(Collectors.toList());
        model.addAttribute("CourseList",courseList);
        model.addAttribute("title","Student Panel");
        return "student/index";
    }
}
