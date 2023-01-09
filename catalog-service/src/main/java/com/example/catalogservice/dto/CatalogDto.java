package com.example.catalogservice.dto;

import lombok.Getter;

@Getter
public final class CatalogDto {
    private final String productId;
    private final Integer stock;
    private final Integer unitPrice;
    private final Integer totalPrice;
    private final String orderId;
    private final String userId;

    public CatalogDto(String productId, Integer stock, Integer unitPrice, Integer totalPrice, String orderId,
                      String userId) {
        this.productId = productId;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.userId = userId;
    }
}
