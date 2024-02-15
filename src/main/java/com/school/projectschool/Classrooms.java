package com.school.projectschool;

public class Classrooms {

    private static int nextClassrooms = 0;

    private int ClassroomsId;
    private String Subject;
    private String ClassroomsCode;

    public Classrooms(String Subject) {
        this.Subject = Subject;
        this.ClassroomsId = nextClassrooms++;
        this.ClassroomsCode = generateClassroomsCode();
    }

    private String generateClassroomsCode(){
        return "CCTB-Classrooms" + String.format("%04d", ClassroomsId);
    }

    public int getClassroomsId() {
        return ClassroomsId;
    }

    public void setClassroomsId(int classroomsId) {
        this.ClassroomsId = classroomsId;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getClasssroomsCode() {
        return this.ClassroomsCode;
    }

    public void setClasssroomsCode(String ClassroomsCode) {
        this.ClassroomsCode = ClassroomsCode;
    }
}

