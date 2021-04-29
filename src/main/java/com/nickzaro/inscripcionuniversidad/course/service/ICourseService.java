package com.nickzaro.inscripcionuniversidad.course.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseService {

    public List<Course> findAll();

    public List<Course> findOrderAll();
}
