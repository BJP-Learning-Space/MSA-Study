package com.example.userservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RefreshScope
@Component
@ConfigurationProperties("yrefresh")
public class RefreshScopeExample {
    private Long id;
    private String name;

    public RefreshScopeExample() {
    }
}
