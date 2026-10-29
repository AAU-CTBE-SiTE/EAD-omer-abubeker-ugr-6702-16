
package com.craft;

public class ConstructorStudent {
    private int id;
    private String name;
    private int age;

    public ConstructorStudent(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

        System.out.println("Parameterized constructor called");
    }

    @Override
    public String toString() {
        return "Student ID: " + id
                + ", Name: " + name
                + ", Age: " + age;
    }
}
