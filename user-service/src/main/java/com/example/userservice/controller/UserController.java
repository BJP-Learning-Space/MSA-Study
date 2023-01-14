package com.example.userservice.controller;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.service.ExampleService;
import com.example.userservice.service.RefreshScopeExampleService;
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
    private final Example example;
    private final Temp temp;
    private final RefreshScopeExample refreshScopeExample;
    private final ExampleService exampleService;
    private final RefreshScopeExampleService refreshScopeExampleService;

    public UserController(Greeting greeting, final UserService userService, Environment environment, final TestController testController, final Example example, final Temp temp, final RefreshScopeExample refreshScopeExample, final ExampleService exampleService, final RefreshScopeExampleService refreshScopeExampleService) {
        this.greeting = greeting;
        this.userService = userService;
        this.environment = environment;
        this.testController = testController;
        this.example = example;
        this.temp = temp;
        this.refreshScopeExample = refreshScopeExample;
        this.exampleService = exampleService;
        this.refreshScopeExampleService = refreshScopeExampleService;
    }

    @RequestMapping("feign")
    public String feign() {
        System.out.println("여기 들어옴" + TenantContext.getCurrentTenant());
        return testController.test();
    }

    @RequestMapping("/health")
    public String healthCheck() {
        return environment.getProperty("local.server.port") + "\n" + environment.getProperty("greeting.message") + "\n" + environment.getProperty("token.secret");
    }

    @RequestMapping("/nrefresh")
    public String nrefresh() {
        return example.getId() + "\n" + example.getName();
    }

    @RequestMapping("/yrefresh")
    public String yrefresh() {
        return refreshScopeExample.getId() + "\n" + refreshScopeExample.getName();
    }

    @RequestMapping("/nrefresh-service")
    public String nrefreshService() {
        return exampleService.nrefresh();
    }

    @RequestMapping("/yrefresh-service")
    public String yrefreshService() {
        return refreshScopeExampleService.yrefresh();
    }

    @RequestMapping("/temp")
    public String temp() {
        return temp.getName() + "\n" + temp.getMoney();
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
