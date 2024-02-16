package com.school.projectschool;

import com.school.projectschool.util.CRUD.GradesResources;
import com.school.projectschool.util.CRUD.ClassResources;
import com.school.projectschool.util.CRUD.InstructorResources;
import com.school.projectschool.util.Messages;
import com.school.projectschool.util.database.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializer data
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.InitializeData();
        //Initializer class
        ClassResources resourcesClass = new ClassResources();
        GradesResources resourcesGrades = new GradesResources();
        InstructorResources resourcesInstructor = new InstructorResources();

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
                            case 'N': {
                                System.out.println("Insert Student mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Student mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Student mode enabled: ");
                                // call external class for connecting to DB

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
                case 'T': {
                    System.out.println("Selecting Teacher Management \n");
                    do {
                        Messages.optionsMenu('T');
                        teacherMenu = menuOption.next().charAt(0);

                        switch (teacherMenu) {
                            case 'N': {
                                System.out.println("Insert Teacher mode enabled: ");
                                resourcesInstructor.insertMethod('T');
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Teacher mode enabled: ");
                                resourcesInstructor.updateMethod('T');

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Teacher mode enabled: ");
                                resourcesInstructor.deleteMethod('T');

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
                            case 'N': {
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
                            case 'N': {
                                System.out.println("Insert Class room mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Class room mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Class room mode enabled: ");
                                // call external class for connecting to DB

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
                            case 'N': {
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