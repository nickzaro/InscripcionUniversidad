package com.nickzaro.inscripcionuniversidad.professor.repository;


import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<Professor,Long> {
}
