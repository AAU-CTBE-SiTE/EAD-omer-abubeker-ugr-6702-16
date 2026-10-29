
package com.craft;

public class Address {
    private String city;
    private String country;

    // No-argument constructor
    public Address() {
    }

    // Parameterized constructor for constructor injection
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{city='" + city +
                "', country='" + country + "'}";
    }
}
