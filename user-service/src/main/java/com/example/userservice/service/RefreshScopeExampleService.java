package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class RefreshScopeExampleService {
    @Value("${yrefresh.id}")
    private String id;

    @Value("${yrefresh.name}")
    private String name;

    public String yrefresh() {
        return "id: " + id + ", name: " + name;
    }
}
