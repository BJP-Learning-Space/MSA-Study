package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ExampleService {
    @Value("${nrefresh.id}")
    private String id;

    @Value("${nrefresh.name}")
    private String name;

    public String nrefresh() {
        return "id: " + id + ", name: " + name;
    }
}
