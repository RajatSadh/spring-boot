package com.order.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger logger= LoggerFactory.getLogger(OrderController.class);


    @GetMapping("/test")
    public String getMethodName() {
        logger.info("order service calling");

        return new String("order service calling");
    }
}