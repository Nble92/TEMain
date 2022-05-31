package com.techelevator.student;

public class Student {
    private String name;
    private String address;
    private String school = "A";


    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address) {
        this.name = name;  // can replace this line with...    this(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
        if (address.startsWith("12")) {
            this.school = "C";
        } else {
            this.school = "B";
        }
    }

    public String getSchool() {
        return school;
    }



}
