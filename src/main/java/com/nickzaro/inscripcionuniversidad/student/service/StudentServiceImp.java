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

    @Override // se borra la fk mas no el registro de course
    @Transactional // muy importante sino no funciona el método
    public void removeCourse(Long studentId, Long courseId) {
        Student student = findById(studentId);
        Course course = courseService.findById(courseId);
        if (course.isSubtractNumberStudents())
            student.removeCourse(course);
        else throw new RuntimeException("course cannot be removed");
    }

    @Override // se borra la fk mas no el registro de course
    @Transactional // muy importante sino no funciona el método
    public void addCourse(Long studentId, Long courseId) {
        Student student = findById(studentId);
        Course course = courseService.findById(courseId);
        if (course.isAddNumberStudents())
            student.addCourse(course);
        else throw new RuntimeException("course cannot be removed");
    }

}
