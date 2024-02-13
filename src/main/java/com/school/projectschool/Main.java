package com.school.projectschool;

import com.school.projectschool.util.CRUD.GradesResources;
import com.school.projectschool.util.CRUD.ClassResources;
import com.school.projectschool.util.database.MySqlConnection;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClassResources resourcesClass = new ClassResources();
        GradesResources resourcesGrades = new GradesResources();

        try (Connection connection = MySqlConnection.getConnection()) {
            String query = "SELECT * FROM Grades";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    System.out.println("Nombre de la columna " + i + ": " + columnName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Getting Parameters
        char mainMenu = 'a';
        boolean mainMenu_bol;
        Scanner menuOption = new Scanner(System.in);
        // variables menu initializer
        char studentMenu = 'a';
        char teacherMenu = 'a';
        char classMenu = 'a';
        char roomMenu = 'a';
        char gradesMenu = 'a';
        // database string initializers

        String selectDB = "select";
        String insertDB = "insert";
        String deleteDB = "remove";
        String updateDB = "update";


        //main menu call
        System.out.println("Welcome to this Basic School Management Program \n");


        do { // loops the main menu until they are ready to quit. So every change or action done, calls back to the menu in question.
            System.out.println("Please select from the options: \n "
                    + "\n For Student management, select S "
                    + "\n For Teacher management, select T "
                    + "\n For Class management, select C "
                    + "\n For Class room management, select R "
                    + "\n For Grades  management, select G "
                    + "\n To leave, press X ");
            mainMenu = menuOption.next().charAt(0);
            switch (mainMenu) {
                case 'S': {
                    System.out.println("Selecting Student Management \n");
                    do {
                        System.out.println("\n Please select from the options: ");
                        System.out.println("For inserting new student data, select N");
                        System.out.println("For Editing student data, select  E ");
                        System.out.println("For Deleting student data, select  D ");
                        System.out.println("To return to the prior menu press  X ");
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
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Teacher data, select N ");
                        System.out.println("For Editing Teacher data, select  E ");
                        System.out.println("For Deleting Teacher data, select  D ");
                        System.out.println("To return to the prior menu press  X ");
                        teacherMenu = menuOption.next().charAt(0);

                        switch (teacherMenu) {
                            case 'N': {
                                System.out.println("Insert Teacher mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Teacher mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Teacher mode enabled: ");
                                // call external class for connecting to DB

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
                    System.out.println("\n Selecting Class Management \n");
                    do {
                        System.out.println("\nPlease select from the options: \n");
                        System.out.println("For inserting new Class data, select N ");
                        System.out.println("For Editing Class data, select E: ");
                        System.out.println("For Deleting Class data, select D: ");
                        System.out.println("To return to the prior menu press X \n");
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
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Class room data, select N ");
                        System.out.println("For Editing Class room data, select E: ");
                        System.out.println("For Deleting Class room data, select D: ");
                        System.out.println("To return to the prior menu press X: ");
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
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Grades data, select N ");
                        System.out.println("For Editing Grades data, select E ");
                        System.out.println("For Deleting Grades data, select D ");
                        System.out.println("To return to the prior menu press X ");
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