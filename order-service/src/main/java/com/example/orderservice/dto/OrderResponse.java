package com.example.orderservice.dto;

import com.example.orderservice.domain.Order;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class OrderResponse implements Serializable {
    private final String productId;
    private final Integer quantity;
    private final Integer unitPrice;
    private final Integer totalPrice;
    private final Date createAt;

    private final String orderId;

    public OrderResponse(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, Date createAt, String orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createAt = createAt;
        this.orderId = orderId;
    }

    public static OrderResponse of(Order order) {
        return new OrderResponse(order.getProductId(), order.getStock(), order.getUnitPrice(), order.getTotalPrice(), order.getCreateAt(), order.getOrderId());
    }
}
