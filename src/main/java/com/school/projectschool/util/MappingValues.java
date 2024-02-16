package com.school.projectschool.util;

import java.util.HashMap;
import java.util.Map;

public class MappingValues {
    public Map<Character, String> tablesSchool() {
        // Create map key - value
        Map<Character, String> map = new HashMap<>();

        // Add elements to map
        map.put('C', "Class");
        map.put('S', "Student");
        map.put('T', "Instructor");
        map.put('R', "Room");
        map.put('G', "Grades");

        return map;
    }
}
