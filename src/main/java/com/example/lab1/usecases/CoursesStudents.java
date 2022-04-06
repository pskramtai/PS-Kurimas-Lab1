package com.example.lab1.usecases;

import com.example.lab1.entities.Course;
import com.example.lab1.persistence.CoursesDAO;
import com.example.lab1.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class CoursesStudents {

    @Inject
    private CoursesDAO coursesDAO;

    @Getter @Setter
    private Course course;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long courseId = Long.parseLong(requestParameters.get("courseId"));
        this.course = coursesDAO.findOne(courseId);
    }
}
