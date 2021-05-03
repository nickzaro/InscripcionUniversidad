package com.nickzaro.inscripcionuniversidad.student.controller;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import com.nickzaro.inscripcionuniversidad.student.service.IStudentService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
        //TODO: implementar el tema de student null y mover el sorted al studentService.
        model.addAttribute("student",student);
        List<Course>  studentCourses = studentService.coursesInOrder(new ArrayList<>(student.getCourses()));
        List<Course> unregisteredCourses = studentService.courseNoRegistered(student);
        model.addAttribute("studentCourses",studentCourses);
        model.addAttribute("unregisteredCourses",unregisteredCourses);
        model.addAttribute("title","Student Panel");
        return "student/index";
    }
    @RequestMapping(value = "/{studentId}/unsubscribe/{courseId}")
    public String unsubscribeCourse(@PathVariable(value ="studentId") Long studentId,@PathVariable(value = "courseId") long courseId, RedirectAttributes flash){
        if(studentId>=0 && courseId >=0){
            studentService.removeCourse(studentId,courseId);
            flash.addFlashAttribute("success", "Course removed successfully");
        }
        return "redirect:/student/"+studentId;

    }
    @RequestMapping(value = "/{studentId}/subscribe/{courseId}")
    public String subscribeCourse(@PathVariable(value = "studentId") Long studentId,@PathVariable(value = "courseId") Long courseId, RedirectAttributes flash){
        if(studentId>=0 && courseId >=0){
            studentService.addCourse(studentId,courseId);
            flash.addFlashAttribute("success", "Course added successfully");
        }
        return "redirect:/student/"+studentId;
    }
}
