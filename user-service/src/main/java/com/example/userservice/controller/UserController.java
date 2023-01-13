package com.example.userservice.controller;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.service.UserService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Greeting greeting;
    private final UserService userService;
    private final Environment environment;
    private final TestController testController;
    private final Token token;

    public UserController(Greeting greeting, final UserService userService, Environment environment, final TestController testController, final Token token) {
        this.greeting = greeting;
        this.userService = userService;
        this.environment = environment;
        this.testController = testController;
        this.token = token;
    }

    @RequestMapping("feign")
    public String feign() {
        System.out.println("여기 들어옴" + TenantContext.getCurrentTenant());
        return testController.test();
    }

    @RequestMapping("/health")
    public String healthCheck() {
        return String.format(
                "Port : %s%nGreetings : %s%nToken : %s", environment.getProperty("local.server.port"), environment.getProperty("greeting.message"), environment.getProperty("token.secret")
        );
    }

    @RequestMapping("/token")
    public String token() {
        return token.getSecret() + "\n" + token.getName() + "\n" + token.getDesk();
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return greeting.getMessage();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse findUserById(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }
}
