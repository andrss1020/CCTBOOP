package com.school.projectschool;

public class Classrooms {
    private int ClassroomID;
    private int ClassroomNumber;

    public Classrooms(int ClassroomID, int ClassroomNumber) {
        this.ClassroomID = ClassroomID;
        this.ClassroomNumber = ClassroomNumber;
    }

    public int getClassroomID() {
        return ClassroomID;
    }

    public void setClassroomID(int classroomID) {
        ClassroomID = classroomID;
    }

    public int getClassroomNumber() {
        return ClassroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        ClassroomNumber = classroomNumber;
    }
}

