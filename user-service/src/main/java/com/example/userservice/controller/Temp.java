package com.example.userservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("temp")
public class Temp {
    private String name;
    private String money;

    public Temp() {
    }
}
