package com.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;

@Configuration
public class RateLimiterConfig {
    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(5, 10); // Default replenish rate and burst capacity
    }
}
