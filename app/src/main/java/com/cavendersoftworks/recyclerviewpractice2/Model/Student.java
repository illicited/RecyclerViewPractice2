package com.cavendersoftworks.recyclerviewpractice2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Student implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemId);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.imageName);
        dest.writeString(this.status);
    }

    protected Student(Parcel in) {
        this.itemId = in.readString();
        this.name = in.readString();
        this.company = in.readString();
        this.imageName = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
