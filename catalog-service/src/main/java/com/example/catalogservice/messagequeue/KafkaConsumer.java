package com.example.catalogservice.messagequeue;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.domain.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class KafkaConsumer {
    private final CatalogRepository catalogRepository;

    public KafkaConsumer(final CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @KafkaListener(topics = "example-catalog-topic")
    public void updateQty(final String kafkaMessage) {
        log.info("Kafka Message: -> {}", kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        final ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>(){});
        } catch (final JsonProcessingException ex) {
            ex.printStackTrace();
        }

        final Catalog catalog = catalogRepository.findByProductId((String) map.get("productId"));
        if (catalog != null) {
            log.info("Catalog before: -> {}", catalog);
            catalog.setStock(catalog.getStock() - (Integer) map.get("stock"));
            catalogRepository.save(catalog);
        }
    }
}
