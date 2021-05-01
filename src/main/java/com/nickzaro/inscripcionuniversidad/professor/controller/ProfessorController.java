package com.nickzaro.inscripcionuniversidad.professor.controller;

import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.professor.service.IProfessorService;
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
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = {"/"})
    public String listar(Model model){
        model.addAttribute("title","Professor List");
        model.addAttribute("professorList",professorService.findOrderAll());
        return "professor/index";
    }

    @RequestMapping(value = "/delete/{professorId}")
    public String deleteProfessor(@PathVariable(value = "professorId") long professorId, RedirectAttributes flash){
        System.out.println("ProfessorID "+ professorId );
        if(professorId>=0){
            professorService.remove(professorId);
            flash.addFlashAttribute("success", "Professor successfully eliminated!");
        }
        return "redirect:/professor/";

    }
}
