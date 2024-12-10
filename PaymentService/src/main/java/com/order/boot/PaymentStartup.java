package com.order.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.payment")
@EnableDiscoveryClient
public class PaymentStartup {
    public static void main(String[] args) {
        SpringApplication.run(PaymentStartup.class, args);
    }
}
