package com.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RequestValidationFilter implements GlobalFilter, Ordered {


    Logger logger= LoggerFactory.getLogger(RequestValidationFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authToken = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authToken == null || !isValidToken(authToken)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Proceed if the token is valid
        return chain.filter(exchange);
    }



      private boolean isValidToken(String token) {
        // Add your validation logic here (e.g., JWT validation, database lookup, etc.)
        return "valid-token".equals(token);
    }

    @Override
    public int getOrder() {
        return -1; // High priority (executed early in the chain)
    }


}
