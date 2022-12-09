package com.example.secondservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/second-service/test")
    public String test(HttpServletRequest request) {
        return "Second Service : " + request.getHeader("Hello") + "\n" + request.getRequestURI();
    }
}
