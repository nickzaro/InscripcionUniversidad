package com.nickzaro.inscripcionuniversidad.student.entity;

import com.nickzaro.inscripcionuniversidad.share.entity.Person;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends Person {

    @Column(name = "student_id")
    private String studentID;



    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
