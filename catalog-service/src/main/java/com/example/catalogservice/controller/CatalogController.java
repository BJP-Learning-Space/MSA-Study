package com.example.catalogservice.controller;

import com.example.catalogservice.dto.CatalogResponse;
import com.example.catalogservice.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "It's Working in Catalog Service";
    }

    @RequestMapping("/catalogs/{productId}")
    public String getCatalog(@PathVariable String productId) {
        return catalogService.getCatalog(productId);
    }

    @RequestMapping("/catalogs")
    public Iterable<CatalogResponse> getAllCatalogs() {
        return catalogService.getAllCatalogs();
    }
}
