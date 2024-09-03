package com.example.ordersystemtoy.repository;

import com.example.ordersystemtoy.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
