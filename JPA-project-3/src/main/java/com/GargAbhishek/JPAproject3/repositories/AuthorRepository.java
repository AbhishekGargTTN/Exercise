package com.GargAbhishek.JPAproject3.repositories;

import com.GargAbhishek.JPAproject3.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
