package com.nickzaro.inscripcionuniversidad.course.entity;

import com.nickzaro.inscripcionuniversidad.share.entity.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "professors")
public class Professor extends Person {

    @Column(name = "activate")
    private Boolean activate;

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
