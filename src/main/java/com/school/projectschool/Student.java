package com.school.projectschool;

public class Student {
    private static int nextStudentID = 0;

    private int StudentID;
    private String StudentName;

    public Student(int StudentID, String StudentName) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
    }

    // Getter method for StudentID
    public int getStudentId() {
        return StudentID;
    }

    // Getter method for name
    public String getName() {
        return StudentName;
    }

    // Method to generate a unique student code using UUID
    private String generateStudentCode() {
        return "CCTB-Student" + String.format("%04d", StudentID);
    }

    public void setStudentID(int studentId) {
        this.StudentID = StudentID;
    }

    public void setName(String StudentName) {
        this.StudentName = StudentName;
    }
}