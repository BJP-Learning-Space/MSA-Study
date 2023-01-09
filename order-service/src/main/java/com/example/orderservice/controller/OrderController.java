package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "It's Working in Order Service";
    }

    @GetMapping("/order/{orderId}")
    public OrderResponse getOrderByOrderId(@PathVariable String orderId) {
        return orderService.getOrderByOrderId(orderId);
    }

    @GetMapping("/orders/{userId}")
    public List<OrderResponse> getAllOrdersByUserId(@PathVariable String userId) {
        return orderService.getAllOrdersByUserId(userId);
    }

    @PostMapping("/{userId}/order")
    public OrderResponse createOrder(@PathVariable String userId, @RequestBody OrderRequest orderRequest) {
        OrderDto orderDto = new OrderDto(orderRequest.getProductId(), orderRequest.getQuantity(), orderRequest.getUnitPrice(), null, null, userId);

        return orderService.createOrder(orderDto);
    }
}
