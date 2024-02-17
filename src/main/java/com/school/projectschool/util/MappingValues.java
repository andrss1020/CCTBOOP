package com.school.projectschool.util;

import java.util.HashMap;
import java.util.Map;

public class MappingValues {
    public Map<Character, String> tablesSchool() {
        // Create map key - value
        Map<Character, String> map = new HashMap<>();

        // Add elements to map
        map.put('C', "Course");
        map.put('S', "Student");
        map.put('I', "Instructor");
        map.put('R', "Classroom");
        map.put('G', "Grades");
        map.put('E', "Enrolment");

        return map;
    }
}