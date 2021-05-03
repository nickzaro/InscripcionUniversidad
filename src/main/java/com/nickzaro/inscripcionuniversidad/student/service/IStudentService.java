package com.nickzaro.inscripcionuniversidad.student.service;

import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IStudentService {

    public Student findById(Long id);

    public void removeCourse(Long studentId, Long courseId);

    public void addCourse(Long studentId, Long courseId);
}
