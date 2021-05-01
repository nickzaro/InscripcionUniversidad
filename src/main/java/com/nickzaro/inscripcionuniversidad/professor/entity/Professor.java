package com.nickzaro.inscripcionuniversidad.professor.entity;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.share.entity.Person;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
public class Professor extends Person {

    @Column(name = "activate")
    private Boolean activate;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
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

    public void updateAttributes(String dni, String firstName, String lastName, Boolean activate){
        this.setDNI(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setActivate(activate);
    }

    @PreRemove
    public  void onDeleteSetNullCourses(){
        courses.forEach(course -> {
            course.setProfessor(null);
        });
    }

}
