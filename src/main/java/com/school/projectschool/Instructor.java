package com.school.projectschool;

public class Instructor {
    private static int nextInstructorId = 0;

    private int InstructorID;
    private String InstructorName;

    public Instructor(String name) {
        this.name = name;
        this.InstructorID = nextInstructorId++;
        //this.InstructorCode = generateInstructorCode();
    }

    private String generateInstructorCode(){
        return "CCTB-Instructor" + String.format("%04d", InstructorID);
    }

    public int getInstructorId() {
        return InstructorID;
    }

    public void setInstructorId(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
