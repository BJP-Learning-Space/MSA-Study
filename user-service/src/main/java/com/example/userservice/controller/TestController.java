package com.example.userservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "first-service", url = "http://localhost:8081", path = "/first-service/test")
public interface TestController {
    @GetMapping
    String test();
}
