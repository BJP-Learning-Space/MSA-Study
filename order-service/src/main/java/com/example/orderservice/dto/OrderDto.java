package com.example.orderservice.dto;

import com.example.orderservice.domain.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String productId;
    private Integer stock;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public OrderDto(String productId, Integer stock, Integer unitPrice, Integer totalPrice, String orderId, String userId) {
        this.productId = productId;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.userId = userId;
    }

    public static OrderDto of(Order order) {
        return new OrderDto(order.getProductId(), order.getStock(), order.getUnitPrice(), order.getTotalPrice(), order.getOrderId(), order.getUserId());
    }

    public Order toEntity() {
        return Order.builder()
                .productId(productId)
                .stock(stock)
                .unitPrice(unitPrice)
                .totalPrice(totalPrice)
                .orderId(orderId)
                .userId(userId)
                .build();
    }
}
