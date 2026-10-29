
package com.craft;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;
    private List<Subject> subjects;

    public Student() {
        System.out.println("Student object created");
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Address: " + address);

        System.out.println("Subjects:");
        if (subjects != null) {
            for (Subject subject : subjects) {
                System.out.println("- " + subject.getSubjectName());
            }
        }
    }
}
