package com.GargAbhishek.JPAproject2.repositories;

import com.GargAbhishek.JPAproject2.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query(value ="select firstName,lastName from Employee where salary > (select avg(salary) from Employee) order by age ASC, salary DESC")
    List<Object[]> findEmployeeWithSalaryGreaterThanAvg();
    @Modifying
    @Transactional
    @Query(value = "Update Employee e SET salary=:newSalary where e.salary<:avgSalary")
    void updateEmployeeWithSalaryLessThanAvgSalary(@Param("newSalary") int newSalary, @Param("avgSalary") int avgSalary);

    @Query(value = "select avg(salary) from Employee")
    int averageSalary();

    @Modifying
    @Transactional
    @Query(value = "delete from Employee e where e.salary=:minSalary")
    void deleteEmployeesWithMinSalary(@Param("minSalary") int minSalary);

    @Query(value = "select min(salary) from Employee")
    int minimumSalary();
    @Query(value = "select empid, empFirstName, age from employee where empLastName='Singh'", nativeQuery = true)
    List<Object[]> findByNameEndingWithSingh();

    @Modifying
    @Query(value = "delete from employee e where e.age>:age",nativeQuery = true)
    void DeleteEmployeeHavingAgeGreaterThan(@Param("age") int age);
}
