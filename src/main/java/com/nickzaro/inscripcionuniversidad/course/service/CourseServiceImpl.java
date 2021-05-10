package com.nickzaro.inscripcionuniversidad.course.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll(){
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findOrderAll(){
        return courseRepository.findOrderAll();
    };

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id){
        Optional<Course> courseOptional= courseRepository.findById(id);
        if(courseOptional.isEmpty()){
            throw new RuntimeException("No present Course for id");
        }
        return courseOptional.get();
    }

    @Override // se borra la fk mas no el registro de course
    @Transactional // muy importante sino no funciona el método
    public void removeCourse(Long courseId) {
        Course course = findById(courseId);
        // course.removeStudents();
        courseRepository.delete(course);
    }

    @Override
    public Course createBlankCourse() {
        return new Course();
    }

    @Override
    public Long save(Course course) {
        courseRepository.save(course);
        return course.getId();
    }

}
