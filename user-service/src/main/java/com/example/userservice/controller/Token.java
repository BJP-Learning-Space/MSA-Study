package com.example.userservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@RefreshScope
@ConfigurationProperties("token")
public class Token {
    private String secret;
    private String name;
    private String desk;

    public Token() {
    }
}
