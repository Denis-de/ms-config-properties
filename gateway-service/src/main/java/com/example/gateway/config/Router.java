package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Router {
    private final Filter filter;

    public Router(Filter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("client", r -> r.path("/api/client/**")
                //.filters(f -> f.filter(filter))
                .uri("lb://client-service"))
                .build();
    }

    @Bean
    public RouteLocator routes1(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("update", r -> r.path("/api/update/**")
                //.filters(f -> f.filter(filter))
                .uri("lb://client-update"))
                .build();
    }
}
