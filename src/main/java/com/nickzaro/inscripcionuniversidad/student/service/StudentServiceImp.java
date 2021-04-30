package com.nickzaro.inscripcionuniversidad.student.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.repository.ICourseRepository;
import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import com.nickzaro.inscripcionuniversidad.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImp implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ICourseService courseService;

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOptional= studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("No present Student for id");
        }
        return studentOptional.get();
    }

    @Override
    @Transactional // muy importante sino no funciona el método
    public void removeCourse(Long studentId, Long courseId) {

        Student student = findById(studentId);
        Course course = courseService.findById(courseId);
        student.removeCourse(course);
        //TODO: no persiste los cambios

         
    }
}
