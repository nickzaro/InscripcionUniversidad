package com.nickzaro.inscripcionuniversidad.course.entity;

import com.nickzaro.inscripcionuniversidad.professor.entity.Professor;
import com.nickzaro.inscripcionuniversidad.schedule.entity.Schedule;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_course")
    private String nameOfCourse;
    @Column(name="course_code")
    private String courseCode;

    @Column(name = "total_number_students")
    private Integer totalNumberStudents;

    @Column(name = "number_students")
    private Integer numberStudents;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Schedule> schedules;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public Integer getTotalNumberStudents() {
        return totalNumberStudents;
    }

    public void setTotalNumberStudents(Integer totalQuota) {
        this.totalNumberStudents = totalQuota;
    }

    public Integer getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Integer remainingQuota) {
        this.numberStudents = remainingQuota;
    }

    public Boolean isAddNumberStudents(){
        return numberStudents < totalNumberStudents;
    }
    public Boolean isSubtractNumberStudents(){
        return numberStudents > 0;
    }
    public Boolean addNumberStudents(){
        Boolean result= isAddNumberStudents();
        if (result)
            numberStudents++;
        return result;
    }

    public Boolean subtractNumberStudents(){
        Boolean result = isSubtractNumberStudents();
        if(result)
            numberStudents--;
        return result;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
