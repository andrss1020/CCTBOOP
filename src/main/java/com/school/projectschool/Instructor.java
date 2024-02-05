package com.school.projectschool;

public class Instructor {
    private static int nextInstructorId = 0;

    private int instructorId;
    private String name;
    private String instructorCode;

    public Instructor(String name) {
        this.name = name;
        this.instructorId = nextInstructorId++;
        this.instructorCode = generateInstructorCode();
    }

    private String generateInstructorCode(){
        return "CCTB-Instructor" + String.format("%04d", instructorId);
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructorCode() {
        return instructorCode;
    }

    public void setInstructorCode(String instructorCode) {
        this.instructorCode = instructorCode;
    }
}
