package com.example.userservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("token")
public class Token {
    private String secret;
    private String name;
    private String desk;

    public Token() {
    }
}
