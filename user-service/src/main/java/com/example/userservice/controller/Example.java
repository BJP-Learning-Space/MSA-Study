package com.example.userservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("nrefresh")
public class Example {
    private Long id;
    private String name;

    public Example() {
    }
}
