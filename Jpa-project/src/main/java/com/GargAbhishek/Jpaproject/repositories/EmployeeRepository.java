package com.GargAbhishek.Jpaproject.repositories;

import com.GargAbhishek.Jpaproject.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findAll();
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findByNameLike(String regex);
    List<EmployeeEntity> findByAgeBetween(int startAge, int endAge);
}
