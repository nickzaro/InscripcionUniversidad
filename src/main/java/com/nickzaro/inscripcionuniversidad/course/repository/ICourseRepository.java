package com.nickzaro.inscripcionuniversidad.course.repository;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course,Long> {

    @Query(value = "SELECT c from Course c order by c.nameOfCourse")
    public List<Course> findOrderAll();
}
