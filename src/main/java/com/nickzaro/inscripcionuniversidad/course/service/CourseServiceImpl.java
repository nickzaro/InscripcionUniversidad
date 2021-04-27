package com.nickzaro.inscripcionuniversidad.course.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll(){
        return (List<Course>) courseRepository.findAll();
    }
}
