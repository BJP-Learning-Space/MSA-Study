package com.example.userservice.controller;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestHeaderConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        System.out.println("여기 들어옴" + TenantContext.getCurrentTenant());
        return requestTemplate ->
                requestTemplate.header("dsdCode", TenantContext.getCurrentTenant());
    }
}
