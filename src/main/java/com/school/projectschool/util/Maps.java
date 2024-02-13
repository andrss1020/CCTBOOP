package com.school.projectschool.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public Map<Character, String> initializeMapSchool() {
        // Create map key - value
        Map<Character, String> map = new HashMap<>();

        // Add elements to map
        map.put('C', "Class");
        map.put('S', "Student");
        map.put('T', "Teacher");
        map.put('R', "Room");
        map.put('G', "Grades");

        return map;
    }
}
