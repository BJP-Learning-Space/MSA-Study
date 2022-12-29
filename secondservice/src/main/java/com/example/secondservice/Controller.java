package com.example.secondservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Environment environment;

    public Controller(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/second-service/test")
    public String test(HttpServletRequest request) {
        return "Second Service : " + request.getHeader("Hello") + "\n" + request.getRequestURI() + "\n" + environment.getProperty("local.server.port");
    }
}
