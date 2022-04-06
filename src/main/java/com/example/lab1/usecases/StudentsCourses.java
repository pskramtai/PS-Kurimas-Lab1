package com.example.lab1.usecases;

import com.example.lab1.entities.Course;
import com.example.lab1.entities.Student;
import com.example.lab1.persistence.CoursesDAO;
import com.example.lab1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class StudentsCourses {

    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private CoursesDAO coursesDAO;

    @Getter @Setter
    private Student student;

    @Getter @Setter
    private Course courseToAdd;

    @Getter @Setter
    private Long courseToAddId;

    @Getter @Setter
    private Long courseToRemoveId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentId = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(studentId);
    }

    @Transactional
    public void addCourse(){
        this.courseToAdd = coursesDAO.findOne(courseToAddId);
        if(!student.getCourses().contains(courseToAdd)){
            student.getCourses().add(courseToAdd);
        }
        studentsDAO.update(student);
    }

    @Transactional
    public void removeCourse(){
        student.getCourses().remove(coursesDAO.findOne(courseToRemoveId));
        studentsDAO.update(student);
    }
}
