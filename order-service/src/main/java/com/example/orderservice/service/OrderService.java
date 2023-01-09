package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.domain.OrderRepository;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse getOrderByOrderId(String orderId) {
        return OrderResponse.of(orderRepository.findByOrderId(orderId));
    }

    public List<OrderResponse> getAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
    }

    public OrderResponse createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getUnitPrice() * orderDto.getStock());

        Order order = orderDto.toEntity();
        orderRepository.save(order);

        return OrderResponse.of(order);
    }
}
