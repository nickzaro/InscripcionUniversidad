package com.nickzaro.inscripcionuniversidad.course.controller;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;
import com.nickzaro.inscripcionuniversidad.professor.service.IProfessorService;
import com.nickzaro.inscripcionuniversidad.schedule.entity.DayOfWeek;
import com.nickzaro.inscripcionuniversidad.schedule.entity.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IProfessorService professorService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ModelAttribute("allDays")
    public List<DayOfWeek> daysOfWeek() {
        return Arrays.asList(DayOfWeek.values());
    }

    @GetMapping(value = {"/"})
    public String listar(Model model) {
        model.addAttribute("title", "Course List");
        model.addAttribute("listOfCourses", courseService.findOrderAll());
        return "course/index";
    }

    @GetMapping(value = "/delete/{courseId}")
    public String deleteCourse(@PathVariable(value = "courseId") Long courseId, Model model, RedirectAttributes flash) {
        if (courseId >= 0) {
            courseService.removeCourse(courseId);
            flash.addFlashAttribute("success", "Course removed successfully");
        }
        return "redirect:/course/";
    }

    @RequestMapping("/form")
    public String createProfessor(Model model) {
        model.addAttribute("course", courseService.createBlankCourse());
        model.addAttribute("title", "Form Course");
        return "course/form";
    }

    @RequestMapping("/form/{courseId}")
    public String editProfessor(@PathVariable(value = "courseId") Long courseId, Model model) {
        //TODO: el tema de no encontrarse el curso
        model.addAttribute("course",courseService.findById(courseId));
        model.addAttribute("professors", professorService.findOrderAll());
        model.addAttribute("title", "Form Course");
        return "course/form";
    }

    @RequestMapping(value="/form/save/", params={"addRow"},method = RequestMethod.POST)
    public String addRow(Course course,Model model, final BindingResult bindingResult) {
        course.getSchedules().add(new Schedule());
        System.out.println(course);
        courseService.save(course);
        return "redirect:/course/form/"+course.getId();
    }

    @RequestMapping(value="/form/save/", params={"removeRow"})
    public String removeRow(Course course, final BindingResult bindingResult, final HttpServletRequest req) {
        Long scheduleId = Long.valueOf(req.getParameter("removeRow"));
        System.out.println(scheduleId);
        //TODO: decidir si se borra el schedule implementando desde scheduleService o solo elimino la referencia.
        course.getSchedules().removeIf(schedule -> !schedule.getId().equals(scheduleId));
        courseService.save(course);
        return "redirect:/course/form/"+course.getId();
    }


    @RequestMapping(value = "/form/save/", method = RequestMethod.POST)
    public String save(Course course) {
        if (course != null)
            System.out.println(course);
        if (course.getProfessor() != null)
            System.out.println(course.getProfessor());
        else
            System.out.println("curso nullo");
        courseService.save(course);
        return "redirect:/course/";
    }
}
