package com.github.api_projeto_final.gateway_service.configuration

import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConf{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/user")
                    .uri("http://localhost:PORTA/user"))
                .route("zelda", r -> r.path("/zelda")
                    .uri("http://localhost:PORTA/zelda"))
                .build();
    }
}