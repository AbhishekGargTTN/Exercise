package com.GargAbhishek.RestfulWebServicesApi.classes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

//@JsonIgnoreProperties({"password","age"})
public class UserV1 {
    private String userName;
//    @JsonIgnore
    private String password;

//    @JsonIgnore
    private int age;
    private String nationality;

    public UserV1(String userName, String password, int age, String nationality) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.nationality = nationality;
    }

    public String getUserName() {
        return userName;
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

    @Override
    public String toString() {
        return "UserV1{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
