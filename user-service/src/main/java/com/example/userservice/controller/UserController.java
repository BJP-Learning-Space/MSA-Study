package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserRequest;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Value("${greeting.message}")
    private String message;

    private final Greeting greeting;
    private UserService userService;

    public UserController(Greeting greeting, final UserService userService) {
        this.greeting = greeting;
        this.userService = userService;
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
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
