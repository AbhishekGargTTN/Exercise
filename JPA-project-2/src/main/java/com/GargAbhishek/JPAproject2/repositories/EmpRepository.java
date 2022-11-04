package com.GargAbhishek.JPAproject2.repositories;

import com.GargAbhishek.JPAproject2.entities.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp,Integer> {
}
