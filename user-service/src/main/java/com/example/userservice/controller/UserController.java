package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${greeting.message}")
    private String message;

    private final Greeting greeting;

    public UserController(Greeting greeting) {
        this.greeting = greeting;
    }

    @RequestMapping("/health")
    public String healthCheck() {
        return message;
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return greeting.getMessage();
    }

    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
