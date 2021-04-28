package com.nickzaro.inscripcionuniversidad.student.controller;

import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import com.nickzaro.inscripcionuniversidad.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/{id}")
    public String student(@PathVariable(value = "id") Long id, Model model){
        Student student = studentService.findById(id);
        //TODO: implementar el tema de student null
        //TODO: implementar el tema de los curso en orden alfabético.
        model.addAttribute("student",student);
        model.addAttribute("title","Student Panel");
        return "student/index";
    }
}
