package com.school.projectschool.util;

import java.util.Map;

public class Messages {
    public static void optionsMainMenu(){
        System.out.println("Please select from the options: \n "
                + "\n For Student management, select S "
                + "\n For Instructor management, select I "
                + "\n For Courses management, select C "
                + "\n For Class room management, select R "
                + "\n For Grades  management, select G "
                + "\n For Report Tables, select P "
                + "\n To leave, press X ");
    }

    public static void optionsMenu(char schoolProperty){
        Map<Character, String> valuesOfTable =  new MappingValues().tablesSchool();
        String valueProperty = valuesOfTable.get(schoolProperty);
        System.out.println("\n Please select from the options: ");
        System.out.println("For inserting new " + valueProperty + " data, select I");
        System.out.println("For Editing " + valueProperty + " data, select  E ");
        System.out.println("For Deleting " + valueProperty + " data, select  D ");
        System.out.println("To return to the prior menu press  X ");
    }

}
