package com.example.catalogservice.service;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.domain.CatalogRepository;
import com.example.catalogservice.dto.CatalogResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public String getCatalog(String productId) {
        return catalogRepository.findByProductId(productId).getProductName();
    }

    public List<CatalogResponse> getAllCatalogs() {
        List<CatalogResponse> catalogList = new ArrayList<>();

        catalogRepository.findAll()
            .forEach(catalog -> catalogList.add(CatalogResponse.of(catalog)));

        return catalogList;
    }
}
