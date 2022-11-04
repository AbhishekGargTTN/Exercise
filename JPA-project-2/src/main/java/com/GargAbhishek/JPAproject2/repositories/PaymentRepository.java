package com.GargAbhishek.JPAproject2.repositories;

import com.GargAbhishek.JPAproject2.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
