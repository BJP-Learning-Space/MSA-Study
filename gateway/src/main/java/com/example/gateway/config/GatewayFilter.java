//package com.example.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayFilter {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/first-service/**")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://localhost:8081/**"))
//                .route(r -> r.path("/second-service/**")
//                        .filters(f -> f.addRequestHeader("Hello2", "World2"))
//                        .uri("http://localhost:8082/**"))
//                .build();
//    }
//}
