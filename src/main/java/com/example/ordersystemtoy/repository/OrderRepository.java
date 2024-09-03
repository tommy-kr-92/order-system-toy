package com.example.ordersystemtoy.repository;

import com.example.ordersystemtoy.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
