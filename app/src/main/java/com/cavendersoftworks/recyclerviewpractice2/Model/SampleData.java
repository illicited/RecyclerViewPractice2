package com.cavendersoftworks.recyclerviewpractice2.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleData {
    public static List<Student> studentList;
    public static Map<String, Student> studentMap;

    static {
        studentList = new ArrayList<>();
        studentMap = new HashMap<>();

        addItem(new Student(null, "Josh Cavender") );
        addItem(new Student(null, "Reid Briley"));
        addItem(new Student(null, "Rob Graine"));
        addItem(new Student(null, "Brian Escalante"));

        }

    private static void addItem(Student student) {
        studentList.add(student);
        studentMap.put(student.getItemId(), student);
    }

}
