package com.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisServer;

@Configuration
public class EmbeddedRedisConfig {

    private RedisServer redisServer;

    /*@Bean
    public RedisServer redisServer() throws Exception {
        if (redisServer == null) {
            // Start Redis on default port 6379
            redisServer = new RedisServer(6379);
            redisServer.start();
        }
        return redisServer;
    }

    // Stop Redis server on shutdown
    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }*/
}
