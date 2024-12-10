package com.order.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.order")
public class OrderStartup {
    public static void main(String[] args) {
        SpringApplication.run(OrderStartup.class, args);
    }
}
