package com.example.lab1.mybatis.dao;

import com.example.lab1.mybatis.model.StudentCourse;
import java.util.List;

public interface StudentCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT_COURSE
     *
     * @mbg.generated Wed Apr 06 15:52:32 EEST 2022
     */
    int insert(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT_COURSE
     *
     * @mbg.generated Wed Apr 06 15:52:32 EEST 2022
     */
    List<StudentCourse> selectAll();
}