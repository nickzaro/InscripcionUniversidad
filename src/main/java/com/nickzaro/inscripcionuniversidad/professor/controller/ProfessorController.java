package com.nickzaro.inscripcionuniversidad.professor.controller;

import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;
import com.nickzaro.inscripcionuniversidad.professor.service.IProfessorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @RequestMapping("/form")
    public String createProfessor(Model model){
        model.addAttribute("professor",professorService.createBlankProfessor());
        model.addAttribute("title","New Professor");
        return "professor/form";
    }

    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public String save(@Valid Professor professor, BindingResult result, Model model,
                          RedirectAttributes flash, SessionStatus status) {
        System.out.println(professor);
        professorService.save(professor);
        return "redirect:/professor/";
        }

    @RequestMapping(value = "/form/{professorId}")
    public String updateProfessor(@PathVariable(value = "professorId") Long professorId,Model model,
                                  RedirectAttributes flash){
        Professor professor = null;
        if(professorId>= 0){
            professor = professorService.findById(professorId);
            if(professor==null){
                flash.addFlashAttribute("Error","professor ID not found");
                return "redirect:/professor/";
            }
        }else {
            flash.addFlashAttribute("Error","professor ID must be greater than zero");
            return "redirect:/professor/";
        }
        model.addAttribute("professor",professor);
        model.addAttribute("title","Edit professor");
        return "professor/form";
    }

}
