package com.GargAbhishek.JPAproject3.repositories;

import com.GargAbhishek.JPAproject3.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
