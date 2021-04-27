package com.nickzaro.inscripcionuniversidad.course.repository;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Long> {
}
