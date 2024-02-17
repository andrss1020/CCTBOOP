package com.school.projectschool;

public class Instructor {

    private int InstructorID;
    private String InstructorName;

    public Instructor(int InstructorID, String InstructorName) {
        this.InstructorName = InstructorName;
        this.InstructorID = InstructorID;
        //this.InstructorCode = generateInstructorCode();
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int instructorID) {
        InstructorID = instructorID;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }
}
