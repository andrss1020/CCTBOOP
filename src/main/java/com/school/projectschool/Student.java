package com.school.projectschool;

public class Student {
    private static int nextStudentId = 0;

    private int studentId;
    private String name;
    private String studentCode;

    public Student(String name) {
        this.studentId = nextStudentId++;
        this.name = name;
        this.studentCode = generateStudentCode();
    }

    // Getter method for studentId
    public int getStudentId() {
        return studentId;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for studentCode
    public String getStudentCode() {
        return studentCode;
    }

    // Method to generate a unique student code using UUID
    private String generateStudentCode() {
        return "CCTB-Student" + String.format("%04d", studentId);
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
