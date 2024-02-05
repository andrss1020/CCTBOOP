package com.school.projectschool;

public class Grades {
    private int gradeId;
    private static int nextgradeId = 0;
    private Student studentId;
    private Courses courseId;

    public Grades(Student studentId, Courses courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.gradeId = nextgradeId++;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Courses getCourseId() {
        return courseId;
    }

    public void setCourseId(Courses courseId) {
        this.courseId = courseId;
    }
}
