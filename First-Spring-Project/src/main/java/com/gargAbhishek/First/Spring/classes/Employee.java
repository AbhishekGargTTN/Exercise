package com.gargAbhishek.First.Spring.classes;

import org.springframework.stereotype.Component;

@Component
public class Employee {
     private String name;
     private int id;
     private String competency;

    public Employee() {
        this.name = "Abhishek Garg";
        this.id = 6573;
        this.competency = "JVM";
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n"+"ID: "+id+"\n"+"Competency: "+competency;
    }
}
