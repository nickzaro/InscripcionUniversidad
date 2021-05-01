package com.nickzaro.inscripcionuniversidad.professor.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.repository.ICourseRepository;
import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;
import com.nickzaro.inscripcionuniversidad.professor.repository.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService{

    @Autowired
    private IProfessorRepository professorRepository;
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Professor> findOrderAll() {
        return professorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Professor findById(Long id) {
        Optional<Professor> professorOptional= professorRepository.findById(id);
        if(professorOptional.isEmpty()){
            throw new RuntimeException("No present professor id:" + id);
        }
        return professorOptional.get();
    }

    @Override
    @Transactional
    public void update(Long id, String dni, String firstName, String lastName, Boolean activate) {
        Professor professor = findById(id);
        professor.updateAttributes(dni,firstName,lastName,activate);
    }

    @Override
    @Transactional
    public void add(String dni, String firstName, String lastName, Boolean activate) {
        Professor professor = new Professor();
        professor.updateAttributes(dni,firstName,lastName,activate);
        professorRepository.save(professor);
    }

    @Override
    @Transactional
    public void remove(Long professorId) {
        professorRepository.deleteById(professorId);
    }

}
