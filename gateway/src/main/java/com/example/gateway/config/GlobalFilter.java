package com.example.gateway.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Getter
    @Setter
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Custom Pre Filter
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Global PRE Filter: request id -> {}", request.getId());

            if (config.isPreLogger()) {
                log.info("Global Filter baseMessage: {}", config.getBaseMessage());
            }

            // Custom Post Filter
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        log.info("Global POST Filter: response code -> {}", response.getStatusCode());

                        if (config.isPostLogger()) {
                            log.info("Global Filter baseMessage: {}", config.getBaseMessage());
                        }
                    }));
        };
    }
}
