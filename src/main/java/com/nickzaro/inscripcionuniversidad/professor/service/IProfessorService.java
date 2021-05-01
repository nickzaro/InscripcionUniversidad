package com.nickzaro.inscripcionuniversidad.professor.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;

import java.util.List;

public interface IProfessorService {

    public List<Professor> findOrderAll();

    public Professor findById(Long id);

    public void update(Long id,String dni,String firstName,String lastName,Boolean activate);

    public void add(String dni,String firstName,String lastName,Boolean activate);

    public void remove(Long professorId);

}
