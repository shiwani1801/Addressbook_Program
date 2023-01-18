package com.bridgelabz.addressbook;

public class Contact {
    String name;
    String lastName;
    String address;
    String city;
    String state;
    String phoneNo;
    String zipCode;
    String email;
    public Contact(String name, String lastName, String address, String city, String state, String phoneNo, String zipCode,String email) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNo = phoneNo;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}


