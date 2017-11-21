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

        addItem(new Student(null, "Josh Cavender", "Pacific Aggregates, Inc.", "josh.jpg", "Practical Test") );
        addItem(new Student(null, "Reid Briley", "Fenaugh Inspection", "reid.jpg", "Written Test"));
        addItem(new Student(null, "Rob Graine", "Associated Ready-mix", "rob.jpg", "Queue"));
        addItem(new Student(null, "Brian Escalante", "Associated Ready-mix", "brian.jpg", "Queue"));
        addItem(new Student(null, "Brandon Agles", "Associated Ready-mix", "brandon.jpg", "Written Test"));
        addItem(new Student(null, "Andy Medina", "Webcor", "andy.jpg", "Practical Test"));

        }

    private static void addItem(Student student) {
        studentList.add(student);
        studentMap.put(student.getItemId(), student);
    }

}
