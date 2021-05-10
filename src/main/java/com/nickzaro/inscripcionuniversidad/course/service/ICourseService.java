package com.nickzaro.inscripcionuniversidad.course.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;

import java.util.List;

public interface ICourseService {

    public List<Course> findAll();

    public List<Course> findOrderAll();

    public Course findById(Long id);

    public void removeCourse(Long courseId);

    public Course createBlankCourse();

    Long save(Course course);
}
