package com.example.orderservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findByOrderId(String orderId);
    List<Order> findAllByUserId(String userId);
}
