package com.cavendersoftworks.recyclerviewpractice2.Model;

public class Student {
    private String itemId;
    private String name;
    private String company;
    private String imageName;

    public Student(String itemId, String name, String company, String img) {
        this.itemId = itemId;
        this.name = name;
        this.company = company;
        imageName = img;
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

    public String getImageName() {
        return imageName;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Student{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
