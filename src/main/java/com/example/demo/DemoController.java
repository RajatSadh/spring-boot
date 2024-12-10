package com.example.demo;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@RestController
@RequestMapping("/rest")
public class DemoController {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;


    RestTemplate restTemplate=new RestTemplate();

    private CircuitBreaker circuitBreaker;

    @PostConstruct
    public void init() {
        this.circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
    }

    @PostMapping("/endpoint")
    public ResponseEntity<String> resp() {
        return ResponseEntity.ok(getAlbumList());
    }

    public String getDefaultAlbumList() {
        String url = "https://jsonplaceholder.typicode.com/albums";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Default album list is unavailable.";
        }
    }

    public String getAlbumList() {
        String url = "http://localhost:1234/not-real";

        return null;
    }



    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name="serviceB",fallbackMethod = "fallbackMethod")
    public String callServiceB() {
        return restTemplate.getForObject("http://service-b:8080/endpoint", String.class);
    }

    public String fallbackMethod(Throwable t) {
        return "Service B is currently unavailable";
    }

}

