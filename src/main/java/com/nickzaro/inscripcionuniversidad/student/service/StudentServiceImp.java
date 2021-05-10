package com.nickzaro.inscripcionuniversidad.student.service;

import com.nickzaro.inscripcionuniversidad.course.entity.Course;
import com.nickzaro.inscripcionuniversidad.course.service.ICourseService;
import com.nickzaro.inscripcionuniversidad.student.entity.Student;
import com.nickzaro.inscripcionuniversidad.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ICourseService courseService;

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOptional= studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("No present Student for id");
        }
        return studentOptional.get();
    }

    @Override // se borra la fk mas no el registro de course
    @Transactional // muy importante sino no funciona el método
    public void removeCourse(Long studentId, Long courseId) {
        Student student = findById(studentId);
        Course course = courseService.findById(courseId);
        if (course.isSubtractNumberStudents())
            student.removeCourse(course);
        else throw new RuntimeException("course cannot be removed");
    }

    @Override // se borra la fk mas no el registro de course
    @Transactional // muy importante sino no funciona el método
    public void addCourse(Long studentId, Long courseId) {
        Student student = findById(studentId);
        Course course = courseService.findById(courseId);
        if (course.isAddNumberStudents())
            student.addCourse(course);
        else throw new RuntimeException("course cannot be agregate");
    }

    @Override
    public List<Course> courseNoRegistered(Student student) {
        List<Course> studentCourses = new ArrayList<>(student.getCourses());
        List<Course> courses= courseService.findAll();
        List<Course> coursesNR = new ArrayList<>();
        for (Course c:courses){
            if( !studentCourses.contains(c))
                coursesNR.add(c);
        }
        return coursesNR;
    }

    @Override
    public List<Course> courseNoRegisteredInOrder(Student student){
        List<Course> courses = courseNoRegistered(student);
        return coursesInOrder(courses);
    }

    @Override
    public List<Course> coursesInOrder(List<Course> courses){
        return courses.stream().
                sorted(Comparator.comparing(Course::getCourseName)).collect(Collectors.toList());
    }
}
