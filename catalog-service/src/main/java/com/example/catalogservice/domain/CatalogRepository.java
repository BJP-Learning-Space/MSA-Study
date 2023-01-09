package com.example.catalogservice.domain;

import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {
    Catalog findByProductId(String productId);
}
