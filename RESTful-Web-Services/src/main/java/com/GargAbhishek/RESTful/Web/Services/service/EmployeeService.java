package com.GargAbhishek.RESTful.Web.Services.service;

import com.GargAbhishek.RESTful.Web.Services.classes.Employee;
import com.GargAbhishek.RESTful.Web.Services.classes.EmployeeNotFound;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

@Component
public class EmployeeService {
    private static List<Employee> employees= new ArrayList<>();
    private static int counter=0;

    static {
        employees.add(new Employee(++counter,"Abhishek Garg",22));
        employees.add(new Employee(++counter,"Tarun Singh",21));
        employees.add(new Employee(++counter,"Nikhil Sharma",23));
    }
    public List<Employee> findAll(){
        return employees;
    }
    public Employee findOne(int id){
        Predicate<? super Employee> predicate= employee -> employee.getId()==id;
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }
    public Employee saveEmployee(Employee employee){
        employee.setId(++counter);
        employees.add(employee);
        return employee;
    }
    public void deleteById(int id){
        Predicate<? super Employee> predicate= employee -> employee.getId()==id;
        employees.removeIf(predicate);
    }
    public String updateEmployee(Employee employee,int id){
        Predicate<? super Employee> predicate= emp -> emp.getId()==id;
        Employee updatedEmployee= employees.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(()->new EmployeeNotFound("id: "+id));
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setAge(employee.getAge());
        return "Success";
    }
}
