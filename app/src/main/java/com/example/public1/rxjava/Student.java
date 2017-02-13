package com.example.public1.rxjava;

import java.util.List;

/**
 * Created by public1 on 2017/2/13.
 */
public class Student {
    private String name;//姓名
    private int age;//年龄
    private List<String> courses;//课程

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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
