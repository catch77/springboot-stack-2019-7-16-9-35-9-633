package com.tw.apistackbase.model;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

public class Employee {

    private int id;

    private String name;

    private int age;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
