package com.example.userservice.dto;

import lombok.Getter;
import java.util.Date;

@Getter
public class OrderResponse {
    private final String productId;
    private final Integer quantity;
    private final Integer unitPrice;
    private final Integer totalPrice;
    private final Date createdAt;
    private final String orderId;

    public OrderResponse(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, Date createdAt, String orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.orderId = orderId;
    }
}
