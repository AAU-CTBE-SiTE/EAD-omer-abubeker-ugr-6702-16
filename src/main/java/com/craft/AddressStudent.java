
package com.craft;

public class AddressStudent {
    private int id;
    private String name;
    private Address address;

    public AddressStudent(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student ID: " + id
                + ", Name: " + name
                + ", Address: " + address;
    }
}
