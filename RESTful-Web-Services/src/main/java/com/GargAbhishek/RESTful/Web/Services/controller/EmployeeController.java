package com.GargAbhishek.RESTful.Web.Services.controller;

import com.GargAbhishek.RESTful.Web.Services.classes.Employee;
import com.GargAbhishek.RESTful.Web.Services.classes.EmployeeNotFound;
import com.GargAbhishek.RESTful.Web.Services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(path = "/employees")
    public List<Employee> retrieveAll() {
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee retrieveOne(@PathVariable int id) throws EmployeeNotFound {
        Employee employee = service.findOne(id);
        if (employee == null)
            throw new EmployeeNotFound("id:" + id);

        return employee;
    }

    @PostMapping("/employees")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        service.saveEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping(path = "/employees/{id}")
    public String updateExistingEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return service.updateEmployee(employee, id);

    }

}
