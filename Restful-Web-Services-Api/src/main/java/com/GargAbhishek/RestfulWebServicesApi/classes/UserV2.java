package com.GargAbhishek.RestfulWebServicesApi.classes;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonFilter("UserV2 Filter")
public class UserV2 {
    private String firstName;

    private String lastName;

    private String password;
    private int age;
    private String nationality;
    private int income;

    public UserV2(String firstName, String lastName, String password, int age, String nationality, int income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
        this.nationality = nationality;
        this.income = income;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "UserV2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", Income=" + income +
                '}';
    }
}
