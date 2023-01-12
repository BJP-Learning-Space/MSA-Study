package com.example.firstservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class Controller {
    @GetMapping(value = "/test")
    public String test() {
        return TenantContext.getCurrentTenant();
    }
}
