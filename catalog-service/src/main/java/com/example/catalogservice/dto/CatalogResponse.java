package com.example.catalogservice.dto;

import com.example.catalogservice.domain.Catalog;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CatalogResponse {
    private final String productId;
    private final Integer stock;
    private final Integer unitPrice;
    private final Integer totalPrice;
    private final Date createAt;

    public CatalogResponse(String productId, Integer stock, Integer unitPrice, Integer totalPrice, Date createAt) {
        this.productId = productId;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createAt = createAt;
    }

    public static CatalogResponse of(Catalog catalog) {
        return new CatalogResponse(catalog.getProductId(), catalog.getStock(), catalog.getUnitPrice(), catalog.getUnitPrice(), catalog.getCreatedAt());
    }
}
