package com.nickzaro.inscripcionuniversidad.student.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;

import java.util.List;
import java.util.Set;

public interface IStudentService {

    public Student findById(Long id);
}
