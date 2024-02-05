package com.school.projectschool;

import java.util.List;

public class Courses {

    private int nextcourse = 0;
    private String name_course;

    private int courseId;

    private String description;

    private int instructorId;

    private List<Student> studentid;

    public Courses(String name_course, String description) {
        this.name_course = name_course;
        this.description = description;
        this.courseId = nextcourse++;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public List<Student> getStudentid() {
        return studentid;
    }

    public void setStudentid(List<Student> studentid) {
        this.studentid = studentid;
    }

}
