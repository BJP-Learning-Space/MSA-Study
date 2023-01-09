package com.example.orderservice.dto;

import lombok.Getter;

@Getter
public class OrderRequest {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
}
