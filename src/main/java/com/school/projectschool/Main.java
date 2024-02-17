package com.school.projectschool;

import com.school.projectschool.util.CRUD.*;
import com.school.projectschool.util.Messages;
import com.school.projectschool.util.database.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializer data
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.InitializeData();
        //Initializer class
        CoursesResources resourcesClass = new CoursesResources();
        GradesResources resourcesGrades = new GradesResources();
        InstructorResources resourcesInstructor = new InstructorResources();
        StudentsResources resourcesStudent = new StudentsResources();
        ClassroomResources resourcesClassroom = new ClassroomResources();
        ReportUtil reportUtil = new ReportUtil();

        // Getting Parameters
        char mainMenu = 'a';
        Scanner menuOption = new Scanner(System.in);
        // variables menu initializer
        char studentMenu = 'a';
        char teacherMenu = 'a';
        char classMenu = 'a';
        char roomMenu = 'a';
        char gradesMenu = 'a';

        //main menu call
        System.out.println("Welcome to this Basic School Management Program \n");

        do {
            Messages.optionsMainMenu();
            mainMenu = menuOption.next().charAt(0);
            switch (mainMenu) {
                case 'S': {
                    System.out.println("Selecting Student Management \n");
                    do {
                        Messages.optionsMenu('S');
                        studentMenu = menuOption.next().charAt(0);

                        switch (studentMenu) {
                            case 'I': {
                                resourcesStudent.insertMethod('S');
                                break;
                            }
                            case 'E': {
                                resourcesStudent.updateMethod('S');
                                break;
                            }
                            case 'D': {
                                resourcesStudent.deleteMethod('S');
                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                studentMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }

                        }
                    }
                    while (  studentMenu != 'X') ;
                    break;
                }
                case 'I': {
                    System.out.println("Selecting Instructor Management \n");
                    do {
                        Messages.optionsMenu('I');
                        teacherMenu = menuOption.next().charAt(0);

                        switch (teacherMenu) {
                            case 'I': {
                                resourcesInstructor.insertMethod('I');
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Teacher mode enabled: ");
                                resourcesInstructor.updateMethod('I');

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Teacher mode enabled: ");
                                resourcesInstructor.deleteMethod('I');

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                teacherMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  teacherMenu != 'X') ;
                    break;
                }
                case 'C': {
                    System.out.println("\n Selecting Courses Management \n");
                    do {
                        Messages.optionsMenu('C');
                        classMenu = menuOption.next().charAt(0);

                        switch (classMenu) {
                            case 'I': {
                                resourcesClass.insertMethod('C');
                                break;
                            }
                            case 'E': {
                                resourcesClass.updateMethod('C');
                                break;
                            }
                            case 'D': {
                                resourcesClass.deleteMethod('C');
                                break; }

                            case 'X': {
                                System.out.println("Returning to main menu. \n");
                                classMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  classMenu != 'X') ;
                    break;
                }
                case 'R': {
                    System.out.println("Selecting Class room Management ");
                    do {
                        Messages.optionsMenu('R');
                        roomMenu = menuOption.next().charAt(0);

                        switch (roomMenu) {
                            case 'I': {
                                System.out.println("Insert Class room mode enabled: ");
                                resourcesClassroom.insertMethod('R');
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Class room mode enabled: ");
                                resourcesClassroom.updateMethod('R');
                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Class room mode enabled: ");
                                resourcesClassroom.deleteMethod('R');
                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                roomMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  roomMenu != 'X') ;
                    break;
                }
                case 'G':{
                    System.out.println("Selecting Grades Management ");
                    do {
                        Messages.optionsMenu('G');
                        gradesMenu = menuOption.next().charAt(0);

                        switch (gradesMenu) {
                            case 'I': {
                                resourcesGrades.insertMethod('G');
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Grades mode enabled: ");
                                resourcesGrades.updateMethod('G');
                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Grades mode enabled: ");
                                resourcesGrades.deleteMethod('G');
                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                gradesMenu = 'X';
                                break;
                            }
                            default: {
                                System.out.println("Unknown response, try again: ");
                                break;
                            }

                        }
                    }
                    while (  gradesMenu != 'X') ;
                    break;
                }
                case 'P':{
                    System.out.println("Generating report... \n");
                    reportUtil.generateReport();
                    break;
                }                
                case 'X':{
                    System.out.println("Exiting now... \n");
                    mainMenu = 'X';
                    break;
                }
                default: {
                    System.out.println("Unknown response, try again.... \n");
                    mainMenu = 'L';
                }
            }
        }
        while (  mainMenu != 'X') ;
        System.out.println("Thanks for using this program.");
    }
}