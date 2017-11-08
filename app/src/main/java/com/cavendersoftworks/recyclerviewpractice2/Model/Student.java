package com.cavendersoftworks.recyclerviewpractice2.Model;

import java.util.UUID;

public class Student {
    private String itemId;
    private String name;
    private String company;
    private String imageName;
    private String status;

    public Student(String itemId, String name, String company, String img, String status) {

        if (itemId == null) {
            itemId = UUID.randomUUID().toString();
        }
        this.itemId = itemId;
        this.name = name;
        this.company = company;
        this.status = status;
        imageName = img;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
