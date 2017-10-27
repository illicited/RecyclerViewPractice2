package com.cavendersoftworks.recyclerviewpractice2.Model;

public class Student {
    private String itemId;
    private String name;

    public Student(String itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
