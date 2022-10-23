package com.GargAbhishek.RESTful.Web.Services.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.GargAbhishek.RESTful.Web.Services.classes.Employee;
import com.GargAbhishek.RESTful.Web.Services.classes.EmployeeNotFound;
import com.GargAbhishek.RESTful.Web.Services.service.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    @GetMapping(path = "/employees")
    @Operation(description = "Get details of all Employees")
    public List<Employee> retrieveAll() {
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    @Operation(description = "Get details of Employee by ID")
    public EntityModel<Employee> retrieveOne(@PathVariable int id) throws EmployeeNotFound {
        Employee employee = service.findOne(id);
        if (employee == null)
            throw new EmployeeNotFound("id:" + id);
        EntityModel<Employee> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAll());
        entityModel.add(link.withRel("all-Employees"));
        return entityModel;
    }

    @PostMapping("/employees")
    @Operation(description = "Add a new Employee")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        service.saveEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    @Operation(description = "Delete details of an Employee by ID")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping(path = "/employees/{id}")
    @Operation(description = "Update details of an Employee by ID")
    public String updateExistingEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return service.updateEmployee(employee, id);

    }

}
