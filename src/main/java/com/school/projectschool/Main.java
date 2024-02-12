package com.school.projectschool;

import com.school.projectschool.util.database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try (Connection connection = MySqlConnection.getConnection()) {
            // Realiza operaciones con la base de datos aquí
            String query = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Procesa los resultados
                    String columna1 = resultSet.getString("columna1");
                    String columna2 = resultSet.getString("columna2");
                    // Realiza operaciones con los datos obtenidos
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
                    System.out.println("Selecting Class Management ");
                    do {
                        System.out.println("Please select from the options: ");
                        System.out.println("For inserting new Class data, select N ");
                        System.out.println("For Editing Class data, select E: ");
                        System.out.println("For Deleting Class data, select D: ");
                        System.out.println("To return to the prior menu press X ");
                        classMenu = menuOption.next().charAt(0);

                        switch (classMenu) {
                            case 'N': {
                                System.out.println("Insert Class mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Class mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Class mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'X': {
                                System.out.println("Returning to main menu. ");
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
                                System.out.println("Insert Grades mode enabled: ");
                                // call external class for connecting to DB
                                break;
                            }
                            case 'E': {
                                System.out.println("Editing Grades mode enabled: ");
                                // call external class for connecting to DB

                                break;
                            }
                            case 'D': {
                                System.out.println("Deleting Grades mode enabled: ");
                                // call external class for connecting to DB

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
